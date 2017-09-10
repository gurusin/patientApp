import {Component, OnInit} from '@angular/core';
import {IssueServiceService} from "../services/issue-service.service";

@Component({
    selector: 'app-issue-finder',
    templateUrl: './issue-finder.component.html',
    styleUrls: ['./issue-finder.component.css']
})
export class IssueFinderComponent implements OnInit {

    issue: any;

    constructor(private issueService: IssueServiceService) {
        this.issue = new Object();
    }

    ngOnInit() {
    }

    onIssueNo(event: any, value: string) {
        if (event.keyCode == 13) {
            this.issueService.findIssue(value).subscribe(
                data => {
                    this.issue=data;
                    console.log(data);
                    this.issue.issueNoteDetails.forEach(
                        item => {item.issuedQty = item.buyingQuantity}
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

        this.issueService.makeIssue(obj).subscribe();
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
