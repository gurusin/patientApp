import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {POServiceService} from "../services/poservice.service";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {


  grnsToPay = [];
  paymentMethods = [];
  grnToSave:any;

  constructor(private poService: POServiceService, private  router: Router, private adminService: AdminService) {
  }


  ngOnInit() {
    this.adminService.loadPaymentMethod().subscribe(
      data => {
        this.paymentMethods = data;
      }
    );
  }

  loadGRN(event, value) {
    if (event.keyCode == 13) {
      this.poService.loadGRN(value).subscribe(
        data => {
          this.grnsToPay = data;
        }
      );
    }
  }

  makePay(index) {
    this.grnToSave = this.grnsToPay[index];
    this.poService.savePayment(this.grnToSave).subscribe(
      data => {
        this.grnsToPay = data;
      }
    );
  }
}
