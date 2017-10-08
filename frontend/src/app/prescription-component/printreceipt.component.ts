import { Component, OnInit } from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";
import {Router} from "@angular/router";
// import {Popup} from "ng2-opd-popup";

@Component({
  selector: 'app-printreceipt',
  templateUrl: './printreceipt.component.html',
  styleUrls: ['./printreceipt.component.css']
})
export class PrintreceiptComponent implements OnInit {

  prescription : any;
  imageUrl ="";
  constructor(private drugService:DrugServiceService, private router:Router)
  {
     this.imageUrl = 'assets/images/Sign.gif';
  }

  ngOnInit() {

      this.prescription = this.drugService.savedPrescription;
      console.log(this.prescription);
  }


  print(): void {
    let printContents, popupWin;
    printContents = document.getElementById('print-section').innerHTML;
    popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
      <html>
        <head>
        </head>
        <body onload="window.print();window.close()">${printContents}
        </body>
      </html>`
    );
    popupWin.document.close();
    this.router.navigate(['start']);
  }

}


