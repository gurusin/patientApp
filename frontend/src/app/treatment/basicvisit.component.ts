import { Component, OnInit } from '@angular/core';
import {Patientvisit} from "./patientvisit";

@Component({
  selector: 'app-basicvisit',
  templateUrl: './basicvisit.component.html',
  styleUrls: ['./basicvisit.component.css']
})
export class BasicvisitComponent implements OnInit {

  patientVisit:Patientvisit;
  constructor() {
    this.patientVisit = new Patientvisit();
  }

  ngOnInit() {
  }

}
