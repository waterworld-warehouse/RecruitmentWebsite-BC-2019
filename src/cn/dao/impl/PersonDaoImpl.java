package cn.dao.impl;


import cn.dao.PersonDao;
import cn.domain.I_person;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: basic_code
 * @Package: cn.dao.impl
 * @ClassName: PersonDaoImpl
 * @Author: 晴天
 * @Date: 2019/12/22 22:04
 * @Version: 1.0
 */
public class PersonDaoImpl implements PersonDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<I_person> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "select * from find_job";
        List<I_person> persons = template.query(sql, new BeanPropertyRowMapper<I_person>(I_person.class));
        return persons;
    }

    @Override
    public void add(I_person person) {
        //1.定义sql语句
        String sql = "insert into find_job values(null,?,?,?)";
        //2.执行sql
        template.update(sql,person.getJob_name(),person.getJob_place(),person.getJob_money());
    }

    @Override
    public void delete(int id) {
        //1.定义sql
        String sql = "delete from find_job where id = ?";
        //2.执行sql
        template.update(sql,id);
    }

    @Override
    public I_person findById(int id) {
        String sql = "select * from find_job where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<I_person>(I_person.class),id);
    }

    @Override
    public void update(I_person person) {
        String sql = "update find_job set job_name = ?,job_place = ?,job_money = ? where id = ?";
        template.update(sql,person.getJob_name(),person.getJob_place(),person.getJob_money(),person.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from find_job where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<I_person> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from find_job where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<I_person>(I_person.class),params.toArray());
    }
}
