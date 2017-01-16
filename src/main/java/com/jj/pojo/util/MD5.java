package com.jj.pojo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	// 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    //签名要加的串
    public final static String SUFFIX = "0f707c8c39af40e1a1420b14bd1ff86b";

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
//        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        String ss = "0f707c8c39af40e1a1420b14bd1ff86b";
        String s = "2804" + ss;
        String a = GetMD5Code(s);
        System.out.println(a);//e1a60d51460dcb048678be2ef2a51231
//        System.out.println(a.equalsIgnoreCase("662E97C6C37F14EB7AE09A9929BAAA96"));
//        System.out.println(GetMD5Code(s));
//        System.out.println(!"662E97C6C37F14EB7AE09A9929BAAA96".equalsIgnoreCase("662e97c6c37f14eb7ae09a9929baaa96"));
    }
}
