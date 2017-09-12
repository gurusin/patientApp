import {Component, Input, OnInit} from '@angular/core';
import {Itemtype} from "../item/itemtype";
import {MedicalServiceItem} from "./medical-service-item";
import {MedicalServiceItemService} from "../services/medical-service-item.service";
import {Router} from "@angular/router";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-medservice',
  templateUrl: './medservice.component.html',
  styleUrls: ['./medservice.component.css']
})
export class MedserviceComponent implements OnInit {
  medicalServiceItem: MedicalServiceItem = null;
  medicalServiceItemList = [];
  selectedRow: number;
  setClickedRow: Function;

  @Input() selectedMedicalServiceItem: MedicalServiceItem;

  constructor(private medicalServiceItemService: MedicalServiceItemService, private router: Router, private adminService: AdminService) {
    this.medicalServiceItem = new MedicalServiceItem();

    this.setClickedRow = function (index) {
      this.selectedRow = index;
      if (index >= 0 && index < this.medicalServiceItemList.length) {
        this.selectedMedicalServiceItem = this.medicalServiceItemList[index];
        this.medicalServiceItem = this.selectedMedicalServiceItem;
      }
    }

  }

  ngOnInit() {
    this.medicalServiceItemService.loadMedicalServiceItems(
    ).subscribe(
      data => {
        this.medicalServiceItemList = data;

      }
    );

    this.selectedMedicalServiceItem = this.medicalServiceItemList[0];
    alert(this.selectedMedicalServiceItem.itemId);
  }

  onSubmit() {
    this.medicalServiceItemService.saveMedicalServiceItem(this.medicalServiceItem);
    this.medicalServiceItemService.medicalServiceItemObject = new MedicalServiceItem();
    this.medicalServiceItemService.loadMedicalServiceItems(
    ).subscribe(
      data => {
        this.medicalServiceItemList = data;
      }
    );
    window.location.reload();
  }

  cancelEdit() {
    this.selectedRow = -1;
    this.selectedMedicalServiceItem = new MedicalServiceItem();
    this.medicalServiceItem = this.selectedMedicalServiceItem;
  }

}
