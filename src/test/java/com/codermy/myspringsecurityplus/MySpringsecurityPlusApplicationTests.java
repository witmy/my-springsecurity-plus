package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.dao.MenuDao;
import com.codermy.myspringsecurityplus.dto.MenuDto;
import com.codermy.myspringsecurityplus.dto.MenuIndexDto;
import com.codermy.myspringsecurityplus.service.MenuService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MySpringsecurityPlusApplicationTests {
    @Test
    void contextLoads() {

    }

}
