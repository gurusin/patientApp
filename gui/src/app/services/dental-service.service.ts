import { Injectable } from '@angular/core';
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";
import {TreatmentItem} from "../dental/model/TreatmentItem";
import {PatTreatment} from "../dental/model/PatTreatment";

@Injectable({
  providedIn: 'root'
})
export class DentalServiceService {

  constructor(private http: HttpServiceService) { }


  getAllTreatmentItems():Observable<any>{
    var url = "TreatmentItem";
    return this.http.sendGet(url);
  }

  saveItem(currItem: TreatmentItem):Observable<any> {
    return this.http.sendPost("TreatmentItem",currItem)
  }

  savePatTreatment(currObj: PatTreatment):Observable<any> {
     return this.http.sendPost("PatTreatment",currObj)
  }

  getAllPatTreatments(patId:number) :Observable<any>{
    return this.http.sendGet("PatTreatment/"+patId+"/");
  }

  deleteTreatmentItem(id):Observable<any> {
    return this.http.sendDelete("TreatmentItem/"+id+"/")
  }

  deletePatTreatment(id: number):Observable<any> {
    return this.http.sendDelete("PatTreatment/"+id+"/");
  }
}
