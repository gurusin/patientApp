import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {MakeIssue} from "../issue/issue-finder.component";

@Injectable()
export class IssueServiceService {

  issue: any;

  constructor(private http:Http) {}

  findIssue(issueId):Observable<any>
  {
    var url = localStorage.getItem("rootURL") +"findIssue";
    return this.http.post(url,issueId).map((res:Response) =>res.json())
  }

    makeIssue(obj: MakeIssue):Observable<any> {
        var url = localStorage.getItem("rootURL") +"makeIssue";
        return this.http.post(url,obj).map((res:Response) =>res.json())
    }
}
