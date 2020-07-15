package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MySpringsecurityPlusApplicationTests {
    @Autowired
    private MenuService menuService;
    @Test
    void contextLoads() {
        List<MenuIndexDto> menu = menuService.getMenu(1);
        System.out.println(menu);
    }

}
