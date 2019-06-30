package com.lsy.pc;

public class PojiePassword {
    static String real = "ZY9199";//真实密码
    static String pass = "";//执行循环操作找出来的与真实密码相等的字符串
    static String prod = "";//中间产生的字符串
    static String[] s = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    //定义一个有62个字符串的字符串数组
    //生成一个指定位数的密码，每一位有以上62种可能,n=6时，第一个为000000，最后一个为ZZZZZZ,共//62^6种可能。n=7时，第一个为0000000，最后一个为ZZZZZZZ，共62^7种可 能。n=8时，第一个为//00000000，最后一个为ZZZZZZZZ，共62^8种可能
    //62^6种情况，累死也列不出来，，，


    public static void main(String[] args) throws InterruptedException {


//循环遍历出数组中的元素，列出数组中的字符可以组成的所有一位字符串，共62^1种可能

        for (int i = 0; i < 62; i++) {
            prod = s[i];
            if (prod.equals(real)) {
                pass = prod;
                System.out.println("执行" + (i + 1) + "次操作,找到真实密码，为" + pass);
                break;
            } else {
                System.out.println(prod);
            }

        }

//列出数组中的字符可以组成的所有两位字符串，共62^2种可能
        if (pass.equals("")) {//在上一级未找到
            for (int i = 0; i < 62; i++) {
                for (int j = 0; j < 62; j++) {
                    prod = s[i] + s[j];
                    if (prod.equals(real)) {
                        pass = prod;
                        System.out.println("找到真实密码，为" + pass);
                        break;
                    }
                }
            }
        }
//列出数组中的字符可以组成的所有三位字符串，共62^3种可能
        if (pass.equals("")) {//在上一级未找到
            for (int i = 0; i < 62; i++) {
                for (int j = 0; j < 62; j++) {
                    for (int k = 0; k < 62; k++) {
                        prod = s[i] + s[j] + s[k];
                        if (prod.equals(real)) {
                            pass = prod;
                            System.out.println("找到真实密码，为" + pass);
                            break;
                        }
                    }
                }

            }
        }
//列出数组中的字符可以组成的所有4位字符串，共62^4种可能
        if (pass.equals("")) {//在上一级未找到
            for (int i = 0; i < 62; i++) {
                for (int j = 0; j < 62; j++) {
                    for (int k = 0; k < 62; k++) {
                        for (int l = 0; l < 62; l++) {
                            prod = s[i] + s[j] + s[k] + s[l];
                            if (prod.equals(real)) {
                                pass = prod;
                                System.out.println("找到真实密码，为" + pass);
                                break;
                            }
                        }
                    }
                }
            }
        }
//列出数组中的字符可以组成的所有5位字符串，共62^5种可能
        if (pass.equals("")) {//在上一级未找到
            for (int i = 0; i < 62; i++) {
                for (int j = 0; j < 62; j++) {
                    for (int k = 0; k < 62; k++) {
                        for (int l = 0; l < 62; l++) {
                            for (int m = 0; m < 62; m++) {
                                prod = s[i] + s[j] + s[k] + s[l] + s[m];
                                if (prod.equals(real)) {
                                    pass = prod;
                                    System.out.println("找到真实密码，为" + pass);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
//列出数组中的字符可以组成的所有6位字符串，共62^6种可能
        if (pass.equals("")) {//在上一级未找到
            for (int i = 0; i < 62; i++) {
                for (int j = 0; j < 62; j++) {
                    for (int k = 0; k < 62; k++) {
                        for (int l = 0; l < 62; l++) {
                            for (int m = 0; m < 62; m++) {
                                for (int n = 0; n < 62; n++) {
                                    prod = s[i] + s[j] + s[k] + s[l] + s[m] + s[n];
                                    if (prod.equals(real)) {
                                        pass = prod;
                                        System.out.println("找到真实密码，为" + pass);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

    }
}