package top.lconcise.sys.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 部门关系表(中间表).
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dept_relation")
@ApiModel(value="DeptRelation对象", description="")
public class DeptRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父节点")
    private Long father;

    @ApiModelProperty(value = "子节点")
    private Long son;


}
