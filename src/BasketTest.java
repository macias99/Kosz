import com.basket.Basket;
import com.basket.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void basket1() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product product4=new Product("c4","name4",400,400);
        Product[] products={product1,product2,product3,product4};
        Basket basket=new Basket(products,true);
        product1.setDiscountPrice(195.0);
        product2.setDiscountPrice(130);
        product3.setDiscountPrice(0);
        product4.setDiscountPrice(260);
        Product product5=basket.getProducts()[4];
        assertArrayEquals(new Product[]{product4,product1,product2,product3,product5},basket.getProducts());
    }
    @Test
    public void basket2() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product product4=new Product("c4","name4",400,400);
        Product[] products={product1,product2,product3,product4};
        Basket basket=new Basket(products,false);
        product1.setDiscountPrice(285);
        product2.setDiscountPrice(190);
        product3.setDiscountPrice(0);
        product4.setDiscountPrice(380);
        Product product5=basket.getProducts()[4];
        assertArrayEquals(new Product[]{product4,product1,product2,product3,product5},basket.getProducts());
    }
    @Test
    public void basket3() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",10,10);
        Product product4=new Product("c4","name4",40,40);
        Product[] products={product1,product2,product3,product4};
        Basket basket=new Basket(products,true);
        product1.setDiscountPrice(21);
        product2.setDiscountPrice(14);
        product3.setDiscountPrice(0);
        product4.setDiscountPrice(28);
        assertArrayEquals(new Product[]{product4,product1,product2,product3},basket.getProducts());
    }
    @Test
    public void basket4() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product[] products={product1,product2};
        Basket basket=new Basket(products,false);
        assertArrayEquals(new Product[]{product1,product2},basket.getProducts());
    }

}