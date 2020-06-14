import { Component, OnInit } from '@angular/core';
import {LoginService} from "../services/login-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent{

   model:any

  constructor(private loginService:LoginService,private router:Router) {
        this.model = new Object();
  }


  onSubmit() {
    this.loginService.login(this.model).subscribe(
      data =>{
        this.loginService.loggedInUser = data;
        this.loginService.loggedIn = true;
        if (data.userType ===1)
        {
          this.router.navigate(['/start']);
        } else {
           this.router.navigate(['/pharmacyList']);
        }

      },error => alert(error)
    );
  }

}
