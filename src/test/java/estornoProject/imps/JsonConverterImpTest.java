package estornoProject.imps;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import estornoProject.interfaces.JsonConverter;
import estornoProject.model.Order;
import estornoProject.model.Product;
import estornoProject.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterImpTest {
    private List<User> users;
    private JsonConverter converter;
    private Gson gson;

    @Test
    void jsonConverter() {
        List<User> users = usersData();

        JsonConverter converter = new JsonConverterImp();
        gson = new Gson();

        String json = converter.jsonConverter(users);
        assertNotNull("Json result should not be null", json);

        String expectedJson = "[{\"user_id\":1,\"name\":\"Julia Passos\",\"orders\":[{\"order_id\":101,\"total\":" + "\"0\",\"date\":" +
                "\"2021-06-20\",\"products\":[{\"product_id\":1,\"value\":\"5.50\"}]}]}," +
                "{\"user_id\":2,\"name\":\"Christian\",\"orders\":[{\"order_id\":55,\"total\":\"0\",\"date\":" +
                "\"2000-03-24\",\"products\":[{\"product_id\":2,\"value\":\"100.50\"}]}]}," +
                "{\"user_id\":3,\"name\":\"Jhon Silva\",\"orders\":[{\"order_id\":200,\"total\":\"0\",\"date\":" +
                "\"2004-12-01\",\"products\":[{\"product_id\":2,\"value\":\"67.90\"}]}]}]";

        JsonElement expectedJsonElement = JsonParser.parseString(expectedJson);
        JsonElement actualJsonElement = JsonParser.parseString(json);

        assertEquals(expectedJsonElement, actualJsonElement);
    }

    private List<User> usersData() {
        List<User> users = new ArrayList<>();

        users.add(createUser(1, "Julia Passos", 101, "2021-06-20", 1, "5.50"));
        users.add(createUser(2, "Christian", 55, "2000-03-24", 2, "100.50"));
        users.add(createUser(3, "Jhon Silva", 200, "2004-12-01", 2, "67.90"));

        return users;
    }

    private User createUser(int user_id, String name, int order_id, String date, int product_id, String value) {
        User user = new User(user_id, name);
        Order order = new Order(order_id, "0", date);
        Product product = new Product(product_id, value);

        order.addProduct(product);
        user.addOrder(order);

        return user;
    }
}