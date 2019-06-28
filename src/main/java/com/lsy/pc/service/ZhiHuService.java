package com.lsy.pc.service;


import com.lsy.pc.model.json.zhihu.Data;
import com.lsy.pc.model.json.zhihu.ZhihuModel;
import com.lsy.pc.utils.HTMLUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.List;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:21
 */
@Service
public class ZhiHuService {

    @Value("${zhihu.url.include}")
    private String include;

    @Value("${zhihu.url.sort_by}")
    private String sortBy;

    @Value("${zhihu.url.maxLimit}")
    private String limit;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 传入问题id 返回所有答案对应数据
     */
    public void getAnswers(String questionId) {
        logger.info("开始爬取知乎questionId:{}对应数据===>", questionId);
        String url = "https://www.zhihu.com/api/v4/questions/{0}/answers?include={1}&sort_by={2}&limit={3}";
        url = MessageFormat.format(url, questionId, include, sortBy, limit);
        url += getOffset(url, 0);
        logger.info("url:{}", url);
        ResponseEntity<ZhihuModel> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity(url, ZhihuModel.class);
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("questionId:[{}]对应无数据!", questionId);
            throw new RuntimeException("问题号有误");
        } catch (Exception e) {
            throw new RuntimeException("爬取异常", e);
        }
        List<Data> data = responseEntity.getBody().getData();
        data.forEach(data1 -> {
            System.out.println("作者" + HTMLUtils.delHTMLTag(data1.getAuthor().getName()));
            System.out.println("内容" + HTMLUtils.delHTMLTag(data1.getContent()));
            System.out.println();
        });
        System.out.println(responseEntity);
    }

    private static String getOffset(String url, int i) {
        return "&offset=" + i;
    }

}
