import { Injectable } from '@angular/core';
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class IssueServiceService {

  makeIssue:any;


  constructor(private http:HttpServiceService) {}

  findIssue(issueId):Observable<any>
  {
    var url = "findIssue";
    return this.http.sendPost(url,issueId);
  }

    registerIssue(obj):Observable<any> {
        var url = "makeIssue";
        return this.http.sendPost(url,obj);
    }

  createIssueForPrescription(prescriptionId):Observable<any>{
    var url = "prepareIssue";
    return this.http.sendPost(url,prescriptionId);
  }

  findIssuesForPatient(patientId:number):Observable<any>
  {
    var url = "findIssueForPatient?patientId="+patientId;
    return this.http.sendGet(url);
  }
}
