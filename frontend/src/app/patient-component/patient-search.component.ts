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
  patIndex:string;

  patientList = [];

  constructor(private patientService: PatientServiceService,private router:Router) {

  }

  onKeyPatNo(event:any)
  {
    if (event.keyCode == 13) {
      this.patientService.getByPatNo(this.patNo).subscribe(
          data =>{
              this.patientService.patientObject = data;
              this.router.navigate(["patientvisit/treatment"]);
          }
      );

    }
  }

  newPatient()
  {
    this.patientService.clearPatient();
    this.router.navigate(["patientsave"]);
  }

  onKeyPhoneNumber(event:any, value)
  {

    if (event.keyCode == 13) {
      this.patientService.getByPhoneNo(this.phone).subscribe(
          data =>{
              this.patientService.patientObject = data;
              this.router.navigate(["patientvisit/treatment"]);
          }
      );

    }
    else if (this.phone.length == 2) {
      this.searchByPhone();
    } else if (this.phone.length < 2) {
      this.patientList = [];
    }
  }
  onKey(event: any) {
    if (event.keyCode == 13) {
      this.patientService.getByNIC(this.nic).subscribe(
          data =>{
            this.patientService.patientObject = data;
              this.router.navigate(["patientvisit/treatment"]);
          }
      );

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

    searchByName(name) {
        this.patientService.findByName(name).subscribe(
            data => {
                this.patientList = data;
            }
        );
    }

    onKeyName(event: any, value)
    {
        if (event.keyCode == 13) {

            var patId = this.patientList[this.patIndex].patientId;
            this.patientService.getByPatNo(patId).subscribe(
                data =>{

                    this.patientService.patientObject = data;
                    this.router.navigate(["patientvisit/treatment"]);
                }
            );
        }
        else if (value.length == 2) {
            this.patientService.findByName(value).subscribe(
                data =>{
                    this.patientList = data;
                }
            );
        } else if (value.length < 2) {
            this.patientList = [];
        }
    }

    onChangeName()
    {
       alert('Value Selected');
    }

    name(i)
    {
        alert('Selected index '+ i);
    }

}
