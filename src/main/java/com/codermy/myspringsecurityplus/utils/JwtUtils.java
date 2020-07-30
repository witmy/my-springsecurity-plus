package com.codermy.myspringsecurityplus.utils;

import com.codermy.myspringsecurityplus.entity.MyUser;
import com.codermy.myspringsecurityplus.security.dto.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * @author codermy
 * @createTime 2020/7/23
 */
public class JwtUtils {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;

    public static final String SECRET  = "mySpringSecurityPlus";


    public static String createToken(JwtUserDto jwtUser,boolean isRememberMe){
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setSubject(jwtUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    //获取用户名
    public static String getUserName(String token){
        return getTokenBody(token).getSubject();
    }
    //是否过期
    public static  boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }
    /**
     * 验证JWT
     */
    public static Boolean validateToken(String token, UserDetails userDetails) {
        JwtUserDto user = (JwtUserDto) userDetails;
        String userName = getUserName( token );
        return (userName.equals( user.getUsername() ) && !isExpiration( token ));
    }

    /**
     * 解析JWT
     */

    public static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        MyUser myUser = new MyUser();
        myUser.setUserName("codermy");
        List<GrantedAuthority> list= new ArrayList<>();
        JwtUserDto jwtUserDto = new JwtUserDto(myUser,list);
        String token = createToken(jwtUserDto, false);
        System.out.println(token);
        System.out.println(getUserName(token));
        System.out.println(isExpiration(token));
    }

}

