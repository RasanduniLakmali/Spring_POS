package lk.ijse.spring_boot_13.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.dto.OrderDetailDTO;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.entity.OrderDetails;
import lk.ijse.spring_boot_13.entity.Orders;
import lk.ijse.spring_boot_13.repo.ItemRepo;
import lk.ijse.spring_boot_13.repo.OrderDetailRepo;
import lk.ijse.spring_boot_13.repo.OrderRepo;
import lk.ijse.spring_boot_13.service.PlaceOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceOrderImpl implements PlaceOrder {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public boolean placeOrder(OrderDTO orderDTO) {

        try {
            Orders orders = modelMapper.map(orderDTO, Orders.class);
            orders.setOrderId(orderDTO.getOrderId());
            Orders orders1 = orderRepo.save(orders);

            List<OrderDetailDTO> orderDetailDTOS = orderDTO.getOrderDetails();
            for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {

                Item item = itemRepo.findById(orderDetailDTO.getItemCode())
                        .orElseThrow(() -> new RuntimeException("Item not found: " + orderDetailDTO.getItemCode()));

                OrderDetails orderDetails = modelMapper.map(orderDetailDTO, OrderDetails.class);
                orderDetails.setItem(item);
                orderDetails.setOrders(orders1);
                orderDetailRepo.save(orderDetails);

                itemRepo.updateQty(item.getItemCode(), orderDetailDTO.getQty());

            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in placing order: " + orderDTO.getOrderId(), e);
        }
    }


}
