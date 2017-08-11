import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";

@Injectable()
export class PatientServiceService {

  patientSearchURL = "http://localhost:8080/searchPat"
  patientVisitSaveURL = "http://localhost:8080/savePatientVisit"
  patientSaveURL = "http://localhost:8080/savePatient"

  constructor(private http:Http) { }

  searchByNIC(nic:string):Observable<any[]>
  {
    return this.http.post(this.patientSearchURL, nic).map((res:Response) =>res.json());
  }

  savePatientVisit(patientVisit : any):Observable<any[]>
  {
    return this.http.post(this.patientVisitSaveURL, patientVisit).map((res:Response) => res.json());
  }

  savePatient(patient : any):Observable<any>
  {
    return this.http.post(this.patientSaveURL, patient).map((res:Response) => res.json());
  }
}
