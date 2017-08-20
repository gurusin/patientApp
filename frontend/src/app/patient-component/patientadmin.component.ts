import {Component, OnInit} from '@angular/core';
import {PatientServiceService} from "../patient-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-patientadmin',
  templateUrl: './patientadmin.component.html',
  styleUrls: ['./patientadmin.component.css']
})
export class PatientadminComponent implements OnInit {

  selectedRow: Number;
  setClickedRow: Function;

  patientList = [];

  constructor(private patientService: PatientServiceService, private router: Router) {
    this.setClickedRow = function (index) {
      this.selectedRow = index;
      this.patientService.patientObject = this.patientList[index];
    }

  }

  ngOnInit() {
    this.patientService.loadPatients(
    ).subscribe(
      data => {
        this.patientList = data;
      }
    );
  }

  onEditPatient() {
    {
      if (this.patientService.patientObject == null) {
        alert(" Please select a patient ");
      } else {
        this.router.navigate(["patientsave"]);

      }
    }

  }

}
