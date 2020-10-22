package com.maro.common.shop.service.impl;

import com.maro.common.shop.dao.MaroCommonShopDao;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.service.MaroCommonShopServiceI;
import com.maro.common.util.Util;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("maroCommonShopService")
@Transactional
public class MaroCommonShopServiceImpl extends CommonServiceImpl implements
		MaroCommonShopServiceI {
	@Autowired
	private MaroCommonShopDao maroCommonShopDao;

	@Override
	public List<MaroShopSeatEntity> listShopSeatInfoByShopId(String shopId) {
		// TODO Auto-generated method stub
		List<MaroShopSeatEntity> maroShopSeatEntitys = maroCommonShopDao
				.listShopSeatInfoByShopId(shopId);
		if (maroShopSeatEntitys != null && maroShopSeatEntitys.size() > 0) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("type", "maro_seat_type");
			Util.getRealValue(maroShopSeatEntitys, map);
			/*for(MaroShopSeatEntity m:maroShopSeatEntitys){
				m.setTypeString(Util.getValueFromTypeByTypeCodeAndKey("maro_seat_type", String.valueOf(m.getType())));
			}*/
			return maroShopSeatEntitys;
		}
		return null;
	}
	
	@Override
	public List<MaroShopSeatEntity> listShopSeatInfoByDepartId(String departId) {
		// TODO Auto-generated method stub
		List<MaroShopSeatEntity> maroShopSeatEntitys = maroCommonShopDao
				.listShopSeatInfoByDepartId(departId);
		if (maroShopSeatEntitys != null && maroShopSeatEntitys.size() > 0) {
			for(MaroShopSeatEntity m:maroShopSeatEntitys){
				m.setTypeString(Util.getValueFromTypeByTypeCodeAndKey("maro_seat_type", String.valueOf(m.getType())));
			}
			return maroShopSeatEntitys;
		}
		return null;
	}
	
	@Override
	public MaroShopSeatEntity getShopSeatInfoBySeatId(String seatId) {
		// TODO Auto-generated method stub
		MaroShopSeatEntity maroShopSeatEntity = maroCommonShopDao
				.getShopSeatInfoBySeatId(seatId);
		if(maroShopSeatEntity!=null) maroShopSeatEntity.setTypeString(Util.getValueFromTypeByTypeCodeAndKey("maro_seat_type", String.valueOf(maroShopSeatEntity.getType())));
		return maroShopSeatEntity;
	}
	
	@Override
	public Boolean updateFlag(String seatId, Integer flag) {
		// TODO Auto-generated method stub
		int num = maroCommonShopDao.updateFlag(seatId, flag);
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String,Object>> listShopSeatInfoBySql(String shopId){
		return maroCommonShopDao.listShopSeatInfoBySql(shopId);
	}

	

}