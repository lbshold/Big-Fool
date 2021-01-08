package top.lconcise.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lconcise.sys.domain.entity.Menu;
import top.lconcise.sys.domain.vo.MenuVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据角色id查询菜单、权限、路径.
     *
     * @param roleId
     * @return
     */
    List<MenuVO> findMenuByRoleId(Long roleId);
}
