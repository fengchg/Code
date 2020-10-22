package com.maro.client.module.serverorder.service;

import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.SeatchangeParamsDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientSeatchangeDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientSeatchangeVO;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.common.shop.pojo.entity.MaroShopEntity;

import java.util.List;

/**
 * MaroClientSeatchangeDO的服务类，针对这个实体进行数据库的操作
 * @since 01.00.0001
 * @author 冯成果
 * @date 2018-03-26
 */
public interface MaroClientSeatchangeService {

    /**
     * 保存桌位更换记录DO到数据库
     * @param maroClientSeatchangeDO 桌位更换记录DO
     * @return Boolean，失败falset，成功
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    Boolean saveSeatchangeDO(MaroClientSeatchangeDO maroClientSeatchangeDO);


    /**
     * 根据参数DTO查询出符合参数值的桌位更换记录列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientSeatchangeDO>，成功则返回桌位更换记录列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientSeatchangeDO> listSeatchangeDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 根据ID主键获取相应的桌位更换记录
     * @param id 主键
     * @return MaroClientServerorderDO，成功则返回桌位更换记录实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientSeatchangeDO getSeatchangeDObyId(String id);
    /**
     * 根据服务订单ID主键获取相应的桌位更换记录
     * @param serverOrderId 主键
     * @return MaroClientSeatchangeDO，成功则返回桌位更换记录实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientSeatchangeDO> listSeatchangeDOByServerOrderId(String serverOrderId);
    /**
     * 根据服务订单ID主键获取相应的桌位更换记录
     * @param listServerOrder：服务订单DO
     * @return List<MaroClientSeatchangeVO>：成功返回桌位信息VO列表，失败则size为0的空列表
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientSeatchangeVO> listUsedSeatchangeDO(List<MaroClientServerorderDO> listServerOrder);

    /**
     * 换桌
     * @param oldSeatId：原桌位主键
     * @param newSeatId：新桌位主键
     * @param serverorderId：服务订单主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void changeSeat(SeatchangeParamsDTO seatchangeParamsDTO);


    /**
     * 换桌
     * @param oldSeatId：原桌位主键
     * @param newSeatId：新桌位主键
     * @param serverorderId：服务订单主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void open(MaroClientServerorderDO maroClientServerorderDO,MaroShopSeatEntity maroShopSeatEntity);

    void mergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList);

    void cancelMergeSeat(SeatchangeParamsDTO seatchangeParamsDTO);

    boolean isSeatMerged(String id, String id1);
}
