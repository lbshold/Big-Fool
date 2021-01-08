package top.lconcise.sys.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.lconcise.model.RestResult;
import top.lconcise.model.RestResultUtils;
import top.lconcise.sys.domain.entity.Menu;
import top.lconcise.sys.service.IMenuService;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    private final IMenuService menuService;

    @ApiOperation("新增菜单")
    @PostMapping
    public RestResult save(@Valid @RequestBody Menu menu) {
        menuService.save(menu);
        return RestResultUtils.success(menu);
    }

    @ApiOperation("编辑菜单")
    @PutMapping
    public RestResult update(@Valid @RequestBody Menu menu) {
        menuService.updateById(menu);
        return RestResultUtils.success(menu);
    }

    @ApiOperation("删除菜单")
    @DeleteMapping("/{id}")
    public RestResult removeById(@PathVariable Long id) {
        return RestResultUtils.success(menuService.removeById(id));
    }

    @ApiOperation("根据id查询菜单详细信息")
    @GetMapping("/{id}")
    public RestResult getById(@PathVariable Long id) {
        return RestResultUtils.success(menuService.getById(id));
    }
}
