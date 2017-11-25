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
import { MedicalServiceComponentComponent } from './item/medical-service-component/medical-service-component.component';
import { SelectedRowDirective } from './selected-row.directive';
import { ServiceComponentComponent } from './treatment/service-component.component';
import {ReturnoutComponent} from "./purchseorder/returnout.component";
import { DailyIncomeComponent } from './report/daily-income.component';
import { POListComponent } from './purchaseorder/polist.component';
import { InOutComponent } from './item/in-out.component';
import { FilterPipePipe } from './filter/filter-pipe.pipe';
import {LoginComponentComponent} from "./login-component/login-component.component";
import {LoginService} from "./services/login-service.service";
import { HomeComponent } from './home/home.component';
import { StockAdjustmentComponent } from './drugcomponent/admin/stock-adjustment/stock-adjustment.component';
import { StrengthComponent } from './drugcomponent/admin/strengh/strength.component';
import { DrugPackagePipe } from './filter/drug-package.pipe';
import { DrugPipePipe } from './filter/drug-pipe.pipe';
import { PatientPipe } from './filter/patient.pipe';
import {DateValueAccessorModule} from "angular-date-value-accessor/src/module";
import { PatientAdminFilterPipe } from './filter/patient-admin-filter.pipe';
import { IssueHistoryComponent } from './issue/issue-history.component';
import { BillReprintComponent } from './issue/bill-reprint.component';

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
        MedicalServiceComponentComponent,
        SelectedRowDirective,
        ServiceComponentComponent,
        ReturnoutComponent,
        DailyIncomeComponent,
        POListComponent,
        InOutComponent,
        FilterPipePipe,
        LoginComponentComponent,
        HomeComponent,
        StockAdjustmentComponent,
        StrengthComponent,
        DrugPackagePipe,
        DrugPipePipe,
        PatientPipe,
        PatientAdminFilterPipe,
        IssueHistoryComponent,
        BillReprintComponent,
    ],
    imports: [
        BrowserModule, //BrowserAnimationsModule,
        FormsModule,
        DropdownModule, //NoopAnimationsModule,
        HttpModule, routing, //, MdDialogModule//PopupModule.forRoot(),
        DateValueAccessorModule
    ],
    entryComponents: [PrintpopComponent],
    providers: [PatientServiceService, DrugServiceService, AdminService, ItemSupplierService,
        ItemProductService, ItemServiceService, POServiceService, IssueServiceService,LoginService],
        // MdDialog, OVERLAY_PROVIDERS],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor()
    {
        //localStorage.setItem("rootURL","http://localhost:8080/");
    }
}

