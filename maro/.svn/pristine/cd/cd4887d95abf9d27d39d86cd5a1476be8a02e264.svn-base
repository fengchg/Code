package com.maro.client.module.user.controller.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.module.user.controller.UserController;
import com.maro.client.module.user.service.UserService;
import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.common.users.tsuser.server.MaroCommonUserService;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户模块的控制器实现类
 * @author 冯成果
 * @date 2018-4-11
 * @since 版本号 01.00.0001
*/
@Controller
@RequestMapping("/clientUserController")
public class UserControllerImpl implements UserController {

    @Resource(name="clientUserServiceImpl")
    private UserService userService;
    @Resource
    private MaroCommonUserService maroCommonUserService;

    @Override
    @RequestMapping(params = "login")
    @ResponseBody
    public AjaxJson login(HttpServletRequest req,String user, String pass) {
        return userService.login(req,user,pass);
    }

    @Override
    @RequestMapping(params = "tsUserList")
    @ResponseBody
    public AjaxJson listUser() {
        UserInfoVO sessionUser = (UserInfoVO) ResourceUtil.getSessionUser();
        String departId = sessionUser.getCurrentDepart().getId();
        List<TSUser> tsUsers = maroCommonUserService.tsUserList(departId);
        AjaxJson ajaxJson = new AjaxJson();
        if(null != tsUsers){
            Map<String,Object> map = new HashMap<>();
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            ajaxJson.setSuccess(true);
            ajaxJson.setObj(tsUsers);
        }else{
            ajaxJson.setMsg(StringConstant.TIP_FAIL);
            ajaxJson.setSuccess(false);
        }
        return ajaxJson;
    }

}
