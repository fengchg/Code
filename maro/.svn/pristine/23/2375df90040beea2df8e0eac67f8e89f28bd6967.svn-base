package com.maro.client.module.serverorder.service.impl;

import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.module.serverorder.pojo.dto.FoodOrderParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.SeatchangeParamsDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientFoodorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.service.MaroClientServerorderlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * 服务订单日志服务实现
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@Service
public class MaroClientServerorderlogServiceImpl implements MaroClientServerorderlogService {

    @Resource
    private ClientCommonDao dao;
    @Override
    public Boolean saveServerorderlogDO(MaroClientServerorderlogDO maroClientServerorderlogDO) {
        dao.save(maroClientServerorderlogDO);
        return true;
    }

    @Override
    public List<MaroClientServerorderlogDO> listServerorderlogDO(MaroClientServerorderDTO maroClientServerorderDTO) {
        return null;
    }

    @Override
    public MaroClientServerorderlogDO getServerorderlogDObyId(String id) {
        return dao.get(MaroClientServerorderlogDO.class,id);
    }

    @Override
    public List<MaroClientServerorderlogDO> listServerorderlogDOByServerOrderId(String serverOrderId) {
        return dao.list(" from MaroClientServerorderlogDO where serverOrderId=? order by happenTime asc",serverOrderId);
    }

    @Override
    public void log(Integer code, String name, String serverorderId) {
        MaroClientServerorderlogDO logDO = new MaroClientServerorderlogDO();
        logDO.setId(UUID.randomUUID().toString());
        logDO.setHappenTime(System.currentTimeMillis());
        logDO.setServerOrderId(serverorderId);
        logDO.setType(code);
        logDO.setDescription(name);
        saveServerorderlogDO(logDO);
    }

    @Override
    public void logMergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList) {
        MaroClientServerorderDO maroClientServerorderDO = seatchangeParamsDTOList.get(0).getMaroClientServerorderDO();
        String serverorderId = maroClientServerorderDO.getId();
        String leadMergeSeatName = seatchangeParamsDTOList.get(0).getMergeMaroShopSeatEntity().getName();
        StringBuffer description = new StringBuffer(leadMergeSeatName);
        description.append(ServerOrderLogTypeEnum.MERGE_SEAT.getName());
        for(int i=1;i<seatchangeParamsDTOList.size();i++){
            SeatchangeParamsDTO seatchangeParamsDTO = seatchangeParamsDTOList.get(i);
            String shopName = seatchangeParamsDTO.getMergeMaroShopSeatEntity().getName();
            description.append(shopName).append("、");
        }
        log(ServerOrderLogTypeEnum.MERGE_SEAT.getCode(),description.toString(),serverorderId);
    }

    @Override
    public void logFoodOrder(FoodOrderParamsDTO foodOrderParamsDTO,ServerOrderLogTypeEnum serverOrderLogTypeEnum){
        List<MaroClientFoodorderDO> maroClientFoodorderDOList = foodOrderParamsDTO.getMaroClientFoodorderDOList();
        try{
            StringBuffer description = new StringBuffer();
            for(int i=0;i<maroClientFoodorderDOList.size();i++) {
                MaroClientFoodorderDO maroClientFoodorderDO = maroClientFoodorderDOList.get(i);
                String foodName = maroClientFoodorderDO.getFoodName();
                BigDecimal quantity = maroClientFoodorderDO.getQuantity();
                description.append(serverOrderLogTypeEnum.getName()+foodName+quantity).append(",");
            }
            log(serverOrderLogTypeEnum.getCode(),description.toString(),foodOrderParamsDTO.getMaroClientServerorderDO().getId());
        }catch (Exception e){

        }
    }


   @Override
   public void logFoodOrder1(FoodOrderParamsDTO foodOrderParamsDTO, ServerOrderLogTypeEnum serverOrderLogTypeEnum){
       MaroClientFoodorderDO maroClientFoodorderDO = foodOrderParamsDTO.getMaroClientFoodorderDO();
       Integer status = FoodOrderStatusEnum.FINISH.getCode();
       String foodId = maroClientFoodorderDO.getId();
       String foodName = maroClientFoodorderDO.getFoodName();
       BigDecimal quantity = maroClientFoodorderDO.getQuantity();
       log(serverOrderLogTypeEnum.getCode(),serverOrderLogTypeEnum.getName()+foodName,foodOrderParamsDTO.getMaroClientServerorderDO().getId());
   }

}
