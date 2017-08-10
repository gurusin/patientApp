import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { PatientComponentComponent } from './patient-component/patient-component.component';
import { PatientSearchComponent } from './patient-component/patient-search.component';
import {PatientServiceService} from "./patient-service.service";
import { NgxTypeaheadModule } from 'ngx-typeahead';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponentComponent,
    PatientSearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgxTypeaheadModule
  ],
  providers: [PatientServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
