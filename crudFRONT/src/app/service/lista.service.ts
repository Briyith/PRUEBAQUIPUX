import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lista } from '../models/lista';

@Injectable({
  providedIn: 'root'
})
export class ListaService {

  listaURL = 'http://localhost:8080/lista/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Lista[]> {
    return this.httpClient.get<Lista[]>(this.listaURL + 'lists');
  }

  public detail(id: number): Observable<Lista> {
    return this.httpClient.get<Lista>(this.listaURL + `lists/${id}`);
  }

  public save(lista: Lista): Observable<any> {
    return this.httpClient.post<any>(this.listaURL + 'lists', lista);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.listaURL + `delete/${id}`);
  }
}
