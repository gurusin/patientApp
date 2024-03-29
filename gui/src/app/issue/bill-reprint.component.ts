import {Component, Input, OnInit} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import { ActivatedRoute } from '@angular/router';
import {IssueServiceService} from "../services/issue-service.service";

@Component({
  selector: 'app-bill-reprint',
  templateUrl: './bill-reprint.component.html',
  styleUrls: ['./bill-reprint.component.css']
})
export class BillReprintComponent implements OnInit {

  selectedIssueNote:any;
  total=0;
  obj={}
  constructor(public patientService:PatientServiceService,private route: ActivatedRoute,
              public issueService:IssueServiceService) { }

  ngOnInit() {
    this.selectedIssueNote = this.route.params.subscribe(
      params =>{
        var issueId = params['issue'];
        this.issueService.findIssue(issueId).subscribe(
          data =>{
            this.selectedIssueNote = data;
            this.calculateTotal();
          }
        );
      }
    );
  }

  calculateTotal()
  {
    this.selectedIssueNote.issueNoteDetails.forEach(
       item =>{
         this.total += item.buyingQuantity * item.drugPackage.unitPrice;
       }
    );

    this.selectedIssueNote.issueNoteServiceItems.forEach(
      item =>{
        this.total += item.fee;
      }
    );

  }

  print(issueNote) {
    var printContents = document.getElementById('print-section').innerHTML;
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
    // this.patientService.patientObject = null;
    // this.router.navigate(['pharmacyList']);
  }

}
