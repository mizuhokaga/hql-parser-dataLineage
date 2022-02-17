package com.hql.parser;


import com.hql.parser.jsonBean.Column;
import com.hql.parser.jsonBean.DataLineage;
import com.hql.parser.jsonBean.Edge;
import com.hql.parser.jsonBean.Node;
import com.hql.parser.parser.CoreParser;
import com.hql.parser.sql.SQL;
import com.hql.parser.utils.FileUtil;
import com.hql.parser.utils.JSONUtil;
import com.hql.parser.utils.TbType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/15 11:09
 * @Description:
 * @Version: 1.0
 **/
public class Driver {
    public static void main(String[] args) throws Exception {
        CoreParser coreParser = new CoreParser();
        coreParser.parse(SQL.vanilla);
        //手动构造JSON
        Edge e = new Edge("a", "col", "b", "col");
        List<Column> list1 = new LinkedList<>();
        List<Column> list2 = new LinkedList<>();
        list1.add(new Column("col"));
        list2.add(new Column("col"));
        Node node1 = new Node("a", "a", TbType.Origin, list1);
        Node node2 = new Node("b", "b", TbType.RS, list2);
        List<Node> nodes = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
        nodes.add(node1);
        nodes.add(node2);
        edges.add(e);
        DataLineage dl = new DataLineage(nodes, edges);
        Map<String, DataLineage> map = new HashMap<>(1);
        map.put("dataLineage", dl);
        
        JSONUtil.printJSON(map);
        FileUtil.genFile(map);
    }

}