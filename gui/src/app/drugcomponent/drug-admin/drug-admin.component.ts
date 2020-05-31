import {Component, OnInit} from '@angular/core';
import {DrugServiceService} from "../../services/drug-service.service";
import {Basedrug} from "../basedrug";
import {Drug} from "../drug";
import {DrugPackage} from "../drug-package";

@Component({
    selector: 'app-drug-admin',
    templateUrl: './drug-admin.component.html',
    styleUrls: ['./drug-admin.component.css']
})
export class DrugAdminComponent implements OnInit {
    baseDrugList = [];
    drugList = [];
    selectedDrugRow = -1;
    drug: Drug;
    selectedDrug: Drug;


    constructor(private drugServiceService: DrugServiceService) {

        this.drug = new Drug();

    }

    setClickedDrugRow(obj: any)
    {
      this.drug = obj;
    }

    ngOnInit() {

        this.drugServiceService.loadBaseDrugs(
        ).subscribe(
            data => {
                this.baseDrugList = data;
            }
        );
    }

    onSubmit() {
        this.drugServiceService.saveDrug(this.drug).subscribe(
            data => {
                if (this.selectedDrugRow == -1)
                {
                    this.drugList.push(data);
                    this.cancelEdit();
                }else
                {
                    this.cancelEdit();
                }
            }
        );
    }

    cancelEdit() {
        this.selectedDrugRow = -1;
        var x = new Drug();
        x.baseDrug = this.drug.baseDrug;
        this.drug = x;
    }
}
