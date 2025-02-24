package lk.ijse.spring_boot_13.controller;


import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.dto.OrderDetailDTO;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import lk.ijse.spring_boot_13.service.impl.ItemServiceImpl;
import lk.ijse.spring_boot_13.service.impl.PlaceOrderImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ItemServiceImpl itemService;

    @Autowired
    private PlaceOrderImpl placeOrder;

    @GetMapping("getCuId")
    public List<Integer> getCustomerIds() {  // Changed return type to List<Integer>
        return customerService.getAllIds();
    }

    @GetMapping("getCode")
    public List<Integer> getItemCodes(){
        return itemService.getAllIds();
    }

    @GetMapping("getCuName/{id}")
    public String getCusName(@PathVariable Integer id){
        String customerNames = customerService.getCustomerNames(id);
        return customerNames;
    }

    @GetMapping("getItDetails/{itemCode}")
    public Optional<Item> getItemDetails(@PathVariable Integer itemCode) {
        Optional<Item> item = itemService.getItemByCode(itemCode);
        return item;
    }

    @PostMapping("saveOrder")
    public ResponseUtil saveOrder(@RequestBody OrderDTO orderDTO) {
        System.out.println("Order id : " + orderDTO.getOrderId());
        boolean isPlaced = placeOrder.placeOrder(orderDTO);

        if (isPlaced){
            return new ResponseUtil(201,"Order placed successfully.",null);
        }
        else {
            return new ResponseUtil(200,"Order not placed successfully.",null);
        }

    }
}
