import { Component } from '@angular/core';
import {LoginService} from "./services/login-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  logged = false;


  constructor(private loginService:LoginService, private router:Router) {
    this.logged = this.loginService.loggedInUser !==null;
  }

  logOff() {
    this.loginService.loggedInUser = null;
    this.loginService.loggedIn = false;
    this.router.navigate(['']);

  }
}

