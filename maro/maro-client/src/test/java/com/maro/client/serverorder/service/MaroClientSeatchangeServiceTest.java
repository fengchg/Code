package com.maro.client.serverorder.service;

import com.maro.client.common.constant.enumconstant.CommonTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientSeatchangeDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.service.MaroClientFoodorderService;
import com.maro.client.module.serverorder.service.MaroClientSeatchangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class MaroClientSeatchangeServiceTest {
    @Autowired
    ApplicationContext ctx;
    MaroClientSeatchangeService service;

    @Before
    public void init(){

        service =(MaroClientSeatchangeService) ctx.getBean("maroClientSeatchangeServiceImpl");
    }


    @Test
    public void testSaveSeatchangeDO(){
        MaroClientSeatchangeDO seatchange = seatchange(UUID.randomUUID().toString(), "8a8a8bfa628917e60162897be7240016", "8a8a8bfa628917e60162897be7240016", "B座", "8a8a8bfa628917e60162897be7240015", "8a8a8bfa628917e60162897be7240015", "A座",ServerOrderLogTypeEnum.MERGE_SEAT);
        service.saveSeatchangeDO(seatchange);
    }

    /**
     * 参数，服务订单ID，源桌位id（可选），目标桌id
     * @param id
     * @param srcSeatId
     * @param srcSeatCode
     * @param srcSeatName
     * @param destSeatId
     * @param destSeatCode
     * @param destSeatName
     * @return
     */
    public MaroClientSeatchangeDO seatchange(String id,String srcSeatId,String srcSeatCode,String srcSeatName,String destSeatId,String destSeatCode,String destSeatName,ServerOrderLogTypeEnum serverOrderLogTypeEnum){
        MaroClientSeatchangeDO maroClientSeatchangeDO = new MaroClientSeatchangeDO();
        maroClientSeatchangeDO.setId(id);
        maroClientSeatchangeDO.setType(serverOrderLogTypeEnum.MERGE_SEAT.getCode());
        maroClientSeatchangeDO.setName(serverOrderLogTypeEnum.MERGE_SEAT.getName());
        maroClientSeatchangeDO.setHappenTime(System.currentTimeMillis());
        maroClientSeatchangeDO.setSrcSeatId (srcSeatId);
        maroClientSeatchangeDO.setSrcSeatCode(srcSeatCode);
        maroClientSeatchangeDO.setSrcSeatName(srcSeatName);
        maroClientSeatchangeDO.setDestSeatId(destSeatId);
        maroClientSeatchangeDO.setDestSeatCode(destSeatCode);
        maroClientSeatchangeDO.setDestSeatName(destSeatName);
        maroClientSeatchangeDO.setServerOrderId("x002");
        maroClientSeatchangeDO.setDeleteFlag(CommonTypeEnum.DELETE_FLAG_NO.getCode());
        return maroClientSeatchangeDO;
    }

    @Test
    public void testListServerorderlogDOByServerOrderId(){

        List<MaroClientSeatchangeDO> x001s = service.listSeatchangeDOByServerOrderId("x001");

        for(int i=0;i<x001s.size();i++){
            System.out.println("桌位更换记录:"+x001s.get(i).getId());
        }
    }
}
