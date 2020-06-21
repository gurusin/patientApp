import {Component, OnInit} from '@angular/core';
import {DrugPackage} from "../drug-package";
import {Basedrug} from "../basedrug";
import {DrugServiceService} from "../../services/drug-service.service";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DrugEditComponent} from "./drug-edit/drug-edit.component";
import {BaseDrugEditComponent} from "./base-drug-edit/base-drug-edit.component";

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

  constructor(private drugServiceService: DrugServiceService, private dialog: MatDialog) {
    this.baseDrug = new Basedrug();
  }

  setClickedBaseDrugRow(obj) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = new Object();
    dialogConfig.data.baseDrug = obj;

    let dialogRef = this.dialog.open(BaseDrugEditComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(
      result => {
        console.log(result);
        if (result != null) {
          var idx = this.findIndex(result.baseDrugId);
          if (idx >= 0) {
            this.baseDrugList[idx].baseDrugName = result.baseDrugName;
          } else {
            this.baseDrugList.push(result);
          }
        }
      }
    );
  }

  findIndex(id: number): number {
    var idx = -1;
    var currIndex = 0
    for (let d of this.baseDrugList) {
      if (d.baseDrugId == id) {
        idx = currIndex;
        break;
      } else {
        currIndex++;
      }
    }
    return idx;
  }

  ngOnInit() {
    this.drugServiceService.loadBaseDrugs(
    ).subscribe(
      data => {
        this.baseDrugList = data;
      }
    );
  }


  onNew() {
    this.setClickedBaseDrugRow(new Basedrug())
  }
}
