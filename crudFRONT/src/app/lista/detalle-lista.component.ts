import { Component, OnInit } from '@angular/core';
import { ListaService } from '../service/lista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Lista } from '../models/lista';

@Component({
  selector: 'app-detalle-lista',
  templateUrl: './detalle-lista.component.html',
  styleUrls: ['./detalle-lista.component.css']
})
export class DetalleListaComponent implements OnInit {

  lista: Lista = null;

  constructor(
    private listaService: ListaService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.listaService.detail(id).subscribe(
      data => {
        this.lista = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.volver();
      }
    );
  }

  volver(): void {
    this.router.navigate(['/lista']);
  }

}
