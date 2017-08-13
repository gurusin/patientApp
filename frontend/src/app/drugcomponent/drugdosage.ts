import {Drug} from "./drug";
import {Strength} from "./strength";
import {Dosefrequency} from "./dosefrequency";
import {Durationunit} from "./durationunit";

export class Drugdosage {
  private _doseId: 0;
  private _drug: Drug;
  private _strength: Strength;
  private _doseSize;
  private _doseFrequency: Dosefrequency;
  private _durationUnit: Durationunit;
  private _duration;
  private _meal;


  get doseId(): any {
    return this._doseId;
  }

  set doseId(value: any) {
    this._doseId = value;
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

  get doseSize() {
    return this._doseSize;
  }

  set doseSize(value) {
    this._doseSize = value;
  }

  get doseFrequency(): Dosefrequency {
    return this._doseFrequency;
  }

  set doseFrequency(value: Dosefrequency) {
    this._doseFrequency = value;
  }

  get durationUnit(): Durationunit {
    return this._durationUnit;
  }

  set durationUnit(value: Durationunit) {
    this._durationUnit = value;
  }

  get duration() {
    return this._duration;
  }

  set duration(value) {
    this._duration = value;
  }

  get meal() {
    return this._meal;
  }

  set meal(value) {
    this._meal = value;
  }
}
