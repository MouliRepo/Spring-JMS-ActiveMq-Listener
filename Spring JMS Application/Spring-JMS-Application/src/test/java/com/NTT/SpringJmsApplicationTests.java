package com.NTT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.NTT.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.NTT.message.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJmsApplicationTests {

    @Autowired
    private OrderSender sender;

    @Autowired
    private OrderReceiver receiver;

    @Test
    public void testReceiveSuccess() throws Exception {
        Product product = new Product();
        product.setProductId("S145");
        product.setProductName("Laptop");
        product.setQuantity(1);
        sender.send(product.toString());
        String message = receiver.receiveMessage();
        assertEquals("Y", message);
    }

    @Test
    public void testReceiveFailure() throws Exception {
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Laptop");
        product.setQuantity(1);
        sender.send(product.toString());
        String message = receiver.receiveMessage();
        assertNotEquals("", message);
    }
}
