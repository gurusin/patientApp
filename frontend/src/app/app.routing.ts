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
import {PaymentComponent} from "./grn/payment.component";
import {MedicalServiceComponentComponent} from "./item/medical-service-component/medical-service-component.component";
import {ReturnoutComponent} from "./purchseorder/returnout.component";
import {DailyIncomeComponent} from "./report/daily-income.component";
import {POListComponent} from "./purchaseorder/polist.component";
import {InOutComponent} from "./item/in-out.component";
import {LoginComponentComponent} from "./login-component/login-component.component";
import {HomeComponent} from "./home/home.component";
import {StockAdjustmentComponent} from "./drugcomponent/admin/stock-adjustment/stock-adjustment.component";

const APP_ROUTES: Routes = [
  {path: '', component: LoginComponentComponent},
  {path: 'serviceIssue', component: IssueComponent},
  {path: 'adjustStock', component: StockAdjustmentComponent},
  {path: 'start', component: PatientSearchComponent},
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
  {path: 'po', component: POListComponent},
  {path: 'poDetail', component: PurchseorderComponent},
  {path: 'item', component: ItemComponent},
  {path: 'issue', component: IssueComponent},
  {path: 'report', component: ReportComponent},
  {path: 'supplier', component: SupplierComponent},
  {path: 'itemtype', component: ItemtypeComponent},
  {path: 'grn', component: GrnComponent},
  {path: 'po', component: PurchseorderComponent},
  {path: 'findIssue', component: IssueFinderComponent},
  {path: 'printPo', component: PrintreceiptComponent},
  {path: 'pharmacyList', component: PharmacyComponent},
  {path: 'payment', component: PaymentComponent},
  {path: 'medServiceItem', component: MedicalServiceComponentComponent},
  {path: 'returnout', component: ReturnoutComponent},
  {path: 'dailyIncome', component: DailyIncomeComponent},
  {path: 'inOut', component: InOutComponent}
]

export const routing = RouterModule.forRoot(APP_ROUTES)
