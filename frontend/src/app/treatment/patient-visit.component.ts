import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";
import {ActivatedRoute, Data, Params, Router} from "@angular/router";
import {PatientServiceService} from "../patient-service.service";
import {Subject} from "rxjs/Subject";

@Component({
  selector: 'app-patient-visit',
  templateUrl: './patient-visit.component.html',
  styleUrls: ['./patient-visit.component.css']
})
export class PatientVisitComponent implements OnInit{
  patientVisit: Patientvisit;
  patient: Patient = null;
  @Input() selectedPatient: Patient;

  onEditPatient()
  {
    this.patientService.patient = new Subject<Patient>();
    this.patientService.patient.next(this.patient);
    this.router.navigate(["patientsave"]);

  }

  ngOnInit(): void {
    this.patientService.patient.subscribe(
      patient =>{
        this.patient = patient;
        this.patientService.patientObject = patient;
      }
    );
  }

  constructor(private router:Router,private patientService:PatientServiceService) {
    this.patientVisit = new Patientvisit();
  }
}
