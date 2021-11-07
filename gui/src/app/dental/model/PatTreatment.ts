import {TreatmentItem} from "./TreatmentItem";

export class PatTreatment{
  id:number;
  timeOfAction:string;
  patientId:number;
  trtItemId:number;
  rate:number;
  remarks:string;
  treatmentItem:TreatmentItem;

  constructor() {
    this.treatmentItem = new TreatmentItem();
  }

}
