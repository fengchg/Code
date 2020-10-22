package com.maro.client.module.user.service;

import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.platform.core.common.model.json.AjaxJson;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {

    public AjaxJson login(HttpServletRequest req, String user, String pass);

    public MaroShopEntity getShop();

    public int getShopNum();

    /**
     * 从字典code=maro_shift中获取班次信息
     * @return
     */
    public Map getShift();
}
