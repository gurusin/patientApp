import {Component, OnInit} from '@angular/core';
import {DrugPackage} from "../drug-package";
import {Basedrug} from "../basedrug";
import {DrugServiceService} from "../../services/drug-service.service";

@Component({
  selector: 'app-basedrugadmin',
  templateUrl: './basedrugadmin.component.html',
  styleUrls: ['./basedrugadmin.component.css']
})
export class BasedrugadminComponent implements OnInit {

  baseDrugList = [];
  selectedBaseDrugRow: number;
  setClickedBaseDrugRow: Function;
  baseDrug: Basedrug;
  selectedBaseDrug: Basedrug;

  constructor(private drugServiceService: DrugServiceService) {
    this.baseDrug = new Basedrug();

    this.setClickedBaseDrugRow = function (index) {
      this.selectedBaseDrugRow = index;
      if (index >= 0 && index < this.baseDrugList.length) {
        this.drugServiceService.baseDrug = this.baseDrugList[index];
        this.selectedBaseDrug = this.baseDrugList[index];
        this.baseDrug = this.selectedBaseDrug;
      }
    }

  }

  ngOnInit() {
    this.drugServiceService.loadBaseDrugs(
    ).subscribe(
      data => {
        this.baseDrugList = data;
      }
    );
  }

  onSubmit() {
    this.drugServiceService.saveBaseDrug(this.baseDrug);
    this.drugServiceService.baseDrug = new Basedrug();
    this.drugServiceService.loadBaseDrugs(
    ).subscribe(
      data => {
        this.baseDrugList = data;
      }
    );
    // window.location.reload();
  }

  cancelEdit() {
    this.selectedBaseDrugRow = -1;
    this.selectedBaseDrug = new Basedrug();
    this.baseDrug = this.selectedBaseDrug;
  }

}
