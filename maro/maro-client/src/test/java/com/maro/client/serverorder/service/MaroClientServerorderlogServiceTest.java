package com.maro.client.serverorder.service;

import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.service.MaroClientServerorderlogService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class MaroClientServerorderlogServiceTest extends TestCase {
    @Autowired
    ApplicationContext ctx;
    MaroClientServerorderlogService service;


    @Before
    public void init(){
        service =(MaroClientServerorderlogService) ctx.getBean("maroClientServerorderlogServiceImpl");
    }

    @Test
     public void testSaveServerlogOrderDO(){
        MaroClientServerorderlogDO log001 = dolog("log001", ServerOrderLogTypeEnum.OPEN);
        service.saveServerorderlogDO(log001);

        MaroClientServerorderlogDO log002 = dolog("log002", ServerOrderLogTypeEnum.ORDER_FOOD);
        service.saveServerorderlogDO(log002);

        MaroClientServerorderlogDO log003 = dolog("log003", ServerOrderLogTypeEnum.ORDER_FOOD);
        service.saveServerorderlogDO(log003);

        MaroClientServerorderlogDO log004 = dolog("log004", ServerOrderLogTypeEnum.PAY);
        service.saveServerorderlogDO(log004);



        MaroClientServerorderlogDO log005 = dolog("log005", ServerOrderLogTypeEnum.CLOSE);
        service.saveServerorderlogDO(log005);

     }

    MaroClientServerorderlogDO dolog(String id,ServerOrderLogTypeEnum logTypeEnum)
    {
        MaroClientServerorderlogDO maroClientServerorderlogDO = new MaroClientServerorderlogDO();
        maroClientServerorderlogDO.setId(id);
        maroClientServerorderlogDO.setHappenTime(System.currentTimeMillis());
        maroClientServerorderlogDO.setType(logTypeEnum.getCode());
        maroClientServerorderlogDO.setDescription(logTypeEnum.getName());
        maroClientServerorderlogDO.setServerOrderId("x001");
        return maroClientServerorderlogDO;

    }

    @Test
    public void testListServerorderlogDOByServerOrderId(){

        List<MaroClientServerorderlogDO> x001s = service.listServerorderlogDOByServerOrderId("x001");

        for(int i=0;i<x001s.size();i++){
            System.out.println("点餐记录:"+x001s.get(i).getId());
        }
    }



}
