package top.lconcise.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.lconcise.sys.domain.entity.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liusj
 * @date 2020/11/24
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String password;

    private String phone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean locked;

    private Boolean isDeleted;

    private Long deptId;

    private String deptName;

    private List<Role> roleList;

}
