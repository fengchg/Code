package com.maro.manager.homepage.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.manager.homepage.dao.MaroHomePageStatementDao;
import com.maro.manager.homepage.entity.PeiVo;
import com.maro.manager.homepage.service.MaroHomePageStatementServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;


@Service("homePageStatementService")
@Transactional
public class MaroHomePageStatementServiceImpl extends CommonServiceImpl implements MaroHomePageStatementServiceI {
	
	@Autowired
	MaroHomePageStatementDao maroHomePageStatementDao;
	
 	
	@Override
	public Map businessVolume(String shopId) {
		return maroHomePageStatementDao.getStatisticalTurnover(shopId);
	}

	@Override
	public List<Map> turnoverHistogram(String tynData,String shopId) {
		return maroHomePageStatementDao.turnoverHistogram(tynData,shopId);
	}

	@Override
	public List<PeiVo> turnoverPie(String shopId) {
		return maroHomePageStatementDao.turnoverPie(shopId);
	}

	@Override
	public List<Map> monthTurnoverHistogram(String tynData,String shopId) {
		return maroHomePageStatementDao.monthTurnoverHistogram(tynData,shopId);
	}

	@Override
	public List<Map> yearTurnoverHistogram(String tynData,String shopId) {
		return maroHomePageStatementDao.yearTurnoverHistogram(tynData,shopId);
	}

}