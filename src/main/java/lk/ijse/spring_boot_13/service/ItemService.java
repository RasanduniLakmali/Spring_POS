package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    public boolean addItem(ItemDTO itemDTO);

    public List<ItemDTO> getAllItems();

    public boolean update(ItemDTO itemDTO);

    public boolean delete(Integer code);

    public Optional<Item> getItemByCode(Integer itemCode);
}
