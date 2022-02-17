package com.hql.parser.jsonBean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 15:58
 * @Description:
 * @Version: 1.0
 **/
@Data
public class DataLineage  implements Serializable {
    public List<Node> nodes;
    public List<Edge> edges;

    public DataLineage(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}