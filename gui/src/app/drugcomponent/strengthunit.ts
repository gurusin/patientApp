export class Strengthunit {
  private _unitId;
  private _unitName: "";

  get unitId() {
    return this._unitId;
  }

  set unitId(value) {
    this._unitId = value;
  }

  get unitName() {
    return this._unitName;
  }

  set unitName(value) {
    this._unitName = value;
  }
}
