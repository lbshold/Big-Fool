package top.lconcise.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.lconcise.sys.domain.dto.UserDTO;
import top.lconcise.sys.domain.entity.User;
import top.lconcise.sys.domain.vo.UserVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id获取用户信息(含角色和部门).
     *
     * @param userId
     * @return
     */
    UserVO getUserVoById(Long userId);

    /**
     * 分页查询用户信息(含角色和部门).
     *
     * @param page
     * @param userDTO
     * @return
     */
    IPage<List<UserVO>> getUserVosPage(Page page, @Param("query") UserDTO userDTO);
}
