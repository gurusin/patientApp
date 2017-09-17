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

    prescriptionDTOList = [];
    date: Date;

    constructor(private issueService: IssueServiceService, private drugService: DrugServiceService, private router: Router) {
        this.date = new Date();
    }

    printView(savedPrescription) {
        this.drugService.savedPrescription = savedPrescription;
        this.router.navigate(['printPo']);
    }

    ngOnInit() {
        this.drugService.loadPrescriptionByDate(this.date
        ).subscribe(
            data => {
                this.prescriptionDTOList = data;
            }
        );
    }

    issueDrugs(index) {
        this.issueService.issue = this.prescriptionDTOList[index].issueNote;
        this.router.navigate(["/findIssue"]);
    }

}
