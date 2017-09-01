import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Popup} from "ng2-opd-popup";
import {Patientvisit} from "./patientvisit";

@Component({
  selector: 'app-printpop',
  templateUrl: './printpop.component.html',
  styleUrls: ['./printpop.component.css']
})
export class PrintpopComponent implements OnInit{
  constructor(private router:Router){  }

  @Input() patientVisit: Patientvisit;
  print(): void {
    let printContents, popupWin;
    printContents = document.getElementById('print-section').innerHTML;
    popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
        <body onload="window.print();window.close()">${printContents}</body>
      <!--</html>-->`
    );
    popupWin.document.close();

    this.router.navigate(['patientvisit/treatmentHistory']);
  }

  ngOnInit() {

  }

}
