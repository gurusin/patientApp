import {Component, OnInit} from '@angular/core';
import {DrugPackage} from "../drug-package";
import {DrugServiceService} from "../../services/drug-service.service";

@Component({
  selector: 'app-drugpackageadmin',
  templateUrl: './drugpackageadmin.component.html',
  styleUrls: ['./drugpackageadmin.component.css']
})
export class DrugpackageadminComponent implements OnInit {


  selectedDrugPackageRow: number;
  setClickedDrugPackageRow: Function;
  drugPackage: DrugPackage;
  selectedDrugPackage: DrugPackage;
  drugPackageList = [];
  strengthList = [];
  drugList = [];

  constructor(private drugServiceService: DrugServiceService) {

    this.drugPackage = new DrugPackage();

    this.setClickedDrugPackageRow = function (index) {
      this.selectedDrugPackageRow = index;
      if (index >= 0 && index < this.drugPackageList.length) {
        this.drugServiceService.drugPackage = this.drugPackageList[index];
        this.selectedDrugPackage = this.drugPackageList[index];
        this.drugPackage = this.selectedDrugPackage;
      }
    }
  }

  ngOnInit() {
    this.drugServiceService.loadStregths(
    ).subscribe(
      data => {
        this.strengthList = data;
      }
    );

    this.drugServiceService.loadDrugPacakges(
    ).subscribe(
      data => {
        this.drugPackageList = data;
      }
    );

    this.drugServiceService.loadDrugs(
    ).subscribe(
      data => {
        this.drugList = data;
      }
    );
  }

  onSubmit() {
    this.drugServiceService.saveDrugPackage(this.drugPackage).subscribe(
        data =>{
            this.drugPackageList = data;
            this.cancelEdit();
        }
    );
  }

  cancelEdit() {
    this.selectedDrugPackageRow = -1;
    this.selectedDrugPackage = new DrugPackage();
    this.drugPackage = this.selectedDrugPackage;
  }

}
