package top.lconcise.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.sys.domain.entity.Dept;
import top.lconcise.sys.domain.entity.DeptRelation;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface IDeptRelationService extends IService<DeptRelation> {

    /**
     * 新建部门关系.
     *
     * @param dept
     */
    void saveDeptRelation(Dept dept);

    /**
     * 通过id删除部门关系.
     *
     * @param id
     */
    void removeDeptRelationById(Long id);
}
