import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "../treatment/patientvisit";
import {Drug} from "../drugcomponent/drug";
import {DrugServiceService} from "../drug-service.service";
import {DrugSearchResult} from "app/prescription-component/drug-search-result";
import {forEach} from "@angular/router/src/utils/collection";
import {PrescribableDrug} from "./prescribable-drug";
import 'rxjs/Rx';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {PatientServiceService} from "../patient-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-prescription-component',
  templateUrl: './prescription-component.component.html',
  styleUrls: ['./prescription-component.component.css']
})
export class PrescriptionComponentComponent implements OnInit {

  @Input() patientVisit: Patientvisit;
  drugList: DrugSearchResult[];
  drugName: '';
  selectedId: number;
  prescribableDrug=[];

  constructor(private drugService: DrugServiceService,
              private patientService:PatientServiceService,
              private router:Router) {
    this.prescribableDrug = [];
  }

  ngOnInit() {
  }

  setDrugId() {
    this.drugList.forEach((obj: DrugSearchResult) => {
        if (obj.brandName === this.drugName) {
          this.selectedId = obj.drugId;
        }
      }
    );
  }

  searchDrug(event: any) {
    if (event.keyCode == 13) {
      // Search for prescibable
      this.setDrugId();
      this.searchPrescribable();
    } else if (this.drugName.length == 2) {
      // Search for drug
      this.doSearch();
    } else if (this.drugName.length == 1) {
      //clear search
      this.drugList = [];
    }
  }

  doSearch() {
    this.drugService.searchDrug(this.drugName).subscribe(
      data => {
        this.drugList = data;
      }
    );
  }

  private searchPrescribable() {
    this.drugService.searchPrescribable(this.selectedId).subscribe(
      data => {
        this.prescribableDrug.push(data);
        console.log(this.prescribableDrug);
      });
  }

  remove(index)
  {
    this.prescribableDrug.splice(index,1);
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
    this.prescribableDrug.forEach((obj: PrescribableDrug) => {
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

export class Prescription
{
  symptoms:string;
  diagnosis:string;
  notes:string;
  prescriptionDetails:PrescriptionDetail[];
  patientId:number;

}
export class PrescriptionDetail
{
  drug:Drug;
  drugId:string;
  strength:string;
  frequency:string;
  amount:number;
  duration:number;
  intervalUnit:string;
  meal:string;


  constructor() {
    this.drug = new Drug();

  }
}

