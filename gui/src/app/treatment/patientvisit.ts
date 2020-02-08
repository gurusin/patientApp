import {PrescribableDrug} from "../prescription-component/prescribable-drug";
export class Patientvisit {
    symptoms: string;
    diagnosys: "";
    diagnoseData:string;
    note:string;
    externalNote="";
    patientId:number;
    public prescribableDrug:PrescribableDrug[];
    medicalServices;
    prescriptionId:number;


    constructor()
    {
      this.prescribableDrug = [];
      this.medicalServices=[];
      this.note='';
      this.symptoms='';
    }
}

