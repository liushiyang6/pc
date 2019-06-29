package com.lsy.pc;

import com.google.gson.Gson;
import com.lsy.pc.model.json.zhihu.ZhihuModel;
import com.lsy.pc.service.ZhiHuService;
import com.lsy.pc.utils.JsonUtils;
import com.lsy.pc.utils.ReadUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


    @Test
    public void test01() {
        zhiHuService.getAnswers("310213933",0);

    }

    @Test
    public void test02() throws IOException {
        String s = ReadUtils.readTxtFile("C:\\code\\pc\\src\\main\\resources\\txt\\json.txt");
        Gson gson = new Gson();
        ZhihuModel zhihuModel = JsonUtils.readValue(s, ZhihuModel.class);
        System.out.println(zhihuModel.getPaging().is_start());
    }
}
