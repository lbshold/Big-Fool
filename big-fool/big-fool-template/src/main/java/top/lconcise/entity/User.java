package top.lconcise.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
