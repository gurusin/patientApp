import {PurchaseOrderDTO} from "../purchseorder/purchseorder.component";
import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';

@Injectable()
export class POServiceService {

  rootUrl ="http://localhost:8080/";

  constructor(private http:Http) {}


  savePO(po: PurchaseOrderDTO)
  {
    this.http.post(this.rootUrl+"savePO",po).map((res:Response) =>res.json()).subscribe(
      data =>{}
    );
  }

  saveGRN(obj):Observable<any>
  {
    return this.http.post(this.rootUrl+"registerGRN",obj).map((res:Response) =>res.json())
  }

  loadPO(poId) :Observable<any>
  {
    return this.http.post(this.rootUrl+"loadPOForInput",poId).map((res:Response) =>res.json());
  }

  loadPendingPOs():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadPendingPOs").map((res:Response) =>res.json())
  }

  saveIssue(issueObject: any) {
    return this.http.post(this.rootUrl+"saveIssue",issueObject).map((res:Response) =>res.json());
  }
}
