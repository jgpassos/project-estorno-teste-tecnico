package estornoProject.service;

import estornoProject.model.Order;
import estornoProject.model.Product;
import estornoProject.model.User;

import static estornoProject.util.DateFormatter.formatDate;

public class DataNormalizer {
    public static User normalizeData(String line) {
        int user_id = Integer.parseInt(line.substring(0, 10).trim());
        String name = line.substring(10, 55).trim();
        User user = new User(user_id, name);

        int order_id = Integer.parseInt(line.substring(55, 65).trim());

        int product_id = Integer.parseInt(line.substring(65, 75).trim());
        String value = line.substring(75, 87).trim();

        String date = formatDate(line.substring(87, 95).trim());

        Order order = new Order(order_id, "0.00", date);
        order.addProduct(new Product(product_id, value));
        user.addOrder(order);

        return user;
    }
}
