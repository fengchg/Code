package com.maro.manager.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MemberCardApi;
import com.maro.common.users.member.pojo.vo.MaroCommonMemberEntity;
import com.maro.common.users.member.server.MaroCommonMemberServiceI;
import com.maro.manager.users.member.service.MaroMemberServiceI;
import com.maro.platform.core.common.controller.BaseController;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.StringUtil;


/**   
 * @Title: Controller
 * @Description: 会员
 * @author onlineGenerator
 * @date 2018-08-28 15:57:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/maroWeixinActiveController")
public class MaroWeixinActiveController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MaroWeixinActiveController.class);

	@Autowired
	private MaroMemberServiceI maroMemberService;
	@Autowired
	private MaroCommonMemberServiceI memberCommonService;

	/**
	 * 获取全部的列表
	 *
	 * @return
	 */
	@RequestMapping(params = "active")
	@ResponseBody
	public AjaxJson active(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String openid=request.getParameter("openid");
		String encrypt_code=request.getParameter("encrypt_code");
		String phone = request.getParameter("phone");
		MaroCommonMemberEntity maroCommonMemberEntity = memberCommonService.getByPohne(phone);
		if(maroCommonMemberEntity==null||StringUtil.isEmpty(maroCommonMemberEntity.getWeixin())){
			j.setSuccess(false);
			j.setMsg("请检查手机号是否正确，或是否已绑定其他微信！");
			return j;
		}
		String jsonStr="{\n" +
				"    \"init_bonus\": "+maroCommonMemberEntity.getMemberPoints()+",\n" +
				"    \"init_bonus_record\":\"积分已同步\",\n" +
				"    \"init_balance\": "+maroCommonMemberEntity.getBalance()+",\n" +
				"    \"membership_number\": \""+maroCommonMemberEntity.getCard()+"\",\n" +
				"    \"code\": \""+encrypt_code+"\"\n" +
				"}";
		ApiResult r = MemberCardApi.activate(jsonStr);
		if(r.isSucceed()) {
			maroCommonMemberEntity.setWeixin(openid);
			maroMemberService.saveOrUpdate(maroCommonMemberEntity);
			j.setMsg("绑定成功！");
			return j;
		}else{
			j.setSuccess(false);
			j.setMsg("激活失败，请重试或请与管理员管理！");
			return j;
		}
	}
}
