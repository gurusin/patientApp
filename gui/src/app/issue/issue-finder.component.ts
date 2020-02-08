import {Component, OnInit} from '@angular/core';
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-issue-finder',
  templateUrl: './issue-finder.component.html',
  styleUrls: ['./issue-finder.component.css']
})
export class IssueFinderComponent implements OnInit {

  makeIssue: any;
  total = 0;
  paidAmount = 0;
  printDisabled = true;
  saveDisabled = false;

  constructor(private issueService: IssueServiceService, private router: Router,) {

  }

  registerIssue() {
    this.issueService.registerIssue(this.makeIssue).subscribe(
      data => {
        this.saveDisabled = true;
        this.printDisabled = false;
      }
    )
  }


  calculateTotal() {
    this.total = 0;
    this.makeIssue.details.forEach(
      item => {
        this.total = this.total + item.currentIssuedQty * item.drugPackage.unitPrice
      }
    );

    if (this.makeIssue.serviceItems != null)
    {
      this.makeIssue.serviceItems.forEach(
        item => {
          this.total += item.fee
        }
      );
    }
  }

  ngOnInit() {
    this.makeIssue = this.issueService.makeIssue;
    this.makeIssue.dateOfIssue = new Date();
    this.calculateTotal();
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

  updated(event)
  {
    this.total = event;
  }

}


