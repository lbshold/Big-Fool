package top.lconcise.sys.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liusj
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单id")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @NotBlank(message = "菜单名称不能为空")
    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "菜单权限标识")
    private String permission;

    @NotNull(message = "菜单父id不能为空")
    @ApiModelProperty(value = "菜单父id")
    private Long parentId;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "前端路由标识路径")
    private String path;

    @ApiModelProperty(value = "排序值")
    private String sort;

    @ApiModelProperty(value = "菜单类型不能为空")
    private String type;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @TableLogic
    @ApiModelProperty(value = "0-正常，1-删除")
    private Boolean deleted;


}
