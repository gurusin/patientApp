import { Component, OnInit } from '@angular/core';
import {DrugServiceService} from "../../../services/drug-service.service";
import {AdminService} from "../../../services/admin.service";

@Component({
  selector: 'app-strengh',
  templateUrl: './strength.component.html',
  styleUrls: ['./strength.component.css']
})
export class StrengthComponent implements OnInit {

  strengthList =[];
  strength: any
  units =[];
  constructor(private drugService:DrugServiceService, private adminService:AdminService) { }

  ngOnInit() {
    this.initObject();
    this.drugService.loadStregths().subscribe(
      data =>{
        this.strengthList = data;

      }
    );

    this.adminService.getStrengthUnits().subscribe(
      data =>{this.units = data}
    );
  }

  doSave()
  {
    this.adminService.saveStrength(this.strength).subscribe(
      data=>{
        this.strengthList = data;
        this.initObject();
      }
    )
  }

  private initObject() {
    this.strength = {
      strengthUnit: {unitId: ''},
      strengthAmount: 0.0
    }
  }
}
