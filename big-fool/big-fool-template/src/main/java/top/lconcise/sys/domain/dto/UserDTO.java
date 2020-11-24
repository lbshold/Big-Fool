package top.lconcise.sys.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lconcise.sys.domain.entity.User;

import java.util.List;

/**
 * @author liusj
 * @date 2020/11/23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends User {

    private List<Long> roleIds;

    private Long deptId;

    private String newPassword;
}
