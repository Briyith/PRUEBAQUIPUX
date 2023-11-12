import { Component, OnInit } from '@angular/core';
import { ListaService } from '../service/lista.service';
import { Lista } from '../models/lista';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-lista',
  templateUrl: './nuevo-lista.component.html',
  styleUrls: ['./nuevo-lista.component.css']
})
export class NuevoListaComponent implements OnInit {

  nombre = '';
  descripcion: '';

  constructor(
    private listaService: ListaService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  onCreate(): void {
    const lista = new Lista(this.nombre, this.descripcion);
    this.listaService.save(lista).subscribe(
      data => {
        this.toastr.success('Lista Creadoa', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/lista']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        // this.router.navigate(['/']);
      }
    );
  }

}
