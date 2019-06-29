/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

import java.util.List;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */
@lombok.Data
public class ZhihuModel {

    private List<Data> data;
    private Paging paging;

}