package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.entity.Customer;

import java.util.List;

public interface CustomerService {

    public boolean addCustomer(CustomerDTO customerDTO);

    public List<CustomerDTO> getAllCustomers();

    public boolean updateCustomer(CustomerDTO customerDTO);

    public boolean deleteCustomer(Integer id);

    public List<Integer> getAllIds();

    public String getCustomerNames(Integer customerId);
}
