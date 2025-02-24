package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.entity.Customer;
import lk.ijse.spring_boot_13.repo.CustomerRepo;
import lk.ijse.spring_boot_13.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException();
        }

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
        return true;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> customers = customerRepo.findAll();
//        List<CustomerDTO> customerDTOs = new ArrayList<>();
//        for (Customer customer : customers) {
//            customerDTOs.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
//
//        }
        return modelMapper.map(customerRepo.findAll(),
        new TypeToken<List<CustomerDTO>>() {}.getType());
    }


    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())){
            Customer customer = modelMapper.map(customerDTO, Customer.class);
            customerRepo.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Integer> getAllIds() {
        return customerRepo.findAll().stream()
                .map(Customer::getId) // Extract only customer IDs
                .collect(Collectors.toList());
    }

    @Override
    public String getCustomerNames(Integer customerId) {
        Optional<Customer> cuNames = customerRepo.findById(customerId);
        return cuNames.map(Customer::getName).orElse("Customer Not Found");
    }
}
