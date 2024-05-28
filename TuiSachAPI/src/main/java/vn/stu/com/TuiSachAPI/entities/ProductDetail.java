package vn.stu.com.TuiSachAPI.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_product_detail")
public class ProductDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String size;
    private String color;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductDetail() {}

    public ProductDetail(int id, String size, String color, int quantity, Product product) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
