import {Component, Inject, OnInit} from '@angular/core';
import {DrugServiceService} from "../../../services/drug-service.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {DrugPackage} from "../../drug-package";
import {Drug} from "../../drug";
import {Strength} from "../../strength";

@Component({
  selector: 'app-drug-package-detail',
  templateUrl: './drug-package-detail.component.html',
  styleUrls: ['./drug-package-detail.component.css']
})
export class DrugPackageDetailComponent implements OnInit {

  drugPackage:DrugPackage=new DrugPackage();
  drugList:Drug[] =[];
  strengthList =[];

  constructor(private drugService:DrugServiceService,private dialogRef:MatDialogRef<DrugPackageDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any)
  {
     Object.assign(this.drugPackage, data.drugPackage);
     this.drugList = data.drugList;
     this.strengthList = data.strengthList;
  }

  ngOnInit(): void {
  }

  cancelEdit() {
    this.dialogRef.close(null);
  }

  onSubmit() {
    this.drugService.saveDrugPackage(this.drugPackage).subscribe(
      data =>{
        this.dialogRef.close(data);
      }
    );
  }
}
