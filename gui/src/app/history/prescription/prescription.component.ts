import { Component, OnInit } from '@angular/core';
import {Prescription} from "../../prescription-component/prescription-component.component";
import {DrugServiceService} from "../../services/drug-service.service";
import {PatientServiceService} from "../../services/patient-service.service";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit {

  prescription:any = new Object();
  prescriptionList: any[] = [];
  currentIndex:number =-1;

  constructor(private drugService:DrugServiceService,private patientService:PatientServiceService,
              private dialogRef:MatDialogRef<PrescriptionComponent>) { }


  ngOnInit(): void {
    this.drugService.getPrescriptionForPatient(this.patientService.patientObject.patientId
    ).subscribe(
      data =>{
        this.prescriptionList =data;
        if(this.prescriptionList.length >0){
          this.currentIndex = 0;
           this.setPrescription();
        }
      }
    );
  }

  setPrescription(){
    this.prescription = this.prescriptionList[this.currentIndex];
  }

  close() {
    this.dialogRef.close(null);
  }

  previous() {
    if(this.currentIndex ==0){
      alert('This is the first one');
      return;
    }
    this.currentIndex--;
    this.setPrescription();
  }

  next() {
    if(this.currentIndex ==(this.prescriptionList.length-1)){
      alert('This is the last one');
      return;
    }
    this.currentIndex++;
    this.setPrescription();
  }
}
