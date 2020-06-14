import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../../services/drug-service.service";
import {Basedrug} from "../basedrug";
import {Drug} from "../drug";
import {DrugPackage} from "../drug-package";
import {MatDialog, MAT_DIALOG_DATA, MatDialogConfig} from "@angular/material/dialog";
import {DrugEditComponent} from "./drug-edit/drug-edit.component";
import {DrugPipePipe} from "../../filter/drug-pipe.pipe";

@Component({
  selector: 'app-drug-admin',
  templateUrl: './drug-admin.component.html',
  styleUrls: ['./drug-admin.component.css']
})
export class DrugAdminComponent implements OnInit {
  baseDrugList = [];
  drugList = [];
  selectedDrugRow = -1;
  drug: Drug;
  selectedDrug: Drug;


  constructor(private drugServiceService: DrugServiceService, private dialog: MatDialog) {

    this.drug = new Drug();

  }

  setClickedDrugRow(obj: any) {
    this.drug = obj;
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

  onEditDrug(drug: Drug) {

    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = new Object();
    dialogConfig.data.list = this.baseDrugList;
    dialogConfig.data.drug = drug;

    let dialogRef = this.dialog.open(DrugEditComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(
      result => {
        if (result != null) {
          var idx = this.findIndex(result.id);
          if (idx > 0) {
            this.drugList[idx] = result;
          } else {
            this.drugList.push(result);
          }
        }
      }
    );
  }


  findIndex(id: number): number {
    var idx = -1;
    var currIndex = 0
    for (let d of this.drugList) {
      if (d.id == id) {
        idx = currIndex;
        break;
      } else {
        currIndex++;
      }
    }
    return idx;
  }


  newDrug() {
    this.onEditDrug(new Drug());
  }
}
