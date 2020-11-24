package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.Role;
import top.lconcise.sys.mapper.RoleMapper;
import top.lconcise.sys.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
