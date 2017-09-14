import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {PatientSearchComponent} from './patient-component/patient-search.component';
import {PatientServiceService} from "./services/patient-service.service";
import {PatientsaveComponent} from './patientsave/patientsave.component';
import {TreatmentComponent} from './treatment/treatment.component';
import {NavbarComponent} from './navbar.component'
import {routing} from "./app.routing";
import {PatientVisitComponent} from './treatment/patient-visit.component';
import {PatientnavbarComponent} from './treatment/patientnavbar.component';
import {BasicvisitComponent} from './treatment/basicvisit.component';
import {DrugcomponentComponent} from './drugcomponent/drugcomponent.component';
import {DrugdosageComponent} from './drugcomponent/drugdosage.component';
import {DrugsearchComponent} from './drugcomponent/drugsearch.component';
import {DrugdosagelistComponent} from './drugcomponent/drugdosagelist.component';
import {PrescriptionComponentComponent} from './prescription-component/prescription-component.component';
import {DrugServiceService} from "app/services/drug-service.service";
import {PrescriptionHistoryComponent} from './prescription-component/prescription-history.component';
import {PrescriptiondetailComponent} from './prescription-component/prescriptiondetail.component';
import {PrintreceiptComponent} from './prescription-component/printreceipt.component';
import {PatientadminComponent} from './patient-component/patientadmin.component';
// import {MdDialog, MaterialModule, MdIconRegistry} from "@angular/material";
// import {OVERLAY_PROVIDERS, MdDialogModule} from "@angular/material";
// import {PopupModule} from "ng2-opd-popup";
import {PrintpopComponent} from './treatment/printpop.component';
import {DrugAdminComponent} from './drugcomponent/drug-admin/drug-admin.component';
import {BasedrugadminComponent} from './drugcomponent/drug-admin/basedrugadmin.component';
import {DrugpackageadminComponent} from './drugcomponent/drug-admin/drugpackageadmin.component';
import {DropdownModule} from "ngx-dropdown";
import {AdminService} from "./services/admin.service";
import {ItemServiceService} from "./services/item-service.service";
import {POServiceService} from "./services/poservice.service";
import {ItemSupplierService} from "./services/itemsupplier.service";
import {ItemProductService} from "./services/itemProduct.service";
import {ReportComponent} from "./report/report.component";
import {IssueComponent} from "./issue/issue.component";
import {PurchseorderComponent} from "./purchseorder/purchseorder.component";
import {ItemComponent} from "./item/item.component";
import {MenubarComponent} from "./menubar.component";
import {GrnComponent} from "./grn/grn.component";
import {ItemtypeComponent} from "./item/itemtype.component";
import {SupplierComponent} from "./supplier/supplier.component";
// import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {IssueFinderComponent} from './issue/issue-finder.component';
import {IssueServiceService} from "./services/issue-service.service";
import { PharmacyComponent } from './pharmacy/pharmacy.component';
import { PaymentComponent } from './grn/payment.component';

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
        PatientadminComponent,
        PrintpopComponent,
        DrugAdminComponent,
        BasedrugadminComponent,
        DrugpackageadminComponent,
        ItemComponent,
        PurchseorderComponent,
        IssueComponent,
        ReportComponent,
        MenubarComponent,
        SupplierComponent,
        ItemtypeComponent,
        GrnComponent,
        IssueFinderComponent,
        PharmacyComponent,
        PaymentComponent,
    ],
    imports: [
        BrowserModule, //BrowserAnimationsModule,
        FormsModule,
        DropdownModule, //NoopAnimationsModule,
        HttpModule, routing//, MdDialogModule//PopupModule.forRoot(),
    ],
    entryComponents: [PrintpopComponent],
    providers: [PatientServiceService, DrugServiceService, AdminService, ItemSupplierService,
        ItemProductService, ItemServiceService, POServiceService, IssueServiceService],
        // MdDialog, OVERLAY_PROVIDERS],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor()
    {
        localStorage.setItem("rootURL","http://localhost:8080/");
    }
}

