package com.basket;

import com.basket.Product;
import com.basket.ProductService;

public class SaleService {

    private static final ProductService productService=new ProductService();

    public Product[] percentDiscount(Product[] products,double discount,double price){

        if (productService.sumPrice(products)>price){
            for (Product p : products) {
                double newPrice=p.getDiscountPrice() - p.getPrice() * (discount / 100);
                if (newPrice>0){
                    p.setDiscountPrice(newPrice);
                }
                else{
                    p.setDiscountPrice(0);
                }

            }
            return products;
        }
        return products;
    }
    public Product[] thirdFree(Product[] products){
        int count=products.length/3;
        products=productService.sortByPrice(products);
        for (int i=0;i<count;i++){
            products[i].setDiscountPrice(0);
        }


        return products;
    }
    public Product[] brandCup(Product[] products){
        if (productService.sumPrice(products)>200){
            products=productService.add(products,new Product("c9","brand cup",0,0));
        }
        return products;
    }
    public Product[] voucher(Product[] products, double discount){
        for (Product p : products) {
            double newPrice=p.getDiscountPrice() - p.getPrice() * (discount / 100);
            if (newPrice>0){
                p.setDiscountPrice(newPrice);
            }
            else{
                p.setDiscountPrice(0);
            }

        }
        return products;
    }

}
