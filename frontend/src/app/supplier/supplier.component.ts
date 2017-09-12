import {Component, Input, OnInit} from '@angular/core';
import {AdminService} from "../services/admin.service";
import {Router} from "@angular/router";
import {ItemSupplier} from "./ItemSupplier";

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {

  itemSupplier: ItemSupplier = null;
  supplierList = [];
  selectedRow: number;
  setClickedRow: Function;
  selectedSupplierName: string;

  newSupplier=true;
  @Input() selectedSupplier: ItemSupplier;

  constructor(private adminService: AdminService, private router: Router) {
    this.itemSupplier = new ItemSupplier();

    this.setClickedRow = function (index) {
      this.selectedRow = index;
      if (index >= 0 && index < this.supplierList.length) {
        this.adminService.supplierObject = this.supplierList[index];
        this.selectedSupplier = this.supplierList[index];
        this.itemSupplier = this.selectedSupplier;
      }
    }

  }

  ngOnInit() {
    this.adminService.loadSuppliers(
    ).subscribe(
      data => {
        this.supplierList = data;

      }
    );
    this.selectedSupplier = this.supplierList[0];
  }

  onSubmit() {
    this.adminService.saveSupplier(this.itemSupplier)
    this.adminService.supplierObject = new ItemSupplier();
    this.adminService.loadSuppliers(
    ).subscribe(
      data => {
        this.supplierList = data;
      }
    );
    window.location.reload();
  }

  cancelEdit(){
    this.selectedRow = -1;
      this.selectedSupplier = new ItemSupplier();
      this.itemSupplier = this.selectedSupplier;
  }
}
