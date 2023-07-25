package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.MenuService;
import kr.jinseok.eatgo.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @PatchMapping("/restaurant/{restaurantId}/menu")
    public String update(@PathVariable("restaurantId") Long restaurantId, @RequestBody List<Menu> menus){

        menuService.update(restaurantId,menus);
        return "success";
    }
}
