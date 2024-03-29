import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "../treatment/patientvisit";
import {Drug} from "../drugcomponent/drug";
import {DrugServiceService} from "../services/drug-service.service";
import {PrescribableDrug} from "./prescribable-drug";
import {Patient} from "../patient";
import {PatientServiceService} from "../services/patient-service.service";
import {Router} from "@angular/router";
import {Dosefrequency} from "../drugcomponent/dosefrequency";
import {Strength} from "../drugcomponent/strength";
import {DrugSearchResult} from "./drug-search-result";

@Component({
  selector: 'app-prescription-component',
  templateUrl: './prescription-component.component.html',
  styleUrls: ['./prescription-component.component.css']
})
export class PrescriptionComponentComponent implements OnInit {

  @Input() patientVisit: Patientvisit;
  prescribableDrug: PrescribableDrug;
  selectedId: any;
  drugId = '';
  total = 0;

  constructor(private drugService: DrugServiceService,
              private patientService: PatientServiceService,
              private router: Router) {
  }

  ngOnInit() {
    this.prescribableDrug = new PrescribableDrug();
  }

  doSearch(drugName: string) {
    this.drugService.searchDrug(drugName).subscribe(
      data => {
        this.prescribableDrug.drugList = data;
      }
    );
  }

  addDrug(comp:any) {
    alert("Adding drug" + comp);
    var x = new PrescribableDrug();
    this.prescribableDrug.frequency = this.prescribableDrug.doseFrequency[this.prescribableDrug.selectedFrequency];
    Object.assign(x,this.prescribableDrug);
    this.patientVisit.prescribableDrug.unshift(x);
    this.prescribableDrug = new PrescribableDrug();
    this.drugId='';
    this.calculateTotal();
    comp.focus();
  }

  private searchPrescribable(searchId,nextComp:any) {
    if (searchId > -1)
    {
      this.drugService.searchPrescribable(searchId).subscribe(
        data => {
          this.prescribableDrug = data;
          this.prescribableDrug.selectedStrength = this.prescribableDrug.packages[0].strength;
          this.prescribableDrug.selectedStrengthIndex =0;
          this.prescribableDrug.selectedFrequency =-1;
          this.selectStrength();
          this.drugId = this.prescribableDrug.drug.brandName;
          nextComp.focus();
        });
    }
  }

  public checkValid()
  {
    this.prescribableDrug.valid =
      this.prescribableDrug.drug &&
      this.prescribableDrug.selectedStrengthIndex >-1 &&
      this.prescribableDrug.selectedFrequency >-1 &&
      this.checkDoseAmount();
      if (this.prescribableDrug.valid)
      {
        this.calculatePrice();
      }
  }

  calcNeeded()
  {
    this.prescribableDrug.price = this.prescribableDrug.unitPrice * this.prescribableDrug.neededQty;
  }
  private checkDoseAmount():boolean
  {
     var result:boolean = !(!this.prescribableDrug.meal || !this.prescribableDrug.selectedDuration);
     if (result && this.prescribableDrug.selectedDuration !=='When Needed' )
     {
       result = this.prescribableDrug.doseAmount > 0 && this.prescribableDrug.doseDuration >0;
     }
     return result;
  }


  selectStrength() {
    this.prescribableDrug.availableQty = this.prescribableDrug.packages[this.prescribableDrug.selectedStrengthIndex].quantity;
    this.prescribableDrug.unitPrice = this.prescribableDrug.packages[this.prescribableDrug.selectedStrengthIndex].unitPrice;
    this.prescribableDrug.meal = 'ORAL';
  }

  setDrugId(pres: PrescribableDrug) {
    pres.drugList.forEach((obj: DrugSearchResult) => {
        if (obj.brandName === pres.drug.brandName) {
          this.selectedId = obj.drugId;
          return;
        }
      }
    );
  }

  removeDrug(i: number) {
      this.patientVisit.prescribableDrug.splice(i, 1);
      this.calculateTotal();
  }

  searchDrug(event: any, dd:any, textCmp: any,nextComp: any) {
     var searchText:string = textCmp.value;
    if (dd.selectedIndex > -1 && searchText.length > 1) {
      var drugId = this.getSelectedId(searchText);
       this.searchPrescribable(drugId,nextComp);

    } else if (searchText.length == 2) {
      // Search for drug
      this.doSearch(searchText);
    } else if (searchText.length == 1) {
      //clear search
      this.prescribableDrug.drugList = [];
    }
  }

  getSelectedId(text:string):string
  {
     var retObj = '-1';
     this.prescribableDrug.drugList.forEach(
       item =>{
           if (item.brandName === text)
           {
             retObj = item.drugId;
             return retObj;
           }
       }
     );
     return retObj;
  }

  calculatePrice() {
    this.calculateQty(this.prescribableDrug);
    this.prescribableDrug.price = this.prescribableDrug.unitPrice * this.prescribableDrug.neededQty;
  }

  calculateTotal()
  {
     this.total =0;
     this.patientVisit.prescribableDrug.forEach(
       obj =>{
         this.total += obj.price;
       }
     );
  }

  private calculateQty(obj: PrescribableDrug) {
    if (obj.selectedFrequency > -1) {
      this.getNoOfDosesForPrescription(obj);
    }
  }

  private getNoOfDosesForPrescription(obj: PrescribableDrug) {
    var freq = obj.doseFrequency[obj.selectedFrequency];
    obj.neededQty = 1;

    // Should not be calculated  for local application etc.
    if (obj.meal !=='ORAL')
    {
      return;
    }
    switch (obj.selectedDuration) {
      case "Days": {
        obj.neededQty = freq.noofDoses * obj.doseAmount * obj.doseDuration;
        break;
      }
      case "Weeks": {
        obj.neededQty = freq.noofDoses * 7 * obj.doseAmount * obj.doseDuration;
        break;
      }
      case "Months": {
        obj.neededQty = freq.noofDoses * 30 * obj.doseAmount * obj.doseDuration;
        break;
      }
      case "When Needed": {
        obj.neededQty = obj.doseAmount * 1;
        break;
      }
    }
  }

  test(drugName: HTMLInputElement) {
    alert('Hello there');
  }
}

export class Prescription {
  id:number;
  patient:Patient;
  prescriptionId:number;
  symptoms: string;
  diagnosis: string;
  notes: string;
  prescriptionDetailDTOS: PrescriptionDetail[];
  patientId: number;
  medicalServices: any[];
  externalNote: string;
  prescriptionDetails =[];
  prescriptionStatus;
}

export class PrescriptionDetail {
  drugPackageId: number;
  drug: Drug;
  drugId: string;
  strength: Strength;
  frequency: Dosefrequency;
  amount: number;
  duration: number;
  intervalUnit: string;
  meal: string;
  doseFrequencyId: number;
  neededQty:number;


  constructor() {
    this.drug = new Drug();
    this.frequency = new Dosefrequency();
    this.strength = new Strength();
  }

  public isValid(): boolean {
    var passed = true;
    return passed;
  }

}


