package top.lconcise.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lconcise.sys.domain.dto.UserDTO;
import top.lconcise.sys.domain.entity.User;
import top.lconcise.sys.domain.vo.UserVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
public interface IUserService extends IService<User> {

    /**
     * 保存用户信息.
     *
     * @param userDTO
     * @return
     */
    Boolean saveUser(UserDTO userDTO);

    /**
     * 更新用户信息.
     *
     * @param userDTO
     * @return
     */
    Boolean updateUser(UserDTO userDTO);

    /**
     * 根据id查询用户信息.
     *
     * @param id
     * @return
     */
    UserVO getUserVoById(Long id);
}
