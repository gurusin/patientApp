import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TreatmentItem} from "../model/TreatmentItem";
import {DentalServiceService} from "../../services/dental-service.service";
import {PatTreatment} from "../model/PatTreatment";
import {PatientServiceService} from "../../services/patient-service.service";

@Component({
  selector: 'app-treatment-history',
  templateUrl: './treatment-history.component.html',
  styleUrls: ['./treatment-history.component.css']
})
export class TreatmentHistoryComponent implements OnInit {

  trtTypes:TreatmentItem[] = [];
  currObj:PatTreatment = new PatTreatment();
  treatments:PatTreatment[] =[];
  @ViewChild("editComp") editComp:ElementRef;

  constructor(private service:DentalServiceService, private patService:PatientServiceService) { }


  ngOnInit(): void {
    this.patTreatments();
    this.loadTreatments();


  }

  private patTreatments() {
    this.service.getAllPatTreatments(this.patService.patientObject.patientId).subscribe(
      data => {
        this.treatments = data;
      }
    );
  }

  private loadTreatments() {
    this.service.getAllTreatmentItems().subscribe(
      data => {
        this.trtTypes = data;
      }
    );
  }

  showNew() {
    this.editComp.nativeElement.style.setProperty('display','block');
  }

  cancel() {
    this.currObj = new PatTreatment();
    this.editComp.nativeElement.style.setProperty('display','none');
    this.loadTreatments();
  }

  save() {
    this.currObj.patientId = this.patService.patientObject.patientId;
    this.service.savePatTreatment(this.currObj).subscribe(
       data =>{
          this.patTreatments();
       }
    );
    this.cancel();
  }

  changeItem() {
    this.trtTypes.forEach(item =>{
       if(item.id == this.currObj.treatmentItem.id){
          this.currObj.rate = item.rate;
          this.currObj.treatmentItem = item;
          this.currObj.trtItemId = item.id;
       }
    });
  }

  editTrt(obj: PatTreatment) {
    this.currObj = obj;
    this.showNew();
  }

  delete(id: number) {
    this.service.deletePatTreatment(id).subscribe(
       data =>{
          this.patTreatments();
       }
    )
  }
}
