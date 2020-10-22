package com.maro.client.serverorder.service;

import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.constant.enumconstant.FoodTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.service.MaroClientFoodorderService;
import com.maro.client.module.serverorder.service.MaroClientServerorderService;
import com.maro.client.module.serverorder.service.MaroClientServerorderlogService;
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
public class MaroClientFoodorderServiceTest {
    @Autowired
    ApplicationContext ctx;
    MaroClientFoodorderService service;

    @Before
    public void init(){
        service = (MaroClientFoodorderService) ctx.getBean("maroClientFoodorderServiceImpl");
    }
    @Test
    public void testSaveFoodorderDO(){
        MaroClientFoodorderDO maroClientFoodorderDO = orderFood("f003","主食","fy001","米饭","f001",new BigDecimal(26),new BigDecimal(1));
        service.saveFoodorderDO(maroClientFoodorderDO);
    }

    /**
     * 参数，foodcode，服务员ID，数量，点餐状态
     * @param id
     * @param foodType
     * @param foodTypeCode
     * @param foodName
     * @param foodCode
     * @param price
     * @param quantity
     * @return
     */
    public MaroClientFoodorderDO orderFood(String id,String foodType,String foodTypeCode,String foodName,String foodCode,BigDecimal price,BigDecimal quantity){
        MaroClientFoodorderDO maroClientFoodorderDO = new MaroClientFoodorderDO();

        maroClientFoodorderDO.setId(id);
        maroClientFoodorderDO.setRestaurantId("x111");
        maroClientFoodorderDO.setServerOrderId("x002");
        maroClientFoodorderDO.setFoodType(foodType);
        maroClientFoodorderDO.setFoodTypeCode(foodTypeCode);
        maroClientFoodorderDO.setFoodName(foodName);
        maroClientFoodorderDO.setFoodCode(foodCode);
        maroClientFoodorderDO.setQuantity(new BigDecimal(1));
        maroClientFoodorderDO.setUnitCode("u001");
        maroClientFoodorderDO.setUnitName("份");
        maroClientFoodorderDO.setPrice(new BigDecimal(26));
        maroClientFoodorderDO.setTotalPrice(maroClientFoodorderDO.getPrice().multiply(maroClientFoodorderDO.getQuantity()));
        maroClientFoodorderDO.setWaiterId("w001");
        maroClientFoodorderDO.setWaiterName("w001");
        maroClientFoodorderDO.setDiscount(new BigDecimal(0));
        maroClientFoodorderDO.setStatus(FoodOrderStatusEnum.ORDER.getCode());
        maroClientFoodorderDO.setType(FoodTypeEnum.NORMAL.getCode());
        return maroClientFoodorderDO;
    }

    @Test
    public void testListFoodorderDOByServerOrderId(){

        List<MaroClientFoodorderDO> x001s = service.listFoodorderDOByServerOrderId("x001");

        for(int i=0;i<x001s.size();i++){
            System.out.println("点餐记录:"+x001s.get(i).getId());
        }
    }



}
