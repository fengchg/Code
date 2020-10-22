package com.maro.client.common.util;

import com.maro.client.common.constant.enumconstant.MakeBillTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderStatusEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientServerorderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PojoUtilTest {

    @Test
    public void test(){
        MaroClientServerorderDO maroClientServerorderDO = new MaroClientServerorderDO();
        maroClientServerorderDO.setStatus(ServerOrderStatusEnum.FINISH.getCode());
        maroClientServerorderDO.setBeginTime(System.currentTimeMillis());
//
        MaroClientServerorderVO maroClientServerorderVO = PojoUtil.convertDO2VO(maroClientServerorderDO, MaroClientServerorderVO.class);
        System.out.println(maroClientServerorderVO.getStatusString());
        System.out.println(maroClientServerorderVO.getBeginTimeString());
        System.out.println(maroClientServerorderVO.getStatus());
//        MaroClientServerorderVO maroClientServerorderVO = new MaroClientServerorderVO();
//        System.out.println(maroClientServerorderVO.getClass().getMethods());
    }

    @Test
    public void testGetName(){
        String name = EnumUtil.getName(MakeBillTypeEnum.class, 1);
        String name1 = EnumUtil.getName(MakeBillTypeEnum.class, 0);
        System.out.println(name);
        System.out.println(name1);
    }

}
