package lk.ijse.spring_boot_13.repo;

import lk.ijse.spring_boot_13.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

//    List<Customer> findById(String id);


    /*List<Customer> findByLastName(String lastName);

    //when we want to write queries which are not in build methods,we can use this type
    @Query(value = "select * from Customer", nativeQuery = true)
    List<Customer> getAllCustomers();

     */

}
