package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.dao.MenuDao;
import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MySpringsecurityPlusApplicationTests {
    @Autowired
    private MenuDao menuDao;
    @Test
    void contextLoads() {
        List<MenuIndexDto> list = menuDao.listByUserId(1);
        List<String> collect = list.stream().map(MenuIndexDto::getPermission).collect(Collectors.toList());
        for (String  authority: collect){
            if (!("").equals(authority) & authority !=null){
                System.out.println(authority + "1");
            }
        }
    }

}
