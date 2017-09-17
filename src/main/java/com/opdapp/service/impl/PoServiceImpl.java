package com.opdapp.service.impl;

import com.opdapp.dto.*;
import com.opdapp.model.*;
import com.opdapp.repository.*;
import com.opdapp.service.POService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PoServiceImpl implements POService {

    @Autowired
    private ItemSupplierRepository itemSupplierRepository;

    @Autowired
    private DrugPackageRepository drugPackageRepository;

    @Autowired
    private PORepository poRepository;

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Autowired
    private GoodReceivingNoteRepository goodReceivingNoteRepository;

    @Autowired
    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    private RetrunsoutRepository retrunsoutRepository;

    @Override
    public PurchaseOrder savePO(PurchaseOrderDTO purchaseOrderDTO) {

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        if (purchaseOrderDTO.getPurchaseOrderNo() > 0) {
            purchaseOrder = poRepository.findOne(purchaseOrderDTO.getPurchaseOrderNo());
        }
        purchaseOrder.setItemSupplier(itemSupplierRepository.findOne(purchaseOrderDTO.getSupplierId()));
        purchaseOrder.setPurchaseOrderDetails(getDetails(purchaseOrderDTO, purchaseOrder));
        final java.util.Date dt = purchaseOrderDTO.getOrderDate().toDateTimeAtStartOfDay().toDate();
        purchaseOrder.setOrderedDate(new Date(dt.getTime()));
        final java.util.Date odt = purchaseOrderDTO.getExpectedRecieveDate().toDateTimeAtStartOfDay().toDate();
        purchaseOrder.setExpectedRecieveDate(new Date(dt.getTime()));
        purchaseOrder.setPoStatus(purchaseOrderDTO.getPoStatus());
        return poRepository.save(purchaseOrder);
    }

    private Set<PurchaseOrderDetail> getDetails(final PurchaseOrderDTO dto, final PurchaseOrder purchaseOrder) {
        final Set<PurchaseOrderDetail> childSet = new HashSet<>();
        for (final PODetail detail : dto.getPoDetails()) {
            final PurchaseOrderDetail pod = new PurchaseOrderDetail();
            pod.setDrugPackage(drugPackageRepository.findOne(detail.getDrugPackageId()));
            pod.setOrderQty(detail.getQty());
            pod.setPurchaseOrder(purchaseOrder);
            childSet.add(pod);
        }
        return childSet;
    }

    @Override
    public List<PurchaseOrderDTO> findPurchaseOrderByPoStatus(final POStatus poStatus) {
        List<PurchaseOrder> poList = poRepository.findPurchaseOrderByPoStatus(poStatus);
        List<PurchaseOrderDTO> poDTOList = new ArrayList<PurchaseOrderDTO>();
        for (PurchaseOrder poOrder : poList) {
            PurchaseOrderDTO poDTO = createPODTO(poOrder);
            poDTOList.add(poDTO);
        }
        return poDTOList;
    }

    private PurchaseOrderDTO createPODTO(PurchaseOrder po) {
        PurchaseOrderDTO poDTO = new PurchaseOrderDTO();
        poDTO.setExpectedRecieveDate(new LocalDate(po.getExpectedRecieveDate()));
        poDTO.setOrderDate(new LocalDate(po.getOrderedDate()));
        poDTO.setPoStatus(po.getPoStatus());
        poDTO.setPurchaseOrderNo(po.getPurchaseOrderNo());
        poDTO.setSupplierId(po.getItemSupplier().getSupplierId());
        poDTO.setPoDetails(getDetailsList(po));

        return poDTO;
    }

    private List<PODetail> getDetailsList(PurchaseOrder po) {
        List<PODetail> podeList = new ArrayList<PODetail>();
        for (PurchaseOrderDetail pod : po.getPurchaseOrderDetails()) {
            PODetail pode = new PODetail();
            if (pod.getDrugPackage() != null)
                pode.setDrugPackageId(pod.getDrugPackage().getDrugPackageId());
            pode.setQty(pod.getOrderQty());
            pode.setPodetailId(pod.getPurchaseOrderDetailId());
        }
        return podeList;
    }

    @Override
    public POForGrnDTO loadForGrn(final long podId) {
        final PurchaseOrder purchaseOrder = poRepository.findOne(podId);
        final POForGrnDTO dto = new POForGrnDTO();
        dto.setPoNumber(purchaseOrder.getPurchaseOrderNo());
        dto.setSupplier(purchaseOrder.getItemSupplier().getSupplierName() + ", " + purchaseOrder.getItemSupplier().getSupplierAddress());
        final List<PoForGrnDetailDTO> list = new ArrayList<>();
        for (final PurchaseOrderDetail detail : purchaseOrder.getPurchaseOrderDetails()) {
            final PoForGrnDetailDTO detailDTO = new PoForGrnDetailDTO();
            detailDTO.setDrugPacakgeId(detail.getDrugPackage().getDrugPackageId());
            detailDTO.setItemName(detail.getDrugPackage().getDrug().getBrandName() + " " + detail.getDrugPackage().getStrength().getStrengthAmount() + detail.getDrugPackage().getStrength().getStrengthUnit().getUnitName());
            detailDTO.setOrderedQty(detail.getOrderQty());
            detailDTO.setBalanceQty(detail.getOrderQty() - detail.getReceivedQty());
            detailDTO.setPoDetailId(detail.getPurchaseOrderDetailId());
            list.add(detailDTO);
        }
        dto.setDetails(list);
        dto.setPaymentDetails(new PaymentDetails());
        return dto;
    }

    @Override
    public PurchaseOrder registerGRN(POForGrnDTO grn) {
        grn.setGrnStatus(GRNStatus.CREATED);
        final PurchaseOrder purchaseOrder = poRepository.findOne(grn.getPoNumber());
        final GoodReceivingNote grnObj = new GoodReceivingNote();
        grnObj.setPurchaseOrder(purchaseOrder);
        grnObj.setSupplierInvoice(grn.getSupplierInvoice());
        grnObj.setGrnDate(new java.sql.Date(grn.getExpectedRecieveDate().getTime()));
        grnObj.setGrnStatus(grn.getGrnStatus());
        final Set<GRNDetails> grnDetailsSet = new HashSet<>();
        for (final PoForGrnDetailDTO dto : grn.getDetails()) {
            updateGRN(dto, purchaseOrder, grnDetailsSet, grnObj);

        }
        grnObj.setgRNDetails(grnDetailsSet);
        purchaseOrder.getGoodReceivingNote().add(grnObj);
        return poRepository.save(purchaseOrder);
    }

    private void updateGRN(PoForGrnDetailDTO dto, PurchaseOrder purchaseOrder, final Set<GRNDetails> grnDetailsSet
            , final GoodReceivingNote grnObj) {
        for (final PurchaseOrderDetail detail : purchaseOrder.getPurchaseOrderDetails()) {
            if (detail.getPurchaseOrderDetailId() == dto.getPoDetailId()) {
                detail.setReceivedQty(detail.getReceivedQty() + dto.getReceivedQty());
                updateItemStock(detail.getDrugPackage(), dto.getReceivedQty());
                GRNDetails grnDetail = createGRNDetail(detail, dto);
                grnDetail.setGoodReceivingNote(grnObj);
                grnDetailsSet.add(grnDetail);
            }
        }
    }

    private GRNDetails createGRNDetail(PurchaseOrderDetail detail, PoForGrnDetailDTO dto) {
        final GRNDetails obj = new GRNDetails();
        obj.setReceivingQty(dto.getReceivedQty());
        DrugPackage drugPacakge = drugPackageRepository.findOne(dto.getDrugPacakgeId());
        obj.setDrugPackage(drugPacakge);
        obj.setItemBoughtPrice(dto.getItemBoughtPrice());
        return obj;
    }

    @Override
    public void saveIssue(IssueDTO issueDTO) {
        final IssueNote note = new IssueNote();
        note.setIssueDate(issueDTO.getIssueDate());
        note.setPaymentMethod(issueDTO.getPaymentMethod());
        note.setIssueStatus(issueDTO.getIssueStatus());
        final Set<IssueNoteDetails> children = new HashSet<>();
        for (final IssueDetailDTO detail : issueDTO.getDetails()) {
            final DrugPackage item = drugPackageRepository.findOne(detail.getItemId());
            updateItemStock(item, detail.getQuantity() * -1);
            final IssueNoteDetails detEntity = new IssueNoteDetails();
            // TODO : Item should be mapped to Drug Package
            //detEntity.setItem(item);
            detEntity.setIssueNote(note);
            detEntity.setBuyingQuantity(detail.getQuantity());
            children.add(detEntity);
        }
        note.setIssueNoteDetails(children);
        issueNoteRepository.save(note);
    }

    private void updateItemStock(final DrugPackage item, final double qty) {
        item.setQuantity(item.getQuantity() + qty);
    }

    @Override
    public List<GRNDTOForPay> loadGRNForPay(String supplierInvoice) {
        List<GoodReceivingNote> goodReceivingNoteList = goodReceivingNoteRepository.getGoodReceivingNoteBySupplierInvoiceLike(supplierInvoice);

        final List<GRNDTOForPay> grndtoForPayList = new ArrayList<GRNDTOForPay>();

        for (GoodReceivingNote drn : goodReceivingNoteList) {
            final GRNDTOForPay grndtoForPay = new GRNDTOForPay();
            createGrndtoForPay(grndtoForPay, drn);
            grndtoForPayList.add(grndtoForPay);
        }

        return grndtoForPayList;
    }

    private void createGrndtoForPay(GRNDTOForPay grndtoForPay, GoodReceivingNote grn) {
        grndtoForPay.setGrnStatus(grn.getGrnStatus());
        grndtoForPay.setDrnid(grn.getDrnid());
        grndtoForPay.setGrnDate(grn.getGrnDate());
        grndtoForPay.setSupplierInvoice(grn.getSupplierInvoice());
        grndtoForPay.setSupplierName(grn.getPurchaseOrder().getItemSupplier().getSupplierName() + " " + grn.getPurchaseOrder().getItemSupplier().getSupplierAddress());
        Set<PoForGrnDetailDTO> poForGrnDetailDTOS = new HashSet<PoForGrnDetailDTO>();
        PaymentDetails paymentDetails = new PaymentDetails();
        double totalAmpount = 0;
        for (GRNDetails grnDetail : grn.getgRNDetails()) {

            final PoForGrnDetailDTO detailDTO = new PoForGrnDetailDTO();
            createPoForGrnDetailDTO(grnDetail, detailDTO);
            poForGrnDetailDTOS.add(detailDTO);
            totalAmpount = totalAmpount + grnDetail.getItemBoughtPrice() * grnDetail.getReceivingQty();
        }
        paymentDetails.setGrnNo(grn.getDrnid());
        grndtoForPay.setPoForGrnDetailDTO(poForGrnDetailDTOS);
        grndtoForPay.setPaymentDetails(paymentDetails);
        grndtoForPay.setTotalAmount(totalAmpount);
    }

    private void createPoForGrnDetailDTO(GRNDetails detail, PoForGrnDetailDTO detailDTO) {
        detailDTO.setPoDetailId(detail.getGrnDetailNo());
        detailDTO.setItemBoughtPrice(detail.getItemBoughtPrice());
        detailDTO.setReceivedQty(detail.getReceivingQty());
        detailDTO.setDrugPacakgeId(detail.getDrugPackage().getDrugPackageId());
        detailDTO.setItemName(detail.getDrugPackage().getDrug().getBrandName() + " " + detail.getDrugPackage().getStrength().getStrengthAmount() + detail.getDrugPackage().getStrength().getStrengthUnit().getUnitName());

    }

    @Override
    public List<GRNDTOForPay> makePayment(final GRNDTOForPay gRNDTOForPay) {
        GoodReceivingNote grn = goodReceivingNoteRepository.findOne(gRNDTOForPay.getDrnid());
        if (gRNDTOForPay.getTotalAmount() <= gRNDTOForPay.getPaymentDetails().getAmount()) {
            grn.setGrnStatus(GRNStatus.PAID);
        } else {
            grn.setGrnStatus(GRNStatus.HALF_PAID);
        }

        goodReceivingNoteRepository.save(grn);
        PaymentDetails paymentToSave = gRNDTOForPay.getPaymentDetails();
        paymentToSave.setPaymentMode(PaymentMode.OUT);
        paymentDetailRepository.save(paymentToSave);
        return loadGRNForPay(gRNDTOForPay.getSupplierInvoice());
    }

    public GRNDTOForReturn loadGRNDTOForReturn(final String supplierInvoice) {
        List<GoodReceivingNote> goodReceivingNoteList = goodReceivingNoteRepository.getGoodReceivingNoteBySupplierInvoiceLike(supplierInvoice);
        GRNDTOForReturn grndtoForReturn = new GRNDTOForReturn();
        if (goodReceivingNoteList.size() > 0) {
            GoodReceivingNote note = goodReceivingNoteList.get(0);
            grndtoForReturn.setDrnid(note.getDrnid());
            grndtoForReturn.setGrnDate(note.getGrnDate());
            grndtoForReturn.setSupplierInvoice(note.getSupplierInvoice());
            grndtoForReturn.setSupplierName(note.getPurchaseOrder().getItemSupplier().getSupplierName() + " " + note.getPurchaseOrder().getItemSupplier().getSupplierAddress());
            List<ReturnOutDetailDTO> returnOutDetailDTOList = new ArrayList<ReturnOutDetailDTO>();
            for (GRNDetails grnDetails : note.getgRNDetails()) {
                ReturnOutDetailDTO returnOutDetailDTO = new ReturnOutDetailDTO();
                returnOutDetailDTO.setDrugName(grnDetails.getDrugPackage().getDrug().getBrandName() + " " + grnDetails.getDrugPackage().getStrength().getStrengthAmount() + grnDetails.getDrugPackage().getStrength().getStrengthUnit().getUnitName());
                returnOutDetailDTO.setDrugPackageId(grnDetails.getDrugPackage().getDrugPackageId());
                returnOutDetailDTO.setGrnDetailNo(grnDetails.getGrnDetailNo());
                returnOutDetailDTO.setRecievedQty(grnDetails.getReceivingQty());
                returnOutDetailDTOList.add(returnOutDetailDTO);
            }
            grndtoForReturn.setReturnOutDetailDTOList(returnOutDetailDTOList);
        }
        return grndtoForReturn;
    }

    public void saveGoodReturn(final GRNDTOForReturn gRNDTOForReturn) {
        Returnsout returnsout = new Returnsout();
        returnsout.setReturnDate(gRNDTOForReturn.getReturnDate());
        returnsout.setSupplierInvoice(gRNDTOForReturn.getSupplierInvoice());
        Set<ReturnOutDetail> returnsoutDetails = new HashSet<ReturnOutDetail>();
        for (ReturnOutDetailDTO returnOutDetailDTO : gRNDTOForReturn.getReturnOutDetailDTOList()) {
            if (returnOutDetailDTO.getReturnQty() > 0) {
                ReturnOutDetail returnOutDetail = new ReturnOutDetail();
                DrugPackage drugPackage = drugPackageRepository.findOne(returnOutDetailDTO.getDrugPackageId());
                drugPackage.setQuantity(drugPackage.getQuantity() - returnOutDetailDTO.getReturnQty());
                drugPackageRepository.save(drugPackage);
                returnOutDetail.setDrugPackage(drugPackage);
                returnOutDetail.setReturnQty(returnOutDetailDTO.getReturnQty());
                returnOutDetail.setReturnsout(returnsout);
                returnsoutDetails.add(returnOutDetail);
            }
        }
        returnsout.setReturnOutDetail(returnsoutDetails);
        retrunsoutRepository.save(returnsout);
    }
}
