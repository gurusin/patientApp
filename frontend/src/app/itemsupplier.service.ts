import { Injectable } from '@angular/core';
import {Http, RequestMethod, RequestOptions,Response} from "@angular/http";
import {ItemSupplier} from "./supplier/ItemSupplier";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItemSupplierService {

  rootUrl ="http://localhost:8080/";
  public supplierObject :ItemSupplier;

  constructor(private http: Http) {
    this.supplierObject = new ItemSupplier();
  }

  loadSuppliers():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadItemSuppliers").map((res:Response) =>res.json())
  }

  saveSupplier(itemSupplier : any)
  {
    itemSupplier = new ItemSupplier();

    return this.http.post("http://localhost:8080/saveItemSupplier", itemSupplier).map((res:Response) => res.json()).subscribe(
      data => {
        this.supplierObject = data;
      }
    );
  }

}
