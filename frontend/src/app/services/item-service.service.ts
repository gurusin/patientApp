import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';


@Injectable()
export class ItemServiceService {

  rootUrl ="http://localhost:8080/";

  constructor(private http:Http) { }

  loadItems():Observable<any[]>
  {
    return this.http.get(this.rootUrl+"loadItems").map((res:Response) =>res.json());
  }

}
