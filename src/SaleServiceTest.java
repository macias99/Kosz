import com.basket.Product;
import com.basket.ProductService;
import com.basket.SaleService;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleServiceTest {
    private static final SaleService saleService=new SaleService();
    @Test
    public void percentDiscount1() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.percentDiscount(products,5,300);
        product1.setDiscountPrice(285);
        product2.setDiscountPrice(190);
        product3.setDiscountPrice(95);
        assertArrayEquals(new Product[]{product1,product2,product3},result);
    }
    @Test
    public void percentDiscount2() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",10,10);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.percentDiscount(products,5,300);
        assertArrayEquals(new Product[]{product1,product2,product3},result);
    }

    @Test
    public void thirdFree1() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.thirdFree(products);
        product3.setDiscountPrice(0);
        assertArrayEquals(new Product[]{product3,product2,product1},result);
    }
    @Test
    public void thirdFree2() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);

        Product[] products={product1,product2,};
        Product[] result=saleService.thirdFree(products);
        assertArrayEquals(new Product[]{product2,product1},result);
    }

    @Test
    public void brandCup1() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.brandCup(products);
        assertArrayEquals(new Product[]{product1,product2,product3,result[3]},result);
    }

    @Test
    public void brandCup2() {
        Product product1=new Product("c1","name1",30,30);
        Product product2=new Product("c2","name2",20,20);
        Product product3=new Product("c3","name3",10,10);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.brandCup(products);
        assertArrayEquals(new Product[]{product1,product2,product3},result);
    }

    @Test
    public void voucher() {
        Product product1=new Product("c1","name1",300,300);
        Product product2=new Product("c2","name2",200,200);
        Product product3=new Product("c3","name3",100,100);
        Product[] products={product1,product2,product3};
        Product[] result=saleService.voucher(products,30);
        product1.setDiscountPrice(210);
        product2.setDiscountPrice(140);
        product3.setDiscountPrice(70);
        assertArrayEquals(new Product[]{product1,product2,product3},result);
    }
}