import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../patient";

@Component({
  selector: 'app-patientnavbar',
  templateUrl: './patientnavbar.component.html',
  styleUrls: ['./patientnavbar.component.css']
})
export class PatientnavbarComponent implements OnInit
{
  @Input() patient: Patient;


  ngOnInit(): void {
  }
}
