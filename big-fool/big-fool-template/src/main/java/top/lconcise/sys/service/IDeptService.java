package top.lconcise.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.sys.domain.dto.DeptTree;
import top.lconcise.sys.domain.entity.Dept;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface IDeptService extends IService<Dept> {

    /**
     * 添加部门信息.
     *
     * @param dept
     * @return
     */
    Boolean saveDept(Dept dept);

    /**
     * 删除部门.
     *
     * @param deptId 部门id
     * @return
     */
    Boolean removeDeptById(Long deptId);

    /**
     * 查询部门树菜单.
     *
     * @return
     */
    List<DeptTree> listDeptDrees();

    /**
     * 添加部门信息.
     *
     * @return
     */
    List<DeptTree> listCurrentUserDeptTrees();

    /**
     * 更新部门.
     *
     * @param dept 部门信息
     * @return 成功、失败
     */
    Boolean updateDeptById(Dept dept);
}
