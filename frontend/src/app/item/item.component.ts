import {Component, Input, OnInit} from '@angular/core';
import {Itemproduct} from "./itemproduct";
import {ItemProductService} from "../services/itemProduct.service";
import {Router} from "@angular/router";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  itemproduct: Itemproduct = null;
  itemproductList = [];
  selectedRow: number;
  setClickedRow: Function;
  unitOfMeasureList = [];
  itemTypeList = [];

  @Input() selectedItemproduct: Itemproduct;

  constructor(private itemProductService: ItemProductService, private router: Router, private adminService: AdminService) {
    this.itemproduct = new Itemproduct();

    this.setClickedRow = function (index) {
      this.selectedRow = index;
      if (index >= 0 && index < this.itemproductList.length) {
        this.adminService.itemTypeObject = this.itemproductList[index];
        this.selectedItemproduct = this.itemproductList[index];
        this.itemproduct = this.selectedItemproduct;
      }
    }

  }

  ngOnInit() {
    this.itemProductService.loadItemProducts(
    ).subscribe(
      data => {
        this.itemproductList = data;

      }
    );
    this.adminService.loadUnitOfMeasure(
    ).subscribe(
      data => {
        this.unitOfMeasureList = data;

      }
    );
    this.adminService.loadItemTypes(
    ).subscribe(
      data => {
        this.itemTypeList = data;

      }
    );
    this.selectedItemproduct = this.itemproductList[0];
  }

  onSubmit() {
    this.itemProductService.saveItemProduct(this.itemproduct);
    this.itemProductService.itemproductObject = new Itemproduct();
    this.itemProductService.loadItemProducts(
    ).subscribe(
      data => {
        this.itemproductList = data;
      }
    );
    window.location.reload();
  }

  cancelEdit() {
    this.selectedRow = -1;
    this.selectedItemproduct = new Itemproduct();
    this.itemproduct = this.selectedItemproduct;
  }
}
