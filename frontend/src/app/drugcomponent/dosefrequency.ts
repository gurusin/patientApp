export class Dosefrequency {
  private _doseFrequencyId;
  private _timeUnit;
  private _noofDoses;


  get doseFrequencyId() {
    return this._doseFrequencyId;
  }

  set doseFrequencyId(value) {
    this._doseFrequencyId = value;
  }

  get timeUnit() {
    return this._timeUnit;
  }

  set timeUnit(value) {
    this._timeUnit = value;
  }

  get noofDoses() {
    return this._noofDoses;
  }

  set noofDoses(value) {
    this._noofDoses = value;
  }
}
