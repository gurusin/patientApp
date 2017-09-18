import {Component, OnInit} from '@angular/core';
import {AdminService} from "../services/admin.service";

@Component({
    selector: 'app-in-out',
    templateUrl: './in-out.component.html',
    styleUrls: ['./in-out.component.css']
})
export class InOutComponent implements OnInit {

    searchCriteria: any;

    reports =[];
    constructor(private adminService: AdminService) {
        this.searchCriteria = new Object();
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
