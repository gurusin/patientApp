import {Component, Input, OnInit} from '@angular/core';
import {Itemtype} from "./itemtype";
import {Router} from "@angular/router";
import {AdminService} from "../services/admin.service";

@Component({
  selector: 'app-itemtype',
  templateUrl: './itemtype.component.html',
  styleUrls: ['./itemtype.component.css']
})
export class ItemtypeComponent implements OnInit {
  itemType: Itemtype = null;
  itemTypeList = [];
  selectedRow: number;
  setClickedRow: Function;

  @Input() selectedItemType: Itemtype;

  constructor(private adminService: AdminService, private router: Router) {
    this.itemType = new Itemtype();

    this.setClickedRow = function (index) {
      this.selectedRow = index;
      if (index >= 0 && index < this.itemTypeList.length) {
        this.adminService.itemTypeObject = this.itemTypeList[index];
        this.selectedItemType = this.itemTypeList[index];
        this.itemType = this.selectedItemType;
      }
    }

  }

  ngOnInit() {
    this.adminService.loadItemTypes(
    ).subscribe(
      data => {
        this.itemTypeList = data;

      }
    );
    this.selectedItemType = this.itemTypeList[0];
  }

  onSubmit() {
    this.adminService.saveItemType(this.itemType);
    this.adminService.itemTypeObject = new Itemtype();
    this.adminService.loadItemTypes(
    ).subscribe(
      data => {
        this.itemTypeList = data;
      }
    );
    window.location.reload();
  }

  cancelEdit(){
    this.selectedRow = -1;
    this.selectedItemType = new Itemtype();
    this.itemType = this.selectedItemType;
  }
}
