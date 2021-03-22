
export class Product {
    public productId: number | undefined;
    public productName: string | undefined;

    constructor(productName?: string) {
        if(productName !== undefined){
            this.productName = productName;
        }
    }
}