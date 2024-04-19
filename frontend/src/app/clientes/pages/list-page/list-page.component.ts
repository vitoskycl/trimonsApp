import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../services/cliente.service';
import { Cliente } from '../../interfaces/cliente';
import { ClienteTableComponent } from '../../components/cliente-table/cliente-table.component';
import { MatTableModule } from '@angular/material/table';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { MatPaginatorModule } from '@angular/material/paginator';

@Component({
  standalone:true,
  selector: 'clientes-list-page',
  imports:[CommonModule, ClienteTableComponent],
  templateUrl: './list-page.component.html',
  styles: ``
})
export class ListPageComponent implements OnInit{

  public clientes: Cliente[] = [];

  constructor(private clienteService: ClienteService){

  }

  ngOnInit(): void {
    this.clienteService.getClientes(6, 5).subscribe(lista => this.clientes = lista);
  }
  // public displayedColumns: string[] = ['id', 'nombre', 'fechaNacimiento', 'direccion', 'telefono'];
  // public dataSource = this.clientes;
}
