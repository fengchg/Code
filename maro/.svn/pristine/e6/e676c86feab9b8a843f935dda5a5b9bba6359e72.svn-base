package com.maro.client.common.net;

import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

@RunWith(JUnit4.class)
public class HttpHelperTest {
    @Test
    public void testDoPost(){
        String url = "http://localhost:8081/clientUserController.do?login";
        JSONObject map = new JSONObject();
        map.put("user","y1");
        map.put("pass","888888");
        String s = HttpHelper.doPost(url, map, "utf-8");
        System.out.println(s);

    }

    @Test
    public void testSendMq(){
        String dto = "{\"maroClientServerorderlogDOs\":[],\"maroClientServerorderDO\":{\"cookId\":\"\",\"phone\":\"\",\"send\":100,\"remark\":\"\",\"personNumber\":20,\"memberPhone\":\"\",\"type\":0,\"endTime\":0,\"cashierName\":\"\",\"payTime\":0,\"seatCode\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"amount\":0,\"id\":\"1379b280-1a73-4a59-b2dc-71627c983521\",\"waiterName\":\"员工2\",\"seatId\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"kitchenNotify\":0,\"memberName\":\"\",\"seatName\":\"E座\",\"mergeServerorderId\":\"\",\"smallChange\":0,\"restaurantName\":\"总店h\",\"restaurantId\":\"8a8a8bfa628917e60162897be7230014\",\"payTerminal\":0,\"customerName\":\"\",\"payAmount\":0,\"status\":7,\"billMoney\":0,\"beginTime\":1527940947476,\"code\":\"test002\",\"discount\":1,\"typeString\":\"\",\"makeBillType\":0,\"cookName\":\"\",\"reserveId\":\"\",\"receivableAmount\":0,\"payType\":0,\"memberId\":\"\",\"payedDeposit\":0,\"collectedAmount\":0,\"serviceCharge\":0,\"cashierId\":\"\",\"waiterId\":\"8a8a8bf861cb71340161cb7fdd47001d\",\"openId\":\"\"},\"maroClientSeatchangeDOs\":[{\"destSeatId\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"id\":\"ce757a55-3242-4db2-ae72-4059eaa149e2\",\"srcSeatCode\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"srcSeatName\":\"E座\",\"destSeatCode\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"destSeatName\":\"E座\",\"name\":\"上桌\",\"srcSeatId\":\"8a8a8bfa62cc88c00162cc8b5ad7000a\",\"happenTime\":1527940947476,\"deleteFlag\":0,\"type\":0,\"serverOrderId\":\"1379b280-1a73-4a59-b2dc-71627c983c21\"}],\"maroClientPayedDOs\":[],\"maroClientFoodOrderDOs\":[]}";
        JSONObject map = new JSONObject();
        map.put("message", dto);
        map.put("user", "y1");
        map.put("pass", "888888");
        String s = HttpHelper.doPost("http://127.0.0.1:8081/serverorderController.do?saveServerorder", map, "UTF-8");
        System.out.println(s);
        s = HttpHelper.doPost("http://127.0.0.1:8081/serverorderController.do?saveServerorder", map, "UTF-8");
        System.out.println(s);
    }


}
