import {Component, OnInit} from '@angular/core';
import {ItemSupplierService} from "../services/itemsupplier.service";
import {ItemServiceService} from "../services/item-service.service";
import {POServiceService} from "../services/poservice.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-purchseorder',
  templateUrl: './purchseorder.component.html',
  styleUrls: ['./purchseorder.component.css']
})
export class PurchseorderComponent implements OnInit {

  po: PurchaseOrderDTO;
  suppliers = [];
  items = [];
  pono: number;
  pendingPos = [];

  constructor(private supplierService: ItemSupplierService, private itemService: ItemServiceService,
              private poService: POServiceService, private router: Router) {

  }

  doAdd() {
    this.po.addItem();
  }

  onSave() {
    this.poService.savePO(this.po);
    this.po = new PurchaseOrderDTO();
    this.router.navigate(['/supplier']);
  }

  onCancel() {
    this.po = new PurchaseOrderDTO();
  }

  ngOnInit() {
    this.po = new PurchaseOrderDTO();
    this.initSuppliers();
    this.initItems();
    this.initPendingPOs();
  }

  private initPendingPOs() {
    this.poService.loadPendingPOs().subscribe(data => {
        this.pendingPos = data;
      }
    );

  }

  private initSuppliers() {
    this.supplierService.loadSuppliers().subscribe(suppliers => {
        this.suppliers = suppliers;
      }
    );
  }

  doDelete(i) {
    this.po.poDetails.splice(i, 1);
  }

  private initItems() {
    this.itemService.loadItems().subscribe(items => {
        this.items = items;
      }
    );
  }

  onSerachPO() {
    alert('find and laod');
  }
}

export class PurchaseOrderDTO {
  supplierId: number;
  poDetails: PODetail[];
  orderDate: Date;
  expectedRecieveDate: Date;
  poStatus: string;

  constructor() {
    this.poDetails = [];
    this.orderDate = new Date();
    this.expectedRecieveDate = new Date();
    this.poStatus = '0';
    this.addItem();
  }


  public addItem() {
    this.poDetails.push(new PODetail());
  }
}

export class PODetail {
  itemId: number;
  qty: number;
}
