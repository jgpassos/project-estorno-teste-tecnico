package estornoProject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCreation() {
        User user = new User(1, "Julia Passos");
        assertNotNull(user);
        assertEquals(1, user.getUser_id());
        assertEquals("Julia Passos", user.getName());
        assertNotNull(user.getOrders());
        assertTrue(user.getOrders().isEmpty());
    }

    @Test
    void testGettersAndSetters() {
        User user = new User(1, "Cristina");
        user.setUser_id(2);
        assertEquals(2, user.getUser_id());

        user.setName("Jorge");
        assertEquals("Jorge", user.getName());

        List<Order> orders = new ArrayList<>();
        Order order = new Order(1, "100.50", "2024-06-23");
        orders.add(order);
        user.setOrders(orders);
        assertEquals(orders, user.getOrders());
    }

    @Test
    void addOrder() {
        User user = new User(1, "Priscila");

        Order order1 = new Order(1, "50.00", "2024-03-24");

        user.addOrder(order1);

        List<Order> orders = user.getOrders();
        assertEquals(1, orders.size());
        assertEquals(order1, orders.get(0));
    }
}