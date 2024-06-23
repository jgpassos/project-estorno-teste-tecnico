package estornoProject.model;

public class Product {
    private int product_id;
    private String value;

    public Product(int product_id, String value) {
        this.product_id = product_id;
        this.value = value;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
