import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {ItemSupplier} from "./supplier/ItemSupplier";
import {Itemtype} from "./item/itemtype";

@Injectable()
export class AdminService {

  rootUrl ="http://localhost:8080/";
  public supplierObject :ItemSupplier;
  public itemTypeObject :Itemtype;

  constructor(private http: Http) {
    this.supplierObject = new ItemSupplier();
  }

  loadSuppliers():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadItemSuppliers").map((res:Response) =>res.json())
  }

  saveSupplier(itemSupplier : any)
  {
    return this.http.post("http://localhost:8080/saveItemSupplier", itemSupplier).map((res:Response) => res.json()).subscribe(
      data => {
        this.supplierObject = data;
      }
    );
  }

  loadItemTypes():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadItemTypes").map((res:Response) =>res.json())
  }

  saveItemType(itemType : any)
  {
    return this.http.post("http://localhost:8080/saveItemType", itemType).map((res:Response) => res.json()).subscribe(
      data => {
        this.itemTypeObject = data;
      }
    );
  }

  loadUnitOfMeasure():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadUnitOfMeasures").map((res:Response) =>res.json())
  }

}
