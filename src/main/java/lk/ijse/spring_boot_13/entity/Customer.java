package lk.ijse.spring_boot_13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Orders> ordersList;

    public Customer() {

    }

    public Customer(int id, String name, String address, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.ordersList = ordersList;
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
