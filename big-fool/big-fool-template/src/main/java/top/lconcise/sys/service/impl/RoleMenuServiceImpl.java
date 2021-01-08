package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.RoleMenu;
import top.lconcise.sys.mapper.RoleMenuMapper;
import top.lconcise.sys.service.IRoleMenuService;

/**
 * <p>
 * 角色菜单中间表 服务实现类
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
