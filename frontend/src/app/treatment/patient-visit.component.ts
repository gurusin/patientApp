import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";

@Component({
  selector: 'app-patient-visit',
  templateUrl: './patient-visit.component.html',
  styleUrls: ['./patient-visit.component.css']
})
export class PatientVisitComponent {
  patientVisit: Patientvisit;
  @Input() selectedPatient: Patient;

  constructor() {
    this.patientVisit = new Patientvisit();
  }
}
