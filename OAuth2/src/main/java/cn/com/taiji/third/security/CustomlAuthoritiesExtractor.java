package cn.com.taiji.third.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import cn.com.taiji.third.dao.UserDao;

import java.util.List;
import java.util.Map;

/**
 * Created by iandtop on 2018/12/9.
 */
@Component
public class CustomlAuthoritiesExtractor extends FixedAuthoritiesExtractor {
	@Autowired
	private UserDao UserDao;
    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        // 默认设置为ADMIN
        String authorities = "ROLE_ADMIN";
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }
}