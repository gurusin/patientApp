import {Component, OnInit} from '@angular/core';
import {DrugPackage} from "../drug-package";
import {DrugServiceService} from "../../services/drug-service.service";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DrugEditComponent} from "./drug-edit/drug-edit.component";
import {DrugPackageDetailComponent} from "../admin/drug-package-detail/drug-package-detail.component";

@Component({
  selector: 'app-drugpackageadmin',
  templateUrl: './drugpackageadmin.component.html',
  styleUrls: ['./drugpackageadmin.component.css']
})
export class DrugpackageadminComponent implements OnInit {


  selectedDrugPackageRow: number;
  drugPackage: DrugPackage;
  selectedDrugPackage: DrugPackage;
  drugPackageList = [];
  strengthList = [];
  drugList = [];

  constructor(private drugServiceService: DrugServiceService, private dialog:MatDialog) {

    this.drugPackage = new DrugPackage();

  }

  setClickedDrugPackageRow(obj: any)
  {
     this.drugPackage = obj;
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

  findIndex(id: number): number {
    var idx = -1;
    var currIndex = 0
    for (let d of this.drugPackageList) {
      if (d.id == id) {
        idx = currIndex;
        break;
      } else {
        currIndex++;
      }
    }
    return idx;
  }

  onEdit(obj: any) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = new Object();
    dialogConfig.data.drugPackage = obj;
    dialogConfig.data.drugList = this.drugList;
    dialogConfig.data.strengthList = this.strengthList;

    let dialogRef = this.dialog.open(DrugPackageDetailComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(
      result => {
          if(result != null){
             this.drugPackageList = result;
          }
      }
    );
  }

  onNew() {
     this.onEdit(new DrugPackage());
  }

}
