import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
// 1. IMPORTAR DomSanitizer y SafeUrl
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
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
    private router: Router,
    private sanitizer: DomSanitizer // 2. INYECTAR EL SANITIZER
  ) {}

  ngOnInit(): void {
    this.reelService.getReels().subscribe({
      next: (data: any[]) => {
        if (data && data.length > 0) {
          // 3. LA CLAVE: Convertimos cada URL normal en una "SafeUrl"
          this.reels = data.map(reel => ({
            ...reel,
            // bypassSecurityTrustUrl le dice a Angular: "Este link es seguro"
            safeUrl: this.sanitizer.bypassSecurityTrustUrl(reel.videoUrl)
          }));
          console.log('✅ Reels seguros:', this.reels);
        } else {
          this.loadMockReels();
        }
      },
      error: (err: any) => {
        console.error('❌ Error, usando backup:', err);
        this.loadMockReels();
      }
    });
  }

  loadMockReels() {
    this.reels = [
      {
        id: 99,
        videoUrl: 'https://cdn.coverr.co/videos/coverr-walking-in-a-fashion-show-2656/1080p.mp4',
        description: 'Modo prueba activado 🚀',
        taggedProducts: []
      }
    ].map(reel => ({
        ...reel,
        // También sanitizamos el mock por si acaso
        safeUrl: this.sanitizer.bypassSecurityTrustUrl(reel.videoUrl)
    }));
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
