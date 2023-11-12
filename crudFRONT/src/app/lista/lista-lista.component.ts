import { Component, OnInit } from '@angular/core';
import { Lista } from '../models/lista';
import { ListaService } from '../service/lista.service';
import { ToastrService } from 'ngx-toastr';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-lista-lista',
  templateUrl: './lista-lista.component.html',
  styleUrls: ['./lista-lista.component.css']
})
export class ListaListaComponent implements OnInit {

  listas: Lista[] = [];
  roles: string[];
  isAdmin = false;

  constructor(
    private listaService: ListaService,
    private toastr: ToastrService,
    private tokenService: TokenService
  ) { }

  ngOnInit() {
    this.cargarListas();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(rol => {
      if (rol === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
  }

  cargarListas(): void {
    this.listaService.lista().subscribe(
      data => {
        this.listas = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(id: number) {
    this.listaService.delete(id).subscribe(
      data => {
        this.toastr.success('Lista Eliminada', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.cargarListas();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000, positionClass: 'toast-top-center',
        });
      }
    );
  }

}
