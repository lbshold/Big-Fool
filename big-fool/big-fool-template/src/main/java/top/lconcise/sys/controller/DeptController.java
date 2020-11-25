package top.lconcise.sys.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lconcise.model.RestResult;
import top.lconcise.model.RestResultUtils;
import top.lconcise.sys.domain.entity.Dept;
import top.lconcise.sys.service.IDeptService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/depts")
@Api(value = "dept", tags = "部门管理模块")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @ApiOperation("添加部门")
    @PostMapping
    public RestResult save(@RequestBody Dept dept) {
        return RestResultUtils.success(deptService.saveDept(dept));
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public RestResult removeById(@PathVariable Long id) {
        return RestResultUtils.success(deptService.removeDeptById(id));
    }
}
