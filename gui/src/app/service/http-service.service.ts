import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private http:HttpClient) { }

  public sendPost(url:string,param:any) :Observable<any>{
     url = localStorage.getItem("rootURL") + url;
     return this.http.post(url,param);
  }

  public sendGet(url:string) :Observable<any>{
    url = localStorage.getItem("rootURL") + url;
    return this.http.get(url);
  }

  public sendDelete(url:string) :Observable<any>{
    url = localStorage.getItem("rootURL") + url;
    return this.http.delete(url);
  }
}
