package com.maro.client.module.user.controller;

import com.maro.platform.core.common.model.json.AjaxJson;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户模块的控制器，提供接口给对应的JSP页面
 * @author 冯成果
 * @date 2018-4-11
 * @since 版本号 01.00.0001
 */
public interface UserController {
    /**
     * 登录接口
     * @param user：用户名
     * @param pass：密码
     * @return AjaxJson：登录结果信息
     * @throws
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本 由【冯成果】于【2018-04-11】进行添加
     */
    AjaxJson login(HttpServletRequest req, String user, String pass);
    AjaxJson listUser();
}
