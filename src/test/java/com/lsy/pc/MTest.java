package com.lsy.pc;

import com.google.gson.Gson;
import com.lsy.pc.model.json.zhihu.ZhihuModel;
import com.lsy.pc.service.OPPOService;
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

    @Autowired
    private OPPOService oppoService;


    @Test
    public void test01() {
        zhiHuService.getAnswers("310213933", 0);

    }

    @Test
    public void test02() throws IOException {
        String s = ReadUtils.readTxtFile("C:\\code\\pc\\src\\main\\resources\\txt\\json.txt");
        Gson gson = new Gson();
        ZhihuModel zhihuModel = JsonUtils.readValue(s, ZhihuModel.class);
        System.out.println(zhihuModel.getPaging().is_start());
    }


    @Test
    public void test03() throws InterruptedException {
        dT t1 = new dT();

        t1.start();


        Thread.sleep(Long.MAX_VALUE);
    }


//    class tt implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println("ewewq");
//            Long l = 1000L;
//            while (l.toString().length() < 11) {
//                oppoService.checkPwd("宋玲玲", l, 11);
//                l++;
//            }
//            System.out.println("ewewq");
//        }
//    }

    public class dT extends Thread {

        private Long l;

        public Long getI() {
            return l;
        }

        public void setI(Long l) {
            this.l = l;
        }

        @Override
        public void run() {
            oppoService.checkPwd("宋玲玲", "");
            l++;
        }
    }
}

