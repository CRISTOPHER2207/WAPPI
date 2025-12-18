import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
// Ahora que arreglaste los archivos de arriba, estos imports funcionarán:
import { ReelService } from '../../services/reel';
import { OutfitStateService } from '../../services/outfit-state';

@Component({
  selector: 'app-reels',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './reels.html',
  styleUrls: ['./reels.scss']
})
export class ReelsComponent implements OnInit {
  reels: any[] = [];

  constructor(
    private reelService: ReelService,
    private outfitStateService: OutfitStateService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reelService.getReels().subscribe({
      // CORRECCIÓN AQUÍ: Agregamos ': any' para quitar la línea roja
      next: (data: any) => {
        this.reels = data;
        console.log('Reels cargados:', this.reels);
      },
      error: (err: any) => { // CORRECCIÓN AQUÍ TAMBIÉN
        console.error('Error cargando reels:', err);
      }
    });
  }

  goToCreator(taggedProducts: any[]) {
    if (taggedProducts && taggedProducts.length > 0) {
        this.outfitStateService.setProductsToTry(taggedProducts);
        this.router.navigate(['/create']);
    } else {
        alert("Este reel no tiene prendas etiquetadas");
    }
  }
}
