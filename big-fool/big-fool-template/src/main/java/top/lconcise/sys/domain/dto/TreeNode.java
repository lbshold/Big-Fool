package top.lconcise.sys.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点.
 *
 * @author liusj
 * @date 2020/11/25
 */
@Data
public class TreeNode {

    protected Long id;

    protected Long parentId;

    protected List<TreeNode> children = new ArrayList<>();

    protected Boolean hasChildren;

    public void add(TreeNode node) {
        this.children.add(node);
    }
}
