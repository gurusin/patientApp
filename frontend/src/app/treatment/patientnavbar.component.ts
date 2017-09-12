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
  @Input() patient: Patient;

  constructor(private patientService:PatientServiceService, private router:Router){

  }

  ngOnInit(): void {

  }

  onEditPatient()
  {
    this.patientService.patient = new Subject<Patient>();
    this.patientService.patient.next(this.patient);
    this.router.navigate(["patientsave"]);

  }
}
