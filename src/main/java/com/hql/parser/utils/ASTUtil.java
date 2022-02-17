package com.hql.parser.utils;

import com.hql.parser.ql.*;

import java.util.List;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/15 11:10
 * @Description: SQL转换为AST
 * @Version: 1.0
 **/
public class ASTUtil {


    // 将传入的 单条 SQL转换为AST
    public static ASTNode parseToAST(String sql, boolean isPrune) throws ParseException {

        String tmp = (sql);
        ParseDriver pd = new ParseDriver();
        if (tmp.startsWith("set") || tmp.startsWith("add") || Check.isEmpty(tmp)) {
            return null;
        }
        ASTNode ast = pd.parse((sql));
        if (isPrune) pruneAST(ast);
        //跳过头节点(空节点)
        return isPrune ? (ASTNode) ast.getChild(0) : (ASTNode) ast.getChild(0);
    }

    //深度遍历打印AST
    public static void printAST(ASTNode tree, int depth) {
        String padding = "";
        for (int i = 0; i < depth; i++) padding += " ";
        System.out.println(padding + tree.getText() + "=" + tree.getType());
        for (int i = 0; i < tree.getChildCount(); i++) {
            printAST((ASTNode) tree.getChild(i), depth + 1);
        }
    }

    //对AST剪枝
    private static void pruneAST(ASTNode tree) {
        if (tree == null || tree.getChildren() == null) return;
        List<Node> children = tree.getChildren();
        for (int i = children.size() - 1; i > 0; --i) {
            ASTNode child = (ASTNode) children.get(i);
            int nodeType = child.getType();
            if (HiveParser.TOK_ORDERBY == nodeType
                    || HiveParser.TOK_DISTRIBUTEBY == nodeType
                    || HiveParser.TOK_CLUSTERBY == nodeType
                    || HiveParser.TOK_LIMIT == nodeType
                    || HiveParser.TOK_SORTBY == nodeType) {
                tree.deleteChild(i);
            } else if (HiveParser.TOK_WHERE == nodeType || HiveParser.TOK_HAVING == nodeType) {
                //是否有必要对where 和having子句的条件进行 1=1 的替换？
            } else pruneAST(child);
        }
    }


}