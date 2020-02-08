import {PurchaseOrderDTO} from "../purchseorder/purchseorder.component";
import {Injectable} from '@angular/core';
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class POServiceService {

  public selectedPO:any;

  constructor(private http: HttpServiceService) {
  }


  getPendingPO():Observable<any>
  {
      var url =  "pendingPO";
      return this.http.sendGet(url);

  }

  savePO(po: PurchaseOrderDTO): Observable<any> {
    var url = "savePO";
    return this.http.sendPost(url, po);
  }

  saveGRN(obj): Observable<any> {
    var url = "registerGRN";
    return this.http.sendPost(url, obj);
  }

  loadPO(poId): Observable<any> {
    var url =  "loadPOForInput";
    return this.http.sendPost(url, poId);
  }

  loadPendingPOs(): Observable<any[]> {
    var url = "loadPendingPOs";
    return this.http.sendGet(url);
  }

  saveIssue(issueObject: any) {
    var url = "saveIssue";
    return this.http.sendPost(url, issueObject);
  }

  loadGRN(supplierInvoice): Observable<any[]> {
    var url =  "loadGRNForPay";
    return this.http.sendPost(url, supplierInvoice);
  }

  savePayment(payment: any) {
    var url = "makePayment";
    return this.http.sendPost(url, payment);
  }

  loadGRNForRet(supplierInvoice): any {
    var url = "loadGRNDTOForReturn";
    return this.http.sendPost(url, supplierInvoice);
  }

  saveRet(grnsToReturn: any) : any{
    var url =  "saveGoodReturn";
    return this.http.sendPost(url, grnsToReturn);
  }
}
