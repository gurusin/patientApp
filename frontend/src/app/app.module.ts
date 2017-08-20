import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { PatientSearchComponent } from './patient-component/patient-search.component';
import {PatientServiceService} from "./patient-service.service";
import { PatientsaveComponent } from './patientsave/patientsave.component';
import { TreatmentComponent } from './treatment/treatment.component';
import { NavbarComponent } from './navbar.component'
import {routing} from "./app.routing";
import { PatientVisitComponent } from './treatment/patient-visit.component';
import { PatientnavbarComponent } from './treatment/patientnavbar.component';
import { BasicvisitComponent } from './treatment/basicvisit.component';
import { DrugcomponentComponent } from './drugcomponent/drugcomponent.component';
import { DrugdosageComponent } from './drugcomponent/drugdosage.component';
import { DrugsearchComponent } from './drugcomponent/drugsearch.component';
import { DrugdosagelistComponent } from './drugcomponent/drugdosagelist.component';
import { PrescriptionComponentComponent } from './prescription-component/prescription-component.component';
import {DrugServiceService} from "app/drug-service.service";
import { PrescriptionHistoryComponent } from './prescription-component/prescription-history.component';
import { PrescriptiondetailComponent } from './prescription-component/prescriptiondetail.component';
import { PrintreceiptComponent } from './prescription-component/printreceipt.component';
import { PatientadminComponent } from './patient-component/patientadmin.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientSearchComponent,
    PatientsaveComponent,
    TreatmentComponent,
    NavbarComponent,
    PatientVisitComponent,
    PatientnavbarComponent,
    BasicvisitComponent,
    DrugcomponentComponent,
    DrugdosageComponent,
    DrugsearchComponent,
    DrugdosagelistComponent,
    PrescriptionComponentComponent,
    PrescriptionHistoryComponent,
    PrescriptiondetailComponent,
    NavbarComponent,
    PrintreceiptComponent,
    PatientadminComponent,
    PatientadminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule, routing
  ],
  providers: [PatientServiceService,DrugServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
