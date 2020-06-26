import {Component, Inject, OnInit} from '@angular/core';
import {DrugServiceService} from "../../services/drug-service.service";
import {AdminService} from "../../services/admin.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-strength-detail',
  templateUrl: './strength-detail.component.html',
  styleUrls: ['./strength-detail.component.css']
})
export class StrengthDetailComponent implements OnInit {

  units =[];
  strength = {
    strengthUnit: {unitId: ''},
    strengthAmount: 0.0
  };

  constructor(private adminService:AdminService, private dialogRef:MatDialogRef<StrengthDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
     this.units = data.units;
     this.strength = data.strength;
  }

  ngOnInit(): void {
  }

  doSave() {
    this.adminService.saveStrength(this.strength).subscribe(
      data=>{
        this.dialogRef.close(data);
      }
    )
  }

  onCancel() {
    this.dialogRef.close(null);
  }
}
