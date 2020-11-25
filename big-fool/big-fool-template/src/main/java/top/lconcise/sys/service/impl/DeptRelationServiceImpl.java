package top.lconcise.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.Dept;
import top.lconcise.sys.domain.entity.DeptRelation;
import top.lconcise.sys.mapper.DeptRelationMapper;
import top.lconcise.sys.service.IDeptRelationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class DeptRelationServiceImpl extends ServiceImpl<DeptRelationMapper, DeptRelation> implements IDeptRelationService {

    @Override
    public void saveDeptRelation(Dept dept) {
        // 维护部门关系表
        List<DeptRelation> deptRelations = baseMapper
                .selectList(Wrappers.<DeptRelation>query().lambda().eq(DeptRelation::getSon, dept.getParentId()))
                .stream().map(deptRelation -> {
                    deptRelation.setSon(dept.getDeptId());
                    return deptRelation;
                }).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(deptRelations)) {
            this.saveBatch(deptRelations);
        }

        // 自己也要维护到部门关系表中
        DeptRelation deptRelation = new DeptRelation();
        deptRelation.setFather(dept.getDeptId());
        deptRelation.setSon(dept.getDeptId());
        baseMapper.insert(deptRelation);
    }

    @Override
    public void removeDeptRelationById(Long id) {
        baseMapper.deleteDeptRelationsById(id);
    }
}
