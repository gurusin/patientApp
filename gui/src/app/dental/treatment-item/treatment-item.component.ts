import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DentalServiceService} from "../../services/dental-service.service";
import {TreatmentItem} from "../model/TreatmentItem";

@Component({
  selector: 'app-treatment-item',
  templateUrl: './treatment-item.component.html',
  styleUrls: ['./treatment-item.component.css']
})
export class TreatmentItemComponent implements OnInit {

  objectList =[];
  currItem:TreatmentItem
  @ViewChild('myModal') modal:ElementRef

  constructor(private service:DentalServiceService) { }

  ngOnInit(): void {
    this.currItem = new TreatmentItem();
    this.loadData();
  }

  private loadData() {
    this.service.getAllTreatmentItems().subscribe(
      data => {
        this.objectList = data;
      }
    );
  }

  onShowModel() {
    this.modal.nativeElement.style.setProperty('display','block');
  }

  onSave() {
    this.service.saveItem(this.currItem).subscribe(
      data =>{
        this.loadData();
      }
    );
    this.onCancel();
  }

  onCancel() {
    this.currItem = new TreatmentItem();
    this.modal.nativeElement.style.setProperty('display','none');
  }

  doEdit(obj: any) {
    this.currItem = obj;
    this.onShowModel();
  }

  delete(id) {
      this.service.deleteTreatmentItem(id).subscribe(
         data =>{
           this.loadData();
         },
        error => {
           alert(error.error.message);
        }
      )
  }
}
