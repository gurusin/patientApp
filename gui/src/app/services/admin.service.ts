import { Injectable } from '@angular/core';
import {ItemSupplier} from "../supplier/ItemSupplier";
import {Itemtype} from "../item/itemtype";
import {Observable} from "rxjs";
import {HttpServiceService} from "../service/http-service.service";

@Injectable()
export class AdminService {

  public supplierObject :ItemSupplier;
  public itemTypeObject :Itemtype;

  constructor(private http: HttpServiceService) {
    this.supplierObject = new ItemSupplier();
  }

  getInOutReport(obj:any):Observable<any>
  {
      var url ="inOutReport";
      return this.http.sendPost(url,obj);
  }

  getDailyIncome(date: any):Observable<any>
  {
      var url = "dailyIncome";
      return this.http.sendPost(url,date);
  }
  loadSuppliers():Observable<any[]>
  {
    var url = "loadItemSuppliers";
    return this.http.sendGet(url);
  }

  saveSupplier(itemSupplier : any):Observable<any>
  {
    var url = "saveItemSupplier";
    return this.http.sendPost(url, itemSupplier);
  }

  loadItemTypes():Observable<any[]>
  {
    var url = "loadItemTypes";
    return this.http.sendGet(url);
  }

  saveItemType(itemType : any)
  {
    var url = "saveItemType";
    return this.http.sendPost(url, itemType).subscribe(
      data => {
        this.itemTypeObject = data;
      }
    );
  }

  loadUnitOfMeasure():Observable<any[]>
  {
    var url = "loadUnitOfMeasures";
    return this.http.sendGet(url);
  }

  getStrengthUnits():Observable<any[]>
  {
    var url = "getStrengthUnits";
    return this.http.sendGet(url);
  }

  loadPaymentMethod():Observable<any[]>
  {
    var url = "loadPaymentMethod";
    return this.http.sendGet(url);
  }

  saveStrength(strength: any):Observable<any[]> {
    var url = "saveStrength";
    return this.http.sendPost(url, strength);
  }
}
