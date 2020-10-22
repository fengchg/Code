package com.maro.client.module.serverorder.apply.impl;

import com.maro.client.common.constant.enumconstant.CommonTypeEnum;
import com.maro.client.common.constant.enumconstant.FoodOrderStatusEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.apply.ServerorderService;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.PayResultDTO;
import com.maro.client.module.serverorder.pojo.dto.ServerorderDTO;
import com.maro.client.module.serverorder.pojo.entity.*;
import com.maro.client.module.serverorder.pojo.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ServerorderServiceImpl implements ServerorderService {

    @Resource
    private ClientCommonDao dao;

    @Override
    public void saveServerorder(ServerorderDTO serverorderDTO) {
        MaroClientServerorderDO maroClientServerorderDO = serverorderDTO.getMaroClientServerorderDO();
        List<MaroClientFoodorderDO> maroClientFoodOrderDOs = serverorderDTO.getMaroClientFoodOrderDOs();
        List<MaroClientSeatchangeDO> maroClientSeatchangeDOs = serverorderDTO.getMaroClientSeatchangeDOs();
        List<MaroClientPayedDO> maroClientPayedDOs = serverorderDTO.getMaroClientPayedDOs();
//        List<MaroClientServerorderlogDO> maroClientServerorderlogDOs = serverorderDTO.getMaroClientServerorderlogDOs();

            dao.save(maroClientServerorderDO);
            dao.batchSave(maroClientFoodOrderDOs);
            dao.batchSave(maroClientSeatchangeDOs);
            dao.batchSave(maroClientPayedDOs);
        //        dao.batchSave(maroClientServerorderlogDOs);


    }
    @Override
    public List<MaroClientServerorderDO> listServerOrderDO(MaroClientServerorderDTO maroClientServerorderDTO) {
        //根据参数拼接where条件
        return dao.list("from MaroClientServerorderDO");
    }


    @Override
    public MaroClientServerorderDTO getServerOrder(String serverOrderId) {
        MaroClientServerorderDO serverOrderDO = dao.get(MaroClientServerorderDO.class,serverOrderId);
        MaroClientServerorderVO maroClientServerorderVO = PojoUtil.convertDO2VO(serverOrderDO, MaroClientServerorderVO.class);

        List<MaroClientFoodorderDO> maroClientFoodorderDOs = dao.list(" from MaroClientFoodorderDO where serverOrderId=? and status != ? order by createTime asc",serverOrderId, FoodOrderStatusEnum.REFUND.getCode());
        List<MaroClientFoodorderVO> maroClientFoodorderVOs = PojoUtil.convertBatchDO2VO(maroClientFoodorderDOs, MaroClientFoodorderVO.class);

        List<MaroClientSeatchangeDO> maroClientSeatchangeDOs = dao.list(" from MaroClientSeatchangeDO where serverOrderId=? and deleteFlag = ?",serverOrderId, CommonTypeEnum.DELETE_FLAG_NO.getCode());
        List<MaroClientSeatchangeVO> maroClientSeatchangeVOs = PojoUtil.convertBatchDO2VO(maroClientSeatchangeDOs, MaroClientSeatchangeVO.class);

        List<MaroClientServerorderlogDO> maroClientServerorderlogDOs =  dao.list(" from MaroClientServerorderlogDO where serverOrderId=? order by happenTime asc",serverOrderId);
        List<MaroClientServerorderlogVO> MaroClientServerorderlogVOs = PojoUtil.convertBatchDO2VO(maroClientServerorderlogDOs, MaroClientServerorderlogVO.class);


        List<MaroClientPayedDO> maroClientPayedDOs = dao.list(" from MaroClientPayedDO where serverOrderId=? order by payTime asc",serverOrderId);
        List<MaroClientPayedVO> maroClientPayedVOs = PojoUtil.convertBatchDO2VO(maroClientPayedDOs, MaroClientPayedVO.class);
        List<PayResultDTO> payResultDTOList = listPayedResultDTOByServerOrderId(serverOrderId);

        MaroClientServerorderDTO maroClientServerorderDTO = new MaroClientServerorderDTO();
        maroClientServerorderDTO.setMaroClientServerorderVO(maroClientServerorderVO);
        maroClientServerorderDTO.setMaroClientFoodOrderVOs(maroClientFoodorderVOs);
        maroClientServerorderDTO.setMaroClientSeatchangeVOs(maroClientSeatchangeVOs);
        maroClientServerorderDTO.setMaroClientServerorderlogVOs(MaroClientServerorderlogVOs);
        maroClientServerorderDTO.setMaroClientPayedVOs(maroClientPayedVOs);
        maroClientServerorderDTO.setPayResultDTO(payResultDTOList);
//        maroClientServerorderDTO.setMaroClientPayedDOs(maroClientPayedDOs);

        return maroClientServerorderDTO;
    }


    public List<PayResultDTO> listPayedResultDTOByServerOrderId(String serverOrderId){
        List<MaroClientPayedDO> maroClientPayedDOList = dao.list(" from MaroClientPayedDO where serverOrderId=? order by payTime asc",serverOrderId);
        List<MaroClientPayedVO> maroClientPayedVOs = PojoUtil.convertBatchDO2VO(maroClientPayedDOList, MaroClientPayedVO.class);
        List<PayResultDTO> payResultDTOList = new ArrayList<PayResultDTO>();
        for(int i=0;i<maroClientPayedVOs.size();i++){
            MaroClientPayedVO maroClientPayedVO = maroClientPayedVOs.get(i);
            PayResultDTO payResultDTO = new PayResultDTO();
            String payId = maroClientPayedVO.getId();
            List<MaroClientPayedDetailDO> maroClientPayedDetailDOList =  dao.list("from MaroClientPayedDetailDO where payId = ?",payId);
            List<MaroClientPayedDetailVO> maroClientPayedDetailVOList = PojoUtil.convertBatchDO2VO(maroClientPayedDetailDOList, MaroClientPayedDetailVO.class);

            payResultDTO.setMaroClientPayedVO(maroClientPayedVO);
            payResultDTO.setMaroClientPayedDetailVOList(maroClientPayedDetailVOList);
        }
        return payResultDTOList;
    }
}
