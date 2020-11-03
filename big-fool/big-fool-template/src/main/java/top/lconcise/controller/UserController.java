package top.lconcise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户相关操作", tags = "用户相关操作")
@RestController
@RequestMapping("/users")
public class UserController {


    @ApiOperation("创建用户")
    @GetMapping
    public void create() {
    }


}