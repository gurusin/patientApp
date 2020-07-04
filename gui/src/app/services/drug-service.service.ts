
import {PrescribableDrug} from "../prescription-component/prescribable-drug";
import {Basedrug} from "../drugcomponent/basedrug";
import {Drug} from "../drugcomponent/drug";
import {DrugPackage} from "../drugcomponent/drug-package";
import {Strength} from "../drugcomponent/strength";
import {Patientvisit} from "../treatment/patientvisit";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {HttpServiceService} from "../service/http-service.service";
import {Injectable} from "@angular/core";

@Injectable()
export class DrugServiceService {

  public baseDrug: Basedrug;
  public drug: Drug;
  public drugPackage: DrugPackage;
  public strength: Strength;

  public savedPrescription:any;

  constructor(private http: HttpServiceService) {
  }

  searchDrug(drugName: string): Observable<any[]> {
    return this.http.sendPost("getDrugByName",drugName);
  }

  searchPrescribable(drugId: any): Observable<PrescribableDrug> {
    return this.http.sendPost("getPrescribable", drugId);
  }

  savePrescription(obj: any):Observable<any> {
    var url = "savePrescription";
     return this.http.sendPost(url, obj);
  }

  loadPrescriptions(patientId: any): Observable<any[]> {
    var url = "loadPrescriptions";
    return this.http.sendPost(url, patientId);
  }

  loadBaseDrugs(): Observable<any[]> {
    var url = "loadBaseDrugs";
    return this.http.sendGet(url);
  }

  loadDrugs(): Observable<any[]> {
    var url = "loadDrugs";
    return this.http.sendGet(url);
  }

  loadStregths(): Observable<any[]> {
    var url = "loadStrengths";
    return this.http.sendGet(url);
  }

  loadDrugPacakges(): Observable<any[]> {
    var url = "loadDrugPackages";
    return this.http.sendGet(url);
  }

  findDrugPackages(name:string): Observable<any[]> {
    var url = "findDrugPackages";
    return this.http.sendPost(url,name);
  }

  saveDrugPackage(drugPackage: any):Observable<any> {
    var url = "saveDrugPackage";
    return this.http.sendPost(url, drugPackage);
  }

  saveBaseDrug(baseDrug: any):Observable<any> {
    var url = "saveBaseDrug";
    return this.http.sendPost(url, baseDrug);
  }

  saveDrug(drug: any):Observable<any>
  {
    var url = "saveDrug";
    return this.http.sendPost(url, drug);
  }

    setSavedPrescription(data: any) {
        this.savedPrescription = data;
    }

  loadPrescriptionByDate(date: any) {
    var url = "loadPrescriptionByDate";
    return this.http.sendPost(url, date);
  }

  getPrescription(id):Observable<any>{
      var url = "getPrescription";
      return this.http.sendPost(url, id);
  }

  getPrescriptionForPatient(id):Observable<any>{
    var url = "getPrescriptionsForPatient?patId="+id;
    return this.http.sendGet(url);
  }



    loadPrescriptionLight(patientId: number):Observable<any> {
        var url = "loadPrescriptionLite";
        return this.http.sendPost(url,patientId);
    }

  searchPrescriptions(prescriptionSearchCriteria: any):Observable<any>
  {
    var url = "prescriptionSearch";
    return this.http.sendPost(url,prescriptionSearchCriteria);
  }

  adjustStock(stock: any):Observable<any>
  {
    var url = "adjustStock";
    return this.http.sendPost(url,stock);
  }

  searchAdjustment(searchCritera: any) {
    var url = "findAdjustments";
    return this.http.sendPost(url,searchCritera);
  }
}

