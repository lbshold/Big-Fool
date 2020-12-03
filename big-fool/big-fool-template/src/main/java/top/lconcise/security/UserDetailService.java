package top.lconcise.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.lconcise.sys.MyUser;

/**
 * @author liusj
 * @date 2020/12/3
 */
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser user = new MyUser();
        user.setUsername(s);
        user.setPassword(passwordEncoder.encode("123456"));

        return user;
    }
}
