import {Drug} from "../drugcomponent/drug";
import {Strength} from "../drugcomponent/strength";
import {Dosefrequency} from "../drugcomponent/dosefrequency";
export class PrescribableDrug {

  public drug:Drug;
  strengths:Strength[];
  doseFrequency:Dosefrequency[];
  selectedStrengthIndex :0;
  doseAmount:number;
  doseDuration:number;
  durationUnit:string[];
  selectedStrength:Strength;
  selectedFrequency:number;
  selectedDuration:string;
  meal:string;
  drugList:any[];
  rowId:number;

  constructor()
  {
    this.drug=new Drug();
    this.rowId = new Date().getMilliseconds();
    this.selectedStrength = new Strength();
  }
}
