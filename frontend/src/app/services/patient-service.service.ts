import {Injectable} from '@angular/core';
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {Subject} from "rxjs/Subject";
import {Patientvisit} from "../treatment/patientvisit";
import {Prescription} from "../prescription-component/prescription-component.component";
import {PrescribableDrug} from "../prescription-component/prescribable-drug";

@Injectable()
export class PatientServiceService {

  patientSearchURL = "searchPat";
  patientVisitSaveURL = "savePatientVisit";
  patientSaveURL = "savePatient";
  patientGetByNIC = "getByNIC";

  public patientObject: Patient;
  public patientVisit:Patientvisit;

  constructor(private http: Http) {

  }

  searchByNIC(nic: string): Observable<any[]> {
    var url = localStorage.getItem("rootURL")  + this.patientSearchURL
    return this.http.post(url, nic).map((res: Response) => res.json());
  }

  getByNIC(nic: string) :Observable<any> {
    var url = localStorage.getItem("rootURL")  + this.patientGetByNIC;
    return this.http.post(url, nic).map((res: Response) => res.json());
  }

  savePatientVisit(patientVisit: any): Observable<any[]> {
    var url = localStorage.getItem("rootURL") + this.patientVisitSaveURL;
    return this.http.post(url , patientVisit).map((res: Response) => res.json());
  }

  savePatient(patient: any):Observable<any> {
    var url = localStorage.getItem("rootURL") + this.patientSaveURL;
    return this.http.post(url , patient).map((res: Response) => res.json());
  }

  getByPatNo(patNo: string):Observable<any> {
    var url = localStorage.getItem("rootURL") + "getByPatientId";
    return this.http.post(url , patNo).map((res: Response) => res.json());
  }

  getByPhoneNo(phoneNo: string): Observable<any>
  {
    var url = localStorage.getItem("rootURL") + "getByPhoneNo";
    return this.http.post(url, phoneNo).map((res: Response) => res.json());
  }

  searchByPhone(phoneNo: string) :Observable<any> {
    var url = localStorage.getItem("rootURL")  + "searchPatByPhoneNo";
    return this.http.post(url, phoneNo).map((res: Response) => res.json());
  }


  public clearPatient() {
    this.patientObject = new Patient();
    this.patientObject.patientId = 0;
  }

  loadPatients(): Observable<any[]> {
    var url = localStorage.getItem("rootURL")  + "loadPatients";
    return this.http.get(url).map((res: Response) => res.json())
  }

    findByName(name: any) :Observable<any>{
        var url = localStorage.getItem("rootURL")  + "findByName";
        return this.http.post(url,name).map((res: Response) => res.json())
    }

  newPatientVisit() {
    this.patientVisit = new Patientvisit();
    this.patientVisit.diagnoseData = '';
    this.patientVisit.prescribableDrug = [];
    this.patientVisit.medicalServices=[];
    this.patientVisit.prescriptionId=0;
  }

  prepareForEdit(prescription:Prescription)
  {
    this.patientVisit = new Patientvisit();
    this.patientObject = prescription.patient;
    this.patientVisit.prescriptionId = prescription.id;
    this.patientVisit.diagnoseData = prescription.diagnosis;
    this.patientVisit.note = prescription.notes;
    this.patientVisit.symptoms = prescription.symptoms;
    this.patientVisit.externalNote = prescription.externalNote;
    prescription.medicalServices.forEach(item=>{
       var medicalServItem = {
          itemId :item.medicalServItem.itemId,
          itemDescription: item.medicalServItem.itemDescription,
          externalRef : item.medicalServItem.externalRef,
          unitPrice: item.fee
       };
       this.patientVisit.medicalServices.push(medicalServItem);
    });

    prescription.prescriptionDetails.forEach(item=>{
      var obj:PrescribableDrug = new PrescribableDrug();
       obj.drug =item.drugPackage.drug;
       obj.drugPackage = item.drugPackage;
       obj.selectedStrength = item.drugPackage.strength;
       obj.doseAmount = item.amount;
       obj.doseDuration = item.duration;
       obj.frequency = item.frequency;
       obj.selectedDuration =item.intervalUnit;
       obj.meal = item.meal;
       obj.neededQty = item.prescribedQty;
       obj.unitPrice = item.drugPackage.unitPrice;
       obj.price = obj.unitPrice * obj.neededQty;
       this.patientVisit.prescribableDrug.push(obj);
    });
  }
}
