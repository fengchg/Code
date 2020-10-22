package com.maro.client.module.reserve.pojo.vo;

import com.maro.client.module.reserve.pojo.entity.MaroClientReserveSeatDO;
import com.maro.platform.core.util.DateUtils;

public class MaroClientReserveSeatVO extends MaroClientReserveSeatDO {
    /*
     * 发生时间字符串表示
     */
    private String happenTimeString;

    public String getHappenTimeString() {
        if(happenTime != null) {
            happenTimeString = DateUtils.formatDate(happenTime);
        }
        return happenTimeString;
    }


}
