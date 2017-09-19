import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';

@Injectable()
export class IssueServiceService {

  makeIssue:any;


  constructor(private http:Http) {}

  findIssue(issueId):Observable<any>
  {
    var url = localStorage.getItem("rootURL") +"findIssue";
    return this.http.post(url,issueId).map((res:Response) =>res.json())
  }

    registerIssue(obj):Observable<any> {
        var url = localStorage.getItem("rootURL") +"makeIssue";
        return this.http.post(url,obj).map((res:Response) =>res.json())
    }

  createIssueForPrescription(prescriptionId):Observable<any>{
    var url = localStorage.getItem("rootURL") +"prepareIssue";
    return this.http.post(url,prescriptionId).map((res:Response) =>res.json())
  }
}
