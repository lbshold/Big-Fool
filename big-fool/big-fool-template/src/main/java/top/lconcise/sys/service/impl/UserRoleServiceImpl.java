package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.UserRole;
import top.lconcise.sys.mapper.UserRoleMapper;
import top.lconcise.sys.service.IUserRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
