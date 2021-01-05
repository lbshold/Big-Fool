package top.lconcise.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lconcise.sys.domain.entity.DeptRelation;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface DeptRelationMapper extends BaseMapper<DeptRelation> {

    /**
     * 根据部门id 删除部门关系表.
     *
     * @param id
     */
    void deleteDeptRelationsById(Long id);

    /**
     * 更新部门关系.
     *
     * @param deptRelation
     */
    void updateDeptRelation(DeptRelation deptRelation);

    /**
     * 根据部门id删除级联关系.
     *
     * @param deptId
     */
    void deleteDeptRelationById(Long deptId);
}
