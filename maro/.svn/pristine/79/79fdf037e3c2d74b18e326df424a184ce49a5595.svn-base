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
     * @param shiftCode：值班code
     * @return AjaxJson：登录结果信息
     * @throws
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本 由【冯成果】于【2018-04-11】进行添加
     */
    AjaxJson login(HttpServletRequest req, String user, String pass,String shiftCode);
    AjaxJson listUser();
    /**
     * 获取数据库中的店铺个数
     * @return AjaxJson：获取数据库中的店铺个数
     * @throws
     * @author 龚道海
     * @since 版本号 01.00.0001
     * @version 版本 由【龚道海】于【2018-09-13】进行添加
     */
    AjaxJson isInit();
    /**
     * 获取班次信息
     * @return AjaxJson：班次信息
     * @throws
     * @author 龚道海
     * @since 版本号 01.00.0001
     * @version 版本 由【龚道海】于【2018-09-13】进行添加
     */
    AjaxJson getShift();
    /**
     * 查看班次的营业流水信息
     * @return AjaxJson
     * @throws
     * @author 龚道海
     * @since 版本号 01.00.0001
     * @version 版本 由【龚道海】于【2018-09-13】进行添加
     */
    AjaxJson getShiftInfo(HttpServletRequest req);
    /**
     * 确认换班，打印营业流水信息
     * @return AjaxJson：确认换班
     * @throws
     * @author 龚道海
     * @since 版本号 01.00.0001
     * @version 版本 由【龚道海】于【2018-09-13】进行添加
     */
    AjaxJson confirmShift(HttpServletRequest req);
}
