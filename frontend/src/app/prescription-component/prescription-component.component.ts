import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "../treatment/patientvisit";
import {Drug} from "../drugcomponent/drug";
import {DrugServiceService} from "../services/drug-service.service";
import {DrugSearchResult} from "app/prescription-component/drug-search-result";
import {forEach} from "@angular/router/src/utils/collection";
import {PrescribableDrug} from "./prescribable-drug";
import 'rxjs/Rx';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {PatientServiceService} from "../services/patient-service.service";
import {Router} from "@angular/router";
import {concatStatic} from "rxjs/operator/concat";
import {Dosefrequency} from "../drugcomponent/dosefrequency";
import {Strength} from "../drugcomponent/strength";

@Component({
  selector: 'app-prescription-component',
  templateUrl: './prescription-component.component.html',
  styleUrls: ['./prescription-component.component.css']
})
export class PrescriptionComponentComponent implements OnInit {

  @Input() patientVisit: Patientvisit;
  selectedId:any;

  constructor(private drugService: DrugServiceService,
              private patientService:PatientServiceService,
              private router:Router) {
  }

  ngOnInit() {
    var obj = new PrescribableDrug();
    this.patientVisit.prescribableDrug.push(obj);
    console.log(obj);
  }

  doSearch(drugName:string,row:PrescribableDrug) {
    this.drugService.searchDrug(drugName).subscribe(
      data => {
        row.drugList = data;
      }
    );
  }

  addDrug()
  {
      this.patientVisit.prescribableDrug.forEach((obj: PrescribableDrug) => {
        console.log(obj);
      });
    this.patientVisit.prescribableDrug.push(new PrescribableDrug());
  }

  private searchPrescribable(row:PrescribableDrug,i:number) {
    this.drugService.searchPrescribable(this.selectedId).subscribe(
      data => {
        console.log(data);
        this.patientVisit.prescribableDrug.splice(i,1,data);
      });
  }

  setDrugId(pres:PrescribableDrug) {
    pres.drugList.forEach((obj: DrugSearchResult) => {
        if (obj.brandName === pres.drug.brandName) {
          this.selectedId = obj.drugId;
          return;
        }
      }
    );
  }

  removeDrug(i:number)
  {
    this.patientVisit.prescribableDrug.
    splice(i,1);
  }

  searchDrug(event: any, row:PrescribableDrug,i:number) {
    var drugName = row.drug.brandName;
    if (event.keyCode == 13) {
      // Search for prescibable
      this.setDrugId(row);
      this.searchPrescribable(row,i);
    } else if (drugName.length == 2) {
      // Search for drug
      this.doSearch(drugName,row);
    } else if (drugName.length == 1) {
      //clear search
      row.drugList = [];
    }
  }
}

export class Prescription
{
  symptoms:string;
  diagnosis:string;
  notes:string;
  prescriptionDetails:PrescriptionDetail[];
  patientId:number;
  medicalServices:any[];

}
export class PrescriptionDetail
{
  drug:Drug;
  drugId:string;
  strength:Strength;
  frequency:Dosefrequency;
  amount:number;
  duration:number;
  intervalUnit:string;
  meal:string;


  constructor() {
    this.drug = new Drug();
    this.frequency = new Dosefrequency();
    this.strength = new Strength();
  }

  public isValid():boolean
  {
    var passed = true;
    passed = (this.amount > 0) && (this.duration >0) && (this.intervalUnit != null) &&
        this.frequency != null && this.drugId != null && this.meal != null;
    return passed;
  }

}


