import {Component, OnInit} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {IssueServiceService} from "../services/issue-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-issue-history',
  templateUrl: './issue-history.component.html',
  styleUrls: ['./issue-history.component.css']
})
export class IssueHistoryComponent implements OnInit {

  issueNotes = [];
  selectedIssueNote = {
    patient :{},
    issueNoteDetails :[]
  }

  constructor(private patientService: PatientServiceService,
              private issueService: IssueServiceService,
              private router: Router) {

  }

  ngOnInit() {

    this.findIssuesForPatient();
  }


  findIssuesForPatient() {
    var patientId = this.patientService.patientObject.patientId;
    this.issueService.findIssuesForPatient(patientId).subscribe(
      data => {
        this.issueNotes = data;
      }
    );
  }

}
