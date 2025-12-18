import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductService } from '../../services/product'; // Asegúrate que este nombre coincida con tu archivo

@Component({
  selector: 'app-marketplace',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './marketplace.html',
  styleUrls: ['./marketplace.scss']
})
export class MarketplaceComponent implements OnInit {

  products: any[] = [];

  // Categorías estáticas para la UI
  categories = ['Todo', 'Vestidos', 'Chaquetas', 'Zapatillas', 'Accesorios'];
  selectedCategory = 'Vestidos'; // La que aparece marcada en turquesa

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe({
      next: (data: any) => {
        this.products = data;
      },
      error: (err: any) => console.error(err)
    });
  }
}
