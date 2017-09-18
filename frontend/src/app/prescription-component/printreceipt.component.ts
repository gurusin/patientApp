import { Component, OnInit } from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";
// import {Popup} from "ng2-opd-popup";

@Component({
  selector: 'app-printreceipt',
  templateUrl: './printreceipt.component.html',
  styleUrls: ['./printreceipt.component.css']
})
export class PrintreceiptComponent implements OnInit {

  prescription : any;
  constructor(private drugService:DrugServiceService)
  {

  }

  ngOnInit() {
      this.drugService.getPrescription(
          this.drugService.savedPrescription.prescriptionId).subscribe(
              data =>{
                this.prescription = data;
              }
      );
  }

  clickButton(){
    // this.popup.options = {
    //   header: "Your custom header",
    //   color: "#5cb85c", // red, blue....
    //   widthProsentage: 40, // The with of the popou measured by browser width
    //   animationDuration: 1, // in seconds, 0 = no animation
    //   showButtons: true, // You can hide this in case you want to use custom buttons
    //   confirmBtnContent: "OK", // The text on your confirm button
    //   cancleBtnContent: "Cancel", // the text on your cancel button
    //   confirmBtnClass: "btn btn-default", // your class for styling the confirm button
    //   cancleBtnClass: "btn btn-default", // you class for styling the cancel button
    //   animation: "fadeInDown" // 'fadeInLeft', 'fadeInRight', 'fadeInUp', 'bounceIn','bounceInDown'
    // };
    // this.popup.show(this.popup.options);
  }

  print(): void {
    let printContents, popupWin;
    printContents = document.getElementById('print-section').innerHTML;
    popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
      <html>
        <head>
          <!--<title>Print tab</title>-->
          <!--<style>-->
          <!--//........Customized style.......-->
          <!--</style>-->
        </head>
        <body onload="window.print();window.close()">${printContents}
        </body>
      </html>`
    );
    popupWin.document.close();
  }

}


