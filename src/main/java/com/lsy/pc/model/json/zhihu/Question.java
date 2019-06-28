/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

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
public class Question {

    private String type;
    private long id;
    private String title;
    private String question_type;
    private long created;
    private long updated_time;
    private String url;
    private Relationship relationship;

}