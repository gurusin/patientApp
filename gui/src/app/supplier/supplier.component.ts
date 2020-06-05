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
  supplierList:ItemSupplier[] = [];
  selectedRow:number;


  constructor(private adminService: AdminService, private router: Router) {
    this.itemSupplier = new ItemSupplier();
  }

  ngOnInit() {
    this.adminService.loadSuppliers(
    ).subscribe(
      data => {
        this.supplierList = data;
      }
    );
  }

  onSubmit() {
    this.adminService.saveSupplier(this.itemSupplier).subscribe(
         data =>{
              this.refreshList(data);
              this.itemSupplier = new ItemSupplier();
         }
    )
  }

  private refreshList(item:ItemSupplier){
    var idx = -1;
    var currIndex =-1;

    for(var x of this.supplierList){
      currIndex++;
      if(x.supplierId == item.supplierId){
        idx = currIndex;
        break;
      }
    }
    if(idx == -1){
      this.supplierList.push(item);
    }else{
      this.supplierList[idx] = item;
    }
  }

  cancelEdit(){

  }

  setClickedRow(index: number) {
    this.selectedRow = index;
    if (index >= 0 && index < this.supplierList.length) {
      Object.assign(this.itemSupplier,this.supplierList[index]);
    }
  }
}
