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
    date: Date;
    prescriptionSearchCriteria : any

    constructor(private issueService: IssueServiceService, private drugService: DrugServiceService,
                private router: Router) {
        this.prescriptionSearchCriteria = new Object();
        this.prescriptionSearchCriteria.initial = true;
        this.prescriptionSearchCriteria.fromDate= new Date();
    }

   doSearch()
   {
     this.drugService.searchPrescriptions(this.prescriptionSearchCriteria).subscribe(
       data =>{ this.prescriptionList = data;}
     );
   }

    printView(savedPrescription) {
        this.drugService.savedPrescription = savedPrescription;
        this.router.navigate(['printPo']);
    }

    ngOnInit() {

    }

    issueDrugs(prescriptionId) {
        this.issueService.createIssueForPrescription(prescriptionId).subscribe(
          data =>{
            this.issueService.makeIssue = data;
            this.router.navigate(["/findIssue"]);
          }
        );

    }

}
