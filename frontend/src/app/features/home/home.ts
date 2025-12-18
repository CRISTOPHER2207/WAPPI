import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html', // Asegúrate que apunte a tu archivo real
  styleUrls: ['./home.scss']
})
export class HomeComponent { // <--- ¡AQUÍ ESTÁ LA CLAVE! El nombre exacto
  // Lógica del home
}
