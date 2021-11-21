package com.basket;

import com.basket.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductService {
    //jedna cena
    public Product findHighestProductPrice(Product[] products){
        double max=products[0].getPrice();
        Product product=products[0];
        for (Product p:products){
            if (p.getPrice()>max){
                max=p.getPrice();
                product=p;
            }
        }
        return product;
    }
    //zwraca tablicę (uzględnia kilka produktów w tej samej cenie)
    public Product[] findHighestProductsPrice(Product[] products){
        products=sortByPrice(products);
        int i=products.length-1;
        Product[] result=new Product[1];
        result[0]=products[i];
        i--;
        while (products[i].getPrice()==products[products.length-1].getPrice()){
            result=add(result,products[i]);
            i--;
        }
        return result;
    }
    //zwraca n porudktów o najwyżjszej cenie (uwzględia kilka porduktów w tej samej cenie)
    public Product[] findNHighestProductsPrice(Product[] products,int n){
        products=sortByPrice(products);
        int i=products.length-1;
        Product[] result=new Product[0];
        for (int j=0;j<n;j++){
            result=add(result,products[i-j]);
        }
        i -= n;
        while (products[i].getPrice() == products[products.length - n].getPrice()){
            result=add(result,products[i]);
            i--;
        }
        return result;
    }
    public Product findLowestProductPrise(Product[] products){
        double min=products[0].getPrice();
        Product product=products[0];
        for (Product p:products){
            if (p.getPrice()<min){
                min=p.getPrice();
                product=p;
            }
        }
        return product;
    }
    public Product[] findLowestProductsPrice(Product[] products){
        products=sortByPrice(products);
        int n=0;
        Product[] result=new Product[1];
        result[0]=products[n];
        n++;
        while (products[n].getPrice()==products[0].getPrice()){
            result=add(result,products[n]);
            n++;
        }
        return result;
    }
    public Product[] findNLowestProductsPrice(Product[] products,int n){
        products=sortByPrice(products);
        int i=0;
        Product[] result=new Product[0];
        for (int j=0;j<n;j++){
            result=add(result,products[i+j]);
        }
        i += n;
        while (products[i].getPrice() == products[n-1].getPrice()){
            result=add(result,products[i]);
            i++;
        }
        return result;
    }
    public double sumPrice(Product[] products){
        double sum=0;
        for (Product p:products){
            sum+=p.getPrice();
        }
        return sum;
    }

    public void showProducts(Product[] products){
        for (Product p:products){
            System.out.println(p);
        }

    }


    public Product[] sortByPrice(Product[] products){
        products= Arrays.stream(products).sorted(Comparator.comparing(Product::getPrice)).toArray(Product[]::new);
        return products;
    }

    public Product[] sortByPriceAndName(Product[] products){

        Comparator<Product> comparator=(p1,p2)->{
            if (p1.getPrice()==p2.getPrice()){
                return p1.getName().compareTo(p2.getName());
            }else {
                Double p1price=p1.getPrice();
                Double p2price=p2.getPrice();
                return p2price.compareTo(p1price);
            }
        };
        products=Arrays.stream(products).sorted(comparator).toArray(Product[]::new);

        return products;
    }

    public Product[] sortByName(Product[] products){
        products= Arrays.stream(products).sorted(Comparator.comparing(Product::getName)).toArray(Product[]::new);
        return products;
    }

    public Product[] add(Product[] products,Product product){
        Product[] result=new Product[products.length+1];
        System.arraycopy(products, 0, result, 0, products.length);
        result[result.length-1]=product;
        return result;
    }
}
