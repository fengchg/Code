package com.maro.client.module.serverorder.apply.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.module.reserve.apply.MaroClientReserveApplyService;
import com.maro.client.module.serverorder.apply.ServerOrderApplyService;
import com.maro.client.module.serverorder.apply.TerminalServerOrderApplyService;
import com.maro.client.module.serverorder.pojo.dto.TerminalParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.*;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.service.*;
import com.maro.client.module.user.service.UserService;
import com.maro.common.dishes.dishes.pojo.dto.DishLabelsRusltDTO;
import com.maro.common.dishes.dishes.pojo.entity.MaroDishesClassificationEntity;
import com.maro.common.dishes.dishes.service.MaroCommonDishesServiceI;
import com.maro.common.shop.pojo.entity.MaroShopEntity;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.service.MaroCommonShopServiceI;
import com.maro.manager.dishes.dishes.service.MaroDishesServiceI;
import com.maro.manager.dishes.dishesspecifications.entity.MaroDishesSpecificationsEntity;
import com.maro.platform.core.common.model.json.AjaxJson;
import com.maro.platform.web.system.pojo.base.TSType;
import com.maro.platform.web.system.pojo.base.TSTypegroup;
import com.maro.platform.web.system.service.SystemService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class TerminalServerOrderApplyServiceImpl implements TerminalServerOrderApplyService {
    @Resource
    private ServerOrderApplyService serverOrderApplyService;
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
    private MaroDishesServiceI maroDishesService;
    @Resource
    private MaroCommonShopServiceI maroCommonShopServiceI;
    @Resource
    private MaroClientReserveApplyService maroClientReserveApplyService;

    @Resource
    private SystemService systemService;
    @Resource(name = "clientUserServiceImpl")
    private UserService userService;

    @Resource
    private MaroCommonDishesServiceI maroCommonDishesServiceI;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public AjaxJson open(TerminalParamsDTO terminalParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", terminalParamsDTO.getSeatCode());
        if(shopSeatEntity == null){
            ajaxJson.setMsg(String.format(StringConstant.TIP_OPEN_NO_HAS_SEATCODE,terminalParamsDTO.getSeatCode()));
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }
        MaroClientServerorderDO maroClientServerorderDO = new MaroClientServerorderDO();
        maroClientServerorderDO.setPersonNumber(terminalParamsDTO.getPersonNumber());
        maroClientServerorderDO.setWaiterName(terminalParamsDTO.getWaiterCode());
        maroClientServerorderDO.setSeatId(shopSeatEntity.getId());

        String reserveId = maroClientReserveApplyService.getSeatCurrentReserve(shopSeatEntity.getId());
        if(reserveId != null) {
            maroClientServerorderDO.setReserveId(reserveId);
        }

        MaroClientServerorderDTO maroClientServerorderDTO = new MaroClientServerorderDTO();
        maroClientServerorderDTO.setMaroClientServerorderDO(maroClientServerorderDO);
        ajaxJson = serverOrderApplyService.open(maroClientServerorderDTO);
        return ajaxJson;
    }

    @Override
    public AjaxJson cancel(String seatCode, String orderCode, String terminalCode) {
        AjaxJson ajaxJson = new AjaxJson();
        MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
        if(shopSeatEntity == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(String.format(StringConstant.TIP_OPEN_NO_HAS_SEATCODE,seatCode));
        }
        MaroClientServerorderDO maroClientServerorderDO =  getOrder(shopSeatEntity.getId(),orderCode);
        if(maroClientServerorderDO == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        serverOrderApplyService.cancal(maroClientServerorderDO.getId());
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    @Override
    public AjaxJson changeSeat(TerminalParamsDTO terminalParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        SeatchangeParamsDTO seatchangeParamsDTO = new SeatchangeParamsDTO();
        String srcSeatCode = terminalParamsDTO.getSrcSeatCode();
        String destSeatCode = terminalParamsDTO.getDestSeatCode();
        MaroShopSeatEntity srcShopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", srcSeatCode);
        MaroShopSeatEntity destShopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", destSeatCode);
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
        seatchangeParamsDTO.setSrcMaroShopSeatEntity(srcShopSeatEntity);
        seatchangeParamsDTO.setDestMaroShopSeatEntity(destShopSeatEntity);
        return serverOrderApplyService.changeSeat(seatchangeParamsDTO);
    }

    @Override
    public AjaxJson updateServerorder(TerminalParamsDTO terminalParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        String seatCode = terminalParamsDTO.getSeatCode();
        MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
        if(shopSeatEntity == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
            return ajaxJson;
        }
        MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), terminalParamsDTO.getOrderCode());
        if(order == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        order.setPersonNumber(terminalParamsDTO.getPersonNumber());
        order.setWaiterName(terminalParamsDTO.getWaiterCode());
        ajaxJson = serverOrderApplyService.updateServerorder(order);
        return ajaxJson;
    }

    @Override
    public AjaxJson mergeListSeat(TerminalParamsDTO terminalParamsDTO) {
        AjaxJson ajaxJson = new AjaxJson();
        List<SeatchangeParamsDTO> seatchangeParamsDTOList = new ArrayList<SeatchangeParamsDTO>();
        SeatchangeParamsDTO leadSeatchangeParamsDTO = new SeatchangeParamsDTO();
        String srcSeatCode = terminalParamsDTO.getSrcSeatCode();
        MaroShopSeatEntity srcShopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", srcSeatCode);
        if(srcShopSeatEntity == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
            return ajaxJson;
        }
        leadSeatchangeParamsDTO.setMergeMaroShopSeatEntity(srcShopSeatEntity);
        MaroClientServerorderDO srcOrder = getOrder(srcShopSeatEntity.getId(), terminalParamsDTO.getSrcOrderCode());
        if(srcOrder == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        leadSeatchangeParamsDTO.setMaroClientServerorderDO(srcOrder);

        SeatchangeParamsDTO seatchangeParamsDTO = new SeatchangeParamsDTO();
        String destOrderCode = terminalParamsDTO.getDestOrderCode();
        String descSeatCode = terminalParamsDTO.getDestSeatCode();
        MaroShopSeatEntity destShopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", descSeatCode);
//        if(destShopSeatEntity == null){
//            ajaxJson.setSuccess(false);
//            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
//            return ajaxJson;
//        }
        seatchangeParamsDTO.setMergeMaroShopSeatEntity(destShopSeatEntity);
        MaroClientServerorderDO destOrder = getOrder(destShopSeatEntity.getId(),destOrderCode);

        seatchangeParamsDTO.setMaroClientServerorderDO(destOrder);
        seatchangeParamsDTOList.add(leadSeatchangeParamsDTO);
        seatchangeParamsDTOList.add(seatchangeParamsDTO);
        ajaxJson = serverOrderApplyService.mergeListSeat(seatchangeParamsDTOList);
        return ajaxJson;
    }

    @Override
    public AjaxJson orderFood(String foodOrderParamsDTOString) {
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = new FoodOrderParamsDTO();
        JSONObject jsonObject = JSONObject.fromObject(foodOrderParamsDTOString);
        String seatCode = jsonObject.getString("seatCode");
        String orderCode= jsonObject.getString("orderCode");
        String terminal= jsonObject.getString("terminal");
        String remarks= jsonObject.getString("remarks");
        JSONArray dishes = jsonObject.getJSONArray("dishes");

        if(dishes == null || dishes.size() ==0){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_ORDERFOOD_CHANGE_FAIL);
            return ajaxJson;
        }
        MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
        if(shopSeatEntity == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
            return ajaxJson;
        }
        MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), orderCode);
        if(remarks != null && !remarks.isEmpty()) {
            order.setRemark(remarks);
        }
        if(order == null){
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
            return ajaxJson;
        }
        foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
        foodOrderParamsDTO.setMaroClientServerorderDO(order);
        foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
        List<MaroClientFoodorderDO> maroClientFoodorderDOList = new ArrayList<MaroClientFoodorderDO>();
        foodOrderParamsDTO.setMaroClientFoodorderDOList(maroClientFoodorderDOList);
        for(int i=0;i<dishes.size();i++){
            MaroClientFoodorderDO maroClientFoodorderDO = new MaroClientFoodorderDO();
            JSONObject row = dishes.getJSONObject(i);
            String code = row.getString("id");
            Double number = row.getDouble("number");
            maroClientFoodorderDO.setQuantity(new BigDecimal(number));
            MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesSpecificationsEntity.class, "dsCode", code);

            maroClientFoodorderDO.setQuantity(new BigDecimal(number));
            maroClientFoodorderDO.setFoodId(maroDishesSpecificationsEntity.getMaroDishesId());
            maroClientFoodorderDO.setPrice(new BigDecimal(maroDishesSpecificationsEntity.getUnitPrice()));
            maroClientFoodorderDO.setSpecificationsId(maroDishesSpecificationsEntity.getId());
            TSTypegroup tsTypegroup = new TSTypegroup();
            tsTypegroup.setId("8a8a8bf8623c2e8e01623cb5ecbe0004");
            TSType type = systemService.getType(maroDishesSpecificationsEntity.getName(), "", tsTypegroup);
            maroClientFoodorderDO.setSpecificationsName(type.getTypename());
            maroClientFoodorderDO.setRemark(remarks);
            maroClientFoodorderDOList.add(maroClientFoodorderDO);
        }

        return serverOrderApplyService.orderFood(foodOrderParamsDTO);
    }

    @Override
    public AjaxJson refundFood(String foodOrderParamsDTOJson) {
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }


            MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesSpecificationsEntity.class, "dsCode", maroClientFoodorderDO.getSpecificationsId());
            maroClientFoodorderDO.setFoodId(maroDishesSpecificationsEntity.getMaroDishesId());
            maroClientFoodorderDO.setSpecificationsId(maroDishesSpecificationsEntity.getId());
            maroClientFoodorderDO.setServerOrderId(order.getId());
            List<MaroClientFoodorderDO> foodorderDOList = maroClientFoodorderService.listFoodorderDO(maroClientFoodorderDO);
            if(foodorderDOList.size() == 0){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_ORDER_FOOD);
                return ajaxJson;
            }
            BigDecimal maxQuentity = BigDecimal.ZERO;
            for(int i=0;i<foodorderDOList.size();i++){
                MaroClientFoodorderDO foodorderDO = foodorderDOList.get(i);
                BigDecimal quantity = foodorderDO.getQuantity();
                maxQuentity = maxQuentity.add(quantity);
            }
            if(maxQuentity.doubleValue() < maroClientFoodorderDO.getQuantity().doubleValue()){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_QUENTITY_TO_MANY);
                return ajaxJson;
            }
            BigDecimal shouldQuentity = maroClientFoodorderDO.getQuantity();
            for(int i=0;i<foodorderDOList.size();i++) {
                MaroClientFoodorderDO foodorderDO = foodorderDOList.get(i);
                BigDecimal quantity = foodorderDO.getQuantity();
                shouldQuentity = shouldQuentity.subtract(quantity);
                //待减菜数量大于等于已经点数量
                if(shouldQuentity.doubleValue() > 0.0){
                    maroClientFoodorderDO.setQuantity(foodorderDO.getQuantity());
                }else{
                    i = foodorderDOList.size();
                }
                maroClientFoodorderDO.setId(foodorderDO.getId());
                foodOrderParamsDTO.setMaroClientServerorderDO(order);
                foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
                foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
                maroClientFoodorderDO.setPrice(new BigDecimal(maroDishesSpecificationsEntity.getUnitPrice()));
                ajaxJson = serverOrderApplyService.refundFood(foodOrderParamsDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return ajaxJson;
    }

    private MaroClientServerorderDO getOrder(String seatId,String orderCode){
        MaroClientServerorderDO maroClientServerorderDO = null;
        if(orderCode != null && !orderCode.isEmpty()){
            maroClientServerorderDO = systemService.findUniqueByProperty(MaroClientServerorderDO.class,"",orderCode);
        }else{
            MaroShopSeatEntity maroShopSeatEntity = new MaroShopSeatEntity();
            maroShopSeatEntity.setId(seatId);
            maroClientServerorderDO =  maroClientServerorderService.getServerOrderDObySeatId(maroShopSeatEntity);
        }
        return maroClientServerorderDO;
    }

    @Override
    public AjaxJson UrgeFood(String foodOrderParamsDTOJson){
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }


            MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesSpecificationsEntity.class, "dsCode", maroClientFoodorderDO.getSpecificationsId());
            maroClientFoodorderDO.setFoodId(maroDishesSpecificationsEntity.getMaroDishesId());
            maroClientFoodorderDO.setSpecificationsId(maroDishesSpecificationsEntity.getId());
            maroClientFoodorderDO.setServerOrderId(order.getId());
            List<MaroClientFoodorderDO> foodorderDOList = maroClientFoodorderService.listFoodorderDO(maroClientFoodorderDO);
            if(foodorderDOList == null || foodorderDOList.size()==0){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_URGEFOOD_NO_ORDER_FOOD);
                return ajaxJson;
            }
//            maroClientFoodorderDO.setId(foodorderDO.getId());
            foodOrderParamsDTO.setMaroClientServerorderDO(order);
            foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
            foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
            foodOrderParamsDTO.setMaroClientFoodorderDOList(foodorderDOList);
            ajaxJson = serverOrderApplyService.UrgeFood(foodOrderParamsDTO);
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return  ajaxJson;
    }

    @Override
    public AjaxJson UrgeAllFood(String foodOrderParamsDTOJson){
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }

            foodOrderParamsDTO.setMaroClientServerorderDO(order);
            foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
            foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
            List<MaroClientFoodorderDO> foodorderDOList = maroClientFoodorderService.listFoodorderDO(order.getId(), shopSeatEntity.getId());
            foodOrderParamsDTO.setMaroClientFoodorderDOList(foodorderDOList);
            ajaxJson = serverOrderApplyService.UrgeFood(foodOrderParamsDTO);
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson finishFood(String foodOrderParamsDTOJson){
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }


            MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesSpecificationsEntity.class, "dsCode", maroClientFoodorderDO.getSpecificationsId());
            maroClientFoodorderDO.setFoodId(maroDishesSpecificationsEntity.getMaroDishesId());
            maroClientFoodorderDO.setSpecificationsId(maroDishesSpecificationsEntity.getId());
            maroClientFoodorderDO.setServerOrderId(order.getId());
            MaroClientFoodorderDO foodorderDO = maroClientFoodorderService.getFoodorderDO(maroClientFoodorderDO);
            if(foodorderDO == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_FINISHFOOD_NO_ORDER_FOOD);
                return ajaxJson;
            }
            maroClientFoodorderDO.setId(foodorderDO.getId());
            foodOrderParamsDTO.setMaroClientServerorderDO(order);
            foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
            foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
            foodOrderParamsDTO.setMaroClientFoodorderDO(maroClientFoodorderDO);
            ajaxJson = serverOrderApplyService.finishFood(foodOrderParamsDTO);
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return  ajaxJson;
    }

    @Override
    public AjaxJson UrgeFoodByType(String foodOrderParamsDTOJson){
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }

            MaroDishesClassificationEntity dishesClassificationEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesClassificationEntity.class, "classificationCode", maroClientFoodorderDO.getFoodTypeCode());

            if(dishesClassificationEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_URGEFOODBYTYPE_NO_TYPE);
                return ajaxJson;
            }

            foodOrderParamsDTO.setMaroClientServerorderDO(order);
            foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
            foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
            List<MaroClientFoodorderDO> foodorderDOList = maroClientFoodorderService.listFoodorderDO(order.getId(), shopSeatEntity.getId(),dishesClassificationEntity.getId());
            foodOrderParamsDTO.setMaroClientFoodorderDOList(foodorderDOList);
            ajaxJson = serverOrderApplyService.UrgeFood(foodOrderParamsDTO);
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson giftFood(String foodOrderParamsDTOJson){
        AjaxJson ajaxJson = new AjaxJson();
        FoodOrderParamsDTO foodOrderParamsDTO = null;
        try {
            foodOrderParamsDTO = objectMapper.readValue(foodOrderParamsDTOJson, FoodOrderParamsDTO.class);
            List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
            if(maroClientFoodorderDOList == null || maroClientFoodorderDOList.size() > 0){
                ajaxJson.setMsg(StringConstant.TIP_REFUNDFOOD_NO_HAS_FOOD);
                ajaxJson.setSuccess(false);
            }
            MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(0);
            String seatCode = maroClientFoodorderDO.getSeatCode();
            MaroShopSeatEntity shopSeatEntity = maroCommonShopServiceI.findUniqueByProperty(MaroShopSeatEntity.class, "flag", seatCode);
            if(shopSeatEntity == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_HAS_SEATCODE);
                return ajaxJson;
            }
            MaroClientServerorderDO order = getOrder(shopSeatEntity.getId(), null);
            if(order == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_OPEN_NO_OPEN);
                return ajaxJson;
            }


            MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = maroCommonDishesServiceI.findUniqueByProperty(MaroDishesSpecificationsEntity.class, "dsCode", maroClientFoodorderDO.getSpecificationsId());
            maroClientFoodorderDO.setFoodId(maroDishesSpecificationsEntity.getMaroDishesId());
            maroClientFoodorderDO.setSpecificationsId(maroDishesSpecificationsEntity.getId());
            maroClientFoodorderDO.setServerOrderId(order.getId());
//            maroClientFoodorderDO.setServerOrderId(order.getId());
            MaroClientFoodorderDO foodorderDO = maroClientFoodorderService.getFoodorderDO(maroClientFoodorderDO);
            if(foodorderDO == null){
                ajaxJson.setSuccess(false);
                ajaxJson.setMsg(StringConstant.TIP_GIFTFOOD_NO_ORDER_FOOD);
                return ajaxJson;
            }
            maroClientFoodorderDO.setId(foodorderDO.getId());
            foodOrderParamsDTO.setMaroClientServerorderDO(order);
            foodOrderParamsDTO.setMaroShopEntity(userService.getShop());
            foodOrderParamsDTO.setMaroShopSeatEntity(shopSeatEntity);
            maroClientFoodorderDO.setPrice(new BigDecimal(maroDishesSpecificationsEntity.getUnitPrice()));
            ajaxJson = serverOrderApplyService.giftFood(foodOrderParamsDTO);
        } catch (IOException e) {
            e.printStackTrace();
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg(StringConstant.TIP_PARAMS_ERROR);
        }
        return ajaxJson;
    }

    @Override
    public AjaxJson listBaseData(){
        AjaxJson ajaxJson = new AjaxJson();
        MaroShopEntity shop = userService.getShop();
        String shopId = shop.getId();


        List<Map<String,Object>> maroShopSeatEntities = maroCommonShopServiceI.listShopSeatInfoBySql(shopId);
        List<Map<String,Object>> dishesList = maroCommonDishesServiceI.listDishesBySql(shop.getId());
        List<Map<String,Object>> dishesClassificationList = maroCommonDishesServiceI.listDishesClassificationBySql(shop.getDepartId());

        List<Map<String,Object>> maroClientFoodorderDOList = maroCommonDishesServiceI.listFoodorderDOBySql(shopId);
        List<Map<String,Object>> dishesLabelList = maroCommonDishesServiceI.getDishesListBySql();

        Map<String,DishLabelsRusltDTO> labelMap = new HashMap<String,DishLabelsRusltDTO>();
        for(int i=0;i<dishesLabelList.size();i++){
            Map<String,Object> map = dishesLabelList.get(i);
            DishLabelsRusltDTO dishLabelsRusltDTO = null;
            String code = (String) map.get("code");
            String name = (String) map.get("name");
            dishLabelsRusltDTO = labelMap.get(code);
            if(dishLabelsRusltDTO == null){
                dishLabelsRusltDTO = new DishLabelsRusltDTO();
                dishLabelsRusltDTO.setLabelCode(code);
                dishLabelsRusltDTO.setLabelName(name);
///               List<Map<String,Object>> maroDishesEntityList=maroDishesService.getMaroDishesEntityList(code,shopId);
                dishLabelsRusltDTO.setMaroDishesEntityList(new ArrayList<Map<String, Object>>());
                labelMap.put(code,dishLabelsRusltDTO);
            }
        }

        if(maroClientFoodorderDOList != null && maroClientFoodorderDOList.size() > 0){
            for(Map<String,Object> map : maroClientFoodorderDOList){
                String specifications_id = (String) map.get("specificationsId");
                if(specifications_id != null) {
                    MaroDishesSpecificationsEntity maroDishesSpecificationsEntity = systemService.get(MaroDishesSpecificationsEntity.class, specifications_id);
                    String theLabel = (String) map.get("theLabel");
                    String[] theLabels = theLabel.split(",");
                    for(int i=0;i<theLabels.length;i++){
                        String lab = theLabels[i];
                        if(lab != null && !lab.isEmpty()){
                            DishLabelsRusltDTO dishLabelsRusltDTO = labelMap.get(lab);
                            if(dishLabelsRusltDTO!= null){
                                map.put("ds_code",maroDishesSpecificationsEntity.getDsCode());
                                map.remove("specificationsId");
                                dishLabelsRusltDTO.getMaroDishesEntityList().add(map);
                            }
                        }
                    }
                }
            }
        }
        
        Map<String,DishLabelsRusltDTO> resultMap = sortMapByKey(labelMap);
        
        List<DishLabelsRusltDTO> dishLabelsRusltList = new ArrayList<DishLabelsRusltDTO>(resultMap.values());

        List<Map<String,Object>> markWayList = maroCommonDishesServiceI.listMarkWayBySql();
        List<Map<String,Object>> terminalMessageTemplateList = maroCommonDishesServiceI.listTerminalMessageTemplateBySql();
        List<Map<String,Object>> dishesRetireReasonList = maroCommonDishesServiceI.listDishesRetireReasonBySql(shopId);


        TerminalResultsDTO terminalResultsDTO = new TerminalResultsDTO();
        terminalResultsDTO.setDishesList(dishesList);
        terminalResultsDTO.setMaroShopSeatEntities(maroShopSeatEntities);
        terminalResultsDTO.setDishesClassificationList(dishesClassificationList);
        terminalResultsDTO.setDishesLabelList(dishesLabelList);
        terminalResultsDTO.setDishLabelsRusltList(dishLabelsRusltList);
        terminalResultsDTO.setMarkWayList(markWayList);
        terminalResultsDTO.setTerminalMessageTemplateList(terminalMessageTemplateList);
        terminalResultsDTO.setDishesRetireReasonList(dishesRetireReasonList);
        Map<String,Object> shopMap = new HashMap<String,Object>();
        shopMap.put("shopName",userService.getShop().getName());
        terminalResultsDTO.setShopMap(shopMap);
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setObj(terminalResultsDTO);
        return ajaxJson;
    }

    @Override
    public AjaxJson getFreeSeat(String terminalCode) {
        AjaxJson json = new AjaxJson();
        try{
            MaroShopEntity shop = userService.getShop();
            String shopId = shop.getId();
            List<Map> list=serverOrderApplyService.getFreeSeat(shopId);
            StringBuffer s=new StringBuffer();
            if(list!=null&&list.size()>0){
                for(Map m:list){
                    s.append(m.get("type")+""+m.get("personnum")+"人台   空闲"+m.get("total")+"\r\n");
                }
                json.setMsg(s.toString());
            }else{
                json.setMsg("无空闲餐台！");
            }
            json.setObj(list);
        }catch (Exception e){
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg("查询失败！");
        }
        return json;
    }

    @Override
    public AjaxJson getFreeSeatBySeatType(String terminalCode, String seatTypeCode) {
        AjaxJson json = new AjaxJson();
        try{
            MaroShopEntity shop = userService.getShop();
            String shopId = shop.getId();
            List<Map> list=serverOrderApplyService.getFreeSeatBySeatType(shopId,seatTypeCode);
            StringBuffer s=new StringBuffer();
            if(list!=null&&list.size()>0){
                for(Map map:list){
                    s.append(map.get("flag")+"   "+map.get("status")+"\r\n");
                }
                json.setMsg(s.toString());
            }else{
                json.setMsg("无空闲餐位！");
            }
            json.setObj(list);
        }catch (Exception e){
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg("查询失败！");
        }
        return json;
    }

    @Override
    public AjaxJson getFreeSeatBySeatCode(String terminalCode, String seatCode) {
        AjaxJson json = new AjaxJson();
        try{
            List<Map> list=serverOrderApplyService.getFreeSeatBySeatCode(terminalCode,seatCode);
            StringBuffer s=new StringBuffer();
            if(list!=null&&list.size()>0){
                s.append(seatCode+"餐台目前状态:\r\n");
                for(Map map:list){
                    s.append(map.get("flag")+"   "+map.get("status")+"\r\n");
                }
                json.setMsg(s.toString());
            }else{
                json.setMsg("该餐位空闲！");
            }
            json.setObj(list);
        }catch (Exception e){
            e.printStackTrace();
            json.setSuccess(false);
            json.setMsg("查询失败！");
        }
        return json;
    }

    public static Map<String,DishLabelsRusltDTO> sortMapByKey(Map<String,DishLabelsRusltDTO> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String,DishLabelsRusltDTO> sortMap = new TreeMap<String,DishLabelsRusltDTO>(new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

	@Override
	public AjaxJson billQuery(String seatCode_billNumber) {
		AjaxJson aj = new AjaxJson();
		try{
			MaroShopEntity shop = userService.getShop();
			
			Map map = serverOrderApplyService.billQuery(seatCode_billNumber,shop.getId());
			if(map!=null){
                String serverOrderId = map.get("id").toString();
                List<Map> mapList = serverOrderApplyService.billQueryDetailsList(serverOrderId);

                Map<String, Object> attributes = new HashMap<String, Object>();

                attributes.put("mapMain", map);
                attributes.put("mapList", mapList);

                aj.setObj(attributes);
                StringBuffer s=new StringBuffer();
                if(map!=null){
                    s.append("账单：\r\n");
                    s.append("总计 "+map.get("quantity")+" 道菜 "+map.get("money")+"元\r\n");
                    if(mapList!=null&&mapList.size()>0){
                        for(Map maptmp:mapList){
                            s.append(maptmp.get("food_name")+"   "+maptmp.get("quantity")+maptmp.get("unit_name")+"\r\n");
                        }
                    }
                    aj.setMsg(s.toString());
                }else{
                    aj.setMsg("无账单记录！");
                }
            }else{
                aj.setMsg("无账单记录！");
            }
		}catch(Exception e){
			aj.setSuccess(false);
            aj.setMsg("查询失败！");
		}
		return aj;
	}

	@Override
	public AjaxJson reserveMessage() {
		AjaxJson aj = new AjaxJson();
		try{
			MaroShopEntity shop = userService.getShop();
			List<Map> mapList = serverOrderApplyService.reserveMessage(shop.getId());
			StringBuffer s=new StringBuffer();
			if(mapList!=null&&mapList.size()>0){
			    for(Map map:mapList){
                    s.append(map.get("customer_name")+"   "+map.get("flag")+"\r\n");
                }
                aj.setMsg(s.toString());
            }else{
                aj.setMsg("无预定记录！");
            }
            aj.setObj(mapList);
        }catch(Exception e){
			aj.setSuccess(false);
            aj.setMsg("查询失败！");
		}
		return aj;
	}

	@Override
	public AjaxJson reserveMessageSeatCode(String seatCode) {
		AjaxJson aj = new AjaxJson();
		try{
			MaroShopEntity shop = userService.getShop();
			List<Map> list = serverOrderApplyService.reserveMessageSeatCode(seatCode,shop.getId());
            StringBuffer s=new StringBuffer();
            if(list!=null&&list.size()>0){
                s.append(seatCode+"餐台目前状态:\r\n");
                for(Map map:list){
                    s.append("已被"+map.get("customer_name")+"预定\r\n");
                    s.append("抵达时间"+map.get("plan_come_time")+"\r\n");
                }
                aj.setMsg(s.toString());
            }else{
                aj.setMsg("无预定记录！");
            }
			aj.setObj(list);
		}catch(Exception e){
			aj.setSuccess(false);
            aj.setMsg("查询失败！");
		}
		return aj;
	}
    
}
