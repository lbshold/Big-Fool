package top.lconcise.security;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import top.lconcise.sys.domain.entity.User;

/**
 * 安全工具类.
 *
 * @author liusj
 * @date 2021/1/4
 */
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication.
     *
     * @return
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户.
     *
     * @param authentication
     * @return
     */
    public User getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    /**
     * 获取用户.
     *
     * @return
     */
    public User getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }

        return getUser(authentication);
    }
}
