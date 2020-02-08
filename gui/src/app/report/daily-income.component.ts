import { Component, OnInit } from '@angular/core';
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-daily-income',
  templateUrl: './daily-income.component.html',
  styleUrls: ['./daily-income.component.css']
})
export class DailyIncomeComponent implements OnInit {

  dailyIncome : {
    fromDate : any;
    toDate: any;
  }

  constructor(private adminService:AdminService) { }

  ngOnInit() {
    this.dailyIncome = {fromDate : new Date(),toDate:new Date()};
  }

    doReport()
    {
        this.adminService.getDailyIncome(this.dailyIncome).subscribe(
            data =>{this.dailyIncome = data}
        );
    }

}
