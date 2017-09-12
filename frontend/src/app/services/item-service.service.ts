import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';


@Injectable()
export class ItemServiceService {

  constructor(private http:Http) { }

  loadItems():Observable<any[]>
  {
    var url = localStorage.getItem("rootURL") +"loadItems";
    return this.http.get(url).map((res:Response) =>res.json());
  }

}
