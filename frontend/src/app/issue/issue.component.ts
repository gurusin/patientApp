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
  printDisabled = true;

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
          this.printDisabled = false;
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
  print() {
    var printContents = document.getElementById('printContent').innerHTML;
    let popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
      <html>
        <head>
        </head>
        <body onload="window.print();window.close()">
        ${printContents}</body>
      </html>`
    );
    popupWin.document.close();
    this.router.navigate(['pharmacyList']);
  }

}
