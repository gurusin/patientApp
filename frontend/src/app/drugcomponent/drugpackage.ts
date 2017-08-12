import {Drug} from "./drug";
import {Strength} from "./strength";

export class Drugpackage {
  private _drugPackageId;
  private _drug: Drug;
  private _strength: Strength;
  private _quantity;


  get drugPackageId() {
    return this._drugPackageId;
  }

  set drugPackageId(value) {
    this._drugPackageId = value;
  }

  get drug(): Drug {
    return this._drug;
  }

  set drug(value: Drug) {
    this._drug = value;
  }

  get strength(): Strength {
    return this._strength;
  }

  set strength(value: Strength) {
    this._strength = value;
  }

  get quantity() {
    return this._quantity;
  }

  set quantity(value) {
    this._quantity = value;
  }
}
