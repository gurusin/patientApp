import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "./patientvisit";
import {Patient} from "../patient";

@Component({
  selector: 'app-basicvisit',
  templateUrl: './basicvisit.component.html',
  styleUrls: ['./basicvisit.component.css']
})
export class BasicvisitComponent implements OnInit {

  patientVisit:Patientvisit;
  @Input() patient:Patient;

  constructor() {
    this.patientVisit = new Patientvisit();
    this.patientVisit.diagnoseData='';

  }

  ngOnInit() {
  }

}
