import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReelService } from '../../services/reel';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser'; // <--- IMPORTANTE
import { HttpClientModule } from '@angular/common/http';
import { OutfitStateService } from '../../services/outfit-state';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reels',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './reels.html',
  styleUrls: ['./reels.scss']
})
export class ReelsComponent implements OnInit {
  reels: any[] = [];

  constructor(
    private reelService: ReelService,
    private sanitizer: DomSanitizer, // <--- Inyectamos el sanitizador
    private outfitState: OutfitStateService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reelService.getReels().subscribe({
      next: (data: any[]) => {
        console.log('Datos recibidos de Supabase:', data);

        // Procesamos cada reel para "limpiar" la URL
        this.reels = data.map(reel => ({
          ...reel,
          // Esto le dice a Angular: "Confía en esta URL, es segura"
          safeUrl: this.sanitizer.bypassSecurityTrustUrl(reel.videoUrl)
        }));
      },
      error: (err) => console.error('Error cargando reels:', err)
    });
  }

  // Función para ir al probador
  tryOutfit(products: any[]) {
    this.outfitState.setProductsToTry(products);
    this.router.navigate(['/outfit-creator']);
  }
}
