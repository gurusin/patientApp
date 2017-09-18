import { Component, OnInit } from '@angular/core';
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-daily-income',
  templateUrl: './daily-income.component.html',
  styleUrls: ['./daily-income.component.css']
})
export class DailyIncomeComponent implements OnInit {

  dailyIncome : any;
  selectedDate:Date;
  constructor(private adminService:AdminService) { }

  ngOnInit() {
    this.dailyIncome = new Object();
    this.dailyIncome.date = new Date();
  }

    doReport()
    {
        this.adminService.getDailyIncome(this.dailyIncome).subscribe(
            data =>{this.dailyIncome = data}
        );
    }

}
