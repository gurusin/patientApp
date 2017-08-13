import {Component, Input, OnInit} from '@angular/core';
import {Patientvisit} from "../treatment/patientvisit";

@Component({
  selector: 'app-prescription-component',
  templateUrl: './prescription-component.component.html',
  styleUrls: ['./prescription-component.component.css']
})
export class PrescriptionComponentComponent implements OnInit {

  @Input()patientVisit:Patientvisit;

  constructor() { }

  ngOnInit() {
  }

}
