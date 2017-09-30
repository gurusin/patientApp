import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-pharmacy',
  templateUrl: './pharmacy.component.html',
  styleUrls: ['./pharmacy.component.css']
})
export class PharmacyComponent implements OnInit {

  prescriptionList = [];
  prescriptionSearchCriteria: PrescriptionSearchCriteria;

  constructor(private issueService: IssueServiceService, private drugService: DrugServiceService,
              private router: Router) {

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

  ngOnInit() {
    this.prescriptionSearchCriteria = new PrescriptionSearchCriteria();
    this.prescriptionSearchCriteria.fromDate = this.getToday();
    this.prescriptionSearchCriteria.toDate = this.getToday();
    this.doSearch();
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
}
