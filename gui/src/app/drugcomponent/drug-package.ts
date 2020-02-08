import {Drug} from "./drug";
import {Strength} from "./strength";

export class DrugPackage {

  constructor(){
    this.drug = new Drug();
    this.strength = new Strength();
  }
  drugPackageId: number;

  drug: Drug;

  strength: Strength;

  quantity: number;

  minOrderLevel: number;

  unitPrice: number

  drugPackageContentType:string;


}
