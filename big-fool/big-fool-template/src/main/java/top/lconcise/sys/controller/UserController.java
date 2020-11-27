package top.lconcise.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lconcise.model.RestResult;
import top.lconcise.model.RestResultUtils;
import top.lconcise.sys.domain.dto.UserDTO;
import top.lconcise.sys.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/users")
@Api(value = "user", tags = "用户管理模块")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("分页查询用户")
    @PostMapping("/page/{current}/{size}")
    public RestResult getUserPage(@PathVariable Long current,
                                  @PathVariable Long size,
                                  @RequestBody(required = false) UserDTO userDTO) {
        return RestResultUtils.success(userService.getUserVosPage(new Page(current, size), userDTO));
    }

    @ApiOperation("添加用户信息")
    @PostMapping
    public RestResult insertUser(@RequestBody UserDTO userDTO) {
        return RestResultUtils.success(userService.saveUser(userDTO));
    }

    @ApiOperation("修改用户信息")
    @PutMapping
    public RestResult updateUser(@RequestBody UserDTO userDTO) {
        return RestResultUtils.success(userService.updateUser(userDTO));
    }

    @ApiOperation("根据用户id获取用户信息")
    @GetMapping("/{userId}")
    public RestResult getUserVoById(@PathVariable Long userId) {
        return RestResultUtils.success(userService.getUserVoById(userId));
    }
}
