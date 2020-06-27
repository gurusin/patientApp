import {Injectable} from '@angular/core';
import 'rxjs';
import {Patient} from "../patient";
import {Patientvisit} from "../treatment/patientvisit";
import {Prescription} from "../prescription-component/prescription-component.component";
import {PrescribableDrug} from "../prescription-component/prescribable-drug";
import {HttpServiceService} from "../service/http-service.service";
import {Observable} from "rxjs";

@Injectable()
export class PatientServiceService {

  patientSearchURL = "searchPat";
  patientVisitSaveURL = "savePatientVisit";
  patientSaveURL = "savePatient";
  patientGetByNIC = "getByNIC";

  public patientObject: Patient;
  public patientVisit:Patientvisit;

  constructor(private http: HttpServiceService) {

  }

  searchByNIC(nic: string): Observable<any[]> {
    var url =  this.patientSearchURL
    return this.http.sendPost(url, nic);
  }

  getByNIC(nic: string) :Observable<any> {
    var url = this.patientGetByNIC;
    return this.http.sendPost(url, nic);
  }

  savePatientVisit(patientVisit: any): Observable<any[]> {
    var url = this.patientVisitSaveURL;
    return this.http.sendPost(url , patientVisit);
  }

  savePatient(patient: any):Observable<any> {
    var url = this.patientSaveURL;
    return this.http.sendPost(url , patient);
  }

  getByPatNo(patNo: string):Observable<any> {
    var url = "getByPatientId";
    return this.http.sendPost(url , patNo);
  }

  getByPhoneNo(phoneNo: string): Observable<any>
  {
    var url =  "getByPhoneNo";
    return this.http.sendPost(url, phoneNo);
  }

  searchByPhone(phoneNo: string) :Observable<any> {
    var url = "searchPatByPhoneNo";
    return this.http.sendPost(url, phoneNo);
  }


  public clearPatient() {
    this.patientObject = new Patient();
    this.patientObject.patientId = 0;
  }

  loadPatients(name:string): Observable<any[]> {
    var url = "loadPatients?name="+name;
    return this.http.sendGet(url);
  }

    findByName(name: any) :Observable<any>{
        var url =  "findByName";
        return this.http.sendPost(url,name);
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
