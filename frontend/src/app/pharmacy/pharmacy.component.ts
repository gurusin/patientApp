import { Component, OnInit } from '@angular/core';
import {DrugServiceService} from "../services/drug-service.service";

@Component({
  selector: 'app-pharmacy',
  templateUrl: './pharmacy.component.html',
  styleUrls: ['./pharmacy.component.css']
})
export class PharmacyComponent implements OnInit {

  prescriptionDTOList  = [];
  date: Date;
  constructor(private drugService: DrugServiceService) {
    this.date = new Date();
  }

  ngOnInit() {
    this.drugService.loadPrescriptionByDate(this.date
    ).subscribe(
      data => {
        this.prescriptionDTOList = data;
      }
    );
  }

}
