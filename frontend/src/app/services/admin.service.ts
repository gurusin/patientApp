import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {ItemSupplier} from "../supplier/ItemSupplier";
import {Itemtype} from "../item/itemtype";

@Injectable()
export class AdminService {

  public supplierObject :ItemSupplier;
  public itemTypeObject :Itemtype;

  constructor(private http: Http) {
    this.supplierObject = new ItemSupplier();
  }

  getDailyIncome(date: any):Observable<any>
  {
      var url = localStorage.getItem("rootURL") +"dailyIncome";
      return this.http.post(url,date).map((res:Response) =>res.json())
  }
  loadSuppliers():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadItemSuppliers";
    return this.http.get(url).map((res:Response) =>res.json())
  }

  saveSupplier(itemSupplier : any)
  {
    var url = localStorage.getItem("rootURL") +"saveItemSupplier";
    return this.http.post(url, itemSupplier).map((res:Response) => res.json()).subscribe(
      data => {
        this.supplierObject = data;
      }
    );
  }

  loadItemTypes():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadItemTypes";
    return this.http.get(url).map((res:Response) =>res.json())
  }

  saveItemType(itemType : any)
  {
    var url = localStorage.getItem("rootURL") +"saveItemType";
    return this.http.post(url, itemType).map((res:Response) => res.json()).subscribe(
      data => {
        this.itemTypeObject = data;
      }
    );
  }

  loadUnitOfMeasure():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadUnitOfMeasures";
    return this.http.get(url).map((res:Response) =>res.json())
  }

  loadPaymentMethod():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadPaymentMethod";
    return this.http.get(url).map((res:Response) =>res.json())
  }
}
