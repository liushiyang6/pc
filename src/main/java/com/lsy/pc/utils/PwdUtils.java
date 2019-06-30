package com.lsy.pc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/30 11:21
 */
public class PwdUtils {

    /*密码组成，有数字，小写字母，大写字母组成*/
    static char charSource[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

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


    public static List<String> getPwd(Long num) {
        return getPwd(15, num);
    }


    public static String getNextPwds(String parent) {
        char c = parent.charAt(parent.length() - 1);
        if (c == 'Z') {
            return getNextPwds(parent, 1);
        } else {
            for (int i = 0; i < charSource.length; i++) {
                if (c == charSource[i]) {
                    StringBuilder stringBuilder = new StringBuilder(parent);
                    stringBuilder.setCharAt(parent.length() - 1, charSource[i + 1]);
                    return stringBuilder.toString();
                }
            }
        }
        return parent;
    }

    private static String getNextPwds(String parent, int i) {
        // 进一位
        if (parent.length() == i) {
            return "0" + parent;
        }
        parent.charAt(parent.length() - i - 1);
        StringBuilder stringBuilder = new StringBuilder(parent);
        stringBuilder.setCharAt(parent.length() - i - 1, '0');
        int index = parent.length() - i - 2;
        if (stringBuilder.charAt(index) == 'Z') {
            return getNextPwds(stringBuilder.toString(), i + 1);
        }

        for (int j = 0; j < charSource.length; j++) {
            if (index == charSource[j]) {
                stringBuilder.setCharAt(parent.length() - 1 - j, charSource[j + 1]);
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        char a = 91;
        System.out.println(a);
    }

}
