package com.hql.parser.parser;

import com.hql.parser.ql.ASTNode;
import com.hql.parser.ql.ParseException;
import com.hql.parser.sql.SQL;
import com.hql.parser.utils.ASTUtil;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 15:11
 * @Description:
 * @Version: 1.0
 **/
public class CoreParser {
    public void parse(String sql) throws ParseException {
        ASTNode tree= ASTUtil.parseToAST(sql,true);
        ASTUtil.printAST(tree, 0);
        parseIteral(tree);
    }

    private void parseIteral(ASTNode ast) {
        parseChildNodes(ast);
        parseCurrentNode(ast);
    }

    private void parseChildNodes(ASTNode ast) {
        int count = ast.getChildCount();
        if (count > 0) {
            for (int num = 0; num < count; num++) {
                ASTNode child = (ASTNode) ast.getChild(num);
                parseIteral(child);
            }
        }
    }


    private void parseCurrentNode(ASTNode ast) {
        System.out.println(ast.getText() + "=" + ast.getType());
    }
}