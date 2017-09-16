import {PurchaseOrderDTO} from "../purchseorder/purchseorder.component";
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';

@Injectable()
export class POServiceService {

  constructor(private http: Http) {
  }


  savePO(po: PurchaseOrderDTO) {
    var url = localStorage.getItem("rootURL") + "savePO";
    this.http.post(url, po).map((res: Response) => res.json()).subscribe(
      data => {
      }
    );
  }

  saveGRN(obj): Observable<any> {
    var url = localStorage.getItem("rootURL") + "registerGRN";
    return this.http.post(url, obj).map((res: Response) => res.json())
  }

  loadPO(poId): Observable<any> {
    var url = localStorage.getItem("rootURL") + "loadPOForInput";
    return this.http.post(url, poId).map((res: Response) => res.json());
  }

  loadPendingPOs(): Observable<any[]> {
    var url = localStorage.getItem("rootURL") + "loadPendingPOs";
    return this.http.get(url).map((res: Response) => res.json())
  }

  saveIssue(issueObject: any) {
    var url = localStorage.getItem("rootURL") + "saveIssue";
    return this.http.post(url, issueObject).map((res: Response) => res.json());
  }

  loadGRN(supplierInvoice): Observable<any[]> {
    var url = localStorage.getItem("rootURL") + "loadGRNForPay";
    return this.http.post(url, supplierInvoice).map((res: Response) => res.json());
  }

  savePayment(payment: any) {
    var url = localStorage.getItem("rootURL") + "makePayment";
    return this.http.post(url, payment).map((res: Response) => res.json());
  }

  loadGRNForRet(supplierInvoice): any {
    var url = localStorage.getItem("rootURL") + "loadGRNDTOForReturn";
    return this.http.post(url, supplierInvoice).map((res: Response) => res.json());

  }

  saveRet(grnsToReturn: any) : any{
    var url = localStorage.getItem("rootURL") + "saveGoodReturn";
    return this.http.post(url, grnsToReturn).map((res: Response) => res.json());
  }
}
