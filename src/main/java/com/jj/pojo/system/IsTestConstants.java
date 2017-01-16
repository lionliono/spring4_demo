package com.jj.pojo.system;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jj on 2016/8/22.
 */
public class IsTestConstants {
    /**
     * 服务器类型map
     * 0测试服，1正式服
     */
    public static Map<String,String> ISTEST_MAP = new HashMap<String,String>();

    static{
        ISTEST_MAP.put("0", "http://121.196.229.39:16666");
        ISTEST_MAP.put("1", "http://121.196.229.39:16666");
    }
}
