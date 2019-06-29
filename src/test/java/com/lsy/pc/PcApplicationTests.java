package com.lsy.pc;

import com.lsy.pc.utils.ImageUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PcApplicationTests {

    @Value("${down.path.image}")
    private String imagePath;

    @Test
    public void contextLoads() {
        // 利用Jsoup获得连接
        Connection connect = Jsoup.connect("http://www.qq.com");
        try {
            // 得到Document对象
            Document document = connect.get();
            // 查找所有img标签
            Elements imgs = document.getElementsByTag("img");
            System.out.println("共检测到下列图片URL：");
            System.out.println("开始下载");
            // 遍历img标签并获得src的属性
            for (Element element : imgs) {
                //获取每个img标签URL "abs:"表示绝对路径
                String imgSrc = element.attr("abs:src");
                // 打印URL
                System.out.println(imgSrc);
                //下载图片到本地
                ImageUtils.downImages(imagePath, imgSrc);
            }
            System.out.println("下载完成");

            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
