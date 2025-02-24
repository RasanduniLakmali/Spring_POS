package lk.ijse.spring_boot_13.repo;

import lk.ijse.spring_boot_13.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}
