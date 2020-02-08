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
  baseDrug: Basedrug;
  selectedBaseDrug: Basedrug;

  constructor(private drugServiceService: DrugServiceService) {
    this.baseDrug = new Basedrug();
  }

    setClickedBaseDrugRow(obj)
    {
        this.baseDrug = obj;
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
    this.drugServiceService.saveBaseDrug(this.baseDrug).subscribe(
        data =>{
            this.drugServiceService.loadBaseDrugs(
            ).subscribe(
                data => {
                    this.baseDrugList = data;
                }
            );
        this.cancelEdit();
        }
    );
  }

  cancelEdit() {
    this.selectedBaseDrugRow = -1;
    this.selectedBaseDrug = new Basedrug();
    this.baseDrug = this.selectedBaseDrug;
  }

}
