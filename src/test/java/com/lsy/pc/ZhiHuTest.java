package com.lsy.pc;


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
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-ab-param", "se_rr=1;se_webrs=1;ug_zero_follow_0=0;zr_km_slot_style=event_card;li_tjys_ec_ab=0;ls_videoad=0;se_page_limit_20=1;se_webtimebox=1;se_ltr_v008=0;se_wannasearch=0;top_v_album=1;tp_header_style=1;ug_follow_topic_1=2;se_amovietab=1;se_movietab=1;top_rank=0;li_price_test=1;pf_creator_card=1;se_billboardsearch=0;se_payconsult=5;se_waterfall=0;ug_goodcomment_0=1;soc_bigone=1;ug_follow_answerer_0=0;ug_goodcomment=0;pf_feed=1;se_spb309=0;se_websearch=3;zr_ans_rec=gbrank;se_ios_spb309=1;tp_qa_metacard_top=top;tp_qa_toast=1;li_hot_score_ab=0;li_se_ebook_chapter=1;li_ts_sample=old;se_webmajorob=0;top_root=0;tp_sft=a;tsp_lastread=0;zr_art_rec=base;zr_km_style=base;li_mceb=1;se_featured=1;se_mobileweb=0;se_zu_onebox=0;top_ebook=0;ls_fmp4=0;pf_fuceng=1;se_bl=0;se_limit=0;se_new_topic=0;li_ebook_detail=2;pf_newguide_vertical=0;se_ad_index=10;top_new_feed=2;top_quality=0;se_timebox_num=3;top_hotcommerce=1;li_qa_cover=old;se_pyc_click2=2;se_site_onebox=0;se_topicdirect=2;tp_sft_v2= a;top_recall_exp_v1=10;top_vipconsume=1;top_ydyq=A;zr_se_footer=1;zr_video_rank=current_rank;li_qa_new_cover=3;se_college_cm=0;top_reason=3;ug_zero_follow=0;li_album3_ab=0;se_whitelist=1;pf_noti_entry_num=0;top_gr_ab=2;zr_video_recall=current_recall;ls_new_upload=1;se_time_threshold=0;li_auif_ab=1;se_college=default;top_recall_exp_v2=1;tsp_hotctr=2;zr_ebook_chapter=1;se_expired_ob=0;se_search_feed=N;se_terminate=0;top_test_4_liguangyi=1;tsp_childbillboard=2;zr_km_xgb_model=old;pf_foltopic_usernum=50;qa_test=0;se_colorfultab=1;se_backsearch=0;se_ltr_v002=1;se_ri=0;se_title_only=0;soc_update=0;tp_m_intro_re_topic=1;zr_infinity_xgb=top3;se_topic_express=1;zr_album_exp=0;zr_km_answer=open_cvr;se_likebutton=0;qa_answerlist_ad=0;se_preset_tech=0;se_p_slideshow=0;se_auto_syn=0;se_payconsult_click=0;ug_follow_answerer=0;se_time_score=1;se_topic_pu=0;soc_special=0;ug_fw_answ_aut_1=0;li_album_liutongab=0;se_zu_recommend=0;soc_bignew=1;zr_album_chapter_exp=0;zr_es_update=0;zr_rel_search=base;se_agency= 0;se_famous=1;se_km_ad_locate=1;se_lottery=0;se_pay_score=0;top_native_answer=6;top_recall_deep_user=1;top_universalebook=1;tp_qa_metacard=1;se_subtext=1;tp_meta_card=0;ug_newtag=1");
        headers.add("x-requested-with", "fetch");
        headers.add("referer", "https://www.zhihu.com/question/27205559");
        headers.add("accept", "*/*");
        headers.add("accept-encoding", "UTF-8");
        headers.add("cookie", "_zap=872f17cf-67d3-4839-b8dc-a5a627bcd20d; d_c0=\"AHBv-wz8nA-PTksiDdLFPl8Dau2LwLioMSI=|1561013094\"; ISSW=1; _xsrf=FsPYYbXZUr4GI0m5i9fUpK8jZOOLEPNM; z_c0=\"2|1:0|10:1561099322|4:z_c0|92:Mi4xT0htWUJnQUFBQUFBY0dfN0RQeWNEeVlBQUFCZ0FsVk5Pc3I1WFFES2M0Smh6TmZCS2NBc2ZLTm13TmdUY2N1cnh3|b3969873314beb82f0a6799b251c52ff1071e53e09e065802f62f73bbabf1b50\"; capsion_ticket=\"2|1:0|10:1561099323|14:capsion_ticket|44:NjBmMzk1NTk4Nzg5NGYxYTkyZDQ5MGQ0ZTE1YTMwMjI=|bf086dc430f7a00e288f1ac3b8644b84bbea67862299e3f97f52d8a5ed14549a\"; tst=r; q_c1=019c8f9865f447efb48742a34b222a97|1561099324000|1561099324000; __gads=ID=f424858fee47c626:T=1561099326:S=ALNI_MYN7-b6lzUMn_hChIdeafkXlr5PDw; tgw_l7_route=7c109f36fa4ce25acb5a9cf43b0b6415");
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("include", "data[*].is_normal,admin_closed_comment,reward_info,is_collapsed,annotation_action,annotation_detail,collapse_reason,is_sticky,collapsed_by,suggest_edit,comment_count,can_comment,content,editable_content,voteup_count,reshipment_settings,comment_permission,created_time,updated_time,review_info,relevant_info,question,excerpt,relationship.is_authorized,is_author,voting,is_thanked,is_nothelp,is_labeled,is_recognized,paid_info;data[*].mark_infos[*].url;data[*].author.follower_count,badge[*].topics");
        params.add("offset", "3");
        params.add("limit", "5");
        params.add("sort_by", "default");
        params.add("platform", "desktop");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Map.class);
        System.out.println(exchange);
//        System.out.println(exchange.getBody().get());
    }
}
