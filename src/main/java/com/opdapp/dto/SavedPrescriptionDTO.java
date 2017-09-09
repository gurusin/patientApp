package com.opdapp.dto;

public class SavedPrescriptionDTO {

    private PrescriptionDTO prescriptionDTO;
    private long issueNo;

    public PrescriptionDTO getPrescriptionDTO() {
        return prescriptionDTO;
    }

    public void setPrescriptionDTO(PrescriptionDTO prescriptionDTO) {
        this.prescriptionDTO = prescriptionDTO;
    }

    public long getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(long issueNo) {
        this.issueNo = issueNo;
    }
}
