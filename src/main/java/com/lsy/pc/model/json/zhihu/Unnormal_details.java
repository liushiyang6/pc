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
public class Unnormal_details {
    private String status;
    private String description;
    private String reason;
    private int reason_id;
    private String note;
}