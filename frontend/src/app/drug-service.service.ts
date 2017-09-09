import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {PrescribableDrug} from "./prescription-component/prescribable-drug";
import {Basedrug} from "./drugcomponent/basedrug";
import {Drug} from "./drugcomponent/drug";
import {DrugPackage} from "./drugcomponent/drug-package";
import {Strength} from "./drugcomponent/strength";

@Injectable()
export class DrugServiceService {

  rootUrl = "http://localhost:8080/";
  public baseDrug: Basedrug;
  public drug: Drug;
  public drugPackage: DrugPackage;
  public strength: Strength;

  constructor(private http: Http) {
  }

  searchDrug(drugName: string): Observable<any[]> {
    return this.http.post(this.rootUrl + "getDrugByName", drugName).map((res: Response) => res.json());
  }

  searchPrescribable(drugId: number): Observable<PrescribableDrug> {
    return this.http.post(this.rootUrl + "getPrescribable", drugId).map((res: Response) => res.json());
  }

  savePrescription(obj: any):Observable<any> {
     return this.http.post(this.rootUrl + "savePrescription", obj).map((res: Response) => res.json());
  }

  loadPrescriptions(patientId: any): Observable<any[]> {
    return this.http.post(this.rootUrl + "loadPrescriptions", patientId).map((res: Response) => res.json())
  }

  loadBaseDrugs(): Observable<any[]> {
    return this.http.get(this.rootUrl + "loadBaseDrugs").map((res: Response) => res.json());
  }

  loadDrugs(): Observable<any[]> {
    return this.http.get(this.rootUrl + "loadDrugs").map((res: Response) => res.json());
  }

  loadStregths(): Observable<any[]> {
    return this.http.get(this.rootUrl + "loadStrengths").map((res: Response) => res.json());
  }

  loadDrugPacakges(): Observable<any[]> {
    return this.http.get(this.rootUrl + "loadDrugPackages").map((res: Response) => res.json());
  }

  saveDrugPackage(drugPackage: any) {
    return this.http.post("http://localhost:8080/saveDrugPackage", drugPackage).map((res: Response) => res.json()).subscribe(
      data => {
        this.drugPackage = data;
      }
    );
  }

  saveBaseDrug(baseDrug: any) {
    return this.http.post("http://localhost:8080/saveBaseDrug", baseDrug).map((res: Response) => res.json()).subscribe(
      data => {
        this.baseDrug = data;
      }
    );
  }

  saveDrug(drug: any) {
    return this.http.post("http://localhost:8080/saveDrug", drug).map((res: Response) => res.json()).subscribe(
      data => {
        this.drug = data;
      }
    );
  }
}

