package cn.dao;

import cn.domain.User;

/**
 * @ProjectName: basic_code
 * @Package: cn.dao
 * @ClassName: UserDao
 * @Author: 晴天
 * @Date: 2019/12/16 16:03
 * @Version: 1.0
 */
public interface UserDao {

    //用户注册
    void userRegister(User user);

    //用户登录
    User findUserByUsernameAndPassword(String username, String password);
}
