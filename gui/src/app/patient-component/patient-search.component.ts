import {Component, HostListener} from '@angular/core';
import {PatientServiceService} from "../services/patient-service.service";
import {Data, Router} from "@angular/router";
import {Patient} from "../patient";
import {LoginService} from "../services/login-service.service";


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

  patientList = []
  filterPatList =[];

  constructor(private patientService: PatientServiceService,private router:Router, private loginService:LoginService) {

  }

  onKeyPatNo(event:any)
  {
    if (event.keyCode == 13) {
      this.patientService.getByPatNo(this.patNo).subscribe(
          data =>{
            this.loadPrescription(data);
            //this.loadPlans(data);
          }
      );

    }
  }

  private loadPlans(data){
    if(data != null){
      this.patientService.patientObject = data;
      this.router.navigate(["dentalPatList"]);
    } else{
      alert(" No patient found");
    }

  }

  private loadPrescription(data) {
    if(data == null){
      alert("No Patient Found");
      return;
    }
    this.patientService.patientObject = data;
    if (this.loginService.loggedInUser.userType ===1)
    {
      this.prepareForPrescription();
      this.router.navigate(["patientvisit/treatment"]);
    } else
    {
      this.router.navigate(["serviceIssue"]);
    }
  }

  newPatient()
  {
    this.patientService.clearPatient();
    this.router.navigate(["patientsave"]);
  }

  onKeyPhoneNumber(event:any)
  {
    let value  = event.target.value;

    if (event.keyCode == 13) {
      this.patientService.getByPhoneNo(this.phone).subscribe(
          data =>{
             this.loadPlans(data);
          }
      );
    }
  }

  onKey(event: any) {
    if (event.keyCode == 13) {
      this.patientService.getByNIC(this.nic).subscribe(
          data =>{
             this.loadPlans(data);
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

    onKeyName(event: any)
    {
      let value  = event.target.value;
        if (!event.key) {
            this.patientService.getByPatNo(this.patIndex).subscribe(
                data =>{
                    this.loadPlans(data);
                }
            );
        }
        else if (value.length == 4) {
            this.patientService.findByName(value).subscribe(
                data =>{
                    this.patientList = data;
                    this.filterPatList = data;
                }
            );
        } else if (value.length < 4) {
            this.patientList = [];
            this.filterPatList = [];
        } else{

        }
    }

    prepareForPrescription()
    {
      this.patientService.newPatientVisit();
    }

  nameSelected() {
    alert("hell");
  }
}
