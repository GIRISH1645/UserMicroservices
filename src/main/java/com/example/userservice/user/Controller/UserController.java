package com.example.userservice.user.Controller;

import com.example.userservice.user.Entity.UserEntity;
import com.example.userservice.user.Service.UserService;
import com.example.userservice.user.Vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public UserEntity saveUsers(@RequestBody UserEntity user){
        log.info("Entering SaveUsers in Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/getuser/{id}")
    public ResponseTemplateVo getUserWithDepartmentId(@PathVariable("id") Long userId){
        return userService.getUserWithDepartmentId(userId);

    }


}
