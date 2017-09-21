import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';

@Injectable()
export class LoginService {

  loggedInUser:any;
  loggedIn = false;
  constructor(private http:Http){ }

  login(model):Observable<any> {
    var url = localStorage.getItem("rootURL") +"login";
    return this.http.post(url,model).map((res: Response) => res.json());
  }

  storeToken(data) {
    localStorage.setItem("token",JSON.parse(JSON.stringify(data))._body);
  }

  getHeaderToken()
  {
    //let headers1 = new Headers({'Content-Type': 'application/json'});
    let headers2 = new Headers({'Authorization':'Bearer '+localStorage.getItem("token")});
    return [{headers2}];
  }

}
