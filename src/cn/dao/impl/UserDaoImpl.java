package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ProjectName: basic_code
 * @Package: cn.dao.impl
 * @ClassName: UserDaoImpl
 * @Author: 晴天
 * @Date: 2019/12/16 16:04
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void userRegister(User user) {
        //1.定义sql语句
        String sql = "insert into w_user values(?,?,?)";
        //2.执行sql语句
        template.update(sql,user.getId(),user.getUsername(),user.getPassword());
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        //1.定义sql语句
        try {
            String sql = "select * from w_user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
