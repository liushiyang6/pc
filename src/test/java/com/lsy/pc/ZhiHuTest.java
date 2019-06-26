package com.lsy.pc;


import com.google.common.collect.Maps;
import com.lsy.pc.model.Data;
import com.lsy.pc.model.ZhihuModel;
import com.lsy.pc.utils.JsonUtils;
import net.minidev.json.JSONUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhiHuTest {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void Test01() {
        Connection connect = Jsoup.connect("https://www.zhihu.com/api/v4/questions/47581654/answers?include=data%5B%2A%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cis_labeled%2Cis_recognized%2Cpaid_info%3Bdata%5B%2A%5D.mark_infos%5B%2A%5D.url%3Bdata%5B%2A%5D.author.follower_count%2Cbadge%5B%2A%5D.topics&limit=5&offset=8&platform=desktop&sort_by=default");
        HashMap<String, String> cookies = new HashMap<>();
        cookies.put("_zap", "872f17cf-67d3-4839-b8dc-a5a627bcd20d");
        cookies.put("d_c0", "AHBv-wz8nA-PTksiDdLFPl8Dau2LwLioMSI=|1561013094");
        cookies.put("_xsrf", "FsPYYbXZUr4GI0m5i9fUpK8jZOOLEPNM");
        cookies.put("ISSW", "1");
        cookies.put("z_c0", "2|1:0|10:1561099322|4:z_c0|92:Mi4xT0htWUJnQUFBQUFBY0dfN0RQeWNEeVlBQUFCZ0FsVk5Pc3I1WFFES2M0Smh6TmZCS2NBc2ZLTm13TmdUY2N1cnh3|b3969873314beb82f0a6799b251c52ff1071e53e09e065802f62f73bbabf1b50");
        cookies.put("capsion_ticket", "2|1:0|10:1561099323|14:capsion_ticket|44:NjBmMzk1NTk4Nzg5NGYxYTkyZDQ5MGQ0ZTE1YTMwMjI=|bf086dc430f7a00e288f1ac3b8644b84bbea67862299e3f97f52d8a5ed14549a");
        cookies.put("tst", "r");
        cookies.put("q_c1", "019c8f9865f447efb48742a34b222a97|1561099324000|1561099324000");
        cookies.put("__gads", "ID=f424858fee47c626:T=1561099326:S=ALNI_MYN7-b6lzUMn_hChIdeafkXlr5PDw");
        cookies.put("tgw_l7_route", "7bacb9af7224ed68945ce419f4dea76d");
        HashMap<String, String> headers = new HashMap<>();
        headers.put("upgrade-insecure-requests", "1");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");

        Document document = null;
        try {
            document = connect.cookies(cookies).headers(headers).post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(document.title());
        Elements pElements = document.select("p");
        for (Element pElement : pElements) {
            System.out.println(pElement);
            System.out.println("\r");
        }
    }

    @Test
    public void test02() throws IOException {
        String url = "https://www.zhihu.com/api/v4/questions/27205559/answers?include=data%5B*%5D.is_normal%2Cadmin_closed_comment%2Creward_info%2Cis_collapsed%2Cannotation_action%2Cannotation_detail%2Ccollapse_reason%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Ccreated_time%2Cupdated_time%2Creview_info%2Crelevant_info%2Cquestion%2Cexcerpt%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cis_labeled%2Cis_recognized%2Cpaid_info%3Bdata%5B*%5D.mark_infos%5B*%5D.url%3Bdata%5B*%5D.author.follower_count%2Cbadge%5B*%5D.topics&offset=3&limit=5&sort_by=default&platform=desktop";
        HashMap<String, String> parms = Maps.newHashMap();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.GET, null, Map.class);
//        System.out.println(exchange.getBody().get());
    }
}
