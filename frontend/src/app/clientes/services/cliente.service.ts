import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { HttpParams } from "@angular/common/http";
import { catchError, Observable, of, map, tap } from 'rxjs';
import { Cliente } from "../interfaces/cliente";

@Injectable({ providedIn: 'root' })
export class ClienteService {
  private apiUrl: string = '/clientes';
  // private apiUrl: string = 'http://localhost:8080/clientes';

  constructor(private http: HttpClient ) {

  }
  getClientes(page:number, size:number): Observable<Cliente[]> {
    const params = new HttpParams()
    .set('page', page)
    .set('size', size);
    return this.http.get<Cliente[]>( this.apiUrl, { params })
      .pipe(
        catchError( () => of([]) ),
      );
  }
  getTotalClientes(): Observable<any>{
    const url = `${ this.apiUrl }/count`;
    return this.http.get(url)
      .pipe(
        catchError( () => of([]) ),
      );
  }

}
