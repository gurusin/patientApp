import {Basedrug} from "./basedrug";

export class Drug {
  private _drugId;
  private _baseDrug: Basedrug;
  private _brandName;

  get drugId() {
    return this._drugId;
  }

  set drugId(value) {
    this._drugId = value;
  }

  get baseDrug(): Basedrug {
    return this._baseDrug;
  }

  set baseDrug(value: Basedrug) {
    this._baseDrug = value;
  }

  get brandName() {
    return this._brandName;
  }

  set brandName(value) {
    this._brandName = value;
  }
}
