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

const APP_ROUTES: Routes = [
  {path:'',component:PatientSearchComponent},
  {path: 'patientsave', component: PatientsaveComponent },
  {path: 'treatment', component: TreatmentComponent},
  {path: 'patientvisit', component: PatientVisitComponent, children:[
    {path:'treatment', component:BasicvisitComponent},
    {path:'treatmentHistory',component:PrescriptionHistoryComponent}
  ]},
  {path:'printReceipt',component:PrintreceiptComponent}
]

export const routing = RouterModule.forRoot(APP_ROUTES)
