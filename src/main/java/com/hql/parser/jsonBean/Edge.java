package com.hql.parser.jsonBean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 15:44
 * @Description:
 * @Version: 1.0
 **/
@Data
public class Edge  implements Serializable {
    private EdgeUnit from;
    private EdgeUnit to;

    public Edge(String from_tb,String from_col,String to_tb,String to_col){
        this.from=new EdgeUnit(from_tb,from_col);
        this.to=new EdgeUnit(to_tb,to_col);
    }

}