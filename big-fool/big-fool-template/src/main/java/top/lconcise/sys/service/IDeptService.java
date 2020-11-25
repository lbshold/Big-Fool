package top.lconcise.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.sys.domain.entity.Dept;

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
}
