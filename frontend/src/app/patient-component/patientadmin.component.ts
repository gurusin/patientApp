import { Component, OnInit } from '@angular/core';
import {PatientServiceService} from "../patient-service.service";

@Component({
  selector: 'app-patientadmin',
  templateUrl: './patientadmin.component.html',
  styleUrls: ['./patientadmin.component.css']
})
export class PatientadminComponent implements OnInit {

  selectedRow : Number;
  setClickedRow : Function;

  patientList =[];
  constructor(private patientService:PatientServiceService) {
    this.setClickedRow = function(index){
      this.selectedRow = index;
    }

  }

  ngOnInit() {
    this.patientService.loadPatients(
    ).subscribe(
      data =>{this.patientList =data;
      }
    );
  }

}
