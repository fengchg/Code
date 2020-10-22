package com.maro.common.finance.operatin.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.common.finance.operatin.dao.MaroCommonOperatinDao;
import com.maro.common.finance.operatin.pojo.entity.MaroOperatinEntity;
import com.maro.common.finance.operatin.service.MaroCommonOperatinServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;

@Service("maroCommonOperatinService")
@Transactional
public class MaroCommonOperatinServiceImpl extends CommonServiceImpl implements
		MaroCommonOperatinServiceI {
	@Autowired
	private MaroCommonOperatinDao maroCommonOperatinDao;

	@Override
	public MaroOperatinEntity getMaroOperatinEntityById(String operatinId) {
		// TODO Auto-generated method stub
		return (MaroOperatinEntity) this.getSession().get(MaroOperatinEntity.class, operatinId);
	}

	@Override
	public boolean updateMaroOperatinEntity(
			MaroOperatinEntity maroOperatinEntity) {
		// TODO Auto-generated method stub
		this.getSession().update(maroOperatinEntity);
		return true;
	}

	@Override
	public String addMaroOperatinEntity(String shopId, String serverOrderId) {
		// TODO Auto-generated method stub
		MaroOperatinEntity maroOperatinEntity=new MaroOperatinEntity();
		maroOperatinEntity.setShopId(shopId);
		maroOperatinEntity.setServerOrderId(serverOrderId);
		Serializable serializable = this.getSession().save(maroOperatinEntity);
		if(serializable!=null){
			return serializable.toString();
		}
		return null;
	}

}