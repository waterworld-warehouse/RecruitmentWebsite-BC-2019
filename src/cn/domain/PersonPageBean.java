package cn.domain;

import java.util.List;

/**
 * @ProjectName: basic_code
 * @Package: cn.domain
 * @ClassName: PersonPageBean
 * @Author: 晴天
 * @Date: 2019/12/24 9:02
 * @Version: 1.0
 */

  //分页对象
public class PersonPageBean<T> {
    private int totalCount;   //总记录数
    private int totalPage;    //总页码
    private List<T> list;     //每页的数据
    private int currentPage;  //当前页码
    private int rows;         //每页显示的记录数

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PersonPageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
