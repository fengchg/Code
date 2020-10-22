package com.maro.client.module.serverorder.apply.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.common.constant.enumconstant.*;
import com.maro.client.common.mq.MqCustomerListener;
import com.maro.client.common.mq.MqProducer;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.reserve.apply.MaroClientReserveApplyService;
import com.maro.client.module.reserve.pojo.dto.ReserveResultDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.client.module.reserve.pojo.vo.MaroClientReserveVO;
import com.maro.client.module.serverorder.apply.ServerOrderApplyService;
import com.maro.client.module.serverorder.dao.MaroClientServerorderDAO;
import com.maro.client.module.serverorder.dao.ServerOrderApplyDao;
import com.maro.client.module.serverorder.pojo.dto.*;
import com.maro.client.module.serverorder.pojo.entity.*;
import com.maro.client.module.serverorder.pojo.vo.*;
import com.maro.client.module.serverorder.service.*;
import com.maro.client.module.user.service.UserService;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesEntity;
import com.maro.common.dishes.dishes.service.MaroCommonDishesServiceI;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.service.MaroCommonShopServiceI;
import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.manager.discount.entity.MaroDishesDiscountEntity;
import com.maro.manager.discount.service.MaroDishesDiscountServiceI;
import com.maro.manager.groupdiscount.service.MaroGroupDiscountServiceI;
import com.maro.manager.maroprint.maroprinter.service.MaroPrinterServiceI;
import com.maro.manager.maroprint.printtemplate.service.MarpPrintTemplateServiceI;
import com.maro.manager.print.controller.PrintMain;
import com.maro.manager.print.entity.*;
import com.maro.manager.specialoffer.service.MaroSpecialOfferServiceI;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.core.util.DateUtils;
import com.maro.platform.core.util.ResourceUtil;
import com.maro.platform.web.cgform.exception.BusinessException;
import com.maro.platform.web.system.service.SystemService;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

/**
 * 服务订单模块的总服务调用接口的实现类
 * @author 冯成果
 * @date 2018-3-27
 * @see ServerOrderApplyService
 * @since 版本号 01.00.0001
*/
@Service
public class ServerOrderApplyServiceImpl implements ServerOrderApplyService {
    @Resource
    private ServerOrderApplyDao serverOrderApplyDao;
    @Resource
    private MaroClientServerorderService maroClientServerorderService;
    @Resource
    private MaroClientFoodorderService maroClientFoodorderService;
    @Resource
    private MaroClientSeatchangeService maroClientSeatchangeService;
    @Resource
    private MaroClientServerorderlogService maroClientServerorderlogService;
    @Resource
    private MaroClientPayedService maroClientPayedService;

    @Resource
    private MaroCommonShopServiceI maroCommonShopServiceI;
    @Resource
    private MaroClientReserveApplyService maroClientReserveApplyService;

    @Resource
    private SystemService systemService;

    @Resource
    private MaroCommonDishesServiceI maroCommonDishesServiceI;

    @Resource
    private MaroGroupDiscountServiceI maroGroupDiscountServiceI;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Resource
    private MqProducer mqProducer;
    @Resource
    private MqCustomerListener mqCustomerListener;

    @Resource(name = "clientUserServiceImpl")
    private UserService userService;
    @Resource
    MaroClientServerorderDAO maroClientServerorderDAO;

    @Resource
    private MaroClientCodeNumService maroClientCodeNumService;
    @Resource
    private MaroSpecialOfferServiceI maroSpecialOfferServiceI;
    @Resource
    private MaroDishesDiscountServiceI maroDishesDiscountServiceI;
    
    @Autowired
	private MarpPrintTemplateServiceI marpPrintTemplateService;
    @Autowired
	private MaroPrinterServiceI maroPrinterService;
    
    @Override
    public MaroClientServerorderDTO getServerOrder(String serverOrderId) {
        MaroClientServerorderDO serverOrderDO = maroClientServerorderService.getServerOrderDObyId(serverOrderId);
        MaroClientServerorderVO maroClientServerorderVO = PojoUtil.convertDO2VO(serverOrderDO, MaroClientServerorderVO.class);

        List<MaroClientFoodorderDO> maroClientFoodorderDOs = maroClientFoodorderService.listFoodorderDOByServerOrderId(serverOrderId);
        List<MaroClientFoodorderVO> maroClientFoodorderVOs = PojoUtil.convertBatchDO2VO(maroClientFoodorderDOs, MaroClientFoodorderVO.class);

        List<MaroClientSeatchangeDO> maroClientSeatchangeDOs = maroClientSeatchangeService.listSeatchangeDOByServerOrderId(serverOrderId);
        List<MaroClientSeatchangeVO> maroClientSeatchangeVOs = PojoUtil.convertBatchDO2VO(maroClientSeatchangeDOs, MaroClientSeatchangeVO.class);

        List<MaroClientServerorderlogDO> maroClientServerorderlogDOs = maroClientServerorderlogService.listServerorderlogDOByServerOrderId(serverOrderId);
        List<MaroClientServerorderlogVO> MaroClientServerorderlogVOs = PojoUtil.convertBatchDO2VO(maroClientServerorderlogDOs, MaroClientServerorderlogVO.class);


        List<MaroClientPayedDO> maroClientPayedDOs = maroClientPayedService.listPayedDOByServerOrderId(serverOrderId);
        List<MaroClientPayedVO> maroClientPayedVOs = PojoUtil.convertBatchDO2VO(maroClientPayedDOs, MaroClientPayedVO.class);
        List<PayResultDTO> payResultDTOList = maroClientPayedService.listPayedResultDTOByServerOrderId(serverOrderId);


        MaroClientServerorderDTO maroClientServerorderDTO = new MaroClientServerorderDTO();
        maroClientServerorderDTO.setMaroClientServerorderVO(maroClientServerorderVO);
        maroClientServerorderDTO.setMaroClientFoodOrderVOs(maroClientFoodorderVOs);
        maroClientServerorderDTO.setMaroClientSeatchangeVOs(maroClientSeatchangeVOs);
        maroClientServerorderDTO.setMaroClientServerorderlogVOs(MaroClientServerorderlogVOs);
        maroClientServerorderDTO.setMaroClientPayedVOs(maroClientPayedVOs);
        maroClientServerorderDTO.setPayResultDTO(payResultDTOList);
//        maroClientServerorderDTO.setMaroClientPayedDOs(maroClientPayedDOs);

        UserInfoVO sessionUser = (UserInfoVO) ResourceUtil.getSessionUser();
        MaroShopEntity maroShopEntity = sessionUser.getMaroShopEntity();
        try{
            List<MaroDishesDiscountEntity> discountList = maroDishesDiscountServiceI.getDiscount(maroShopEntity.getId());
            maroClientServerorderDTO.setDiscountList(discountList);
        }catch(Exception e){
            e.printStackTrace();
    }
        try{
            List<Map> groupDiscountList = maroGroupDiscountServiceI.getGroupDiscounts(maroShopEntity.getId());
            maroClientServerorderDTO.setGroupDiscountList(groupDiscountList);
        }catch(Exception e){
            e.printStackTrace();
        }
        return maroClientServerorderDTO;
    }

    @Override
    public AjaxJson open(MaroClientServerorderDTO maroClientServerorderDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroShopSeatEntity seatEntity = new MaroShopSeatEntity();
        seatEntity.setId(maroClientServerorderDTO.getMaroClientServerorderDO().getSeatId());
        MaroClientServerorderDO serverorderDO = maroClientServerorderService.getServerOrderDObySeatId(seatEntity);
        if(serverorderDO != null){
            ajaxJson.setMsg(StringConstant.TIP_OPEN_OPENED);
            ajaxJson.setSuccess(false);
            ajaxJson.setObj(serverorderDO);
            return ajaxJson;
        }

        MaroClientServerorderDO maroClientServerorderDO = maroClientServerorderDTO.getMaroClientServerorderDO();
        MaroClientServerorderParamsDTO maroClientServerorderParamsDTO = new MaroClientServerorderParamsDTO();
        String reserveId = maroClientServerorderDO.getReserveId();
        if(null != reserveId && !reserveId.equals("")){
            MaroClientReserveDO maroClientReserveDO = systemService.getEntity(MaroClientReserveDO.class, reserveId);
            maroClientServerorderParamsDTO.setMaroClientReserveDO(maroClientReserveDO);
            maroClientReserveApplyService.open(reserveId);
        }
        MaroShopEntity shop = userService.getShop();
        Integer codeNum = maroClientCodeNumService.getCode(shop.getId(),new Date());
        String code = getCode(shop,codeNum);
        maroClientServerorderDO.setCode(code);
        //桌位信息
        String seatId = maroClientServerorderDO.getSeatId();
        MaroShopSeatEntity maroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(seatId);
        maroClientServerorderParamsDTO.setMaroClientServerorderDO(maroClientServerorderDO);
        maroClientServerorderParamsDTO.setMaroShopSeatEntity(maroShopSeatEntity);
        maroClientServerorderParamsDTO.setMaroShopEntity(userService.getShop());
        /**
         * 预定开台，首先生成服务订单，然后把预定记录状态设置为开单状态
         */
        MaroClientServerorderDO returnDO = maroClientServerorderService.open(maroClientServerorderParamsDTO);
        maroClientSeatchangeService.open(maroClientServerorderDO,maroShopSeatEntity);
        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.OPEN.getCode(),ServerOrderLogTypeEnum.OPEN.getName(),maroClientServerorderDO.getId());
        MaroClientServerorderVO returnVO = PojoUtil.convertDO2VO(returnDO, MaroClientServerorderVO.class);
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setObj(returnVO);
        return ajaxJson;
    }

    private String getCode(MaroShopEntity shop,Integer codeNum) {
        String number = shop.getNumber();
        String tmpCodeNum = codeNum.toString();
        String fillCode = "0";
        int len = 4 - tmpCodeNum.length();
        for(int i=0;i<len;i++){
            tmpCodeNum = fillCode + tmpCodeNum;
        }
        String code = number + DateUtils.formatDate(new Date(),DateUtils.yyyyMMdd.toPattern()) + tmpCodeNum;
        return code;
    }


    @Override
    public void cancal(String serverOrderId) {
        maroClientServerorderService.updateServerOrderDOStatus(serverOrderId,ServerOrderStatusEnum.CANCEL_OPEN.getCode());
        MaroClientServerorderlogDO logDO = new MaroClientServerorderlogDO();
        logDO.setId(UUID.randomUUID().toString());
        logDO.setHappenTime(System.currentTimeMillis());
        logDO.setServerOrderId(serverOrderId);
        logDO.setType(ServerOrderStatusEnum.CANCEL_OPEN.getCode());
        logDO.setDescription("");
        maroClientServerorderlogService.saveServerorderlogDO(logDO);
    }

    @Override
    public void clear(String serverOrderId) {
        maroClientServerorderService.clear(serverOrderId);
        MaroClientServerorderlogDO logDO = new MaroClientServerorderlogDO();
        logDO.setId(UUID.randomUUID().toString());
        logDO.setHappenTime(System.currentTimeMillis());
        logDO.setServerOrderId(serverOrderId);
        logDO.setType(ServerOrderStatusEnum.FINISH.getCode());
        logDO.setDescription(ServerOrderStatusEnum.FINISH.getName());
        maroClientServerorderlogService.saveServerorderlogDO(logDO);
    }

    @Override
    public List<SeatListVO> listSeat(String restanrantId) {
        List<MaroClientServerorderDO> listServerOrder = maroClientServerorderService.listOpenServerorder();
        List<MaroClientSeatchangeVO> maroClientSeatchangeVOList = maroClientSeatchangeService.listUsedSeatchangeDO(listServerOrder);
        List<MaroShopSeatEntity> maroShopSeatEntities = maroCommonShopServiceI.listShopSeatInfoByShopId(restanrantId);
        List<MaroShopSeatVO> maroShopSeatVOList = new ArrayList<MaroShopSeatVO>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<Integer,SeatListVO> typeToSeatListMap = new HashMap<Integer,SeatListVO>();

        for(int j=0;j<maroShopSeatEntities.size();j++){
            MaroShopSeatEntity maroShopSeatEntity = maroShopSeatEntities.get(j);
            MaroShopSeatVO maroShopSeatVO = PojoUtil.convertDO2VO(maroShopSeatEntity, MaroShopSeatVO.class);
            maroShopSeatVOList.add(maroShopSeatVO);
            map.put(maroShopSeatVO.getId(),j);

            Integer type = maroShopSeatEntity.getType();
            SeatListVO seatListVO = typeToSeatListMap.get(type);
            if(seatListVO == null){
                seatListVO = new SeatListVO();
                seatListVO.setType(type);
                seatListVO.setTypeString(maroShopSeatEntity.getTypeString());
                seatListVO.setList(new ArrayList<MaroShopSeatVO>());
                typeToSeatListMap.put(type,seatListVO);
            }
            List<MaroShopSeatVO> list = seatListVO.getList();
            list.add(maroShopSeatVO);
            /**
             * 根据获取桌位ID获取预定信息列表
             */
            ReserveResultDTO reserveResultDTO = maroClientReserveApplyService.listReserveBySeatId(maroShopSeatEntity.getId());
            maroShopSeatVO.setMaroClientReserveVOList(reserveResultDTO.getMaroClientReserveVOList());
        }
        for(int i=0;i<maroClientSeatchangeVOList.size();i++){
            MaroClientSeatchangeVO maroClientSeatchangeVO = maroClientSeatchangeVOList.get(i);
            String destSeatId = maroClientSeatchangeVO.getDestSeatId();
            Integer index = map.get(destSeatId);
            if(index != null){
                MaroShopSeatVO maroShopSeatVO = maroShopSeatVOList.get(index);
                maroShopSeatVO.setMaroClientSeatchangeVO(maroClientSeatchangeVO);
            }
        }

        Collection<SeatListVO> values = typeToSeatListMap.values();



        return new ArrayList<SeatListVO>(values);
    }

    @Override
    public MenuResultDTO listMenu(String serverOrderId, MaroShopEntity maroShopEntity, String seatId) {
        List<MaroDishesEntity> dishesList = maroCommonDishesServiceI.getDishesList(maroShopEntity.getId());
        List<MaroClientFoodorderDO> maroClientFoodorderDOList = maroClientFoodorderService.listFoodorderDO(serverOrderId,seatId);
        MaroShopSeatEntity maroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(seatId);
        Map<String,Integer> dishesIdToIndexMap = new HashMap<String,Integer>();
        Map<String,MenuItemGroupResultDTO> dishesTypeToMenuGroupMap = new HashMap<String,MenuItemGroupResultDTO>();
        List<MenuItemResultDTO> menuItemResultDTOList = new ArrayList<MenuItemResultDTO>();
        List<MaroClientFoodorderVO> maroClientFoodorderVOList = new ArrayList<MaroClientFoodorderVO>();
        
        List<MenuItemGroupResultDTO> menuItemGroupResultDTOList = new ArrayList<MenuItemGroupResultDTO>();
        
        for (int i=0;i<dishesList.size();i++){
            MenuItemResultDTO menuItemResultDTO = new MenuItemResultDTO();
            MaroDishesEntity maroDishesEntity = dishesList.get(i);
            menuItemResultDTO.setMaroDishesEntity(maroDishesEntity);
            menuItemResultDTO.setQuantity(BigDecimal.ZERO);
            menuItemResultDTOList.add(menuItemResultDTO);
            dishesIdToIndexMap.put(maroDishesEntity.getId(),i);
            String type = maroDishesEntity.getDishesClassification();
            String typeName = maroDishesEntity.getDishesClassificationName();
            
            MenuItemGroupResultDTO menuItemGroupResultDTO = dishesTypeToMenuGroupMap.get(type);
            if(menuItemGroupResultDTO == null) {
                menuItemGroupResultDTO = new MenuItemGroupResultDTO();
                dishesTypeToMenuGroupMap.put(type,menuItemGroupResultDTO);
                menuItemGroupResultDTOList.add(menuItemGroupResultDTO);
                menuItemGroupResultDTO.setType(type);
                menuItemGroupResultDTO.setTypeString(typeName);
                menuItemGroupResultDTO.setMenuItemResultDTOList(new ArrayList<MenuItemResultDTO>());
            }
            menuItemGroupResultDTO.getMenuItemResultDTOList().add(menuItemResultDTO);
        }

        for(int i=0;i<maroClientFoodorderDOList.size();i++){
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(i);
            MaroClientFoodorderVO maroClientFoodorderVO = PojoUtil.convertDO2VO(maroClientFoodorderDO, MaroClientFoodorderVO.class);
            String foodId = maroClientFoodorderVO.getFoodCode();
            Integer index = dishesIdToIndexMap.get(foodId);
            //设置菜肴的已点数量
            if(index != null){
                MenuItemResultDTO menuItemResultDTO = menuItemResultDTOList.get(index);
                menuItemResultDTO.setQuantity(maroClientFoodorderVO.getQuantity());
            }
            maroClientFoodorderVOList.add(maroClientFoodorderVO);
        }
        MenuResultDTO menuResultDTO = new MenuResultDTO();
        menuResultDTO.setMaroClientFoodorderVOList(maroClientFoodorderVOList);
        menuResultDTO.setMenuItemGroupResultDTOList(menuItemGroupResultDTOList);
        menuResultDTO.setServerorderId(serverOrderId);
        menuResultDTO.setMaroShopSeatEntity(maroShopSeatEntity);

        try{
            List<Map> salesPromotionList = maroSpecialOfferServiceI.getOfferDetail(maroShopEntity.getId());
            menuResultDTO.setSalesPromotionList(salesPromotionList);
        }catch (Exception e){
            e.printStackTrace();
        }

        return menuResultDTO;
    }

    @Override
    public AjaxJson orderFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        String serverorderId = foodOrderParamsDTO.getMaroClientServerorderDO().getId();
        String seatId = foodOrderParamsDTO.getMaroShopSeatEntity().getId();
        MaroShopSeatEntity maroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(seatId);
        foodOrderParamsDTO.setMaroShopSeatEntity(maroShopSeatEntity);
        MaroShopEntity shop = userService.getShop();
        foodOrderParamsDTO.setMaroShopEntity(shop);
        //update fengchg 18-09-17 获取点菜次数
        int times = maroClientFoodorderService.getTimes(foodOrderParamsDTO);
        foodOrderParamsDTO.setTimes(times);
        maroClientServerorderService.orderFood(foodOrderParamsDTO);
        maroClientFoodorderService.orderFood(foodOrderParamsDTO);
        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.ORDER_FOOD.getCode(),ServerOrderLogTypeEnum.ORDER_FOOD.getName(),serverorderId);
        try {
//            FoodOrderPrintResultDTO foodOrderPrintResultDTO = new FoodOrderPrintResultDTO(foodOrderParamsDTO);
//            Map<String, Object> attr = new HashMap<String, Object>();
//            attr.put("printJson", foodOrderPrintResultDTO);
//            ajaxJson.setAttributes(attr);

            OrderSubmenu orderSubmenu = PrintMain.convertOrderSubmenu(foodOrderParamsDTO);
            //获取打印机的IP PORT
            Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printOrderSubmenu");
            for (Entry<String, Integer> vo : map.entrySet()) {
            	orderSubmenu.setPrinterIp(vo.getKey());
            	orderSubmenu.setPrinterPort(vo.getValue());
    		}
            orderSubmenu.setTitleName("点菜整单");
            PrintMain.printOrderSubmenu(orderSubmenu);
            
            //打印 点菜分单
            for(int i=0;i<orderSubmenu.getDishesList().size();i++){
            	SettleAccountsDishes sad = orderSubmenu.getDishesList().get(i);
            	if(sad.getDishesClassification()!=null&&!"".equals(sad.getDishesClassification())){
            		List<SettleAccountsDishes> dishesList = new ArrayList<SettleAccountsDishes>();
            		dishesList.add(sad);
            		
            		OrderSubmenu orderSubmenu2 = new OrderSubmenu();
            		orderSubmenu2.setTitleName("点菜分单");
            		orderSubmenu2.setNumber(orderSubmenu.getNumber());
            		orderSubmenu2.setWaiter(orderSubmenu.getWaiter());
            		orderSubmenu2.setOrderTime(orderSubmenu.getOrderTime());
            		orderSubmenu2.setBillMark(orderSubmenu.getBillMark());
            		orderSubmenu2.setRemark(orderSubmenu.getRemark());
            		orderSubmenu2.setWholeRemark(orderSubmenu.getWholeRemark());
            		orderSubmenu2.setDeliveryTime(orderSubmenu.getDeliveryTime());
            		orderSubmenu2.setDishesList(dishesList);
            		orderSubmenu2.setFlag(orderSubmenu.getFlag());
            		
            		Map mapP = maroPrinterService.examineClassification(shop.getId(),sad.getDishesClassification());
            		//System.out.println(mapP.get("printer_ip"));
            		//System.out.println(mapP.get("printer_port"));
            		orderSubmenu2.setPrinterIp(mapP.get("printer_ip").toString());
            		orderSubmenu2.setPrinterPort(Integer.valueOf(mapP.get("printer_port").toString()));
            		PrintMain.printOrderSubmenu(orderSubmenu2);
            	}
            }
            

        }catch (Exception e){

        }
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    @Override
    public AjaxJson changeSeat(SeatchangeParamsDTO seatchangeParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        String oldSeatId = seatchangeParamsDTO.getSrcMaroShopSeatEntity().getId();
        String newSeatId = seatchangeParamsDTO.getDestMaroShopSeatEntity().getId();
        MaroShopSeatEntity srcShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(oldSeatId);
        MaroShopSeatEntity destShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(newSeatId);
        seatchangeParamsDTO.setDestMaroShopSeatEntity(destShopSeatEntity);
        seatchangeParamsDTO.setSrcMaroShopSeatEntity(srcShopSeatEntity);

        if(srcShopSeatEntity == null || destShopSeatEntity==null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
            return ajaxJson;
        }

        MaroClientServerorderDO order = maroClientServerorderService.getServerOrderDObySeatId(srcShopSeatEntity);
        if(order == null) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        MaroClientServerorderDO serverorderDO = maroClientServerorderService.getServerOrderDObySeatId(destShopSeatEntity);
        if(serverorderDO != null){
            ajaxJson.setMsg(String.format(StringConstant.TIP_CHANGESEAT_DEST_SEAT_OPEN,destShopSeatEntity.getFlag()));
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }

        boolean isSeatMerged = maroClientSeatchangeService.isSeatMerged(srcShopSeatEntity.getId(),order.getId());
        if(isSeatMerged){
            ajaxJson.setMsg(String.format(StringConstant.TIP_CHANGESEAT_SRC_SEAT_MARGERD,destShopSeatEntity.getFlag()));
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }
        if(serverorderDO != null) {
            isSeatMerged = maroClientSeatchangeService.isSeatMerged(destShopSeatEntity.getId(), serverorderDO.getId());
            if (isSeatMerged) {
                ajaxJson.setMsg(String.format(StringConstant.TIP_CHANGESEAT_DEST_SEAT_MARGERD, destShopSeatEntity.getFlag()));
                ajaxJson.setSuccess(false);
                return ajaxJson;
            }
        }

        String serverorderId = order.getId();
        seatchangeParamsDTO.setMaroClientServerorderDO(order);
        maroClientServerorderService.changeSeat(seatchangeParamsDTO);
        maroClientFoodorderService.changeSeat(seatchangeParamsDTO);
        maroClientSeatchangeService.changeSeat(seatchangeParamsDTO);
        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.CHANGE_SEAT.getCode(),ServerOrderLogTypeEnum.CHANGE_SEAT.getName(),serverorderId);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        try{
            ChangeChannel s = PrintMain.convertChangeChannel(seatchangeParamsDTO);
            
            //获取打印机的IP PORT
            Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printChangeChannel");
            for (Entry<String, Integer> vo : map.entrySet()) {
            	s.setPrinterIp(vo.getKey());
            	s.setPrinterPort(vo.getValue());
    		}
            PrintMain.printChangeChannel(s);
        }catch (Exception e){

        	e.printStackTrace();
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson mergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList) {
        AjaxJson ajaxJson = new AjaxJson();
        SeatchangeParamsDTO leadMergeSeatchangeParamsDTO = seatchangeParamsDTOList.get(0);
        MaroClientServerorderDO maroClientServerorderDO = leadMergeSeatchangeParamsDTO.getMaroClientServerorderDO();
        MaroClientServerorderDO serverorderDO = maroClientServerorderService.getServerOrderDObyId(maroClientServerorderDO.getId());
        if(serverorderDO == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        leadMergeSeatchangeParamsDTO.setMaroClientServerorderDO(serverorderDO);
        for(int i=0;i<seatchangeParamsDTOList.size();i++){
            SeatchangeParamsDTO seatchangeParamsDTO = seatchangeParamsDTOList.get(i);
            MaroShopSeatEntity mergeMaroShopSeatEntity = seatchangeParamsDTO.getMergeMaroShopSeatEntity();
            mergeMaroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(mergeMaroShopSeatEntity.getId());
            if(mergeMaroShopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO currentServerOrder = maroClientServerorderService.getCurrentServerOrderBySeatId(mergeMaroShopSeatEntity.getId());
            if(currentServerOrder != null) {
                boolean isSeatMerged = maroClientSeatchangeService.isSeatMerged(mergeMaroShopSeatEntity.getId(), currentServerOrder.getId());
                if (isSeatMerged) {
                    ajaxJson.setMsg(StringConstant.TIP_MERGELISTSEAT_SEAT_MARGERD);
                    ajaxJson.setSuccess(false);
                    return ajaxJson;
                }
            }
            seatchangeParamsDTO.setMergeMaroShopSeatEntity(mergeMaroShopSeatEntity);
        }
        maroClientServerorderService.mergeListSeat(seatchangeParamsDTOList);
        maroClientSeatchangeService.mergeListSeat(seatchangeParamsDTOList);
        maroClientFoodorderService.mergeListSeat(seatchangeParamsDTOList);
        maroClientServerorderlogService.logMergeListSeat(seatchangeParamsDTOList);
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        try{
            CombineTable combineTable = PrintMain.convertCombineTable(seatchangeParamsDTOList);
          //获取打印机的IP PORT
            Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printCombineTable");
            for (Entry<String, Integer> vo : map.entrySet()) {
            	combineTable.setPrinterIp(vo.getKey());
            	combineTable.setPrinterPort(vo.getValue());
    		}
            PrintMain.printCombineTable(combineTable);
        }catch (Exception e){

        	e.printStackTrace();
        }
        return ajaxJson;
    }

    @Override
    public Boolean cancelMergeSeat(SeatchangeParamsDTO seatchangeParamsDTO) {
        MaroClientServerorderDO maroClientServerorderDO = seatchangeParamsDTO.getMaroClientServerorderDO();
        maroClientServerorderDO = maroClientServerorderService.getServerOrderDObyId(maroClientServerorderDO.getId());
        seatchangeParamsDTO.setMaroClientServerorderDO(maroClientServerorderDO);

        MaroShopSeatEntity mergeMaroShopSeatEntity = seatchangeParamsDTO.getMergeMaroShopSeatEntity();
        mergeMaroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(mergeMaroShopSeatEntity.getId());
        seatchangeParamsDTO.setMergeMaroShopSeatEntity(mergeMaroShopSeatEntity);

        BigDecimal amount = maroClientFoodorderService.getAllFoodorderTotalPrice(maroClientServerorderDO.getId(), mergeMaroShopSeatEntity.getId());

        MaroClientServerorderDO cancelMergerMaroClientServerorderDO = new MaroClientServerorderDO();
        cancelMergerMaroClientServerorderDO.setAmount(amount);
        seatchangeParamsDTO.setCancelMergeMaroClientServerorderDO(cancelMergerMaroClientServerorderDO);
        seatchangeParamsDTO.setMaroShopEntity(userService.getShop());
        try {
            maroClientServerorderService.cancelMergeSeat(seatchangeParamsDTO);

            maroClientSeatchangeService.cancelMergeSeat(seatchangeParamsDTO);
            maroClientFoodorderService.cancelMergeSeat(seatchangeParamsDTO);
            maroClientServerorderlogService.log(ServerOrderLogTypeEnum.CANCEL_OPEN.getCode(),seatchangeParamsDTO.getMergeMaroShopSeatEntity().getName()+ServerOrderLogTypeEnum.CANCEL_OPEN.getName(),maroClientServerorderDO.getId());
        } catch (BusinessException e) {
            return false;
        }


        return true;
    }

    /*******************************************点菜模块start*************************************************************************/
    /**
     * 划菜
     */
    @Override
    public AjaxJson finishFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroClientFoodorderDO maroClientFoodorderDO = foodOrderParamsDTO.getMaroClientFoodorderDO();
        Integer status = FoodOrderStatusEnum.FINISH.getCode();
        String foodId = maroClientFoodorderDO.getId();
        maroClientFoodorderService.updateStatus(foodId,status, BigDecimal.ZERO);
        maroClientServerorderlogService.logFoodOrder1(foodOrderParamsDTO,ServerOrderLogTypeEnum.FINISH_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }
    /**
     * 取消划菜
     */
    @Override
    public AjaxJson unFinishFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroClientFoodorderDO maroClientFoodorderDO = foodOrderParamsDTO.getMaroClientFoodorderDO();
        String foodId = maroClientFoodorderDO.getId();
        maroClientFoodorderService.unFinishFood(foodId);
        maroClientServerorderlogService.logFoodOrder1(foodOrderParamsDTO,ServerOrderLogTypeEnum.UNFINISH_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    /**
     * 起菜
     */
    @Override
    public AjaxJson cookedFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroClientFoodorderDO maroClientFoodorderDO = foodOrderParamsDTO.getMaroClientFoodorderDO();
        Integer status = FoodOrderStatusEnum.COOKED.getCode();
        String foodId = maroClientFoodorderDO.getId();
        String foodName = maroClientFoodorderDO.getFoodName();
        BigDecimal quantity = maroClientFoodorderDO.getQuantity();
        maroClientFoodorderService.updateStatus(foodId,status, BigDecimal.ZERO);
        maroClientServerorderlogService.logFoodOrder1(foodOrderParamsDTO,ServerOrderLogTypeEnum.COOKED_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }
    /**
     * 临时改价
     */
    @Override
    public AjaxJson changeFoodTempPrice(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        maroClientFoodorderService.changeFoodTempPrice(foodOrderParamsDTO);
        maroClientServerorderlogService.logFoodOrder1(foodOrderParamsDTO,ServerOrderLogTypeEnum.UPDATE_FOODTEMPPRICE);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    /**
     * 催菜
     */
    @Override
    public AjaxJson UrgeFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        maroClientFoodorderService.UrgeFood(foodOrderParamsDTO);
        maroClientServerorderlogService.logFoodOrder(foodOrderParamsDTO,ServerOrderLogTypeEnum.URGE_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);

        try{
        	String id = foodOrderParamsDTO.getMaroClientServerorderDO().getId();
        	MaroClientServerorderDO serverDO = maroClientServerorderService.getServerOrderDObyId(id);
        	foodOrderParamsDTO.setMaroClientServerorderDO(serverDO);
            SingleUrge singleUrge = PrintMain.convertSingleUrge(foodOrderParamsDTO);
            
            //获取打印机的IP PORT
            Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printSingleUrge");
            for (Entry<String, Integer> vo : map.entrySet()) {
            	singleUrge.setPrinterIp(vo.getKey());
            	singleUrge.setPrinterPort(vo.getValue());
    		}
            PrintMain.printSingleUrge(singleUrge);
            
        }catch (Exception e){

        	e.printStackTrace();
        }

        return ajaxJson;
    }
    /**
     * 批量退菜
     */
    @Override
    public AjaxJson refundFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
        maroClientFoodorderService.refundOrGiftFood(foodOrderParamsDTO,FoodOrderStatusEnum.REFUND.getCode(),FoodTypeEnum.NORMAL.getCode());
        maroClientServerorderlogService.logFoodOrder(foodOrderParamsDTO,ServerOrderLogTypeEnum.REFUND_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        try{
        	String id = foodOrderParamsDTO.getMaroClientServerorderDO().getId();
        	MaroClientServerorderDO serverDO = maroClientServerorderService.getServerOrderDObyId(id);
        	foodOrderParamsDTO.setMaroClientServerorderDO(serverDO);
            SingleReturnDishes singleReturnDishes = PrintMain.convertSingleReturnDishes(foodOrderParamsDTO);
            
            //获取打印机的IP PORT
            Map<String,Integer> map = marpPrintTemplateService.getPrinterId("printSingleReturnDishes");
            for (Entry<String, Integer> vo : map.entrySet()) {
            	singleReturnDishes.setPrinterIp(vo.getKey());
            	singleReturnDishes.setPrinterPort(vo.getValue());
    		}

            PrintMain.printSingleReturnDishes(singleReturnDishes);
        }catch (Exception e){

        	e.printStackTrace();
        }

        return ajaxJson;
    }
    /**
     *批量赠菜
     */
    @Override
    public AjaxJson giftFood(FoodOrderParamsDTO foodOrderParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
        maroClientFoodorderService.refundOrGiftFood(foodOrderParamsDTO,FoodOrderStatusEnum.ORDER.getCode(),FoodTypeEnum.GIFT.getCode());
        maroClientServerorderlogService.logFoodOrder(foodOrderParamsDTO,ServerOrderLogTypeEnum.GIFT_FOOD);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }
    /*******************************************点菜模块end*************************************************************************/

    @Override
    public void updateServerOrderAmount(MaroClientServerorderDO maroClientServerorderDO) {
        String serverorderId = maroClientServerorderDO.getId();
        if(maroClientServerorderDO.getSeatId() == null){
            maroClientServerorderDO = maroClientServerorderService.getServerOrderDObyId(serverorderId);
        }
        BigDecimal foodAmount = maroClientFoodorderService.getAllFoodorderTotalPrice(serverorderId);
//        boolean isSeatPayed = maroClientFoodorderService.isSeatPayed(serverorderId,maroClientServerorderDO.getSeatId());
        BigDecimal payedAmount = maroClientPayedService.getPayedAmount(serverorderId);
        maroClientServerorderService.updateAmount(serverorderId,foodAmount,payedAmount);
        sessionFactory.getCurrentSession().clear();
    }
    @Override
    public void updateBatchServerOrderAmount() {
        List<MaroClientServerorderDO> listServerOrder = maroClientServerorderService.listOpenServerorder();
        //批量更新价格
        for(int i=0;i<listServerOrder.size();i++){
            MaroClientServerorderDO maroClientServerorderDO = listServerOrder.get(i);
            updateServerOrderAmount(maroClientServerorderDO);
        }
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void updateBatchServerOrderSeatchange(){
        List<MaroClientServerorderDO> listServerOrder = maroClientServerorderService.listTypeIsNullServerorder();
        //批量更新价格
        for(int i=0;i<listServerOrder.size();i++){
            MaroClientServerorderDO maroClientServerorderDO = listServerOrder.get(i);
            updateServerOrderSeatchange(maroClientServerorderDO.getId());
        }
        sessionFactory.getCurrentSession().clear();
    }

    private void updateServerOrderSeatchange(String orderId) {
        List<MaroClientSeatchangeDO> maroClientSeatchangeDOList = maroClientSeatchangeService.listSeatchangeDOByServerOrderId(orderId);
        StringBuffer seatIds = new StringBuffer();
        StringBuffer seatNames = new StringBuffer();
        if(maroClientSeatchangeDOList != null && maroClientSeatchangeDOList.size() > 0){
            for(MaroClientSeatchangeDO maroClientSeatchangeDO:maroClientSeatchangeDOList) {
                seatIds.append("," +maroClientSeatchangeDO.getDestSeatId());
                seatNames.append(","+maroClientSeatchangeDO.getDestSeatName());
            }
        }
        maroClientServerorderService.updateServerOrderSeatchange(orderId,seatIds.toString(),seatNames.toString());
        sessionFactory.getCurrentSession().clear();
    }


    //查询退菜记录列表
    @Override
    public AjaxJson listRefundFood(String serverorderId, String seatId) {
        AjaxJson ajaxJson = new AjaxJson();
        List<MaroClientFoodorderDO> list = maroClientFoodorderService.listRefundFood(serverorderId,seatId);
        List<MaroClientFoodorderVO> maroClientFoodorderVOList = PojoUtil.convertBatchDO2VO(list, MaroClientFoodorderVO.class);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        ajaxJson.setObj(maroClientFoodorderVOList);
        return ajaxJson;
    }
    //修改订单信息
    @Override
    public AjaxJson updateServerorder(MaroClientServerorderDO maroClientServerorderDO) {
        AjaxJson ajaxJson = new AjaxJson();
        maroClientServerorderService.updateServerorder(maroClientServerorderDO);

        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.UPDATE_SERVERORDERINFO.getCode(),ServerOrderLogTypeEnum.UPDATE_SERVERORDERINFO.getName(),maroClientServerorderDO.getId());

        MaroClientFoodorderVO maroClientFoodorderVO = PojoUtil.convertDO2VO(maroClientServerorderDO, MaroClientFoodorderVO.class);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        ajaxJson.setObj(maroClientFoodorderVO);
        return ajaxJson;
    }

    @Override
    public AjaxJson pay(PayParamsDTO payParamsDTO){
        AjaxJson ajaxJson = new AjaxJson();
        maroClientPayedService.pay(payParamsDTO);
        maroClientServerorderService.pay(payParamsDTO);
        maroClientFoodorderService.pay(payParamsDTO);
        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.PAY.getCode(),ServerOrderLogTypeEnum.PAY.getName(),payParamsDTO.getMaroClientServerorderDO().getId());

        Boolean isPrint = payParamsDTO.getPrint();
        if(isPrint) {
            try {
                payParamsDTO.setMaroShopEntity(userService.getShop());
                SettleAccounts s = PrintMain.convertSettleAccounts(payParamsDTO, false);

                Map<String, Integer> map = null;
                if (!s.getIsPre()) { //结账单
                    //获得打印的ip port
                    map = marpPrintTemplateService.getPrinterId("printSettleAccounts1");
                } else { //预结单
                    //获得打印的ip port
                    map = marpPrintTemplateService.getPrinterId("printSettleAccounts2");
                }
                for (Entry<String, Integer> vo : map.entrySet()) {
                    //System.out.println(vo.getKey() + "  " + vo.getValue());
                    s.setPrinterIp(vo.getKey());
                    s.setPrinterPort(vo.getValue());
                }

                PrintMain.printSettleAccounts(s);
                //            SettleAccounts s = new SettleAccounts();
                //            PayedPrintResultDTO payedPrintResultDTO = new PayedPrintResultDTO(payParamsDTO,false,s);
                //            PrintMain.printSettleAccounts(s);
                //            payParamsDTO.setMaroShopEntity(userService.getShop());
                //            PayedPrintResultDTO payedPrintResultDTO = new PayedPrintResultDTO(payParamsDTO,false,s);
                //            Map<String, Object> attr = new HashMap<String, Object>();
                //            attr.put("printJson", payedPrintResultDTO);
                //            ajaxJson.setAttributes(attr);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    @Override
    public AjaxJson changeFoodListTo(FoodOrderParamsDTO foodOrderParamsDTO) {
        String seatId = foodOrderParamsDTO.getMaroShopSeatEntity().getId();
        MaroShopSeatEntity maroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(seatId);
        foodOrderParamsDTO.setMaroShopSeatEntity(maroShopSeatEntity);
        foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
        maroClientFoodorderService.changeFoodListTo(foodOrderParamsDTO);
        /**
         * 菜品转台出去日志记录
         */
        maroClientServerorderlogService.logFoodOrder(foodOrderParamsDTO,ServerOrderLogTypeEnum.CHANGEFOODLISTTO1_FOOD);
        String srcServerorderId = foodOrderParamsDTO.getMaroClientFoodorderDOList().get(0).getServerOrderId();
        /**
         * 菜品转台接受日志记录
         */
        foodOrderParamsDTO.getMaroClientServerorderDO().setId(srcServerorderId);
        maroClientServerorderlogService.logFoodOrder(foodOrderParamsDTO,ServerOrderLogTypeEnum.CHANGEFOODLISTTO2_FOOD);
//        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.);
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        return ajaxJson;
    }

    @Override
    public AjaxJson orderFoodToListSeat(List<FoodOrderParamsDTO> foodOrderParamsDTOList) {
        for (int i=0;i<foodOrderParamsDTOList.size();i++){
            FoodOrderParamsDTO foodOrderParamsDTO = foodOrderParamsDTOList.get(i);
            orderFood(foodOrderParamsDTO);
        }
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    @Override
    public AjaxJson listFoodToKitchen(String shopId) {
        AjaxJson ajaxJson = new AjaxJson();
        List<MaroClientServerorderDO> maroClientServerorderDOS = maroClientServerorderService.listOpenServerorder();
        StringBuffer idsBuf = new StringBuffer();
        if(maroClientServerorderDOS.size() > 0) {
            for (int i = 0; i < maroClientServerorderDOS.size(); i++) {
                idsBuf.append(",'" + maroClientServerorderDOS.get(i).getId()+"'");
            }
            String ids = idsBuf.substring(1);
            FoodOrderResultDTO foodOrderResultDTO = maroClientFoodorderService.listFoodToKitchen(shopId,ids);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            ajaxJson.setObj(foodOrderResultDTO);
        }else{
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_NO_FIND_DATA);
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson cookFood(List<String> foodorderIdList) {
        for(int i=0;i<foodorderIdList.size();i++) {
            String foodorderId = foodorderIdList.get(i);
            maroClientFoodorderService.updateStatus(FoodOrderStatusEnum.COOK.getCode(), foodorderId);
            MaroClientFoodorderDO foodorderDO = maroClientFoodorderService.getFoodorderDObyId(foodorderId);
            String serverorderId = foodorderDO.getServerOrderId();
            String foodName = foodorderDO.getFoodName();
            maroClientServerorderlogService.log(ServerOrderLogTypeEnum.COOK_FOOD.getCode(), ServerOrderLogTypeEnum.COOK_FOOD.getName() + foodName, serverorderId);
        }
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        return ajaxJson;
    }

    @Override
    public AjaxJson cookedFood(String foodorderId) {
        //update by fengchg 18-9-17
        maroClientFoodorderService.updateStatus(FoodOrderStatusEnum.FINISH.getCode(), foodorderId);
        MaroClientFoodorderDO foodorderDO = maroClientFoodorderService.getFoodorderDObyId(foodorderId);
        String serverorderId = foodorderDO.getServerOrderId();
        String foodName = foodorderDO.getFoodName();
        //update by fengchg 18-9-17
        maroClientServerorderlogService.log(ServerOrderLogTypeEnum.FINISH_FOOD.getCode(), ServerOrderLogTypeEnum.FINISH_FOOD.getName() + foodName, serverorderId);
        AjaxJson ajaxJson = new AjaxJson();

        try {

            MaroClientServerorderDO serverorderDO = maroClientServerorderService.getServerOrderDObyId(serverorderId);
//            SettleAccounts s = new SettleAccounts();
//            FoodCookedPrintResultDTO foodCookedPrintResultDTO = new FoodCookedPrintResultDTO(serverorderDO,foodorderDO,s);
//            PrintMain.printSingleReturnDishes()

//            FoodCookedPrintResultDTO foodCookedPrintResultDTO = new FoodCookedPrintResultDTO(serverorderDO,foodorderDO);
//            Map<String, Object> attr = new HashMap<String, Object>();
//            attr.put("printJson", foodCookedPrintResultDTO);
//            ajaxJson.setAttributes(attr);
            FlyoutMenu flyoutMenu = PrintMain.convertFlyoutMenu(serverorderDO,foodorderDO);
            PrintMain.printFlyoutMenu(flyoutMenu);
        }catch (Exception e){

        	e.printStackTrace();
        }

        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        return ajaxJson;
    }

    @Override
    public void sendServerorderToMq() {
        try {
            mqCustomerListener.start();
            List<MaroClientServerorderDO> list = maroClientServerorderService.listFinishedServerorder();
            for (int i = 0; i < list.size(); i++) {
                ServerorderDTO serverorderDTO = new ServerorderDTO();
                MaroClientServerorderDO maroClientServerorderDO = list.get(i);
                String serverorderId = maroClientServerorderDO.getId();
                List<MaroClientFoodorderDO> listFood = maroClientFoodorderService.listFoodorderDOByServerOrderId(serverorderId);
                List<MaroClientSeatchangeDO> listSeatchange = maroClientSeatchangeService.listSeatchangeDOByServerOrderId(serverorderId);
                List<MaroClientPayedDO> listPay = maroClientPayedService.listPayedDOByServerOrderId(serverorderId);
                serverorderDTO.setMaroClientServerorderDO(maroClientServerorderDO);
                serverorderDTO.setMaroClientFoodOrderDOs(listFood);
                serverorderDTO.setMaroClientSeatchangeDOs(listSeatchange);
                serverorderDTO.setMaroClientPayedDOs(listPay);
                try {
                    mqProducer.sendMsg(serverorderDTO);
                    maroClientServerorderService.updateSendStatus(serverorderId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public MaroClientServerorderDO getServerOrderByOpenId(String openId) {
        MaroClientServerorderDO maroClientServerorderDO = maroClientServerorderService.getServerOrderByOpenId(openId);
        return maroClientServerorderDO;
    }

    @Override
    public AjaxJson orderFoodForApp(String foodOrderParamsDTOString, String payParamsDTOJson) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setMsg(StringConstant.TIP_FAIL);
        ajaxJson.setSuccess(false);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            FoodOrderParamsDTO foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOString, FoodOrderParamsDTO.class);
            PayParamsDTO payParamsDTO = objectMapper.readValue(payParamsDTOJson, PayParamsDTO.class);
            if(foodOrderParamsDTO  == null){
                return ajaxJson;
            }
            MaroClientServerorderDO serverorderDO = foodOrderParamsDTO.getMaroClientServerorderDO();
            String restaurantId = serverorderDO.getRestaurantId();
            MaroShopEntity maroShopEntity = maroCommonShopServiceI.get(MaroShopEntity.class, restaurantId);
            serverorderDO.setRestaurantName(maroShopEntity.getName());
//            serverorderDO.setOpenId(openId);
            if(serverorderDO.getId() == null || serverorderDO.getId().isEmpty()){
                String seatId = foodOrderParamsDTO.getMaroShopSeatEntity().getId();
//                MaroClientServerorderParamsDTO maroClientServerorderParamsDTO = new MaroClientServerorderParamsDTO();
//                MaroShopSeatEntity maroShopSeatEntity = maroCommonShopServiceI.getShopSeatInfoBySeatId(seatId);
                MaroClientServerorderDTO maroClientServerorderDTO = new MaroClientServerorderDTO();
                serverorderDO.setSeatId(seatId);
                maroClientServerorderDTO.setMaroClientServerorderDO(serverorderDO);
                AjaxJson result = open(maroClientServerorderDTO);
//                if(result.isSuccess()){
                    serverorderDO = (MaroClientServerorderDO) result.getObj();
//                }
            }
            if(serverorderDO != null) {
                foodOrderParamsDTO.setMaroClientServerorderDO(serverorderDO);
                //将deleteFlag设置为删除状态，等微信支付成功后再重设置为未删除状态
                List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
                for(int i=0;i<maroClientFoodorderDOList.size();i++) {
                    MaroClientFoodorderDO foodorderDO = maroClientFoodorderDOList.get(i);
                    foodorderDO.setDeleteFlag(CommonTypeEnum.DELETE_FLAG_YES.getCode());
                }
                ajaxJson = orderFood(foodOrderParamsDTO);
                if (!ajaxJson.isSuccess()) {
                    return ajaxJson;
                }
                payParamsDTO.setMaroClientServerorderDO(serverorderDO);
                ajaxJson = pay(payParamsDTO);
                if(ajaxJson.isSuccess()){
                    ajaxJson.setObj(foodOrderParamsDTO);
                    Map<String,Object> attr = new HashMap<String,Object>();
                    attr.put("payId",payParamsDTO.getMaroClientPayedDO().getId());
                    ajaxJson.setAttributes(attr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson = PojoUtil.createAjaxJson(false, null);
        }
        return ajaxJson;
    }

    @Override
    public List<Map> getFreeSeat(String shopId) {
        return serverOrderApplyDao.getFreeSeat(shopId);
    }

    @Override
    public List<Map> getFreeSeatBySeatType(String shopId,String seatTypeCode) {
        Integer period = MaroClientReserveVO.getNowPeriod();
        List<Map> list = serverOrderApplyDao.getReserveFreeSeatBySeatType(shopId, seatTypeCode, period);
        Map map = list.get(0);
        Object status = map.get("status");
        if(status != "空闲"){
            return list;
        }
        return serverOrderApplyDao.getFreeSeatBySeatType(shopId,seatTypeCode);
    }

    @Override
    public List<Map> getFreeSeatBySeatCode(String terminalCode,String seatCode) {
        MaroShopEntity shop = userService.getShop();
        String shopId = shop.getId();
        Integer period = MaroClientReserveVO.getNowPeriod();
        List<Map> list = serverOrderApplyDao.getReserveFreeSeatBySeatCode(shopId, seatCode, period);
        Map map = list.get(0);
        Object status = map.get("status");
        if(status != "空闲"){
            return list;
        }
        return serverOrderApplyDao.getFreeSeatBySeatCode(shopId,seatCode);
    }

    @Override
    public Map billQuery(String seatCode_billNumber,String shopId) {
        Map map = maroClientServerorderDAO.billQuery(seatCode_billNumber,shopId,ServerOrderStatusEnum.CANCEL_OPEN.getCode().toString(),ServerOrderStatusEnum.FINISH.getCode().toString(),FoodOrderStatusEnum.REFUND.getCode());
        return map;
    }

    @Override
    public List<Map> billQueryDetailsList(String serverOrderId) {
        return maroClientServerorderDAO.billQueryDetailsList(serverOrderId,FoodOrderStatusEnum.REFUND.getCode());
    }

    @Override
    public List<Map> reserveMessage(String shopId) {
        return maroClientServerorderDAO.reserveMessage(shopId, ReserveStatusEnum.ORDER.getCode());
    }

    @Override
    public List<Map> reserveMessageSeatCode(String seatCode,String shopId) {
        List<Map> map = maroClientServerorderDAO.reserveMessageSeatCode(seatCode,shopId);
        return map;
    }
    @Override
    public void updateFoodOrderDeleteFlag(String payId, Integer code){
        maroClientFoodorderService.updateFoodOrderDeleteFlag(payId,code);
    }

	@Override
	public AjaxJson printOrder(String orderId, boolean isPre,String payId) {
		AjaxJson ajaxJson = new AjaxJson();
        try {
        	PayParamsDTO payParamsDTO = new PayParamsDTO();
        	MaroClientServerorderDO orderDO = maroClientServerorderService.getServerOrderDObyId(orderId);
        	List<MaroClientFoodorderDO> listFood = maroClientFoodorderService.listFoodorderDOByServerOrderId(orderId);
        	payParamsDTO.setMaroClientServerorderDO(orderDO);

        	payParamsDTO.setMaroClientFoodorderDOList(listFood);
        	if(!isPre){
                MaroClientPayedDO maroClientPayedDO = maroClientPayedService.getPayedDObyId(payId);
                payParamsDTO.setMaroClientPayedDO(maroClientPayedDO);
                List<MaroClientPayedDetailDO> payedDetailDOList = maroClientPayedService.listPayedDetailDObyPayId(payId);
                payParamsDTO.setMaroClientPayedDetailDOList(payedDetailDOList);
        	}
            payParamsDTO.setMaroShopEntity(userService.getShop());
//            SettleAccounts s = new SettleAccounts();
//            payParamsDTO.setMaroShopEntity(userService.getShop());
//            PayedPrintResultDTO payedPrintResultDTO = new PayedPrintResultDTO(payParamsDTO,false,s);
            try {
                SettleAccounts s = PrintMain.convertSettleAccounts(payParamsDTO, isPre);
                
                Map<String,Integer> map = null;
                if(!s.getIsPre()){ //结账单
        			 //获得打印的ip port
                	 map = marpPrintTemplateService.getPrinterId("printSettleAccounts1");
        		}else{ //预结单
        			 //获得打印的ip port
                     map = marpPrintTemplateService.getPrinterId("printSettleAccounts2");
        		}
                for (Entry<String, Integer> vo : map.entrySet()) {
        			//System.out.println(vo.getKey() + "  " + vo.getValue());
                	s.setPrinterIp(vo.getKey());
                	s.setPrinterPort(vo.getValue());
        		}
                
                PrintMain.printSettleAccounts(s);
            }catch (Exception e){
            	e.printStackTrace();
            }
//            PayedPrintResultDTO payedPrintResultDTO = new PayedPrintResultDTO(payParamsDTO,isPre, s);
//            Map<String, Object> attr = new HashMap<String, Object>();
//            attr.put("printJson", payedPrintResultDTO);
//            ajaxJson.setAttributes(attr);
        }catch (Exception e){

        }
        return ajaxJson;
	}

    @Override
    public AjaxJson listSalesPromotion(MaroShopEntity maroShopEntity) {
        AjaxJson ajaxJson = new AjaxJson();
        String shopId = maroShopEntity.getId();
        try {
            List<Map> offerDetail = maroSpecialOfferServiceI.getOfferDetail(shopId);
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            ajaxJson.setSuccess(true);
            ajaxJson.setObj(offerDetail);
        }catch (Exception e){
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_FAIL);
        }
        return ajaxJson;
    }

}
