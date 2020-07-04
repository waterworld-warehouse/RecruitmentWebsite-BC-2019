package cn.service.impl;

import cn.dao.PersonDao;
import cn.dao.impl.PersonDaoImpl;
import cn.domain.I_person;
import cn.domain.PersonPageBean;
import cn.service.PersonService;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: basic_code
 * @Package: cn.service.impl
 * @ClassName: PersonServiceImpl
 * @Author: 晴天
 * @Date: 2019/12/22 22:04
 * @Version: 1.0
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao Pdao = new PersonDaoImpl();

    @Override
    public List<I_person> findAll() {
        //调用dao查询
        return Pdao.findAll();
    }

    @Override
    public void addPerson(I_person person) {
        Pdao.add(person);
    }

    @Override
    public void deletePerson(String id) {
        Pdao.delete(Integer.parseInt(id));
    }

    @Override
    public I_person findPersonById(String id) {
        return Pdao.findById(Integer.parseInt(id));
    }

    @Override
    public void updatePerson(I_person person) {
        Pdao.update(person);
    }

    @Override
    public void delSelectedPerson(String[] pids) {
        if(pids != null && pids.length > 0){
            //1.遍历数组
            for (String id : pids) {
                //2.调用dao删除
                Pdao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PersonPageBean<I_person> findPersonByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0)
        {
            currentPage = 1;
        }


        //1.创建空的PageBean对象
        PersonPageBean<I_person> pb = new PersonPageBean<I_person>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount = Pdao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<I_person> list = Pdao.findByPage(start,rows,condition);
        pb.setList(list);
        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
