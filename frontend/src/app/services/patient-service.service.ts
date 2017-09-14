import {Injectable} from '@angular/core';
import {Http, RequestMethod, RequestOptions, Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import {Patient} from "../patient";
import {Subject} from "rxjs/Subject";

@Injectable()
export class PatientServiceService {

  // rootUrl ="http://localhost:8080/";
  patientSearchURL = "searchPat";
  patientVisitSaveURL = "savePatientVisit";
  patientSaveURL = "savePatient";
  patientGetByNIC = "getByNIC";

  public patient: Subject<Patient>;
  public patientObject: Patient;

  constructor(private http: Http) {
    this.patient = new Subject();
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
    this.patient = new Subject<Patient>();
  }

  loadPatients(): Observable<any[]> {
    var url = localStorage.getItem("rootURL")  + "loadPatients";
    return this.http.get(url).map((res: Response) => res.json())
  }
}
