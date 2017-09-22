import { Component, OnInit } from '@angular/core';
import {ItemServiceService} from "../services/item-service.service";
import {Router} from "@angular/router";
import {POServiceService} from "../services/poservice.service";
import {IssueServiceService} from "../services/issue-service.service";
import {PatientServiceService} from "../services/patient-service.service";
import {Patientvisit} from "../treatment/patientvisit";

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  patientVisit =new Patientvisit();
  dateOfIssue = new Date();

  constructor(private issueService: IssueServiceService, private router: Router,
              private patientService:PatientServiceService) {

  }

  cancelIssue()
  {
    this.router.navigate(['start']);
  }

  saveIssue()
  {
    let makeIssue = Object();
    makeIssue.patient = new Object();
    makeIssue.patient.patientId = this.patientService.patientObject.patientId;
    makeIssue.prescriptionId = -1;
    makeIssue.dateOfIssue = this.dateOfIssue;
    makeIssue.serviceItems = [];
    this.patientVisit.medicalServices.forEach( item =>{
         var detail =  {
           medicalServItem:{itemId: item.itemId},
           fee : item.unitPrice,
           externalRef : item.externalRef
         };
         makeIssue.serviceItems.push(detail);
      });
     this.issueService.registerIssue(makeIssue).subscribe(
        data =>{
          this.router.navigate(['start']);
        }
     );

  }

  ngOnInit() {
    if (!this.patientService.patientObject)
    {
      alert('Please select a patient first');
      this.router.navigate(['start']);
    }
  }

}
