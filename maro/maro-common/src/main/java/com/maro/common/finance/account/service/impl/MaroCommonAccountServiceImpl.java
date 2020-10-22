package com.maro.common.finance.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.finance.account.dao.MaroCommonAccountDao;
import com.maro.common.finance.account.pojo.entity.MaroAccountEntity;
import com.maro.common.finance.account.service.MaroCommonAccountServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;

@Service("maroCommonAccountService")
@Transactional
public class MaroCommonAccountServiceImpl extends CommonServiceImpl implements
		MaroCommonAccountServiceI {
	@Autowired
	private MaroCommonAccountDao maroCommonAccountDao;

	@Override
	public List<MaroAccountEntity> listAccount() {
		// TODO Auto-generated method stub
		List<MaroAccountEntity> maroAccountEntitys=maroCommonAccountDao.listAccount();
		if(maroAccountEntitys!=null&&maroAccountEntitys.size()>0){
			return maroAccountEntitys;
		}
		return null;
	}

	@Override
	public MaroAccountEntity getAccount(String shopId) {
		// TODO Auto-generated method stub
		return maroCommonAccountDao.getAccount(shopId);
	}

	@Override
	public boolean addMoney(String shopId, String money) {
		// TODO Auto-generated method stub
		int num=maroCommonAccountDao.addMoney(shopId,money);
		return num==1?true:false;
	}

	@Override
	public boolean minusMoney(String shopId, String money) {
		// TODO Auto-generated method stub
		int num=maroCommonAccountDao.minusMoney(shopId,money);
		return num==1?true:false;
	}

	@Override
	public boolean updateMoney(MaroAccountEntity maroAccountEntity) {
		// TODO Auto-generated method stub
		this.getSession().update(maroAccountEntity);
		return true;
	}
}