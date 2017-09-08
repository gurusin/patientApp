import { Component, OnInit } from '@angular/core';
import {POServiceService} from "../services/poservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-grn',
  templateUrl: './grn.component.html',
  styleUrls: ['./grn.component.css']
})
export class GrnComponent implements OnInit {

  poDetail ={};
  constructor(private poService:POServiceService, private  router:Router) { }


  ngOnInit() {
  }

  onSave()
  {
    this.poService.saveGRN(this.poDetail).subscribe(
      data =>{
        this.router.navigate(['/supplier']);
      }
    );
  }

  onCancel()
  {
    this.router.navigate(['/supplier']);
  }

  loadPo(event, value)
  {
    if (event.keyCode == 13)
    {
       // Check for the PO
       this.poService.loadPO(value).subscribe(
         data =>{
              this.poDetail = data;
         }
       );
    }
  }

}
