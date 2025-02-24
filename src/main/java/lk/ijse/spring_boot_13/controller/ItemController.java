package lk.ijse.spring_boot_13.controller;


import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/item")
public class ItemController {


    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping("save")
    public ItemDTO saveItem(@RequestBody ItemDTO itemDTO){
        boolean isSaved = itemService.addItem(itemDTO);
        return itemDTO;
    }

    @GetMapping("getAll")
    public List<ItemDTO> getAllItem(){
        List<ItemDTO> itemList = itemService.getAllItems();
        return itemList;
    }

    @PutMapping("update")
    public ItemDTO updateItem(@RequestBody ItemDTO itemDTO){
        boolean isUpdated = itemService.update(itemDTO);
        return itemDTO;
    }

    @DeleteMapping("delete/{code}")
    public boolean deleteItem(@PathVariable Integer code){
        boolean res = itemService.delete(code);
        return res;
    }

}
