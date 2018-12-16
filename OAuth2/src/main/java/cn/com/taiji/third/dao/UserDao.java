package cn.com.taiji.third.dao;

import cn.com.taiji.third.domain.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author andyzhao
 */
@Mapper
public interface UserDao {
	 User findByUserName(String user_name);
	    User findByUserMobile(String mobile);
	    User findByUserEmail(String email);
	    List<User> listAll();
}
