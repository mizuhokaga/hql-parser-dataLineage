package com.hql.parser.jsonBean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 15:53
 * @Description:
 * @Version: 1.0
 **/
@Data
public class Column  implements Serializable {
    private String name;

    public Column(String name) {
        this.name = name;
    }
}