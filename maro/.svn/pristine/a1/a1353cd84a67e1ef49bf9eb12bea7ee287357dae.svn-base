package com.maro.client.serverorder.apply;

import com.maro.client.module.serverorder.apply.ServerOrderApplyService;
import com.maro.client.module.serverorder.apply.TerminalServerOrderApplyService;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientSeatchangeVO;
import com.maro.client.module.serverorder.pojo.vo.MaroShopSeatVO;
import com.maro.client.module.serverorder.pojo.vo.SeatListVO;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.ApplicationContextUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class ServerOrderApplyServiceTest {
    @Autowired
    ApplicationContext ctx;
    ServerOrderApplyService service;
    TerminalServerOrderApplyService terminalServerOrderApplyService;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    @Before
    public void init(){
        service = (ServerOrderApplyService) ctx.getBean("serverOrderApplyServiceImpl");
        terminalServerOrderApplyService = (TerminalServerOrderApplyService) ctx.getBean("terminalServerOrderApplyServiceImpl");
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



    @Test
    public void test999(){
        AjaxJson ajaxJson = service.listFoodToKitchen("8a8a8bfa628917e60162897be7230014");
        System.out.println(ajaxJson.getObj());
    }




    @Test
    public void testCancen(){
        String seatCode="0001";
        String orderCode="";
        String terminalCode="001";
        AjaxJson cancel = terminalServerOrderApplyService.cancel(seatCode, orderCode, terminalCode);
        System.out.println(cancel);

    }

    @Test
    public void test66(){


        ApplicationContext context = ApplicationContextUtil.getContext();
        LocalSessionFactoryBean configBean = (LocalSessionFactoryBean) context.getBean("&sessionFactory");//这里其实是获取到SessionFactory的上一级对象
        Configuration configuration = configBean.getConfiguration();
        Iterator<Table> iterator = configuration.getTableMappings();
        while ( iterator.hasNext() ) {
            Table table = iterator.next();
            System.out.println(table.getName()); //获取表名
            Iterator ics = table.getColumnIterator();
            while (ics.hasNext()){
                Column col = (Column) ics.next();
                System.out.println(col.getName()); //获取列名
                System.out.println(col.getQuotedName());
            }
        }
    }

//    @Test
//    public void test88(){
//        service.listFoodToKitchen();
//    }
}
