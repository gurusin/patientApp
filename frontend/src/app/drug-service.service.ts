import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import 'rxjs/Rx';
import {PrescribableDrug} from "./prescription-component/prescribable-drug";

@Injectable()
export class DrugServiceService {

  rootUrl ="http://localhost:8080/";
  constructor(private http:Http) { }

  searchDrug(drugName:string):Observable<any[]> {
    return this.http.post(this.rootUrl+"getDrugByName",drugName).map((res:Response) =>res.json());
  }

  searchPrescribable(drugId:number):Observable<PrescribableDrug>
  {
    return this.http.post(this.rootUrl+"getPrescribable",drugId).map((res:Response) =>res.json());
  }

  savePrescription(obj:any)
  {
    this.http.post(this.rootUrl+"savePrescription",obj).map((res:Response) =>res.json()).subscribe(
      data => {
        console.log("successful");
      }
    );
  }

  loadPrescriptions(patientId:any):Observable<any[]>
  {
    return this.http.post(this.rootUrl+"loadPrescriptions",patientId).map((res:Response) =>res.json())
  }

}
