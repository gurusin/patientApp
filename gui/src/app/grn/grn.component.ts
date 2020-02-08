import { Component, OnInit } from '@angular/core';
import {POServiceService} from "../services/poservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-grn',
  templateUrl: './grn.component.html',
  styleUrls: ['./grn.component.css']
})
export class GrnComponent implements OnInit {

  po:any;
  poDetail ={};
  constructor(private poService:POServiceService, private  router:Router) {
      this.po = this.poService.selectedPO;
  }

  ngOnInit() {
      this.po = this.poService.selectedPO;
      this.initPo(this.po.purchaseOrderNo)


  }

  onSave()
  {
    this.poService.saveGRN(this.poDetail).subscribe(
      data =>{
        this.poDetail = [];
        this.router.navigate(['po']);
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
        this.initPo(value);
    }
  }


    private initPo(value) {
// Check for the PO
        this.poService.loadPO(value).subscribe(
            data => {
                this.poDetail = data;
            }
        );
    }
}
