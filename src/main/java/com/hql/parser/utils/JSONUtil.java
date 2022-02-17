package com.hql.parser.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author: mizuhokaga
 * @Date: 2022/2/16 16:21
 * @Description:
 * @Version: 1.0
 **/
public class JSONUtil {
    /**
     * 输出标准的json字符串
     *
     * @param obj
     */
    public static String genJSON(Object obj){
        return JSON.toJSONString(obj,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.PrettyFormat);
    }

    public static void printJSON(Object obj) {
        System.out.println(genJSON(obj));
    }

}