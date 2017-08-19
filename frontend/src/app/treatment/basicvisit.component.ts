import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";
import {Prescription, PrescriptionDetail} from "../prescription-component/prescription-component.component";
import {PatientServiceService} from "../patient-service.service";
import {PrescribableDrug} from "../prescription-component/prescribable-drug";
import {DrugServiceService} from "../drug-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-basicvisit',
  templateUrl: './basicvisit.component.html',
  styleUrls: ['./basicvisit.component.css']
})
export class BasicvisitComponent implements OnInit {

  patientVisit:Patientvisit;
  @Input() patient:Patient;

  constructor(private patientService:PatientServiceService,
  private drugService:DrugServiceService,private router:Router) {
    this.patientVisit = new Patientvisit();
    this.patientVisit.diagnoseData='';
    this.patientVisit.prescribableDrug=[]
  }

  ngOnInit() {
  }

  onSave()
  {
    var presc = new Prescription();
    presc.prescriptionDetails=[];
    presc.patientId = this.patientService.patientObject.patientId;
    presc.diagnosis = this.patientVisit.diagnoseData;
    presc.notes = this.patientVisit.note;
    presc.symptoms = this.patientVisit.symptoms;

    var details =[];
    this.patientVisit.prescribableDrug.forEach((obj: PrescribableDrug) => {
        var detail = new PrescriptionDetail();
        detail.drugId =obj.drug.drugId;
        detail.drug.drugId =obj.drug.drugId;
        detail.amount =obj.doseAmount;
        detail.duration =obj.doseDuration;
        detail.strength =obj.selectedStrength;
        detail.frequency=obj.selectedFrequency;
        detail.intervalUnit = obj.selectedDuration;
        detail.meal = obj.meal;
        details.push(detail);
      }
    );
    presc.prescriptionDetails =details;
    this.drugService.savePrescription(presc);
    this.router.navigate(['patientvisit/treatmentHistory']);

  }

}
