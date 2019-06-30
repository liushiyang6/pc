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
import java.util.Objects;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/29 14:21
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

    private static int count = 0;

    /**
     * 传入问题id 输出所有答案对应数据
     */
    public void getAnswers(String questionId, int offset) {
        logger.info("开始爬取知乎questionId:{}对应数据===>", questionId);
        getAn(questionId, offset);
        logger.info("共计：{}回答数", count);
    }

    private void getAn(String questionId, int offset) {
        String url = "https://www.zhihu.com/api/v4/questions/{0}/answers?include={1}&sort_by={2}&limit={3}";
        url = MessageFormat.format(url, questionId, include, sortBy, limit);
        url += getOffset( offset);
        ResponseEntity<ZhihuModel> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(url, ZhihuModel.class);
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("questionId:[{}]对应无数据!", questionId);
            throw new RuntimeException("问题号有误");
        } catch (Exception e) {
            throw new RuntimeException("爬取异常", e);
        }
        ZhihuModel body = responseEntity.getBody();
        List<Data> dataList = Objects.requireNonNull(body).getData();
        dataList.forEach(data -> {
            if (data.getContent().contains("上饶") && data.getContent().contains("女")) {
                count++;
                logger.info("作者:{}", HTMLUtils.delHTMLTag(data.getAuthor().getName()));
                logger.info("内容:{}", HTMLUtils.delHTMLTag(data.getContent()));
            }
        });
        if (!body.getPaging().is_end()) {
            getAn(questionId, offset + Integer.valueOf(limit));
        }
    }

    private static String getOffset(int i) {
        return "&offset=" + i;
    }

}
