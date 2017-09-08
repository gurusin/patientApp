import { Component, OnInit } from '@angular/core';
import {ItemServiceService} from "../services/item-service.service";
import {Router} from "@angular/router";
import {POServiceService} from "../services/poservice.service";

@Component({
  selector: 'app-issue',
  templateUrl: './issue.component.html',
  styleUrls: ['./issue.component.css']
})
export class IssueComponent implements OnInit {

  items = [];
  issueObject;
  total=0;

  constructor(private itemService: ItemServiceService,private router:Router,
              private poService:POServiceService) { }

  ngOnInit() {
    this.initItems();
    this.issueObject = new Object();
    this.issueObject.details=[];
    this.issueObject.issueDate = new Date();
    this.issueObject.paymentMethod ='CASH';
    this.issueObject.issueStatus = 'CREATED';
    this.addNew();

  }

  addNew()
  {
    this.issueObject.details.push({
      unitPrice : 0,
      itemId :0,
      avQuantity: 0,
      quantity : 0,
    });
  }

  onSelectItem(itemIndex, issueIndex)
  {
     var detail = this.issueObject.details[issueIndex];
     var item = this.items[itemIndex];
     detail.unitPrice = item.unitPrice;
     detail.itemId = item.itemId;
     detail.avQuantity = item.quantity;
  }

  calculateTotal()
  {
    this.total =0;
    for (let obj of this.issueObject.details){
      this.total = this.total +(obj.unitPrice * obj.quantity);
    }
  }

  doAdd()
  {
    this.addNew();
  }

  doDelete(i)
  {
    this.issueObject.details.splice(i,1);
    this.calculateTotal();
  }
  private initItems() {
    this.itemService.loadItems().subscribe(items => {
        this.items = items;
      }
    );
  }

  onSave() {
    this.poService.saveIssue(this.issueObject).subscribe(
      data =>{
        this.router.navigate(['/supplier']);
      }
    );
  }

  onCancel() {
    this.router.navigate(['/supplier']);
  }

}
