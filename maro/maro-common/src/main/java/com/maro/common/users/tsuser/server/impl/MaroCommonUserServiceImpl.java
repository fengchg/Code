package com.maro.common.users.tsuser.server.impl;

import com.maro.common.shop.dao.MaroCommonShopDao;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.users.tsuser.dao.MaroCommonUserServiceDao;
import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.common.users.tsuser.server.MaroCommonUserService;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import com.maro.platform.core.util.PasswordUtil;
import com.maro.platform.web.system.pojo.base.TSDepart;
import com.maro.platform.web.system.pojo.base.TSUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("maroCommonUserService")
@Transactional
public class MaroCommonUserServiceImpl extends CommonServiceImpl implements MaroCommonUserService{

	@Autowired
	MaroCommonUserServiceDao userServiceDao;
	@Autowired
	private MaroCommonShopDao maroCommonShopDao;

    private Logger logger = Logger.getLogger(MaroCommonUserServiceImpl.class);
	@Override
	public UserInfoVO clientLogin(String userName, String passWord) {
		//密码加密
		passWord=PasswordUtil.encrypt(userName,passWord, PasswordUtil.getStaticSalt());
		logger.error(userName+"--------"+passWord);
		logger.error(userName+"--------"+passWord);
		//获取用户的详细信息
		UserInfoVO user=userServiceDao.getUserInfo(userName,passWord);
		if(user!=null){
			//获取当前用户所属当前部门
			List<TSDepart> currentDepart = userServiceDao.getCurrentDepart(user.getId());
			if(currentDepart!=null&&currentDepart.size()!=0){
				user.setCurrentDepart(currentDepart.get(0));
			}
			//获取当前用户所属上级部门
			TSDepart parentDepart = userServiceDao.getParentDepart(user.getId());
			user.setParentDepart(parentDepart);
			//获取用户所属店铺
			MaroShopEntity maroShopEntity = maroCommonShopDao.getMaroShopByDepartId(user.getCurrentDepart().getId());
			user.setMaroShopEntity(maroShopEntity);
		}
		return user;
	}
	
	@Override
	public List<TSUser> tsUserList(String departId) {
		return userServiceDao.tsUserList(departId);
	}

	@Override
	public List<Map> getIsLogin(String shiftCode, String userId) {
		return userServiceDao.getIsLogin(shiftCode,userId);
	}

	@Override
	public void addShift(String shiftCode, String userId) {
		userServiceDao.addShift(shiftCode,userId);
	}

}
