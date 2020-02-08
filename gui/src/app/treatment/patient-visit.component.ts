import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";
import {ActivatedRoute, Data, Params, Router} from "@angular/router";
import {PatientServiceService} from "../services/patient-service.service";

@Component({
    selector: 'app-patient-visit',
    templateUrl: './patient-visit.component.html',
    styleUrls: ['./patient-visit.component.css']
})
export class PatientVisitComponent implements OnInit {
    patientVisit: Patientvisit;
    patient: Patient = null;
    @Input() selectedPatient: Patient;

    toggleText = "show";
    showHistory = false;

    onEditPatient() {
        this.patientService.patientObject = new Patient();
        this.router.navigate(["patientsave"]);

    }

    handleHistory() {
        this.showHistory = !this.showHistory;
        if (this.showHistory) {
            this.toggleText = 'Hide';
        } else {
            this.toggleText = 'Show';
        }

    }

    ngOnInit(): void {
        this.patient = this.patientService.patientObject;
        this.patientVisit = new Patientvisit();
        this.patientVisit.patientId = this.patient.patientId;
    }

    constructor(private router: Router, private patientService: PatientServiceService) {

    }
}
