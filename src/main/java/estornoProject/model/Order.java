package estornoProject.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int order_id;
    private String total;
    private String date;
    private List<Product> products = new ArrayList<>();

    public Order(int order_id, String total, String date) {
        this.order_id = order_id;
        this.total = total;
        this.date = date;
        this.products = new ArrayList<>();
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

