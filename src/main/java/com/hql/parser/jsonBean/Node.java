package com.hql.parser.jsonBean;

import com.hql.parser.utils.TbType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 15:53
 * @Description:
 * @Version: 1.0
 **/
@Data
public class Node implements Serializable {
    private String id;
    private String name;
    private TbType type;
    private Integer left = 0;
    private Integer top = 0;
    private List<Column> columns;

    public Node(String id, String name, TbType type, List<Column> columns) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.columns = columns;
    }

    public Node(String id, String name, TbType type, Integer left, Integer top, List<Column> columns) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.left = left;
        this.top = top;
        this.columns = columns;
    }
}