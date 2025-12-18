import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OutfitStateService { // <--- ¡ASEGÚRATE DE QUE TENGA 'export'!

  // Estado inicial vacío
  private selectedProductsSource = new BehaviorSubject<any[]>([]);
  selectedProducts$ = this.selectedProductsSource.asObservable();

  constructor() {}

  setProductsToTry(products: any[]) {
    this.selectedProductsSource.next(products);
  }

  clearProducts() {
    this.selectedProductsSource.next([]);
  }
}
