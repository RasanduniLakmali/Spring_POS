package lk.ijse.spring_boot_13.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Item {

    @Id
    private int itemCode;
    private String itemName;
    private double itemPrice;
    private int itemQuantity;

    @OneToMany(mappedBy = "item")
    List<OrderDetails> orderDetailsList;

    public Item() {}

    public Item(int itemCode, String itemName, double itemPrice, int itemQuantity, List<OrderDetails> orderDetailsList) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.orderDetailsList = orderDetailsList;
    }

    public Item(int itemCode, String itemName, double itemPrice, int itemQuantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;

    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
