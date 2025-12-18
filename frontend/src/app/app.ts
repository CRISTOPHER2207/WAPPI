import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router'; // Importamos todo lo necesario para navegar
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  // AQUÍ ESTÁ LA CLAVE: Importamos RouterOutlet y RouterLink
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class AppComponent {
  title = 'wappi-frontend';
}
