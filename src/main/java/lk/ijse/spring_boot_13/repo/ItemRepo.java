package lk.ijse.spring_boot_13.repo;

import lk.ijse.spring_boot_13.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item, Integer> {

    Optional<Item> findByItemCode(Integer itemCode);

    @Modifying
    @Query(value = "update Item set itemQuantity = itemQuantity - :qty where itemCode = :item_code")
    void updateQty(Integer item_code, int qty);
}
