package com.opdapp.controller;

import com.opdapp.dto.IssueDTO;
import com.opdapp.dto.POForGrnDTO;
import com.opdapp.dto.PurchaseOrderDTO;
import com.opdapp.model.POStatus;
import com.opdapp.model.PurchaseOrder;
import com.opdapp.service.POService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class POController {
    @Autowired
    private POService poService;

    @RequestMapping(path = "/savePO", method = RequestMethod.POST)
    public @ResponseBody
    PurchaseOrder savePO(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {

        return poService.savePO(purchaseOrderDTO);
    }

    @RequestMapping(path = "/loadPendingPOs", method = RequestMethod.GET)
    public @ResponseBody List<PurchaseOrderDTO> loadPendingPOs() {
        List<PurchaseOrderDTO> list = poService.findPurchaseOrderByPoStatus(POStatus.INITIAL);
        return list;
    }

    @RequestMapping(path="/loadPOForInput", method = RequestMethod.POST)
    public @ResponseBody
    POForGrnDTO loadPOForInput(@RequestBody final String poId)
    {
        return poService.loadForGrn(Long.parseLong(poId));
    }

    @RequestMapping(path="/registerGRN", method = RequestMethod.POST)
    public @ResponseBody POForGrnDTO registerGRN(@RequestBody final POForGrnDTO grn) {
        poService.registerGRN(grn);
        return grn;
    }

    @RequestMapping(path="/saveIssue", method = RequestMethod.POST)
    public @ResponseBody
    IssueDTO saveIssue(@RequestBody final IssueDTO issueDTO) {
        poService.saveIssue(issueDTO);

        return new IssueDTO();
    }

}
