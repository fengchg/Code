package com.maro.client.serverorder.service;

import com.maro.client.common.constant.enumconstant.ServerOrderPayedTerminalTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderPayedTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderStatusEnum;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientServerorderVO;
import com.maro.client.module.serverorder.service.MaroClientServerorderService;
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

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class MaroClientServerorderServiceTest  extends TestCase {
    @Autowired
    ApplicationContext ctx;
    private  MaroClientServerorderService service;
    @Before
    public void init(){
        service =(MaroClientServerorderService) ctx.getBean("maroClientServerorderServiceImpl");
    }



    @Test
    public void testListServerOrderDO(){
        List<MaroClientServerorderDO> maroClientServerorderDOS = service.listServerOrderDO(new MaroClientServerorderDTO());
        for(int i=0;i<maroClientServerorderDOS.size();i++){
            System.out.println("服务订单:"+maroClientServerorderDOS.get(i).getId());
        }
    }

    @Test
    public void testGetServerOrderDObyId(){
        MaroClientServerorderService service =(MaroClientServerorderService) ctx.getBean("maroClientServerorderServiceImpl");
        MaroClientServerorderDO x001 = service.getServerOrderDObyId("x001");
        System.out.println("服务订单："+x001.getId());
    }







}
