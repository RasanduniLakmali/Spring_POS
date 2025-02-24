package lk.ijse.spring_boot_13.dto;

import lk.ijse.spring_boot_13.entity.Customer;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private int customerId;

    private List<OrderDetailDTO> orderDetails;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, Date orderDate, double orderTotal, int customerId, List<OrderDetailDTO> orderDetailDTOS) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
        this.orderDetails = orderDetailDTOS;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
