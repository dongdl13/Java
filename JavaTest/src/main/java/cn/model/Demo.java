package main.java.cn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author dongdongliang13@hotmail.com
 * @version v1.0
 * @date 2018/4/26 23:38
 * @description
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Demo {

    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    private Demo demo;

    private List<Demo> demoList;

}
