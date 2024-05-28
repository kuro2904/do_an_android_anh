package vn.stu.com.TuiSachAPI.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductDetail> details;

    public Product() {}

    public Product(int id, String name, String description, double price, Category category, List<ProductDetail> details) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetail> details) {
        this.details = details;
    }
}
