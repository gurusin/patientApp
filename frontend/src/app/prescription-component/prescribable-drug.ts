import {Drug} from "../drugcomponent/drug";
import {Strength} from "../drugcomponent/strength";
import {Dosefrequency} from "../drugcomponent/dosefrequency";
export class PrescribableDrug {

  drug:Drug;
  strengths:Strength[];
  doseFrequency:Dosefrequency[];
  doseAmount:number;
  doseDuration:number;
  durationUnit:string[];
  selectedStrength:string;
  selectedFrequency:string;
  selectedDuration:string;
  meal:string;
}
