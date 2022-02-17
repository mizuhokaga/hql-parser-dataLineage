package com.hql.parser.utils;

import com.hql.parser.jsonBean.DataLineage;

import javax.sound.sampled.DataLine;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 17:14
 * @Description: 将生成的JSON写到指定目录, 使得json serve 可以代理使用
 * @Version: 1.0
 **/
public class FileUtil {
    private static final String path="C:/Users/mizuhokaga/Desktop/test_jsonServer/db.json";
    //TODO:改成spring boot项目 该类可以遗弃
    public static void genFile(DataLineage dl) throws IOException {
        File file = new File(path);
        if (!file.exists()) file.createNewFile();
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(JSONUtil.genJSON(dl));
        bw.close();
    }
    public static void genFile(Map<String,DataLineage> map) throws IOException {
        File file = new File(path);
        if (!file.exists()) file.createNewFile();
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(JSONUtil.genJSON(map));
        bw.close();
    }
}