package top.lconcise.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lconcise.sys.entity.User;
import top.lconcise.sys.mapper.UserMapper;
import top.lconcise.sys.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liusj
 * @since 2020-11-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
