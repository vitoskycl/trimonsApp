import { Component, Input, OnInit, input } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Cliente } from '../../interfaces/cliente';
import { ClienteService } from '../../services/cliente.service';
import { MatPaginatorModule, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'cliente-table',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule],
  templateUrl: './cliente-table.component.html',
  styles: ``
})
export class ClienteTableComponent  implements OnInit{
  public clientesDS: Cliente[] = [];
  length = 50;
  pageSize = 10;
  pageIndex = 0;
  pageSizeOptions = [5, 10, 25];

 pageEvent: PageEvent;

 handlePageEvent(e: PageEvent) {
   this.pageEvent = e;
   this.length = e.length;
   this.pageSize = e.pageSize;
   this.pageIndex = e.pageIndex;

  // console.log(this.pageIndex);
   this.clienteService.getClientes(this.pageIndex, this.pageSize).subscribe(lista => this.clientesDS = lista);
 }

  constructor(private clienteService: ClienteService){

  }

  ngOnInit(): void {
    this.clienteService.getClientes(this.pageIndex, this.pageSize).subscribe(lista => this.clientesDS = lista);
  }

  displayedColumns: string[] = ['id', 'nombre', 'fechaNacimiento', 'direccion', 'telefono'];
  dataSource = this.clientesDS;
}
