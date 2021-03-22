import {Component, OnInit} from '@angular/core';

import {Product} from './product.model';
import {ProductService} from './product.service';

@Component({
    selector: 'app-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.scss'],
    providers: [ProductService]
})
export class ProductsComponent implements OnInit {
    products: Product[] = [];
    constructor(private productService: ProductService) { }

    ngOnInit() {
        this.productService
            .getProducts()
            .subscribe(
                (products) => {
                    this.products = products;
                }
            );
    }
}
