import {Strengthunit} from "./strengthunit";

export class Strength {
  private _strengthId;
  private _strengthUnit: Strengthunit;
  private _strengthAmount;

  get strengthId() {
    return this._strengthId;
  }

  set strengthId(value) {
    this._strengthId = value;
  }

  get strengthUnit(): Strengthunit {
    return this._strengthUnit;
  }

  set strengthUnit(value: Strengthunit) {
    this._strengthUnit = value;
  }

  get strengthAmount() {
    return this._strengthAmount;
  }

  set strengthAmount(value) {
    this._strengthAmount = value;
  }
}
