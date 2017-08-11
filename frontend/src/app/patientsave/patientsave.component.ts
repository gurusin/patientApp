import {Component} from '@angular/core';
import {PatientServiceService} from "../patient-service.service";
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {Router} from "@angular/router";


@Component({
  selector: 'app-patientsave',
  templateUrl: './patientsave.component.html',
  styleUrls: ['./patientsave.component.css']
})

export class PatientsaveComponent {

  patient: Patient;

  constructor(private patientService: PatientServiceService, private router: Router) {
    this.patient = new Patient();
  }

  onSubmit() {
    this.patientService.savePatient(this.patient).subscribe(
      data => {
        console.log(data);
        this.patient = data;
      }
    );
    this.router.navigate(['../patientvisit'])
  }
}
