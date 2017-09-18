import { Component, OnInit } from '@angular/core';
import {POServiceService} from "../services/poservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-polist',
  templateUrl: './polist.component.html',
  styleUrls: ['./polist.component.css']
})
export class POListComponent implements OnInit {

  pendingPOList =[];
  constructor(private poService:POServiceService,private router:Router) { }

    newPo()
    {
      this.router.navigate(['poDetail']);

    }
  ngOnInit() {
    this.poService.getPendingPO().subscribe(
        data =>{this.pendingPOList = data;}
    )
  }

  doGrn(object)
  {
    this.poService.selectedPO = object;
    this.router.navigate(['grn']);
  }

}
