package top.lconcise.sys.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lconcise.sys.domain.vo.MenuVO;

import java.io.Serializable;

/**
 * 菜单树节点.
 *
 * @author liusj
 * @date 2021/1/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode implements Serializable {

    private String name;

    private String permission;

    private Long parentId;

    private String icon;

    private String path;

    private String sort;

    private String type;

    public MenuTree() {
    }

    public MenuTree(MenuVO menuVO) {
        this.id = menuVO.getMenuId();
        this.name = menuVO.getName();
        this.permission = menuVO.getPermission();
        this.parentId = menuVO.getParentId();
        this.icon = menuVO.getIcon();
        this.path = menuVO.getPath();
        this.sort = menuVO.getSort();
        this.type = menuVO.getType();
    }
}
