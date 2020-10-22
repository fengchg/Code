package com.maro.client.serverorder.service;

import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.constant.enumconstant.FoodTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderPayedTerminalTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderPayedTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.service.MaroClientFoodorderService;
import com.maro.client.module.serverorder.service.MaroClientPayedService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class MaroClientPayedServiceTest {
    @Autowired
    ApplicationContext ctx;
    MaroClientPayedService service;
    @Before
    public void init(){
        service =(MaroClientPayedService) ctx.getBean("maroClientPayedServiceImpl");
    }

    @Test
    public void testSavePayedDO(){
        MaroClientPayedDO maroClientFoodorderDO = pay("p001");
        service.savePayedDO(maroClientFoodorderDO);
    }

    /**
     * 参数，支付类型，支付终端，支付卡号，金额
     * @param id
     * @return
     */
    public MaroClientPayedDO pay(String id){
        MaroClientPayedDO maroClientPayedDO = new MaroClientPayedDO();

        maroClientPayedDO.setId(id);
        maroClientPayedDO.setPayTime(System.currentTimeMillis());
        maroClientPayedDO.setPayType(ServerOrderPayedTypeEnum.CASH.getCode());
        maroClientPayedDO.setPayTerminal(ServerOrderPayedTerminalTypeEnum.CASH.getCode());
        maroClientPayedDO.setCardNumber("");

        return maroClientPayedDO;
    }


    @Test
    public void testListPayedDOByServerOrderId(){

        List<MaroClientPayedDO> x001s = service.listPayedDOByServerOrderId("x001");

        for(int i=0;i<x001s.size();i++){
            System.out.println("支付记录:"+x001s.get(i).getId());
        }
    }
}
