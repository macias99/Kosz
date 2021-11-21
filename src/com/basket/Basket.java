package com.basket;

public class Basket {
    private Product[] products;

    private static final SaleService saleService=new SaleService();
    private static final ProductService productService=new ProductService();

    public Basket(Product[] products,boolean voucher) {
        if (voucher){
            products=saleService.voucher(products,30);
        }
        products=saleService.percentDiscount(products,5,300);
        products=saleService.thirdFree(products);
        products=saleService.brandCup(products);
        products=productService.sortByPriceAndName(products);

        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
