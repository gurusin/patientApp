import {PrescribableDrug} from "../prescription-component/prescribable-drug";
export class Patientvisit {
    symptoms: "";
    diagnosys: "";
    diagnoseData:string;
    note: "";
    patientId:number;
    public prescribableDrug:PrescribableDrug[];

    constructor()
    {
      this.prescribableDrug = [];
    }
}

