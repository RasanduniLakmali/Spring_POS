package lk.ijse.spring_boot_13.service.impl;


import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.repo.ItemRepo;
import lk.ijse.spring_boot_13.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemCode())) {
            return false;
        }

        Item item = modelMapper.map(itemDTO,Item.class);
        itemRepo.save(item);
        return true;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for (Item item : items) {
            itemDTOs.add(new ItemDTO(item.getItemCode(),item.getItemName(),item.getItemPrice(),item.getItemQuantity()));
        }
        return itemDTOs;
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemCode())) {
            Item item = modelMapper.map(itemDTO,Item.class);
            itemRepo.save(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer code) {
        if (itemRepo.existsById(code)) {
            itemRepo.deleteById(code);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Item> getItemByCode(Integer itemCode)  {
        return itemRepo.findByItemCode(itemCode);
    }

    public List<Integer> getAllIds() {

        return itemRepo.findAll().stream()
                .map(Item::getItemCode) // Extract only customer IDs
                .collect(Collectors.toList());
    }
}
