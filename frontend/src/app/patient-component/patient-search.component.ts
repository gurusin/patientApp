import {Component, HostListener} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {Data, Router} from "@angular/router";
import {Patient} from "../patient";


@Component({
  selector: 'app-patient-search',
  templateUrl: './patient-search.component.html',
  styleUrls: ['./patient-search.component.css']
})
export class PatientSearchComponent {

  nic: string;
  phone:string;
  patNo:string;

  patientList = [];

  constructor(private patientService: PatientServiceService,private router:Router) {

  }

  onKeyPatNo(event:any)
  {
    if (event.keyCode == 13) {
      this.patientService.getByPatNo(this.patNo);
      this.router.navigate(["patientvisit/treatment"]);
    }
  }

  onChange()
  {
    alert('Changed');
  }

  newPatient()
  {
    this.patientService.clearPatient();
    this.router.navigate(["patientsave"]);
  }

  onKeyPhoneNumber(event:any)
  {
    if (event.keyCode == 13) {
      this.patientService.getByPhoneNo(this.phone);
      this.router.navigate(["patientvisit/treatment"]);
    }
    else if (this.phone.length == 2) {
      this.searchByPhone();
    } else if (this.phone.length < 2) {
      this.patientList = [];
    }
  }
  onKey(event: any) {
    if (event.keyCode == 13) {
      this.patientService.getByNIC(this.nic);
      this.router.navigate(["patientvisit/treatment"]);
    }
    else if (this.nic.length == 2) {
      this.doSearch();
    } else if (this.nic.length < 2) {
      this.patientList = [];
    }
  }

  doSearch() {
    this.patientService.searchByNIC(this.nic).subscribe(
      data => {
        this.patientList = data;
      }
    );
  }

  searchByPhone() {
    this.patientService.searchByPhone(this.phone).subscribe(
      data => {
        this.patientList = data;
      }
    );
  }

}
