package top.lconcise.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lconcise.sys.domain.entity.User;
import top.lconcise.sys.domain.vo.UserVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户id获取用户信息.
     * @param userId
     * @return
     */
    UserVO getUserVOById(Long userId);
}
