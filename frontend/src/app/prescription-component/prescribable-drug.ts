import {Drug} from "../drugcomponent/drug";
import {Strength} from "../drugcomponent/strength";
import {Dosefrequency} from "../drugcomponent/dosefrequency";
export class PrescribableDrug {

  public drug:Drug;
  strengths:Strength[];
  doseFrequency:Dosefrequency[];
  doseAmount:number;
  doseDuration:number;
  durationUnit:string[];
  selectedStrength:string;
  selectedFrequency:number;
  selectedDuration:string;
  meal:string;
  drugList:any[];
  rowId:number;

  constructor()
  {
    this.drug=new Drug();
    this.rowId = new Date().getMilliseconds();
  }
}
