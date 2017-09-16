import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";
import {Prescription, PrescriptionDetail} from "../prescription-component/prescription-component.component";
import {PatientServiceService} from "../services/patient-service.service";
import {PrescribableDrug} from "../prescription-component/prescribable-drug";
import {DrugServiceService} from "../services/drug-service.service";
import {Router} from "@angular/router";
// import { MdDialog } from "@angular/material";
import {PrintreceiptComponent} from "../prescription-component/printreceipt.component";
// import { MdDialogRef, MD_DIALOG_DATA } from "@angular/material";
import {PrintpopComponent} from "./printpop.component";

// import {Popup} from "ng2-opd-popup";

@Component({
    selector: 'app-basicvisit',
    templateUrl: './basicvisit.component.html',
    styleUrls: ['./basicvisit.component.css']
})
export class BasicvisitComponent implements OnInit {

    patientVisit: Patientvisit;
    @Input() patient: Patient;

    // dialogRef: MdDialogRef<PrintpopComponent>;

    constructor(private patientService: PatientServiceService,
                private drugService: DrugServiceService, private router: Router) {
        // public mdDialog: MdDialog){//}, private popup:Popup) {
        this.patientVisit = new Patientvisit();
        this.patientVisit.diagnoseData = '';
        this.patientVisit.prescribableDrug = []
    }

    onCancel() {
        // Navigate to any page
    }

    ngOnInit() {
    }

    onSave() {
        var presc = new Prescription();
        presc.medicalServices = this.patientVisit.medicalServices;
        presc.prescriptionDetails = [];
        presc.patientId = this.patientService.patientObject.patientId;
        presc.diagnosis = this.patientVisit.diagnoseData;
        presc.notes = this.patientVisit.note;
        presc.symptoms = this.patientVisit.symptoms;
        var details = [];
        var bOK = true;
        this.patientVisit.prescribableDrug.forEach((obj: PrescribableDrug) => {
                var detail = new PrescriptionDetail();

                detail.drugId = obj.drug.drugId;
                detail.drug.drugId = obj.drug.drugId;
                detail.amount = obj.doseAmount;
                detail.duration = obj.doseDuration;
                if (obj.strengths == null)
                {
                    alert('Prescription has empty fields');
                    bOK=false;
                    return;
                }
                detail.strength = obj.strengths[obj.selectedStrengthIndex];
                detail.frequency.doseFrequencyId = obj.selectedFrequency;
                detail.intervalUnit = obj.selectedDuration;
                detail.meal = obj.meal;
                if (!detail.isValid()){
                    alert("Empty rows found. Can't submit");
                    bOK = false;
                    return;
                }
                details.push(detail);
            }
        );
        if (!bOK) {
            return;
        }
        presc.prescriptionDetails = details;
        this.drugService.savePrescription(presc).subscribe(
            data => {
                this.drugService.setSavedPrescription(data);
                this.router.navigate(['printPo']);
            }
        );
    }
}
