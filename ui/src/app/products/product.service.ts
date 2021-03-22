import {Injectable} from '@angular/core';
import {Product} from './product.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {environment} from '../../environments/environment'

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable({
    providedIn: 'root',
})
export class ProductService {
    private productUrl = environment.api.products;

    constructor(private http: HttpClient) {}

    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.productUrl, httpOptions)
                        .pipe(catchError(this.handleError([])));
    }

    getProductById(id: number): Observable<Product> {
        return this.http.get<Product>(this.productUrl + id, httpOptions)
                        .pipe(catchError(this.handleError<Product>()));
    }

    addProduct(product: Product): Observable<Product> {
        return this.http.post<Product>(this.productUrl, JSON.stringify(product), httpOptions)
                        .pipe(catchError(this.handleError<Product>()));
    }

    private handleError<T>(result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            return of(result as T);
        };
    }
}