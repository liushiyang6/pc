/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

import lombok.Data;

import java.util.List;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */
@Data
public class Relationship {

    private boolean is_author;
    private boolean is_authorized;
    private boolean is_nothelp;
    private boolean is_thanked;
    private int voting;
    private List<String> upvoted_followees;

}