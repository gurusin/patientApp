import {Component, OnInit} from '@angular/core';
import {AdminService} from "../services/admin.service";
import {DrugServiceService} from "../services/drug-service.service";

@Component({
    selector: 'app-in-out',
    templateUrl: './in-out.component.html',
    styleUrls: ['./in-out.component.css']
})
export class InOutComponent implements OnInit {

    searchCriteria: any;
    drugList=[];
    drugId=0;

    reports =[];
    constructor(private adminService: AdminService, private  drugServiceService:DrugServiceService) {
        this.searchCriteria =
          {
            fromDate:new Date(),
            toDate:new Date(),
            drugId: 0
          };

      this.drugServiceService.loadDrugs(
      ).subscribe(
        data => {
          this.drugList = data;
          console.log(data);
        }
      );


    }

  searchDrug(event: any) {

  }

    ngOnInit() {
    }

    doSearch() {

        this.adminService.getInOutReport(this.searchCriteria).subscribe(
            data =>{
                this.reports = data;
            }
        );

    }


}
