import {Component, OnInit} from '@angular/core';
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-issue-finder',
    templateUrl: './issue-finder.component.html',
    styleUrls: ['./issue-finder.component.css']
})
export class IssueFinderComponent implements OnInit {

    issue: any;
    show=false;
    total =0;
    date = new Date();

    constructor(private issueService: IssueServiceService, private router:Router,) {
        this.issue = new Object();
        if (issueService.issue != null){
          this.issue = issueService.issue;
          this.issue.issueNoteDetails.forEach(
            item => {item.issuedQty = item.buyingQuantity}
          );
        }
    }

    ngOnInit() {
    }

    getTotal()
    {
        var total = 0;
        this.issue.issueNoteDetails.forEach(
            item =>{
                total = total + (item.issuedQty * item.drugPackage.unitPrice);}
        );
        this.issue.issueNoteServiceItems.forEach(
            item =>{total = total + item.fee;}
        );
        this.total =total;
    }

    onIssueNo(event: any, value: string) {
        if (event.keyCode == 13) {
            this.issueService.findIssue(value).subscribe(
                data => {
                    this.issue=data;
                    this.issue.issueNoteDetails.forEach(
                        item => {item.issuedQty = item.buyingQuantity;}
                    );
                }
            );
        }
    }

    // Actually call server and make the  issue
    makeIssue()
    {
        var obj  = new MakeIssue();
        obj.issueNote = this.issue.issueNote;
        this.issue.issueNoteDetails.forEach(
            item => {
                var detail = new MakeIssueDetailDTO();
                detail.issueNoteId = item.issueNoteId;
                detail.issuedQty = item.issuedQty;
                obj.details.push(detail);
            }
        );

        this.issueService.makeIssue(obj).subscribe(
            data =>{
                this.router.navigate(['/pharmacyList']);
            }
        );
    }

    print(): void {
        this.getTotal();
        let printContents, popupWin;
        printContents = document.getElementById('printContent').innerHTML;
        popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
        popupWin.document.open();
        popupWin.document.write(`
      <html>
        <head>
          <!--<title>Print tab</title>-->
          <!--<style>-->
          <!--//........Customized style.......-->
          <!--</style>-->
        </head>
        <body onload="window.print();window.close()">${printContents}</body>
      </html>`
        );
        popupWin.document.close();
    }

}

export class MakeIssue
{
    issueNote: number;
    details:MakeIssueDetailDTO[];

    constructor()
    {
        this.details = [];
    }
}

export class MakeIssueDetailDTO
{
    issueNoteId :number
    issuedQty:number;
}
