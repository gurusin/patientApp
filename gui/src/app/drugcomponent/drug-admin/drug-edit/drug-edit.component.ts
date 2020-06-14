import {Component, Inject, OnInit} from '@angular/core';
import {DrugServiceService} from "../../../services/drug-service.service";
import {Drug} from "../../drug";
import {
  MAT_DIALOG_DATA, MatDialogRef
} from "@angular/material/dialog";


@Component({
  selector: 'app-drug-edit',
  templateUrl: './drug-edit.component.html',
  styleUrls: ['./drug-edit.component.css']
})
export class DrugEditComponent implements OnInit {

  baseDrugList = [];
  drugList = [];
  selectedDrugRow = -1;
  drug: Drug;
  selectedDrug: Drug;

  constructor(private drugServiceService:DrugServiceService,
              private dialogRef:MatDialogRef<DrugEditComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
     this.baseDrugList = data.list;
     this.drug = data.drug;
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.drugServiceService.saveDrug(this.drug).subscribe(
      data => {
        this.dialogRef.close(data);
      }
    );
  }

  cancelEdit() {
    this.dialogRef.close(null);
  }


}
