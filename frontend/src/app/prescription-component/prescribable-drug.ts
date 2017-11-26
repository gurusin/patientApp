import {Drug} from "../drugcomponent/drug";
import {Strength} from "../drugcomponent/strength";
import {Dosefrequency} from "../drugcomponent/dosefrequency";

export class PrescribableDrug {

  public drug: Drug;
  doseFrequency: Dosefrequency[];
  selectedStrengthIndex: 0;
  doseAmount: number;
  doseDuration: number;
  durationUnit: string[];
  selectedStrength: Strength;
  selectedFrequency: number;
  selectedDuration: string;
  meal: string;
  drugList: any[];
  rowId: number;
  packages: any[];
  availableQty: any;
  unitPrice = 0.00;
  price = 0.00;
  neededQty = 0;
  frequency : Dosefrequency;
  drugPackage:any;
  valid=false;

  constructor() {
    this.drug = new Drug();
    this.rowId = new Date().getMilliseconds();
    this.selectedStrength = new Strength();
    this.valid = false;
  }

  public findAvailableQty() {
    this.availableQty = this.packages[this.selectedStrengthIndex].quantity;
  }



}
