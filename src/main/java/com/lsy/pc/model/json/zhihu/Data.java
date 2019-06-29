/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */
@lombok.Data
public class Data {

    private long id;
    private String type;
    private String answer_type;
    private Question question;
    private Author author;
    private String url;
    private boolean is_collapsed;
    private long created_time;
    private long updated_time;
    private String extras;
    private boolean is_copyable;
    private boolean is_normal;
    private int voteup_count;
    private int comment_count;
    private boolean is_sticky;
    private boolean admin_closed_comment;
    private String comment_permission;
    private Can_comment can_comment;
    private String reshipment_settings;
    private String content;
    private String editable_content;
    private String excerpt;
    private String collapsed_by;
    private String collapse_reason;
    private String annotation_action;
    private Relevant_info relevant_info;
    private Suggest_edit suggest_edit;
    private Reward_info reward_info;
    private Relationship relationship;

}