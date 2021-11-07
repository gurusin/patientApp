package com.opdapp.service.dental.impl;

import com.opdapp.dto.dental.PatTreatmentDTO;
import com.opdapp.model.Patient;
import com.opdapp.model.dental.PatTreatmentItem;
import com.opdapp.model.dental.TreatmentItem;
import com.opdapp.repository.dental.PatTreatmentItemRepository;
import com.opdapp.repository.dental.TreatmentItemRepository;
import com.opdapp.service.dental.TreatmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentItemServiceImpl implements TreatmentItemService {

    @Autowired
    private TreatmentItemRepository treatmentItemRepository;

    @Autowired
    private PatTreatmentItemRepository patTreatmentItemRepository;

    public TreatmentItem createTreatment(TreatmentItem item ){
       return treatmentItemRepository.save(item);
    }

    public List<TreatmentItem> findAll(){
        List<TreatmentItem> list = new ArrayList<>();
        treatmentItemRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public List<?> findPatTreatment(long patId) {
        final Patient patObj = new Patient();
        patObj.setPatientId(patId);
        return patTreatmentItemRepository.findPatTreatmentItemByPatient(patObj);
    }

    public PatTreatmentItem savePatTreatment(PatTreatmentDTO dto) {
        final PatTreatmentItem patObj = new PatTreatmentItem();
        // Move the attributes from the DTO
        final Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());
        patObj.setPatient(patient);
        patObj.setId(dto.getId());
        patObj.setRate(dto.getRate());

        patObj.setTreatmentItem(dto.getTreatmentItem());

        patObj.setRemarks(dto.getRemarks());
        patObj.setTimeOfAction(LocalDateTime.parse(dto.getTimeOfAction()));

        return patTreatmentItemRepository.save(patObj);
    }

    @Override
    public void deleteTreatmentItem(long id) {
        Optional<TreatmentItem> val = treatmentItemRepository.findById(id);
        if(val.isPresent()){
            int count = patTreatmentItemRepository.countPatTreatmentItemByTreatmentItem(val.get());
            if(count == 0){
                treatmentItemRepository.deleteById(id);
            }else {
                throw new RuntimeException("Treatment can not be deleted");
            }
        }
    }

    @Override
    public void deletePatTreatment(long id) {
        patTreatmentItemRepository.deleteById(id);
    }
}
