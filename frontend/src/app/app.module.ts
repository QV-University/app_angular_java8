import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { EmpleadosService } from './servicios/empleados.service';
import { HttpClientModule } from '@angular/common/http';

import { APP_ROUTING } from './app.routes';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    APP_ROUTING
  ],
  providers: [
    EmpleadosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
