package cn.domain;

/**
 * @ProjectName: basic_code
 * @Package: cn.domain
 * @ClassName: I_person
 * @Author: 晴天
 * @Date: 2019/12/22 16:44
 * @Version: 1.0
 */
public class I_person {
    private int id;
    private String job_name;
    private String job_place;
    private String job_money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_place() {
        return job_place;
    }

    public void setJob_place(String job_place) {
        this.job_place = job_place;
    }

    public String getJob_money() {
        return job_money;
    }

    public void setJob_money(String job_money) {
        this.job_money = job_money;
    }

    @Override
    public String toString() {
        return "I_person{" +
                "id=" + id +
                ", job_name='" + job_name + '\'' +
                ", job_place='" + job_place + '\'' +
                ", job_money='" + job_money + '\'' +
                '}';
    }
}
