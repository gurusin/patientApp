import { Injectable } from '@angular/core';
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";


@Injectable()
export class ItemServiceService {

  constructor(private http:HttpServiceService) { }

  loadItems():Observable<any[]>
  {
    var url = "loadItems";
    return this.http.sendGet(url);
  }

}
