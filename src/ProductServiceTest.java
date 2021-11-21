import com.basket.Product;
import com.basket.ProductService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {
    private static final ProductService productService=new ProductService();

    @Test
    public void findHighestProductPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",10,10);
        Product[] products={product1,product2,product3};
        Product result=productService.findHighestProductPrice(products);
        assertEquals(product1,result);
    }

    @Test
    public void findHighestProductsPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product[] products={product1,product2,product3};
        Product[] result=productService.findHighestProductsPrice(products);
        assertArrayEquals(new Product[]{product3,product1},result);
    }

    @Test
    public void findNHighestProductsPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product1,product2,product3,product4};
        Product[] result=productService.findNHighestProductsPrice(products,2);
        assertArrayEquals(new Product[]{product4,product3,product1},result);
    }

    @Test
    public void findLowestProductPrise() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",10,10);
        Product[] products={product1,product2,product3};
        Product result=productService.findLowestProductPrise(products);
        assertEquals(product3,result);
    }

    @Test
    public void findLowestProductsPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",20,30);
        Product[] products={product1,product2,product3};
        Product[] result=productService.findLowestProductsPrice(products);
        assertArrayEquals(new Product[]{product2,product3},result);
    }

    @Test
    public void findNLowestProductsPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product1,product2,product3,product4};
        Product[] result=productService.findNLowestProductsPrice(products,2);
        assertArrayEquals(new Product[]{product2,product1,product3},result);
    }

    @Test
    public void sumPrice() {
        Product product1=new Product("c1","name1",30.11,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",20,30);
        Product[] products={product1,product2,product3};
        double result=productService.sumPrice(products);
        assertEquals(70.11,result,0);
    }

    @Test
    public void sortByPrice() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product3,product2,product1,product4};
        Product[] result=productService.sortByPrice(products);
        assertArrayEquals(new Product[]{product2,product3,product1,product4},result);

    }

    @Test
    public void sortByPriceAndName() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product4,product3,product1,product2};
        Product[] result=productService.sortByPriceAndName(products);
        assertArrayEquals(new Product[]{product4,product1,product3,product2},result);
    }

    @Test
    public void sortByName() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product4,product3,product1,product2};
        Product[] result=productService.sortByName(products);
        assertArrayEquals(new Product[]{product1,product2,product3,product4},result);
    }

    @Test
    public void add() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",30,30);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product1,product2,product3};
        Product[] result=productService.add(products,product4);
        assertArrayEquals(new Product[]{product1,product2,product3,product4},result);

    }
}