import {Component, OnInit} from '@angular/core';
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-issue-finder',
  templateUrl: './issue-finder.component.html',
  styleUrls: ['./issue-finder.component.css']
})
export class IssueFinderComponent implements OnInit {

  makeIssue: any;
  total = 0;
  paidAmount = 0;

  constructor(private issueService: IssueServiceService, private router: Router,) {

  }

  registerIssue(){
    this.issueService.registerIssue(this.makeIssue).subscribe(
       data =>{
         this.router.navigate(['pharmacyList']);
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

    this.makeIssue.serviceItems.forEach(
      item => {
        this.total += item.fee
      }
    );
  }

  ngOnInit() {
    this.makeIssue = this.issueService.makeIssue;
    this.calculateTotal();
  }

  getTotal() {

  }

  // Actually call server and make the  issue
  makeIssueItem() {
    // var obj  = new MakeIssue();
    // obj.issueNote = this.issue.issueNote;
    // this.issue.issueNoteDetails.forEach(
    //     item => {
    //         var detail = new MakeIssueDetailDTO();
    //         detail.issueNoteId = item.issueNoteId;
    //         detail.issuedQty = item.issuedQty;
    //         obj.details.push(detail);
    //     }
    // );
    //
    // this.issueService.makeIssue(obj).subscribe(
    //     data =>{
    //         this.router.navigate(['/pharmacyList']);
    //     }
    // );
  }

  print() {
  }

  //     this.getTotal();
  //     let printContents, popupWin;
  //     printContents = document.getElementById('printContent').innerHTML;
  //     popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
  //     popupWin.document.open();
  //     popupWin.document.write(`
  //   <html>
  //     <head>
  //       <!--<title>Print tab</title>-->
  //       <!--<style>-->
  //       <!--//........Customized style.......-->
  //       <!--</style>-->
  //     </head>
  //     <body onload="window.print();window.close()">${printContents}</body>
  //   </html>`
  //     );
  //     popupWin.document.close();
  // }
}


