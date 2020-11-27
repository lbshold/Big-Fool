package top.lconcise.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lconcise.sys.domain.dto.UserDTO;
import top.lconcise.sys.domain.entity.User;
import top.lconcise.sys.domain.entity.UserRole;
import top.lconcise.sys.domain.vo.UserVO;
import top.lconcise.sys.mapper.UserMapper;
import top.lconcise.sys.service.IUserRoleService;
import top.lconcise.sys.service.IUserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

//    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public Boolean saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        user.setPassword(userDTO.getPassword());
        baseMapper.insert(user);
        // 添加用户角色中间表
        List<UserRole> userRoles = userDTO.getRoleIds().stream().map(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            return userRole;
        }).collect(Collectors.toList());
        return userRoleService.saveBatch(userRoles);
    }

    @Override
    public Boolean updateUser(UserDTO userDTO) {
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        if (StringUtils.isNotEmpty(userDTO.getPassword())) {
            user.setPassword(userDTO.getPassword());
        }
        this.updateById(user);
        // 更新用户角色中间表
        if (userDTO.getRoleIds().size() > 0) {
            userRoleService
                    .remove(new QueryWrapper<UserRole>().lambda().eq(UserRole::getUserId, userDTO.getUserId()));
            List<UserRole> userRoles = userDTO.getRoleIds().stream().map(roleId -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(userDTO.getUserId());
                userRole.setRoleId(roleId);
                return userRole;
            }).collect(Collectors.toList());
            userRoleService.saveBatch(userRoles);
        }
        return Boolean.TRUE;
    }

    @Override
    public UserVO getUserVoById(Long id) {
        return baseMapper.getUserVoById(id);
    }

    @Override
    public IPage getUserVosPage(Page page, UserDTO userDTO) {
        return baseMapper.getUserVosPage(page, userDTO);
    }
}
