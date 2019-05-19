import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Rx';
import { baseURL } from '../common/baseurl';

@Injectable()
export class EmpleadosService {

  private url = baseURL;

  constructor(public http: HttpClient) {
    console.log("Servicio listo para usar");
  }

  getEmpleados() {
    return this.http.get(this.url);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}

export interface Empleado {
  id: string;
  nombres: string;
  apellidos: string;
  telefono: string;
  direccion: string;
  edad: number;
}
