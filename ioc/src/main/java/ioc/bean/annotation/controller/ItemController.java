package ioc.bean.annotation.controller;

import ioc.bean.annotation.MyFirstAutoWired;
import ioc.bean.annotation.MySecondAutoWired;
import ioc.bean.annotation.service.ItemService;
import ioc.bean.annotation.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    @MyFirstAutoWired
    private ItemService itemService;

    @MySecondAutoWired
    private UserService userService;

    public ItemService getItemService() {
        return itemService;
    }

//    public void setItemService(ItemService itemService) {
//        this.itemService = itemService;
//    }
}
