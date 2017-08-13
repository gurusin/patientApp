import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {Patient} from "./patient";
import {Subject} from "rxjs/Subject";

@Injectable()
export class PatientServiceService {

  rootUrl ="http://localhost:8080/";
  patientSearchURL = "http://localhost:8080/searchPat";
  patientVisitSaveURL = "http://localhost:8080/savePatientVisit";
  patientSaveURL = "http://localhost:8080/savePatient";
  patientGetByNIC = "http://localhost:8080/getByNIC";

  public patient:Subject<Patient>;
  public patientObject :Patient;

  constructor(private http:Http) {
    this.patient = new Subject();
  }

  searchByNIC(nic:string):Observable<any[]>
  {
    return this.http.post(this.patientSearchURL, nic).map((res:Response) =>res.json());
  }

  getByNIC(nic:string)
  {
    return this.http.post(this.patientGetByNIC, nic).map((res:Response) =>res.json()).subscribe(
      data => {
       this.patient.next(data);
       this.patientObject = data;
      }
    );
  }

  savePatientVisit(patientVisit : any):Observable<any[]>
  {
    return this.http.post(this.patientVisitSaveURL, patientVisit).map((res:Response) => res.json());
  }

  savePatient(patient : any)
  {

    return this.http.post(this.patientSaveURL, patient).map((res:Response) => res.json()).subscribe(
      data => {
        this.patient.next(data);
        this.patientObject = data;
      }
    );
  }

  getByPatNo(patNo: string) {
    this.http.post(this.rootUrl+"getByPatientId",patNo).map((res:Response) =>res.json()).subscribe(
      data => {
        this.patient.next(data);
        this.patientObject = data;
      }
    );
  }

  getByPhoneNo(phoneNo: string) {
    this.http.post(this.rootUrl+"getByPhoneNo",phoneNo).map((res:Response) =>res.json()).subscribe(
      data => {
        this.patient.next(data);
      }
    );
  }

  searchByPhone(phoneNo: string) {
    return this.http.post(this.rootUrl+"searchPatByPhoneNo",phoneNo).map((res:Response) =>res.json());
  }


  public clearPatient() {
    this.patientObject = new Patient();
    this.patientObject.patientId=0;
    this.patient = new Subject<Patient>();
  }
}
