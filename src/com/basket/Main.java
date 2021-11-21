package com.basket;

import com.basket.Basket;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",200,200);
        Product product4=new Product("c4","name4",400,400);
        ProductService productService=new ProductService();
        SaleService saleService=new SaleService();
        Product[] products={product1,product3,product2,product4};
       // System.out.println(Arrays.toString(productService.sortByPriceAndName(products)));
        Basket basket=new Basket(products,true);
        Arrays.stream(basket.getProducts()).forEach(System.out::println);
//        Map<Integer,Integer> map=new HashMap<>();
//
//
//        Scanner scanner=new Scanner(System.in);
//        for (int i=0;i<4;i++){
//            Integer a=scanner.nextInt();
//            if (map.containsKey(a)){
//                map.put(a,map.get(a)+1);
//            }else {
//                map.put(a,1);
//            }
//        }

//        System.out.println(map);


//        productService.showProducts(products);
//        System.out.println(productService.sumPrice(products));
//        System.out.println(Arrays.toString(productService.sortByPriceAndName(products)));
//        System.out.println(Arrays.toString(saleService.percentDiscount(products, 10, 300)));
//        System.out.println(Arrays.toString(saleService.thirdFree(products)));
//        System.out.println(Arrays.toString(saleService.brandCup(products)));
//        System.out.println(Arrays.toString(saleService.voucher(products, 30)));

    }
}
