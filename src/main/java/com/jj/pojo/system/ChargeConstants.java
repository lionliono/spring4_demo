package com.jj.pojo.system;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jj on 2016/12/29.
 */
public class ChargeConstants {
    /**
     * 服务器对应的比例map
     */
    public static Map<Integer,String> CHARGE_MAP = new HashMap<>();

    static{
        CHARGE_MAP.put(1, "100");
        CHARGE_MAP.put(5, "500&600");
        CHARGE_MAP.put(10, "1000&1200");
        CHARGE_MAP.put(50, "5000");
        CHARGE_MAP.put(100, "10000");
    }

//    public static void main(String[] args) {
//        String charge = CHARGE_MAP.get(5);
//        System.out.println(charge.split("&").length);
//        System.out.println(charge.split("&")[0]);
//        System.out.println(charge.split("&")[1]);
//    }
}
