package com.lsy.pc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/30 11:21
 */
public class PwdUtils {

    /**
     * 传入最大尝试位数 和数字 返回所有对应密码
     *
     * @param digit 位数
     * @param num   数字
     * @return 密码集合
     */
    public static List<String> getPwd(int digit, Long num) {
        int length = num.toString().length();
        if (length > digit) {
            return null;
        }

        List<String> pwds = new ArrayList<>();
        pwds.add(num.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digit - length; i++) {
            stringBuilder.append("0");
            pwds.add(stringBuilder.toString() + num);
        }

        return pwds;

    }


    /**
     * 获取密码
     *
     * @param count 次数
     * @return 尝试的密码
     */
    public static String getNumPwd(Long count) {
        return DigitalFor62._10_to_62(count, 0);
    }

    public static void main(String[] args) {
        long i = 0;
        while (true) {
            System.out.println(getNumPwd(i));
            i++;
        }
    }

}
