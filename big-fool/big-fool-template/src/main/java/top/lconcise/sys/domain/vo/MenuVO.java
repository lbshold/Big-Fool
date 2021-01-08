package top.lconcise.sys.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单权限表VO.
 *
 * @author liusj
 * @date 2021/1/6
 */
@Data
public class MenuVO implements Serializable {

    private static final long serialVersionUID = 749312760462895630L;

    private Long menuId;

    private String name;

    private String permission;

    private Long parentId;

    private String icon;

    private String path;

    private String sort;

    private String type;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuVO menuVO = (MenuVO) o;
        return menuId.equals(menuVO.menuId);
    }
}
