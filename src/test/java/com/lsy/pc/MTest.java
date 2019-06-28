package com.lsy.pc;

import com.lsy.pc.service.ZhiHuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        zhiHuService.getAnswers("324321497");

    }
}
