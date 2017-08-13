import { Component, OnInit } from '@angular/core';
import {PatientServiceService} from "../patient-service.service";
import {DrugServiceService} from "../drug-service.service";

@Component({
  selector: 'app-prescription-history',
  templateUrl: './prescription-history.component.html',
  styleUrls: ['./prescription-history.component.css']
})
export class PrescriptionHistoryComponent implements OnInit {

  prescriptionList =[];
  constructor(private drugService:DrugServiceService,private patientService:PatientServiceService) { }

  ngOnInit() {
    this.drugService.loadPrescriptions(this.patientService.patientObject.patientId
    ).subscribe(
      data =>{this.prescriptionList =data;
      }
    );
  }

}
