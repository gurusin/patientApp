package com.opdapp.service.impl;

import com.opdapp.dto.*;
import com.opdapp.model.*;
import com.opdapp.repository.IssueNoteRepository;
import com.opdapp.repository.ItemRepository;
import com.opdapp.repository.ItemSupplierRepository;
import com.opdapp.repository.PORepository;
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
    private ItemRepository itemRepository;

    @Autowired
    private PORepository poRepository;

    @Autowired
    private IssueNoteRepository issueNoteRepository;

    @Override
    public PurchaseOrder savePO(PurchaseOrderDTO purchaseOrderDTO) {

        final PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setItemSupplier(itemSupplierRepository.findOne(purchaseOrderDTO.getSupplierId()));
        purchaseOrder.setPurchaseOrderDetails(getDetails(purchaseOrderDTO,purchaseOrder));
//        purchaseOrder.setPurchaseOrderNo(purchaseOrderDTO.getPurchaseOrderNo());
        purchaseOrder.setPurchaseOrderDetails(getDetails(purchaseOrderDTO, purchaseOrder));
        final java.util.Date dt = purchaseOrderDTO.getOrderDate().toDateTimeAtStartOfDay().toDate();
        purchaseOrder.setOrderedDate(new Date(dt.getTime()));
        poRepository.save(purchaseOrder);
        // Dummy return. Change to a proper return type
//        return new PurchaseOrder();
        final java.util.Date odt = purchaseOrderDTO.getExpectedRecieveDate().toDateTimeAtStartOfDay().toDate();
        purchaseOrder.setExpectedRecieveDate(new Date(dt.getTime()));
        purchaseOrder.setPoStatus(purchaseOrderDTO.getPoStatus());
        return poRepository.save(purchaseOrder);
    }

    private Set<PurchaseOrderDetail> getDetails(final PurchaseOrderDTO dto, final PurchaseOrder purchaseOrder) {
        final Set<PurchaseOrderDetail> childSet = new HashSet<>();
        for (final PODetail detail : dto.getPoDetails()) {
            final PurchaseOrderDetail pod = new PurchaseOrderDetail();
            pod.setItem(itemRepository.findOne(detail.getItemId()));
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

    private PurchaseOrderDTO createPODTO(PurchaseOrder po){
        PurchaseOrderDTO poDTO= new PurchaseOrderDTO();
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
            if(pod.getItem()!=null)
            pode.setItemId(pod.getItem().getItemId());
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
        final List<PoForGrnDetailDTO> list = new ArrayList<>();
        for (final PurchaseOrderDetail detail : purchaseOrder.getPurchaseOrderDetails()) {
            final PoForGrnDetailDTO detailDTO = new PoForGrnDetailDTO();
            detailDTO.setItemId(detail.getItem().getItemId());
            detailDTO.setItemName(detail.getItem().getItemDescription());
            detailDTO.setOrderedQty(detail.getOrderQty());
            detailDTO.setBalanceQty(detail.getOrderQty() - detail.getReceivedQty());
            detailDTO.setPoDetailId(detail.getPurchaseOrderDetailId());
            list.add(detailDTO);
        }
        dto.setDetails(list);
        return dto;
    }

    @Override
    public PurchaseOrder registerGRN(POForGrnDTO grn) {

        final PurchaseOrder purchaseOrder = poRepository.findOne(grn.getPoNumber());
        final GoodReceivingNote grnObj = new GoodReceivingNote();
        grnObj.setPurchaseOrder(purchaseOrder);
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
                updateItemStock(detail.getItem(), dto.getReceivedQty());
                GRNDetails grnDetail = createGRNDetail(detail, dto);
                grnDetail.setGoodReceivingNote(grnObj);
                grnDetailsSet.add(grnDetail);
            }
        }
    }

    private GRNDetails createGRNDetail(PurchaseOrderDetail detail, PoForGrnDetailDTO dto) {
        final GRNDetails obj = new GRNDetails();
        obj.setReceivingQty(dto.getReceivedQty());
        return obj;
    }

    @Override
    public void saveIssue(IssueDTO issueDTO)
    {
        final IssueNote note = new IssueNote();
        note.setIssueDate(issueDTO.getIssueDate());
        note.setPaymentMethod(issueDTO.getPaymentMethod());
        note.setIssueStatus(issueDTO.getIssueStatus());
        final Set<IssueNoteDetails> children = new HashSet<>();
        for (final IssueDetailDTO detail : issueDTO.getDetails())
        {
            final Item item = itemRepository.findOne(detail.getItemId());
            updateItemStock(item,detail.getQuantity() * -1);
            final IssueNoteDetails detEntity = new IssueNoteDetails();
            detEntity.setItem(item);
            detEntity.setIssueNote(note);
            detEntity.setBuyingQuantity(detail.getQuantity());
            children.add(detEntity);
        }
        note.setIssueNoteDetails(children);
        issueNoteRepository.save(note);
    }

    private void updateItemStock(final Item item, final double qty) {
        item.setQuantity(item.getQuantity() + qty);
    }


}
