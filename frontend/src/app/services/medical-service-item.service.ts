import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {MedicalServiceItem} from "../medservice/medical-service-item";

@Injectable()
export class MedicalServiceItemService {
  constructor(private http:Http) { }

  public medicalServiceItemObject :MedicalServiceItem;

  loadMedicalServiceItems():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadMedicalServiceItems";
    return this.http.get(url).map((res:Response) =>res.json());
  }

  saveMedicalServiceItem(medicalServiceItem: MedicalServiceItem){
    var url = localStorage.getItem("rootURL") +"saveMedicalServiceItem";
    return this.http.post(url, medicalServiceItem).map((res:Response) => res.json()).subscribe(
      data => {
        this.medicalServiceItemObject = data;
      }
    );
  }
}
