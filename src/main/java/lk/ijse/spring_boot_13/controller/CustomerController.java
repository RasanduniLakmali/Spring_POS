package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;  //property injection

    @PostMapping("save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean isSaved = customerService.addCustomer(customerDTO);
        if (isSaved) {
            return new ResponseUtil(201,"Customer Saved",null);
        }else{
            return new ResponseUtil(200,"Exist Customer",null);
        }

    }

    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return customers;
    }

    @PutMapping("update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
          boolean isUpdated = customerService.updateCustomer(customerDTO);
          return customerDTO;
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return true;

    }

}

