import { Component, OnInit } from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {Patient} from "../patient";

@Component({
  selector: 'app-treatment',
  templateUrl: './treatment.component.html'
})
export class TreatmentComponent  {
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
        this.patientList = data;
        console.log(this.patientList);
      }
    );
  }
}
