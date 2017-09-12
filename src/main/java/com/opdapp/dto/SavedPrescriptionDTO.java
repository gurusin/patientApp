package com.opdapp.dto;

import com.opdapp.model.IssueNote;

public class SavedPrescriptionDTO {

    private PrescriptionDTO prescriptionDTO;
    private IssueNote issueNote;

    public PrescriptionDTO getPrescriptionDTO() {
        return prescriptionDTO;
    }

    public void setPrescriptionDTO(PrescriptionDTO prescriptionDTO) {
        this.prescriptionDTO = prescriptionDTO;
    }

    public IssueNote getIssueNote() {
        return issueNote;
    }

    public void setIssueNote(IssueNote issueNote) {
        this.issueNote = issueNote;
    }
}
