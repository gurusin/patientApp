import {provideRoutes, RouterModule, Routes} from "@angular/router";
import {PatientsaveComponent} from "./patientsave/patientsave.component";
import {NavbarComponent} from "./navbar.component";
import {AppComponent} from "app/app.component";
import {TreatmentComponent} from "./treatment/treatment.component";
import {PatientVisitComponent} from "./treatment/patient-visit.component";
import {PatientSearchComponent} from "./patient-component/patient-search.component";
import {BasicvisitComponent} from "./treatment/basicvisit.component";
import {PrescriptionHistoryComponent} from "./prescription-component/prescription-history.component";
import {PrintreceiptComponent} from "./prescription-component/printreceipt.component";
import {PatientadminComponent} from "./patient-component/patientadmin.component";
import {PrintpopComponent} from "./treatment/printpop.component";
import {DrugAdminComponent} from "./drugcomponent/drug-admin/drug-admin.component";
import {BasedrugadminComponent} from "./drugcomponent/drug-admin/basedrugadmin.component";
import {DrugpackageadminComponent} from "./drugcomponent/drug-admin/drugpackageadmin.component";
import {PurchseorderComponent} from "./purchseorder/purchseorder.component";
import {ItemComponent} from "./item/item.component";
import {ReportComponent} from "./report/report.component";
import {IssueComponent} from "./issue/issue.component";
import {SupplierComponent} from "./supplier/supplier.component";
import {ItemtypeComponent} from "./item/itemtype.component";
import {GrnComponent} from "./grn/grn.component";
import {IssueFinderComponent} from "./issue/issue-finder.component";
import {PharmacyComponent} from "./pharmacy/pharmacy.component";

const APP_ROUTES: Routes = [
    {path: '', component: PatientSearchComponent},
    {path: 'patientsave', component: PatientsaveComponent},
    {path: 'treatment', component: TreatmentComponent},
    {
        path: 'patientvisit', component: PatientVisitComponent, children: [
        {path: 'treatment', component: BasicvisitComponent},
        {path: 'treatmentHistory', component: PrescriptionHistoryComponent}
    ]
    },
    {path: 'printReceipt', component: PrintreceiptComponent},
    {path: 'patientAdmin', component: PatientadminComponent},
    {path: 'printpop', component: PrintpopComponent},
    {path: 'drugAdmin', component: DrugAdminComponent},
    {path: 'baseDrugAdmin', component: BasedrugadminComponent},
    {path: 'drugPackageAdmin', component: DrugpackageadminComponent},
    {path: 'po', component: PurchseorderComponent},
    {path: 'item', component: ItemComponent},
    {path: 'issue', component: IssueComponent},
    {path: 'report', component: ReportComponent},
    {path: 'supplier', component: SupplierComponent},
    {path: 'itemtype', component: ItemtypeComponent},
    {path: 'grn', component: GrnComponent},
    {path: 'po', component: PurchseorderComponent},
    {path: 'findIssue', component: IssueFinderComponent},
    {path: 'printPo',component:PrintreceiptComponent},
    {path: 'pharmacyList', component:PharmacyComponent}
  // {path: 'medServiceItem', component: MedicalSer}
]

export const routing = RouterModule.forRoot(APP_ROUTES)
