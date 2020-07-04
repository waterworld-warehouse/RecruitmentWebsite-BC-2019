package cn.service;

import cn.domain.I_person;
import cn.domain.PersonPageBean;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: basic_code
 * @Package: cn.service
 * @ClassName: PersonService
 * @Author: 晴天
 * @Date: 2019/12/22 22:04
 * @Version: 1.0
 */
/**
 求职者管理的业务接口
 */
public interface PersonService {

    //查询所有的求职者信息
    public List<I_person> findAll();

    //保存Person
    void addPerson(I_person person);

    //根据id删除Person
    void deletePerson(String id);

    //根据id查询
    I_person findPersonById(String id);

    //修改求职信息
    void updatePerson(I_person person);

    //删除选中求职信息
    void delSelectedPerson(String[] pids);

    //分页查询
    PersonPageBean<I_person> findPersonByPage(String currentPage, String rows, Map<String, String[]> condition);
}
