package com.maro.client.reserve.service.apply;

import com.maro.client.module.serverorder.apply.ServerOrderApplyService;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientSeatchangeVO;
import com.maro.client.module.serverorder.pojo.vo.MaroShopSeatVO;
import com.maro.client.module.serverorder.pojo.vo.SeatListVO;
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
public class MaroClientReserveApplyServiceTest {
    @Autowired
    ApplicationContext ctx;
    ServerOrderApplyService service;

    @Before
    public void init(){
        service = (ServerOrderApplyService) ctx.getBean("maroClientReserveApplyServiceImpl");
    }

    @Test
    public void testGetServerOrder(){
        MaroClientServerorderDTO x001 = service.getServerOrder("x001");
        System.out.println(x001);
    }


    /**
     * 开台操作
     */
    @Test
    public void open(){
//        MaroClientServerorderDTO dto = new MaroClientServerorderDTO();
//        MaroClientServerorderDO maroClientServerorderDO = new MaroClientServerorderDO();
//        maroClientServerorderDO.setPersonNumber(total);
//        maroClientServerorderDO.setSeatId(tableId);
//        maroClientServerorderDO.setReserveId(reserveId);
//        MaroClientServerorderVO maroClientServerorderVO = service.open(dto);
    }
    /**
     * 取消开台
     */
    @Test
    public void cancel(){
        service.cancal("x001");
    }

    /**
     * 清台
     */
    @Test
    public void clear(){
        service.clear("x002");
    }


    /**
     * 获取桌位信息
     */
    @Test
    public void listSeat(){

        List<SeatListVO> SeatListVOList = service.listSeat("8a8a8bfa628917e60162897be7230014");
        for(int i=0;i<SeatListVOList.size();i++){
            SeatListVO seatListVO = SeatListVOList.get(i);
            List<MaroShopSeatVO> list = seatListVO.getList();
            System.out.println(seatListVO.getType());
            for(int j=0;j<list.size();j++) {
                MaroClientSeatchangeVO maroClientSeatchangeVO = list.get(j).getMaroClientSeatchangeVO();
                if (maroClientSeatchangeVO == null) {
                    System.out.println(list.get(i).getName() + "," + "空闲");
                } else {
                    String typeString = maroClientSeatchangeVO.getTypeString();
                    String destSeatName = maroClientSeatchangeVO.getDestSeatName();
                    System.out.println(typeString + "," + destSeatName);
                }
            }
        }
    }











}
