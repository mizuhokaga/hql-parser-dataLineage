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
public class EdgeUnit implements Serializable {
    private  String tbName;
    private  String column;

    public EdgeUnit(String tbName,String column){
        this.tbName=tbName;
        this.column=column;
    }
}