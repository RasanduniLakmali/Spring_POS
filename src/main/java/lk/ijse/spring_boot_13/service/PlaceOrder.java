package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.dto.OrderDetailDTO;

public interface PlaceOrder {

    public boolean placeOrder(OrderDTO orderDTO);
}
