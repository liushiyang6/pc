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
public class Reward_info {

    private boolean can_open_reward;
    private boolean is_rewardable;
    private int reward_member_count;
    private int reward_total_money;
    private String tagline;

}