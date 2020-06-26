import { Component, OnInit } from '@angular/core';
import {DrugServiceService} from "../../../services/drug-service.service";
import {AdminService} from "../../../services/admin.service";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DrugEditComponent} from "../../drug-admin/drug-edit/drug-edit.component";
import {StrengthDetailComponent} from "../../../strength/strength-detail/strength-detail.component";

@Component({
  selector: 'app-strengh',
  templateUrl: './strength.component.html',
  styleUrls: ['./strength.component.css']
})
export class StrengthComponent implements OnInit {

  strengthList =[];
  strength: any
  units =[];
  constructor(private drugService:DrugServiceService, private adminService:AdminService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.initObject();
    this.drugService.loadStregths().subscribe(
      data =>{
        this.strengthList = data;

      }
    );

    this.adminService.getStrengthUnits().subscribe(
      data =>{this.units = data}
    );
  }

  doSave()
  {
    this.adminService.saveStrength(this.strength).subscribe(
      data=>{
        this.strengthList = data;
        this.initObject();
      }
    )
  }

  private initObject() {
    this.strength = {
      strengthUnit: {unitId: ''},
      strengthAmount: 0.0
    }
  }

  onEdit(row: any) {
    this.strength = row;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = new Object();
    dialogConfig.data.units = this.units;
    dialogConfig.data.strength = {
      strengthAmount : row.strengthAmount,
      strengthUnit: {unitId: row.unitId},
       unitName : row.unitName,
    };

    let dialogRef = this.dialog.open(StrengthDetailComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(
      result => {
        if (result != null) {
               this.strengthList = result;
        }
      });
  }

  onNew() {
     this.initObject();
     this.onEdit(this.strength);
  }
}
