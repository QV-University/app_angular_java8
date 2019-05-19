import { Component, OnInit } from '@angular/core';
import { Empleado, EmpleadosService } from '../../servicios/empleados.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recordings',
  templateUrl: './empleados.component.html',
})
export class EmpleadosComponent implements OnInit {

  empleados: Empleado[];
  public empleado_id: string;

  constructor(private _empleadosService: EmpleadosService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.empleado_id = params.get('empleado');
    });
  }

  ngOnInit() {
    this._empleadosService.getEmpleados().subscribe(
      (data: any) => {
        let empleados = [];
        let lista = data;
        if (lista === undefined) {
          console.log("Error")
        } else {
          for (let registro of lista) {
            let nuevo = {
              id: registro.id,
              nombres: registro.nombres,
              apellidos: registro.apellidos,
              telefono: registro.telefono,
              direccion: registro.direccion,
              edad: registro.edad,
            }
            empleados.push(nuevo);
          }
        }
        this.empleados = empleados;
      },
      err => {
        console.log(err);
      }
    )
    
  }

}
