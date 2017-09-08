import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../../drug-service.service";
import {Basedrug} from "../basedrug";
import {Drug} from "../drug";
import {DrugPackage} from "../drug-package";

@Component({
  selector: 'app-drug-admin',
  templateUrl: './drug-admin.component.html',
  styleUrls: ['./drug-admin.component.css']
})
export class DrugAdminComponent implements OnInit {
  baseDrugList = [];
  drugList = [];
  selectedDrugRow: number;
  setClickedDrugRow: Function;
  drug: Drug;
  selectedDrug: Drug;


  constructor(private drugServiceService: DrugServiceService) {

    this.drug = new Drug();

    this.setClickedDrugRow = function (index) {
      this.selectedDrugRow = index;
      if (index >= 0 && index < this.drugList.length) {
        this.drugServiceService.drug = this.drugList[index];
        this.selectedDrug = this.drugList[index];
        this.drug = this.selectedDrug;
      }
    }
  }

  ngOnInit() {
    this.drugServiceService.loadDrugs(
    ).subscribe(
      data => {
        this.drugList = data;
      }
    );
    this.drugServiceService.loadBaseDrugs(
    ).subscribe(
      data => {
        this.baseDrugList = data;
      }
    );
  }

  onSubmit() {
    this.drugServiceService.saveDrug(this.drug);
    this.drugServiceService.drug = new Drug();
    this.drugServiceService.loadDrugs(
    ).subscribe(
      data => {
        this.drugList = data;
      }
    );
    window.location.reload();
  }

  cancelEdit() {
    this.selectedDrugRow = -1;
    this.selectedDrug = new Drug();
    this.drug = this.selectedDrug;
  }
}
