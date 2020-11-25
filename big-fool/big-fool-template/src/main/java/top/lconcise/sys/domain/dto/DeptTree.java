package top.lconcise.sys.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liusj
 * @date 2020/11/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode{

    private String name;
}
