package com.maro.client.module.serverorder.service;

import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.module.serverorder.pojo.dto.FoodOrderParamsDTO;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.SeatchangeParamsDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderlogDO;

import java.util.List;

/**
 * MaroClientServerorderDO的服务类，针对这个实体进行数据库的操作
 * @since 01.00.0001
 * @author 冯成果
 * @date 2018-03-26
 */
public interface MaroClientServerorderlogService {

/**
 * 保存服务订单日志DO到数据库
 * @param maroClientServerorderlogDO 服务订单日志DO
 * @return Boolean，失败falset，成功
 * @author 冯成果
 * @since 版本号 01.00.0001
 * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
 */
Boolean saveServerorderlogDO(MaroClientServerorderlogDO maroClientServerorderlogDO);


    /**
     * 根据参数DTO查询出符合参数值的服务订单日志列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientServerorderlogDO>，成功则返回服务订单日志列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientServerorderlogDO> listServerorderlogDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 根据ID主键获取相应的服务订单日志记录
     * @param id 主键
     * @return MaroClientServerorderlogDO，成功则返回服务订单日志实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    MaroClientServerorderlogDO getServerorderlogDObyId(String id);


    /**
     * 根据服务订单ID主键获取相应的服务订单日志记录
     * @param serverOrderId 主键
     * @return MaroClientServerorderlogDO，成功则返回服务订单日志实体，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-27】进行添加
     */
    List<MaroClientServerorderlogDO> listServerorderlogDOByServerOrderId(String serverOrderId);

    /**
     * 做日志
     * @param code：日志类型
     * @param name：日志类型描述
     * @param serverorderId：服务订单主键
     * @return
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void log(Integer code, String name, String serverorderId);

    void logMergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList);

    /**
     * 点餐模块的日志记录1
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void logFoodOrder(FoodOrderParamsDTO foodOrderParamsDTO,ServerOrderLogTypeEnum serverOrderLogTypeEnum);
    /**
     * 点餐模块的日志记录2
     * @author 冯成果
     * @since 01.00.0001
     * @version 01.00.0001
     * @description 由【冯成果】于【2018-4-17】进行添加
     */
    void logFoodOrder1(FoodOrderParamsDTO foodOrderParamsDTO, ServerOrderLogTypeEnum serverOrderLogTypeEnum);

}
