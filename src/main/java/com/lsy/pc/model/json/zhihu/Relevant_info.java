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
public class Relevant_info {

    private boolean is_relevant;
    private String relevant_type;
    private String relevant_text;

}