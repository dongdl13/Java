package cn.model;

import java.util.Date;
import java.util.List;

/**
 * @author dongdongliang13@hotmail.com
 * @version v1.0
 * @date 2018/4/26 23:38
 * @description
 */
public class Demo {

    private Integer id;

    private String name;

    private Date createDate;

    private Demo demo;

    private List<Demo> demoList;

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    public List<Demo> getDemoList() {
        return demoList;
    }

    public void setDemoList(List<Demo> demoList) {
        this.demoList = demoList;
    }

    public Demo() {
    }

    public Demo(Integer id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", demo=" + demo +
                ", demoList=" + demoList +
                '}';
    }
}
