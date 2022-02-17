package com.hql.parser.utils;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/17 11:23
 * @Description:对sql清洗成底层 parser代码能解析的形式
 * @Version: 1.0
 **/
public class SQLUtil {
    /**
     * 变量替换正则
     */
    private static final String regex_replace_params = "\\$\\{.*?\\}|\\$[a-zA-Z_]+[a-z-A-Z_0-9]+";
    /**
     * 排除列替换正则
     */
    private static final String regex_replace_exclude = "`\\(.*?\\).+?`";


    public static String cleanSQL(String sql) {
        String cleaned = sql.toLowerCase().trim();

        return cleaned;
    }

    private static String convertSqlVariable(String sql) {
        if (sql != null) {
            //替换参数
            sql = sql.replaceAll(regex_replace_params, "1024");
            //替换排除列：select `(name|id|pwd)?+.+` from table
            sql = sql.replaceAll(regex_replace_exclude, "1024");
            //替换 “ ` ”
            sql = sql.trim().replace("`", "");
        }
        return sql;
    }
}