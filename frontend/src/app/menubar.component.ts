import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AdminService} from "./services/admin.service";
import {LoginService} from "./services/login-service.service";

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.css']
})
export class MenubarComponent implements OnInit {

  userType:number;
  supplierList = [];

  constructor(private adminService: AdminService, private router: Router, private loginService:LoginService) {
    this.userType = this.loginService.loggedInUser.userType;
  }

  ngOnInit() {
    this.userType = this.loginService.loggedInUser.userType;
  }

  loadSupplier() {
    // this.adminService.loadSuppliers(
    // ).subscribe(
    //   data => {
    //     this.supplierList = data;
    //   }
    // );
    this.router.navigate(["/supplier"]);
  }

  loadItemType(){
    this.router.navigate(["/itemtype"]);
  }

  loadItem(){
    this.router.navigate(["/item"]);
  }
}
