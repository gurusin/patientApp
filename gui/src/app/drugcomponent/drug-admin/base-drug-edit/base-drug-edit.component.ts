import {Component, Inject, OnInit} from '@angular/core';
import {Basedrug} from "../../basedrug";
import {DrugServiceService} from "../../../services/drug-service.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-base-drug-edit',
  templateUrl: './base-drug-edit.component.html',
  styleUrls: ['./base-drug-edit.component.css']
})
export class BaseDrugEditComponent implements OnInit {

  baseDrug: Basedrug = new Basedrug();

  constructor(private drugServiceService:DrugServiceService, private dialogRef:MatDialogRef<BaseDrugEditComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
    Object.assign(this.baseDrug, data.baseDrug);
  }


  ngOnInit(): void {
  }

  onSubmit() {
    this.drugServiceService.saveBaseDrug(this.baseDrug).subscribe(
      data => {
        this.dialogRef.close(data);
      }
    );
  }

  cancelEdit() {
     this.dialogRef.close(null);
  }

}
