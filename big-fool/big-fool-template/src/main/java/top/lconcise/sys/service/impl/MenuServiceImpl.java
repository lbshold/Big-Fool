package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.entity.Menu;
import top.lconcise.sys.domain.vo.MenuVO;
import top.lconcise.sys.mapper.MenuMapper;
import top.lconcise.sys.service.IMenuService;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<MenuVO> findMenuByRoleId(Long roleId) {



        return baseMapper.findMenuByRoleId(roleId);
    }
}
