package com.maro.client.serverorder.pojo;

import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientServerorderVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PojoTest {
    @Test
    public  void testInit(){
        MaroClientServerorderVO entity = new MaroClientServerorderVO();
        entity.setStatus(1);
        System.out.println(entity.getStatusString());
    }
}
