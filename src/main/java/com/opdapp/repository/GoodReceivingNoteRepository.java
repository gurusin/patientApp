package com.opdapp.repository;

import com.opdapp.model.GoodReceivingNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GoodReceivingNoteRepository extends CrudRepository<GoodReceivingNote, Long> {

    List<GoodReceivingNote> getGoodReceivingNoteBySupplierInvoiceLike(String supplierInvoice);

    List<GoodReceivingNote> findGoodReceivingNoteByGrnDateBetween(Date fromDate,Date toDate);
}
