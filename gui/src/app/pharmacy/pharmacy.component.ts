import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";
import {Prescription} from "../prescription-component/prescription-component.component";
import {PatientServiceService} from "../services/patient-service.service";
import {LoginService} from "../services/login-service.service";

@Component({
  selector: 'app-pharmacy',
  templateUrl: './pharmacy.component.html',
  styleUrls: ['./pharmacy.component.css']
})
export class PharmacyComponent implements OnInit {

  prescriptionList = [];
  prescriptionSearchCriteria: PrescriptionSearchCriteria;
  userType;

  constructor(private issueService: IssueServiceService, private drugService: DrugServiceService,
              private router: Router, private patientService:PatientServiceService,
              private loginService:LoginService) {

  }

  isLocked(savedPrescription:Prescription)
  {
     return savedPrescription.prescriptionStatus != 'INITIAL' || this.userType !=1;
  }

  doSearch() {
    this.drugService.searchPrescriptions(this.prescriptionSearchCriteria).subscribe(
      data => {
        this.prescriptionList = data;
      }
    );
  }

  printView(savedPrescription) {
    this.drugService.savedPrescription = savedPrescription;
    this.router.navigate(['printPo']);
  }

  editPrescription(savedPrescription:Prescription) {
    console.log(savedPrescription);
    this.patientService.prepareForEdit(savedPrescription);
    this.router.navigate(["patientvisit/treatment"]);
  }

  ngOnInit() {
    this.prescriptionSearchCriteria = new PrescriptionSearchCriteria();
    this.prescriptionSearchCriteria.fromDate = this.getToday();
    this.prescriptionSearchCriteria.toDate = this.getToday();
    this.doSearch();
    this.userType = this.loginService.loggedInUser.userType;
  }

  getToday(): Date {
    var x = new Date();
    return new Date(x.getFullYear(), x.getMonth(), x.getDate());
  }


  issueDrugs(prescriptionId) {
    this.issueService.createIssueForPrescription(prescriptionId).subscribe(
      data => {
        this.issueService.makeIssue = data;
        this.router.navigate(["/findIssue"]);
      }
    );

  }
}

export class PrescriptionSearchCriteria
{
  initial = true;
  fromDate:Date;
  toDate:Date;
  completed:boolean;
  partCompleted:boolean;
  all:boolean;
}
