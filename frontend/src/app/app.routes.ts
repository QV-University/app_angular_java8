import { RouterModule, Routes } from 'node_modules/@angular/router';
import { EmpleadosComponent } from './components/empleados/empleados.component';

const APP_ROUTES: Routes = [
  { path: 'empleados', component: EmpleadosComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'empleados' }
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
