import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { ListPageComponent } from './clientes/pages/list-page/list-page.component';
import { ClienteTableComponent } from './clientes/components/cliente-table/cliente-table.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListPageComponent, ClienteTableComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'TRIMONS FRONTEND';
}
