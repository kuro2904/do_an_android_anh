package vn.stu.com.TuiSachAPI.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phone;
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;
    private double total;

    public Order() {}

    public Order(int id, LocalDateTime orderDate, User user, List<OrderDetail> details, double total) {
        this.id = id;
        this.orderDate = orderDate;
        this.user = user;
        this.details = details;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
