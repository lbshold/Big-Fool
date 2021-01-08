package top.lconcise.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.sys.domain.entity.Menu;
import top.lconcise.sys.domain.vo.MenuVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过角色id 查询 权限、路径.
     *
     * @param roleId
     * @return
     */
    List<MenuVO> findMenuByRoleId(Long roleId);
}
