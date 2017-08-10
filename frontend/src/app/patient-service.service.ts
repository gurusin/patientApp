import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";

@Injectable()
export class PatientServiceService {

  patientSearchURL = "http://localhost:8080/searchPat"
  constructor(private http:Http) { }

  searchByNIC(nic:string):Observable<any[]>
  {
    return this.http.post(this.patientSearchURL, nic).map((res:Response) =>res.json());
  }

}
