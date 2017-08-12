import {PatientComponentComponent} from "./patient-component/patient-component.component";
import {provideRoutes, RouterModule, Routes} from "@angular/router";
import {PatientsaveComponent} from "./patientsave/patientsave.component";
import {NavbarComponent} from "./navbar.component";
import {AppComponent} from "app/app.component";
import {TreatmentComponent} from "./treatment/treatment.component";
import {PatientVisitComponent} from "./treatment/patient-visit.component";
import {PatientSearchComponent} from "./patient-component/patient-search.component";

const APP_ROUTES: Routes = [
  {path:'',component:PatientSearchComponent},
  {path:'patient-component', component: PatientComponentComponent },
  {path: 'patientsave', component: PatientsaveComponent },
  {path: 'treatment', component: TreatmentComponent},
  {path: 'patientvisit', component: PatientVisitComponent}
]

export const routing = RouterModule.forRoot(APP_ROUTES)
