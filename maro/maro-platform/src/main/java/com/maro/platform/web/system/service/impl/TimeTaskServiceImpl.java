package com.maro.platform.web.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maro.platform.web.system.service.TimeTaskServiceI;

import com.maro.platform.core.common.service.impl.CommonServiceImpl;

@Service("timeTaskService")
@Transactional
public class TimeTaskServiceImpl extends CommonServiceImpl implements TimeTaskServiceI {
	
}