package com.codermy.myspringsecurityplus.admin.controller;



import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.JobService;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Controller
@RequestMapping("/api/user")
@Api(tags = "系统：用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @GetMapping("/index")
    @PreAuthorize("hasAnyAuthority('user:list')")
    public String index(){
        return "system/user/user";
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "用户列表")
    @PreAuthorize("hasAnyAuthority('user:list')")
    @MyLog("查询用户")
    public Result<MyUser> userList(PageTableRequest pageTableRequest, MyUser myUser){
        pageTableRequest.countOffset();
        return userService.getAllUsersByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit(),myUser);
    }

    @GetMapping("/add")
    @ApiOperation(value = "添加用户页面")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String addUser(Model model){
        model.addAttribute("myUser",new MyUser());
        model.addAttribute("jobs",jobService.selectJobAll());
        return "/system/user/user-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加用户")
    @PreAuthorize("hasAnyAuthority('user:add')")
    @MyLog("添加用户")
    public Result<MyUser> saveUser(@RequestBody MyUser myUser){
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(myUser))){
            return Result.error().message("手机号已存在");
        }
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkUserNameUnique(myUser))){
            return Result.error().message("用户名已存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        myUser.setPassword(bCryptPasswordEncoder.encode("123456"));
        return userService.save(myUser,myUser.getRoleId());
    }

    @GetMapping("edit")
    @ApiOperation(value = "修改用户界面")
    @PreAuthorize("hasAnyAuthority('user:edit')")
    public String editUser(Model model, MyUser tbUser){
        model.addAttribute("myUser",userService.getUserById(tbUser.getUserId()));
        model.addAttribute("jobs",jobService.selectJobsByUserId(tbUser.getUserId()));
        return "/system/user/user-edit";
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改用户")
    @PreAuthorize("hasAnyAuthority('user:edit')")
    @MyLog("修改用户")
    public Result updateUser(@RequestBody MyUser myUser){
        MyUser userById = userService.getUserById(myUser.getUserId());
        userService.checkUserAllowed(userById);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(myUser))){

            return Result.error().message("手机号已存在");
        }
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkUserNameUnique(myUser))){
            return Result.error().message("用户名已存在");
        }
        return userService.updateUser(myUser,myUser.getRoleId());
    }
    /**
     * 用户状态修改
     */
    @MyLog("修改用户状态")
    @PutMapping("/changeStatus")
    @ResponseBody
    @ApiOperation(value = "修改用户状态")
    @PreAuthorize("hasAnyAuthority('user:edit')")
    public Result changeStatus(@RequestBody MyUser myUser)
    {
        userService.checkUserAllowed(myUser);
        userService.changeStatus(myUser);
        return Result.judge(userService.changeStatus(myUser),"修改成功");
    }

    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除用户")
    @PreAuthorize("hasAnyAuthority('user:del')")
    @MyLog("删除用户")
    public Result deleteUser(Integer userId){
        int count = userService.deleteUser(userId);
        return Result.judge(count,"删除用户");
    }
}
