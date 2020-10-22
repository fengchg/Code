package com.maro.client.module.serverorder.service;

import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.PayParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.PayResultDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientPayedDetailDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientPayedDetailVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * MaroClientPayedDO的服务类，针对这个实体进行数据库的操作
 * @since 01.00.0001
 * @author 冯成果
 * @date 2018-03-26
 */
public interface MaroClientPayedService {

    /**
     * 保存服务订单支付记录DO到数据库
     * @param maroClientPayedDO 服务订单支付记录DO
     * @return Boolean，失败falset，成功
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    Boolean savePayedDO(MaroClientPayedDO maroClientPayedDO);


    /**
     * 根据参数DTO查询出符合参数值的服务订单支付记录列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientPayedDO>，成功则返回服务订单支付记录列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientPayedDO> listPayedDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 根据ID主键获取相应的服务订单支付记录
     * @param id 主键
     * @return MaroClientPayedDO，成功则返回服务订单支付记录，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientPayedDO getPayedDObyId(String id);

    /**
     * 根据服务订单ID主键获取相应的支付记录
     * @param serverOrderId 主键
     * @return MaroClientPayedDO，成功则返回支付记录实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientPayedDO> listPayedDOByServerOrderId(String serverOrderId);

    /**
     * 结账
     * @param payParamsDTO:结账参数传输对象，包括服务订单DO、支付记录DO
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-20】进行添加
     */
    void pay(PayParamsDTO payParamsDTO);


    BigDecimal getPayedAmount(String serverorderId);

    List<PayResultDTO> listPayedResultDTOByServerOrderId(String serverOrderId);
    
    List<MaroClientPayedDetailDO> listPayedDetailDObyPayId(String payId);
}
