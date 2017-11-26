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

    constructor(private patientService: PatientServiceService,
                private drugService: DrugServiceService, private router: Router) {
        this.patientVisit = this.patientService.patientVisit;
    }

    onCancel() {
      this.patientService.patientObject = null;
      this.router.navigate(['/start']);
    }

    ngOnInit() {
    }

    onSave() {
        var presc = new Prescription();
        presc.prescriptionId = this.patientVisit.prescriptionId;
        presc.medicalServices = this.patientVisit.medicalServices;
        presc.prescriptionDetailDTOS = [];
        presc.patientId = this.patientService.patientObject.patientId;
        presc.diagnosis = this.patientVisit.diagnoseData;
        presc.notes = this.patientVisit.note;
        presc.symptoms = this.patientVisit.symptoms;
        presc.externalNote = this.patientVisit.externalNote;
        var details = [];
        var bOK = true;
        this.patientVisit.prescribableDrug.forEach((obj: PrescribableDrug) => {
                var detail:PrescriptionDetail = new PrescriptionDetail();
                if (obj.packages && obj.packages.length >0)
                {
                  detail.drugPackageId = obj.packages[obj.selectedStrengthIndex].drugPackageId;
                } else {
                  detail.drugPackageId = obj.drugPackage.drugPackageId;
                }
                detail.amount = obj.doseAmount;
                detail.duration = obj.doseDuration;
                if (detail.drugPackageId < 0 )
                {
                    alert('Prescription has empty fields');
                    bOK=false;
                    return;
                }
                detail.doseFrequencyId = obj.frequency.doseFrequencyId;
                detail.intervalUnit = obj.selectedDuration;
                detail.meal = obj.meal;
                detail.neededQty = obj.neededQty;
                details.push(detail);
            }
        );
        if (!bOK) {
            return;
        }
        presc.prescriptionDetailDTOS = details;
        this.drugService.savePrescription(presc).subscribe(
            data => {
                this.patientService.patientObject = null;
                this.drugService.setSavedPrescription(data);
                this.router.navigate(['printPo']);
            }
        );
    }
}
