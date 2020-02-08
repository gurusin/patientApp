import {Component, Input, OnInit} from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";

@Component({
  selector: 'app-prescriptiondetail',
  templateUrl: './prescriptiondetail.component.html',
  styleUrls: ['./prescriptiondetail.component.css']
})
export class PrescriptiondetailComponent implements OnInit {
  @Input() prescription :any;
  fullPrescription: any;
  expanded = false;

    constructor(private drugService : DrugServiceService) {
    }

    ngOnInit() {
  }

    doExpand()
    {
      this.expanded = !this.expanded;
      if (this.expanded)
      {
        this.fullPrescription = this.drugService.getPrescription(this.prescription.prescriptionId)
            .subscribe(data =>{
              this.fullPrescription = data;
            });
      }
    }
}
