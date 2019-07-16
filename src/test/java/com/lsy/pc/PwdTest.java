package com.lsy.pc;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class PwdTest {

    public static void main(String[] args) {
        String url = "http://shoppo.nesdo.cn/Login_Wap.aspx";
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> datas = new HashMap<>();
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
        Connection connect = Jsoup.connect(url);

        datas.put("TbUser", "邢小海");
        String pwd;

            pwd = String.valueOf(556566);
            datas.put("TbPass", pwd);
            Connection connection = connect.headers(headers).data(datas);
            Document post = null;
            try {
                post = connection.post();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert post != null;
            Elements fonts = post.body().select("font");
            System.out.println(post.body());

        }


}
