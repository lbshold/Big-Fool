package top.lconcise.sys.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lconcise.sys.domain.dto.DeptTree;
import top.lconcise.sys.domain.entity.Dept;
import top.lconcise.sys.domain.entity.DeptRelation;
import top.lconcise.sys.mapper.DeptMapper;
import top.lconcise.sys.service.IDeptRelationService;
import top.lconcise.sys.service.IDeptService;
import top.lconcise.sys.util.TreeUtil;

import java.util.Comparator;
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
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private IDeptRelationService deptRelationService;

    @Override
    public Boolean saveDept(Dept dept) {
        baseMapper.insert(dept);
        deptRelationService.saveDeptRelation(dept);
        return Boolean.TRUE;
    }

    @Override
    public Boolean removeDeptById(Long deptId) {
        // 级联删除部门
        List<Long> idList = deptRelationService
                .list(Wrappers.<DeptRelation>query().lambda().eq(DeptRelation::getFather, deptId))
                .stream().map(DeptRelation::getSon).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(idList)) {
            this.removeByIds(idList);
        }
        // 删除部门级联关系
        deptRelationService.removeDeptRelationById(deptId);
        return Boolean.TRUE;
    }

    @Override
    public List<DeptTree> listDeptDrees() {
        return getDeptTree(baseMapper.selectList(Wrappers.emptyWrapper()));
    }

    private List<DeptTree> getDeptTree(List<Dept> deptList) {
        List<DeptTree> deptTrees = deptList.stream().filter(dept -> !dept.getDeptId().equals(dept.getParentId()))
                .sorted(Comparator.comparingInt(Dept::getSort))
                .map(dept -> {
                    DeptTree node = new DeptTree();
                    node.setId(dept.getDeptId());
                    node.setParentId(dept.getParentId());
                    node.setName(dept.getName());
                    return node;
                }).collect(Collectors.toList());
        return TreeUtil.build(deptTrees, 0L);
    }
}
