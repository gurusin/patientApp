import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {POServiceService} from "../services/poservice.service";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private poService:POServiceService, private  router:Router) { }

  grnsToPay =[];

  ngOnInit() {
  }

  loadGRN(event, value)
  {
    if (event.keyCode == 13)
    {
      this.poService.loadGRN(value).subscribe(
        data =>{
          this.grnsToPay = data;
        }
      );

      alert(this.grnsToPay.length);
    }
  }
}
