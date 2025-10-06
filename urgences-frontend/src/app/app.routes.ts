import { Routes } from '@angular/router';
import {RadiologyComponent} from './components/radiology/radiology.component';
import {LaboComponent} from './components/labo/labo.component';
import {ConsultationComponent} from './components/consultation/consultation.component';
import {LandingPageComponent} from './components/landing-page/landing-page.component';

export const routes: Routes = [
  { path: 'radiology', component: RadiologyComponent },
  { path: 'labo', component: LaboComponent },
  { path: 'consultation', component: ConsultationComponent },
  { path: '', component: LandingPageComponent },
];
