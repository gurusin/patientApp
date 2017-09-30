import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../patient";
import {PatientServiceService} from "../services/patient-service.service";
import {Subject} from "rxjs/Subject";
import {Router} from "@angular/router";

@Component({
  selector: 'app-patientnavbar',
  templateUrl: './patientnavbar.component.html',
  styleUrls: ['./patientnavbar.component.css']
})
export class PatientnavbarComponent implements OnInit
{
  patient : any;
  showHistory = false;
  toggleText ='Show';
  constructor(private patientService:PatientServiceService, private router:Router){
     this.patient = patientService.patientObject;
  }

  ngOnInit(): void {

  }

  handleHistory() {
    this.showHistory = !this.showHistory;
    if (this.showHistory) {
      this.toggleText = 'Hide';
    } else {
      this.toggleText = 'Show';
    }

  }


  onEditPatient()
  {
    this.router.navigate(["patientsave"]);
  }
}
