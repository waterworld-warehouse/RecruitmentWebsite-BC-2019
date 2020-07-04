package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.User;
import cn.service.UserService;

/**
 * @ProjectName: basic_code
 * @Package: cn.service.impl
 * @ClassName: UserServiceImpl
 * @Author: 晴天
 * @Date: 2019/12/16 18:10
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
