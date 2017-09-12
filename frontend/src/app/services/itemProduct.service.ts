import { Injectable } from '@angular/core';
import {Itemproduct} from "../item/itemproduct";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItemProductService {

  public itemproductObject :Itemproduct;

  constructor(private http: Http) {
    this.itemproductObject = new Itemproduct();
  }

  loadItemProducts():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadItems";
    return this.http.get(url).map((res:Response) =>res.json());
  }

  saveItemProduct(itemproduct : any)
  {
    var url = localStorage.getItem("rootURL") +"saveItem";
    return this.http.post(url, itemproduct).map((res:Response) => res.json()).subscribe(
      data => {
        this.itemproductObject = data;
      }
    );
  }
}
