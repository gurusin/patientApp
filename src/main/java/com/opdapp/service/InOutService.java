package com.opdapp.service;

import com.opdapp.dto.inout.InOutReport;
import com.opdapp.dto.inout.InOutSearchCriteria;

import java.util.List;

public interface InOutService {
    List<InOutReport> getInOut(InOutSearchCriteria criteria);
}
