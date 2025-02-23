package com.lsy.pc;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ZhiHu {
    public static void main(String[] args) {
        //请求链接
        String url = "https://www.zhihu.com/api/v4/questions/324321497/answers?" +
                "include=data[*].is_normal,admin_closed_comment,reward_info," +
                "is_collapsed,annotation_action,annotation_detail,collapse_reason," +
                "is_sticky,collapsed_by,suggest_edit,comment_count,can_comment,content," +
                "editable_content,voteup_count,reshipment_settings,comment_permission," +
                "created_time,updated_time,review_info,relevant_info,question,excerpt," +
                "relationship.is_authorized,is_author,voting,is_thanked,is_nothelp;data[*].mark_infos[*].url;" +
                "data[*].author.follower_count,badge[?(type=best_answerer)].topics&sort_by=default";
        //调用方法
        StringBuffer stringBuffer = sendGet(url, 20, 0);
        System.out.println(stringBuffer);
        //输出结果
        System.out.println(delHTMLTag(new String(stringBuffer)));
    }

    public static StringBuffer sendGet(String baseUrl, int limit, int offset) {
        //存放每次获取的返回结果
        StringBuilder responseResult = new StringBuilder();
        //读取服务器响应的流
        BufferedReader bufferedReader = null;
        //存放所有的回答内容
        StringBuffer stringBuffer = new StringBuffer();
        //每次返回的回答数
        int num = 0;
        try {
            //更改链接的limit设置每次返回的回答条数, 更改offset设置查询的起始位置
            //即上一次的limit+offset是下一次的起始位置,经过试验,每次最多只能返回20条结果
            String urlToConnect = baseUrl + "&limit=" + limit + "&offset=" + offset;
            URL url = new URL(urlToConnect);
            // 打开和URL之间的连接
            URLConnection connection = url.openConnection();
            // 设置通用的请求属性,这个在上面的请求头中可以找到
            connection.setRequestProperty("Referer", "https://www.zhihu.com/question/324321497");
            connection.setRequestProperty("origin", "https://www.zhihu.com");
//            connection.setRequestProperty("x-udid","换成自己的udid");
            connection.setRequestProperty("Cookie", "_zap=872f17cf-67d3-4839-b8dc-a5a627bcd20d; d_c0=\"AHBv-wz8nA-PTksiDdLFPl8Dau2LwLioMSI=|1561013094\"; ISSW=1; _xsrf=FsPYYbXZUr4GI0m5i9fUpK8jZOOLEPNM; z_c0=\"2|1:0|10:1561099322|4:z_c0|92:Mi4xT0htWUJnQUFBQUFBY0dfN0RQeWNEeVlBQUFCZ0FsVk5Pc3I1WFFES2M0Smh6TmZCS2NBc2ZLTm13TmdUY2N1cnh3|b3969873314beb82f0a6799b251c52ff1071e53e09e065802f62f73bbabf1b50\"; capsion_ticket=\"2|1:0|10:1561099323|14:capsion_ticket|44:NjBmMzk1NTk4Nzg5NGYxYTkyZDQ5MGQ0ZTE1YTMwMjI=|bf086dc430f7a00e288f1ac3b8644b84bbea67862299e3f97f52d8a5ed14549a\"; tst=r; q_c1=019c8f9865f447efb48742a34b222a97|1561099324000|1561099324000; __gads=ID=f424858fee47c626:T=1561099326:S=ALNI_MYN7-b6lzUMn_hChIdeafkXlr5PDw; tgw_l7_route=7c109f36fa4ce25acb5a9cf43b0b6415");
            connection.setRequestProperty("accept", "application/json, text/plain, */*");
//            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Host", "www.zhihu.com");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                responseResult.append(line);
            }
            //将返回结果转成map
            Gson gson = new Gson();
            Map<String, Object> map = new HashMap<>();
            map = gson.fromJson(responseResult.toString(), map.getClass());
            //获取page信息
            LinkedTreeMap<String, Object> pageList = (LinkedTreeMap<String, Object>) map.get("paging");
            //得到总条数
            double totals = (Double) pageList.get("totals");
            //等于0 说明查询的是最后不足20条的回答
            if (totals - (limit + offset) != 0) {
                //如果每页的页数加上起始位置与总条数的差大于20, 可以递归查找下一个20条内容
                if (totals - (limit + offset) > 20) {
                    //追加返回结果
                    stringBuffer.append(sendGet(baseUrl, 20, limit + offset));
//                     stringBuffer.append("\r\n");//换行,调整格式

                } else {
                    //如果不大于20,说明是最后的几条了,这时需要修改limit的值
                    stringBuffer.append(sendGet(baseUrl, (int) (totals - (limit + offset)), limit + offset));
//                    stringBuffer.append("\r\n");
                }
            }
            //获得包含回答的数组
            ArrayList<LinkedTreeMap<String, String>> dataList = (ArrayList<LinkedTreeMap<String, String>>) map.get("data");
            //追加每一条回答,用于返回
            for (LinkedTreeMap<String, String> contentLink : dataList) {
                String content = contentLink.get("content");
                stringBuffer.append(content).append("\r\n\r\n");
                num++;//本次查询到多少条回答
            }
            System.out.println("回答数  " + num);
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //返回本次查到的所有回答
        return stringBuffer;
    }

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    /**
     * @param htmlStr
     * @return 删除Html标签
     */
    public static String delHTMLTag(String htmlStr) {
        System.out.println(htmlStr);
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr; // 返回文本字符串
    }
}