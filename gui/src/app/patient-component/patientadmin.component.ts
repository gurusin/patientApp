import {Component, OnInit} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
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

  constructor(private patientService: PatientServiceService, private router: Router){
  }

  goToEditView(patId)
  {
    this.patientService.getByPatNo(patId).subscribe(
      data =>{
        this.patientService.patientObject = data;
        this.router.navigate(["/patientsave"]);
      }
    );
  }

  ngOnInit() {
    this.patientService.loadPatients(
    ).subscribe(
      data => {
        this.patientList = data;
        this.patientList.forEach(pat =>{
           pat.name = pat.firstname+ " "+pat.lastname;
        })
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
