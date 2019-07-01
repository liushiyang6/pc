package com.lsy.pc;

import com.google.gson.Gson;

import com.lsy.pc.model.json.zhihu.ZhihuModel;
import com.lsy.pc.post.ShanghaiOppoPost;
import com.lsy.pc.service.OPPOService;
import com.lsy.pc.service.ZhiHuService;
import com.lsy.pc.utils.JsonUtils;
import com.lsy.pc.utils.ReadUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MTest {

    @Autowired
    private ZhiHuService zhiHuService;

    @Autowired
    private OPPOService oppoService;


    @Test
    public void test01() {
        ShanghaiOppoPost shanghaiOppoPost = new ShanghaiOppoPost();
        shanghaiOppoPost.checkPwd("邢小海", 10, 556000L);
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() throws IOException {
        String s = ReadUtils.readTxtFile("C:\\code\\pc\\src\\main\\resources\\txt\\json.txt");
        Gson gson = new Gson();
        ZhihuModel zhihuModel = JsonUtils.readValue(s, ZhihuModel.class);
        System.out.println(zhihuModel.getPaging().is_start());
    }


    @Test
    public void test03() throws InterruptedException, IOException {

        oppoService.checkPwd("邢小海", 3, 565555L);
        Thread.sleep(Long.MAX_VALUE);
    }


}

