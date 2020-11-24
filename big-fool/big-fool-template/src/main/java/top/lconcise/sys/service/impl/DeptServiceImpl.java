package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.Dept;
import top.lconcise.sys.mapper.DeptMapper;
import top.lconcise.sys.service.IDeptService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
