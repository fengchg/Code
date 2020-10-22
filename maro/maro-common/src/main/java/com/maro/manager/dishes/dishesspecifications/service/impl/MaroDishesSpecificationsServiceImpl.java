package com.maro.manager.dishes.dishesspecifications.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.manager.dishes.dishesspecifications.service.MaroDishesSpecificationsServiceI;
import com.maro.platform.core.common.service.impl.CommonServiceImpl;


@Service("maroDishesSpecificationsServiceI")
@Transactional
public class MaroDishesSpecificationsServiceImpl  extends CommonServiceImpl implements MaroDishesSpecificationsServiceI{

}
