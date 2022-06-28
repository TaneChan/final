package com.demo.common;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author Gangamtou
 * @date 2020/2/26 20:43
 */


public class MD5Encoder {

    public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}