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
public class Unnormal_details {

    private String status;
    private String description;
    private String reason;
    private int reason_id;
    private String note;

}