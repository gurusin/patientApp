import { Component, HostListener } from '@angular/core';
import {PatientServiceService} from "../patient-service.service";



@Component({
  selector: 'app-patient-search',
  templateUrl: './patient-search.component.html',
  styleUrls: ['./patient-search.component.css']
})
export class PatientSearchComponent {

  nic:string;
  patientList=[];

  constructor(private patientService:PatientServiceService) {

  }

  onKey(event:any)
  {
    if (this.nic.length >1)
    {
      this.doSearch();
    }else {
      this.patientList=[];
    }
  }

  doSearch()
  {
    this.patientService.searchByNIC(this.nic).subscribe(
      data =>{
        console.log(data);
        this.patientList = data;}
    );
  }

}
