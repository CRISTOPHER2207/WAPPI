import { Routes } from '@angular/router';
import { MarketplaceComponent } from './features/marketplace/marketplace';
import { HomeComponent } from './features/home/home';
import { OutfitCreatorComponent } from './features/outfit-creator/outfit-creator';
import { ProfileComponent } from './features/profile/profile';
// CORRECCIÓN AQUÍ: Apuntamos a './features/reels/reels'
import { ReelsComponent } from './features/reels/reels';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'marketplace', component: MarketplaceComponent },
  { path: 'reels', component: ReelsComponent },
  { path: 'create', component: OutfitCreatorComponent },
  { path: 'profile', component: ProfileComponent },
  { path: '**', redirectTo: 'home' }
];
