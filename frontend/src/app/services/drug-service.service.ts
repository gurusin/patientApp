import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {PrescribableDrug} from "../prescription-component/prescribable-drug";
import {Basedrug} from "../drugcomponent/basedrug";
import {Drug} from "../drugcomponent/drug";
import {DrugPackage} from "../drugcomponent/drug-package";
import {Strength} from "../drugcomponent/strength";

@Injectable()
export class DrugServiceService {

  public baseDrug: Basedrug;
  public drug: Drug;
  public drugPackage: DrugPackage;
  public strength: Strength;

  public savedPrescription:any;

  constructor(private http: Http) {
  }

  searchDrug(drugName: string): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"getDrugByName";
    return this.http.post(url, drugName).map((res: Response) => res.json());
  }

  searchPrescribable(drugId: number): Observable<PrescribableDrug> {
    var url = localStorage.getItem("rootURL") +"getPrescribable";
    return this.http.post(url, drugId).map((res: Response) => res.json());
  }

  savePrescription(obj: any):Observable<any> {
    var url = localStorage.getItem("rootURL") +"savePrescription";
     return this.http.post(url, obj).map((res: Response) => res.json());
  }

  loadPrescriptions(patientId: any): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"loadPrescriptions";
    return this.http.post(url, patientId).map((res: Response) => res.json())
  }

  loadBaseDrugs(): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"loadBaseDrugs";
    return this.http.get(url).map((res: Response) => res.json());
  }

  loadDrugs(): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"loadDrugs";
    return this.http.get(url).map((res: Response) => res.json());
  }

  loadStregths(): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"loadStrengths";
    return this.http.get(url).map((res: Response) => res.json());
  }

  loadDrugPacakges(): Observable<any[]> {
    var url = localStorage.getItem("rootURL") +"loadDrugPackages";
    return this.http.get(url).map((res: Response) => res.json());
  }

  saveDrugPackage(drugPackage: any) {
    var url = localStorage.getItem("rootURL") +"saveDrugPackage";
    return this.http.post(url, drugPackage).map((res: Response) => res.json()).subscribe(
      data => {
        this.drugPackage = data;
      }
    );
  }

  saveBaseDrug(baseDrug: any):Observable<any> {
    var url = localStorage.getItem("rootURL") +"saveBaseDrug";
    return this.http.post(url, baseDrug).map((res: Response) => res.json());
  }

  saveDrug(drug: any):Observable<any>
  {
    var url = localStorage.getItem("rootURL") +"saveDrug";
    return this.http.post(url, drug).map((res: Response) => res.json());
  }

    setSavedPrescription(data: any) {
        this.savedPrescription = data;
    }

  loadPrescriptionByDate(date: any) {
    var url = localStorage.getItem("rootURL") +"loadPrescriptionByDate";
    return this.http.post(url, date).map((res: Response) => res.json());
  }
}

