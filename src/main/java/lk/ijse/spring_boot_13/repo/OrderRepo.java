package lk.ijse.spring_boot_13.repo;

import jakarta.persistence.criteria.Order;
import lk.ijse.spring_boot_13.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
