import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';

import {Product} from './product.model';
import {ProductService} from './product.service';

@Component({
    selector: 'app-add-product',
    templateUrl: './addProduct.component.html',
    styleUrls: ['./addProduct.component.scss'],
    providers: [ProductService]
})
export class AddProductComponent implements OnInit {
    form!: FormGroup;
    product!: Observable<Product>;
    submitted = false;

    constructor(private formBuilder: FormBuilder,
                private productService: ProductService) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            productName: ['', Validators.required],
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    addProduct(product: Product) {
        this.productService
            .addProduct(product)
            .subscribe();
        window.location.reload();
    }

    onSubmit() {
        if(this.form.valid){
            this.addProduct(new Product(this.form.controls['productName'].value));
        }
        this.submitted = true;
    }

}
