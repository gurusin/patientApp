import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../patient";
import {PatientServiceService} from "../services/patient-service.service";
import {Router} from "@angular/router";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DrugPackageDetailComponent} from "../drugcomponent/admin/drug-package-detail/drug-package-detail.component";
import {PrescriptionComponent} from "../history/prescription/prescription.component";

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
  constructor(public patientService:PatientServiceService, public router:Router,private dialog:MatDialog){
     this.patient = patientService.patientObject;
  }

  ngOnInit(): void {

  }

  handleHistory1() {
    // this.showHistory = !this.showHistory;
    // if (this.showHistory) {
    //   this.toggleText = 'Hide';
    // } else {
    //   this.toggleText = 'Show';
    // }


  }

  handleHistory() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.position={
      'top':'0',
      'left':'0'
    }
    dialogConfig.data = new Object();
    let dialogRef = this.dialog.open(PrescriptionComponent, dialogConfig);
    dialogRef.afterClosed().subscribe(
    );
  }



  onEditPatient()
  {
    this.router.navigate(["patientsave"]);
  }
}
