package com.maro.client.module.user.service.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.module.user.service.UserService;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.common.users.tsuser.server.MaroCommonUserService;
import com.maro.common.util.CacheManager;
import com.maro.common.util.entity.Cache;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.constant.Globals;
import com.maro.platform.core.util.ContextHolderUtils;
import com.maro.platform.core.util.IpUtil;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.system.manager.ClientManager;
import com.maro.platform.web.system.pojo.base.Client;
import com.maro.platform.web.system.pojo.base.TSType;
import com.maro.platform.web.system.pojo.base.TSUser;
import com.maro.platform.web.system.service.MutiLangServiceI;
import com.maro.platform.web.system.service.SystemService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service("clientUserServiceImpl")
public class UserServiceImpl extends CommonServiceImpl implements UserService {

    @Resource
    private SystemService systemService;
    @Resource
    private MutiLangServiceI mutiLangService;
    @Resource
    private MaroCommonUserService maroCommonUserService;

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    public AjaxJson login(HttpServletRequest req, String user, String pass){
        AjaxJson ajaxJson = new AjaxJson();
        if(user == null || pass == null){
            ajaxJson.setMsg(StringConstant.TIP_LOGIN_USER_OR_PASS_IS_NULL);
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }
        logger.error(user+"------"+pass);
        UserInfoVO userInfoVO = maroCommonUserService.clientLogin(user, pass);
        logger.error("userInfoVO:"+userInfoVO);
        if(null != userInfoVO){
            //保存班次信息
            saveShiftInfo(req,userInfoVO);
            saveLoginSuccessInfo(req,userInfoVO);
            Map<String,Object> map = new HashMap<>();
            map.put("sessionId",req.getSession().getId());
            ajaxJson.setAttributes(map);
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            ajaxJson.setSuccess(true);
            ajaxJson.setObj(userInfoVO);
        }else{
            ajaxJson.setMsg(StringConstant.TIP_FAIL);
            ajaxJson.setSuccess(false);
        }
        return ajaxJson;
    }

    /**
     * 在maro_client_shift表中保存班次信息
     * @param req
     * @param userInfoVO
     */
    private void saveShiftInfo(HttpServletRequest req, UserInfoVO userInfoVO) {
        String shiftCode = req.getSession().getAttribute("shiftCode")==null?null:req.getSession().getAttribute("shiftCode").toString();
        if(shiftCode!=null){
            String userId=userInfoVO.getId();
            //获取记录数
            List<Map> map=maroCommonUserService.getIsLogin(shiftCode,userId);
            if(map==null||map.size()==0){
                //增加新记录
                maroCommonUserService.addShift(shiftCode,userId);
            }
        }
    }


    /**
     * 保存用户登录的信息，并将当前登录用户的组织机构赋值到用户实体中；
     * @param req request
     * @param user 当前登录用户
     * @param orgId 组织主键
     */
    private void saveLoginSuccessInfo(HttpServletRequest req, TSUser user) {
        String message = null;
        HttpSession session = ContextHolderUtils.getSession();
//        TSDepart currentDepart = systemService.get(TSDepart.class, orgId);
//        user.setCurrentDepart(currentDepart);
//
//
//        user.setDepartid(orgId);

        session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
        message = mutiLangService.getLang("common.user") + ": " + user.getUserName() + "["+ user.getCurrentDepart().getDepartname() + "]" + mutiLangService.getLang("common.login.success");

//        String browserType = "";
//        Cookie[] cookies = req.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            Cookie cookie = cookies[i];
//            if("BROWSER_TYPE".equals(cookie.getName())){
//                browserType = cookie.getValue();
//            }
//        }
//        session.setAttribute("brower_type", browserType);

        //当前session为空 或者 当前session的用户信息与刚输入的用户信息一致时，则更新Client信息
        Client clientOld = ClientManager.getInstance().getClient(session.getId());
        if(clientOld == null || clientOld.getUser() ==null ||user.getUserName().equals(clientOld.getUser().getUserName())){
            Client client = new Client();
            client.setIp(IpUtil.getIpAddr(req));
            client.setLogindatetime(new Date());
            client.setUser(user);
            ClientManager.getInstance().addClinet(session.getId(), client);
        } else {//如果不一致，则注销session并通过session=req.getSession(true)初始化session
            ClientManager.getInstance().removeClinet(session.getId());
            session.invalidate();
            session = req.getSession(true);//session初始化
            session.setAttribute(ResourceUtil.LOCAL_CLINET_USER, user);
            session.setAttribute("randCode",req.getParameter("randCode"));//保存验证码
//            checkuser(user,req);
        }
        // 添加登陆日志
        systemService.addLog(message, Globals.Log_Type_LOGIN, Globals.Log_Leavel_INFO);
    }

    public MaroShopEntity getShop(){
        MaroShopEntity maroShopEntity = new MaroShopEntity();
//        maroShopEntity.setId("8a8a8bfa62cc3d350162cc58d1390005");
//        maroShopEntity.setDepartId("8a8a8bf861cb71340161cb7941c4000b");
//        maroShopEntity.setName("白云店");

        //获取店铺对象

        //如果缓存里有数据
        if(CacheManager.hasCache("maroShopEntity")){
            Cache c = CacheManager.getCache("maroShopEntity");
            maroShopEntity = (MaroShopEntity)c.getValue();
        }else{
            maroShopEntity = super.loadAll(MaroShopEntity.class).get(0);
            Cache c = new Cache();
            c.setKey("shop");
            c.setValue(maroShopEntity);
            CacheManager.putCache("maroShopEntity",c);
        }

        return maroShopEntity;
    }

    @Override
    public int getShopNum() {
        List<Object> list = systemService.getList(MaroShopEntity.class);
        return list.size();
    }

    @Override
    public Map getShift() {
        Map map=new TreeMap();
        List<TSType> list = ResourceUtil.allTypes.get("maro_shift");
        if(list!=null&&list.size()>0){
            for(TSType t:list){
                map.put(t.getTypecode(),t.getTypename());
            }
        }
        return map;
    }

}
