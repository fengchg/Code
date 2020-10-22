package com.maro.client.module.serverorder.service.impl;

import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.constant.enumconstant.FoodTypeEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.PayParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.PayResultDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDetailDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientPayedDetailVO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientPayedVO;
import com.maro.client.module.serverorder.service.MaroClientPayedService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 服务订单支付记录服务实现
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@Service
public class MaroClientPayedServiceImpl implements MaroClientPayedService {

    @Resource
    private ClientCommonDao dao;

    @Override
    public Boolean savePayedDO(MaroClientPayedDO maroClientPayedDO) {
        dao.save(maroClientPayedDO);
        return null;
    }

    @Override
    public List<MaroClientPayedDO> listPayedDO(MaroClientServerorderDTO maroClientServerorderDTO) {
        return null;
    }

    @Override
    public MaroClientPayedDO getPayedDObyId(String id) {
        return dao.get(MaroClientPayedDO.class,id);

    }

    @Override
    public List<MaroClientPayedDO> listPayedDOByServerOrderId(String serverOrderId) {
        return dao.list(" from MaroClientPayedDO where serverOrderId=? order by payTime asc",serverOrderId);
    }

    @Override
    public void pay(PayParamsDTO payParamsDTO){
        BigDecimal smallChange = payParamsDTO.getMaroClientServerorderDO().getSmallChange();
        BigDecimal billMoney = payParamsDTO.getMaroClientServerorderDO().getBillMoney();
        String serverorderId = payParamsDTO.getMaroClientServerorderDO().getId();
        if(smallChange == null){
            smallChange=BigDecimal.ZERO;
        }

        if(billMoney == null){
            billMoney = BigDecimal.ZERO;
        }
        MaroClientPayedDO maroClientPayedDO = payParamsDTO.getMaroClientPayedDO();
        maroClientPayedDO.setId(UUID.randomUUID().toString());
        maroClientPayedDO.setPayTime(System.currentTimeMillis());
        maroClientPayedDO.setServerOrderId(serverorderId);
        maroClientPayedDO.setSmallChange(smallChange);
        maroClientPayedDO.setBillMoney(billMoney);
        savePayedDO(maroClientPayedDO);

        List<MaroClientPayedDetailDO> maroClientPayedDetailDOList = payParamsDTO.getMaroClientPayedDetailDOList();
        for(int i=0;i<maroClientPayedDetailDOList.size();i++){
            MaroClientPayedDetailDO maroClientPayedDetailDO = maroClientPayedDetailDOList.get(i);
            maroClientPayedDetailDO.setPayId(maroClientPayedDO.getId());
            maroClientPayedDetailDO.setId(UUID.randomUUID().toString());
            savePayedDetailDO(maroClientPayedDetailDO);
        }
    }

    private void savePayedDetailDO(MaroClientPayedDetailDO maroClientPayedDetailDO) {
        dao.save(maroClientPayedDetailDO);
    }

    @Override
    public BigDecimal getPayedAmount(String serverorderId){
        final String SQL_COUNT_GETPAYEDAMOUNT = "select sum(f.total_price) FROM maro_client__foodorder f WHERE f.server_order_id = ? and status !=? and type != ? and f.pay_id is not null";
        BigDecimal payedAmount = (BigDecimal) dao.getObjectBySql(SQL_COUNT_GETPAYEDAMOUNT, serverorderId, FoodOrderStatusEnum.REFUND.getCode(), FoodTypeEnum.GIFT.getCode());
        if(payedAmount == null){
            payedAmount = BigDecimal.ZERO;
        }
        return payedAmount;
    }

    @Override
    public List<PayResultDTO> listPayedResultDTOByServerOrderId(String serverOrderId){
        List<MaroClientPayedDO> maroClientPayedDOList = listPayedDOByServerOrderId(serverOrderId);
        List<MaroClientPayedVO> maroClientPayedVOs = PojoUtil.convertBatchDO2VO(maroClientPayedDOList, MaroClientPayedVO.class);
        List<PayResultDTO> payResultDTOList = new ArrayList<PayResultDTO>();
        for(int i=0;i<maroClientPayedVOs.size();i++){
            MaroClientPayedVO maroClientPayedVO = maroClientPayedVOs.get(i);
            PayResultDTO payResultDTO = new PayResultDTO();
            String payId = maroClientPayedVO.getId();
            List<MaroClientPayedDetailDO> maroClientPayedDetailDOList = listPayedDetailDObyPayId(payId);
            List<MaroClientPayedDetailVO> maroClientPayedDetailVOList = PojoUtil.convertBatchDO2VO(maroClientPayedDetailDOList, MaroClientPayedDetailVO.class);

            payResultDTO.setMaroClientPayedVO(maroClientPayedVO);
            payResultDTO.setMaroClientPayedDetailVOList(maroClientPayedDetailVOList);
        }
        return payResultDTOList;
    }

    public List<MaroClientPayedDetailDO> listPayedDetailDObyPayId(String payId) {
        final String HQL_LIST_GETPAYEDDETAILDOBYPAYID = "from MaroClientPayedDetailDO where payId = ?";
        return dao.list(HQL_LIST_GETPAYEDDETAILDOBYPAYID,payId);
    }
}
