package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.dto.MenuDto;
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
        List<MenuDto> menuAll =menuService.buildMenuAll();
        MenuDto menuDto = new MenuDto();
        menuDto.setId(0);
        menuDto.setTitle("顶级目录");
        menuAll.add(menuDto);
        System.out.println(menuAll);
    }

}
