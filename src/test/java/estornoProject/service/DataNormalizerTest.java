package estornoProject.service;

import estornoProject.model.Order;
import estornoProject.model.Product;
import estornoProject.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataNormalizerTest {

    @Test
    void normalizeData() {
        assertUserData("0000000058                                  Dewey Crona00000005660000000003     1516.2320210820",
                58, "Dewey Crona", 566, 3, "1516.23", "2021-08-20");
        assertUserData("0000000087                                Tesha Quigley00000008230000000000      881.0620210819",
                87, "Tesha Quigley", 823, 0, "881.06", "2021-08-19");
        assertUserData("0000000056                              Jonathon Marvin00000006150000000002      306.3520211206",
                56, "Jonathon Marvin", 615, 2, "306.35", "2021-12-06");
        assertUserData("0000000065                                  Burma Crona00000006930000000004     1762.6820211105",
                65, "Burma Crona", 693, 4, "1762.68", "2021-11-05");
        assertUserData("0000000063                             Dr. Carlee Welch00000006750000000003      1693.220210423",
                63, "Dr. Carlee Welch", 675, 3, "1693.2", "2021-04-23");

    }

    private void assertUserData(String inputLine, int expectUserId, String expectedName, int expectedOrderId,
                                int expectedProdId, String value, String expectedeDate) {
        User user = DataNormalizer.normalizeData(inputLine);

        assertNotNull(user, "User should not be null");

        assertEquals(expectUserId, user.getUser_id());
        assertEquals(expectedName, user.getName());

        List<Order> orders = user.getOrders();
        assertNotNull(orders, "Orders should not be null");
        Order order = orders.get(0);
        assertEquals(expectedOrderId, order.getOrder_id());

        List<Product> products = order.getProduct();
        assertNotNull(products, "Products should not be null");
        assertFalse(products.isEmpty(), "Products should not be empty");

        Product product = products.get(0);
        assertEquals(expectedProdId, product.getProduct_id());
        assertEquals(value, product.getValue());

        assertEquals(expectedeDate, order.getDate());
    }
}