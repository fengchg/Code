package com.maro.client.module.reserve.apply.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.reserve.apply.MaroClientReserveApplyService;
import com.maro.client.module.reserve.pojo.dto.ReserveParamsDTO;
import com.maro.client.module.reserve.pojo.dto.ReserveResultDTO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveDO;
import com.maro.client.module.reserve.pojo.entity.MaroClientReserveSeatDO;
import com.maro.client.module.reserve.pojo.vo.MaroClientReserveSeatVO;
import com.maro.client.module.reserve.pojo.vo.MaroClientReserveVO;
import com.maro.client.module.reserve.service.MaroClientReserveSeatService;
import com.maro.client.module.reserve.service.MaroClientReserveService;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.service.MaroClientServerorderService;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.service.MaroCommonShopServiceI;
import com.maro.platform.core.common.model.json.AjaxJson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务订单模块的总服务调用接口的实现类
 * @author 冯成果
 * @date 2018-3-27
 * @see MaroClientReserveApplyService
 * @since 版本号 01.00.0001
*/
@Service
public class MaroClientReserveApplyServiceImpl implements MaroClientReserveApplyService {

    @Resource(name = "maroClientReserveServiceImpl1")
    private MaroClientReserveService maroClientReserveService;

    @Resource
    private MaroClientReserveSeatService maroClientReserveSeatService;

    @Resource
    private MaroCommonShopServiceI maroCommonService;
    @Resource
    private MaroClientServerorderService maroClientServerorderService;

    @Override
    public AjaxJson reserve(ReserveParamsDTO reserveParamsDTO) {
        String seatId = reserveParamsDTO.getSeatId();
        AjaxJson ajaxJson = new AjaxJson();
        MaroShopSeatEntity seatEntity = new MaroShopSeatEntity();
        seatEntity.setId(seatId);
        MaroClientServerorderDO serverorderDO = maroClientServerorderService.getServerOrderDObySeatId(seatEntity);
        if(serverorderDO != null){
            ajaxJson.setMsg(StringConstant.TIP_OPEN_OPENED);
            ajaxJson.setSuccess(false);
            return ajaxJson;
        }

        seatEntity = maroCommonService.getShopSeatInfoBySeatId(seatId);

        reserveParamsDTO.setMaroShopSeatEntity(seatEntity);
        MaroClientReserveDO maroClientReserveDO = maroClientReserveService.save(reserveParamsDTO);
        MaroClientReserveVO maroClientReserveVO = PojoUtil.convertDO2VO(maroClientReserveDO, MaroClientReserveVO.class);

        reserveParamsDTO.setMaroClientReserveDO(maroClientReserveDO);
        MaroClientReserveSeatDO maroClientReserveSeatDO = maroClientReserveSeatService.save(reserveParamsDTO);
        MaroClientReserveSeatVO maroClientReserveSeatVO = PojoUtil.convertDO2VO(maroClientReserveSeatDO, MaroClientReserveSeatVO.class);

        ReserveResultDTO reserveResultDTO = new ReserveResultDTO();
        reserveResultDTO.setMaroClientReserveVO(maroClientReserveVO);
        reserveResultDTO.setMaroClientReserveSeatVO(maroClientReserveSeatVO);

        ajaxJson.setObj(reserveResultDTO);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        ajaxJson.setSuccess(true);
        return ajaxJson;
    }

    @Override
    public ReserveResultDTO listReserveBySeatId(String seatId) {
        List<MaroClientReserveDO> maroClientReserveDOList = maroClientReserveService.listReserveBySeatId(seatId);
        ReserveResultDTO reserveResultDTO = new ReserveResultDTO();
        List<MaroClientReserveVO> reserveResultVOList = new ArrayList<MaroClientReserveVO>();
        for(int i=0;i<maroClientReserveDOList.size();i++){
            MaroClientReserveDO maroClientReserveDO = maroClientReserveDOList.get(i);
            MaroClientReserveVO maroClientReserveVO = PojoUtil.convertDO2VO(maroClientReserveDO,MaroClientReserveVO.class);
            reserveResultVOList.add(maroClientReserveVO);
        }
        reserveResultDTO.setMaroClientReserveVOList(reserveResultVOList);
        return reserveResultDTO;
    }


    @Override
    public Boolean cancelReserve(String reserveId){
       maroClientReserveService.cancelReserve(reserveId);
       maroClientReserveSeatService.cancelReserve(reserveId);
        return true;
    }

    @Override
    public Boolean open(String reserveId) {
        maroClientReserveService.open(reserveId);
        maroClientReserveSeatService.open(reserveId);
        return true;
    }
    @Override
    public String getSeatCurrentReserve(String seatId){
        return maroClientReserveService.getSeatCurrentReserve(seatId);
    }
}
