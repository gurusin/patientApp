import { Injectable } from '@angular/core';
import {ItemSupplier} from "../supplier/ItemSupplier";
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class ItemSupplierService {

  public supplierObject :ItemSupplier;

  constructor(private http: HttpServiceService) {
    this.supplierObject = new ItemSupplier();
  }

  loadSuppliers():Observable<any[]>
  {
    var url = "loadItemSuppliers";
    return this.http.sendGet(url);
  }

  saveSupplier(itemSupplier : any)
  {
    itemSupplier = new ItemSupplier();
    var url = "saveItemSupplier";
    return this.http.sendPost(url, itemSupplier).subscribe(
      data => {
        this.supplierObject = data;
      }
    );
  }

}
