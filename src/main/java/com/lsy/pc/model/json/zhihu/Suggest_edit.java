/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

import lombok.Data;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */
@Data
public class Suggest_edit {

    private String reason;
    private boolean status;
    private String tip;
    private String title;
    private Unnormal_details unnormal_details;
    private String url;

}