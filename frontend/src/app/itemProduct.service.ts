import { Injectable } from '@angular/core';
import {Itemproduct} from "./item/itemproduct";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItemProductService {

  rootUrl ="http://localhost:8080/";
  public itemproductObject :Itemproduct;

  constructor(private http: Http) {
    this.itemproductObject = new Itemproduct();
  }

  loadItemProducts():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadItems").map((res:Response) =>res.json());
  }

  saveItemProduct(itemproduct : any)
  {
    return this.http.post("http://localhost:8080/saveItem", itemproduct).map((res:Response) => res.json()).subscribe(
      data => {
        this.itemproductObject = data;
      }
    );
  }
}
