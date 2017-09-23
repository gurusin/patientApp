import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../../../services/drug-service.service";

@Component({
  selector: 'app-stock-adjustment',
  templateUrl: './stock-adjustment.component.html',
  styleUrls: ['./stock-adjustment.component.css']
})
export class StockAdjustmentComponent implements OnInit {

  drugPackageList = [];
  selectedIndex: string;
  selectedDrugPackage: any;
  adjustment: any;
  saved = false;
  searchCritera: any;
  adjustments = [];

  constructor(private drugService: DrugServiceService) {
    this.initAdjustment();
    this.searchCritera = {
      fromDate: new Date().toDateString(),
      toDate: new Date().toDateString()
    }
  }


  private initAdjustment() {
    this.adjustment = {
      dateOfAdjustment: new Date(),
      drugPackage: {drugPackageId: 0},
      adjustedQty: 0,
      remarks: ""
    };
  }

  ngOnInit() {
  }

  saveAdjustment() {

    this.adjustment.drugPackage.drugPackageId = this.selectedDrugPackage.drugPackageId;
    this.drugService.adjustStock(this.adjustment).subscribe(
      data => {
        this.saved = true;
        this.initAdjustment();
      }
    );
  }

  doSearch() {
    this.drugService.searchAdjustment(this.searchCritera).subscribe(
      data => {
        this.adjustments = data;
      }
    );
  }

  searchDrugPackage(event: any, value: string) {
    this.saved = false;
    if (event.keyCode == 13) {
      this.selectedDrugPackage = this.drugPackageList[this.selectedIndex];
      return;
    }
    if (value.length == 2) {
      this.drugService.findDrugPackages(value).subscribe(
        data => {
          this.drugPackageList = data;
        }
      );
    }

  }

}
