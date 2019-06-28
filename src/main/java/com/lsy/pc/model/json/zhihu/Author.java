/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */


@Getter
@Setter
@ToString
public class Author {

    private String id;
    private String url_token;
    private String name;
    private String avatar_url;
    private String avatar_url_template;
    private boolean is_org;
    private String type;
    private String url;
    private String user_type;
    private String headline;
    private List<String> badge;
    private int gender;
    private boolean is_advertiser;
    private boolean is_followed;
    private boolean is_privacy;

}