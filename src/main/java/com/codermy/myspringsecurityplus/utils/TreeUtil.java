package com.codermy.myspringsecurityplus.utils;

import com.codermy.myspringsecurityplus.dto.MenuDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author codermy
 * @createTime 2020/7/2
 */
public class TreeUtil {
    //todo 判断list是否为空

    /**
     *
     * @param listByRoleId 通过角色id查询的menuid
     * @param menuDtos 返回的menutree
     * @return
     */
    public static List<MenuDto> tree(List<MenuDto> listByRoleId, List<MenuDto> menuDtos ){
        // if (listByRoleId == null & listByRoleId.size() ==0){
        //     throw
        // }
        List<Integer> collect = listByRoleId.stream().map(MenuDto::getId).collect(Collectors.toList());
        List<Integer> collect1 = menuDtos.stream().map(MenuDto::getId).collect(Collectors.toList());
        for (Integer item : collect) {// 遍历list2
            if (collect1.contains(item)) {// 如果存在这个数
                MenuDto menuDto = new MenuDto();
                menuDto = menuDtos.get(item-1);
                menuDto.setCheckArr("1");
                menuDtos.set(item-1,menuDto);
            }
        }
        return menuDtos;
    }
}
