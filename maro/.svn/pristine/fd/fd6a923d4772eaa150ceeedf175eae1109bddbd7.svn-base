package com.maro.client.module.serverorder.apply;

import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.ServerorderDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;

import java.util.List;

/**
 * 用于MQ的服务订单数据同步操作接口
 * @author 冯成果
 * @date
 * @since
 */
public interface ServerorderService {

    /**
     * 保存服务订单
     * @param serverorderDTO
     */
    public void saveServerorder(ServerorderDTO serverorderDTO);

    /**
     * 根据参数DTO查询出符合参数值的服务订单列表
     * @param maroClientServerorderDTO 服务订单DTO
     * @return List<MaroClientServerorderDO>，成功则返回服务订单列表，失败则返回空
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本01.00.0001 由【冯成果】于【2018-03-26】进行添加
     */
    List<MaroClientServerorderDO> listServerOrderDO(MaroClientServerorderDTO maroClientServerorderDTO);

    /**
     * 方法描述，包括方法的作用，方法的什么时候什么场景用，方法怎么用
     * @param serverOrderId:服务订单id主键
     * @return MaroClientServerorderDTO，服务订单DTO
     * @author 冯成果
     * @since 版本号 01.00.0001
     * @version 版本 由【冯成果】于【01.00.0001】进行添加
     */
    MaroClientServerorderDTO getServerOrder(String serverOrderId);
}
