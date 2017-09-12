import { Component, OnInit } from '@angular/core';
import {PatientServiceService} from "./services/patient-service.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent  {

  constructor(private patService:PatientServiceService) { }

  newPat()
  {
    this.patService.clearPatient();
  }

}
