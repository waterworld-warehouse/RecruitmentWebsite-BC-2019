package cn.dao;

import cn.domain.I_person;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: basic_code
 * @Package: cn.dao
 * @ClassName: PersonDao
 * @Author: 晴天
 * @Date: 2019/12/22 22:04
 * @Version: 1.0
 */
/**
 求职者管理的dao
 */
public interface PersonDao {

    public List<I_person> findAll();

    void add(I_person person);

    void delete(int i);

    I_person findById(int parseInt);

    void update(I_person person);

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);

    //分页查询每页记录
    List<I_person> findByPage(int start, int rows, Map<String, String[]> condition);
}
