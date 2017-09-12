import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import {ItemSupplier} from "../supplier/ItemSupplier";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItemSupplierService {

  public supplierObject :ItemSupplier;

  constructor(private http: Http) {
    this.supplierObject = new ItemSupplier();
  }

  loadSuppliers():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadItemSuppliers";
    return this.http.get(url).map((res:Response) =>res.json())
  }

  saveSupplier(itemSupplier : any)
  {
    itemSupplier = new ItemSupplier();
    var url = localStorage.getItem("rootURL") +"saveItemSupplier";
    return this.http.post(url, itemSupplier).map((res:Response) => res.json()).subscribe(
      data => {
        this.supplierObject = data;
      }
    );
  }

}
