import {Component, Input, OnInit} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {Router} from "@angular/router";
import {Subject} from "rxjs/Subject";


@Component({
  selector: 'app-patientsave',
  templateUrl: './patientsave.component.html',
  styleUrls: ['./patientsave.component.css']
})

export class PatientsaveComponent implements OnInit{

  patient: Patient = null;
  newPatient=true;
  @Input() selectedPatient: Patient;

  ngOnInit(): void {
    this.patient =  this.patientService.patientObject;
    if (this.patient.patientId > 0)
    {
      this.newPatient = false;
    }

  }

  constructor(private patientService: PatientServiceService, private router: Router)
  {
  }

  onSubmit() {
    this.patientService.savePatient(this.patient)
    this.router.navigate(['patientvisit/treatment'])
  }
}
