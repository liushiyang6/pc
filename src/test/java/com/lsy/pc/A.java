package com.lsy.pc;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.example.ZhihuPageProcessor;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 16:49
 */
public class A {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    public static void main(String[] args) {
        Spider.create(new ZhihuPageProcessor()).addUrl("https://www.zhihu.com/question/324321497").thread(5).run();

    }
}
