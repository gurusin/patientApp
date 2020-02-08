import { Component, OnInit } from '@angular/core';
import {POServiceService} from "../services/poservice.service";

@Component({
  selector: 'app-returnout',
  templateUrl: './returnout.component.html',
  styleUrls: ['./returnout.component.css']
})
export class ReturnoutComponent implements OnInit {

  grnsToReturn : any;

  constructor(private poService: POServiceService) {
    this.grnsToReturn = new Object();
  }

  ngOnInit() {
  }

  loadgrnbysi(event, value){
    if (event.keyCode == 13) {
      this.poService.loadGRNForRet(value).subscribe(
        data => {
          this.grnsToReturn = data;
        }
      );
    }
  }

  returnGoods() {
    alert("here");
    this.poService.saveRet(this.grnsToReturn).subscribe(
      data => {
      }
    );
    this.grnsToReturn = new Object();
  }
}
