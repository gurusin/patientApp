import {Injectable} from '@angular/core';
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class LoginService {

  loggedInUser:any;
  loggedIn = false;
  constructor(private http:HttpServiceService){ }

  login(model):Observable<any> {
    var url = "login";
    return this.http.sendPost(url,model);
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
