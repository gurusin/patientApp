import {Component, Input, OnInit} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {Patient} from "../patient";
import {Router} from "@angular/router";
import {LoginService} from "../services/login-service.service";


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
    if (this.patient && this.patient.patientId > 0)
    {
      this.newPatient = false;
    }
  }

  constructor(private patientService: PatientServiceService, private router: Router,
    private loginService:LoginService)
  {
  }

  onSubmit() {
    this.patientService.savePatient(this.patient).subscribe(
        data =>{
            this.patientService.patientObject = data;
            this.router.navigate(['dentalPatList']);
        }
    );

  }
}
