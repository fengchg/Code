package com.maro.client.module.serverorder.pojo.entity;

import javax.persistence.*;

/**
 * 服务订单日志DO
 * @author 冯成果
 * @date 2018-4-2
 * @since 版本号 01.00.0001
*/
@Entity
@Table(name = "maro_client_serverorderlog", schema = "", catalog = "")
public class MaroClientServerorderlogDO {
    /**
     * 主键
     */
    private String id;
    /**
     * 发生时间
     */
    private Long happenTime;
    /**
     * 类型，这里有‘上桌’，‘点餐’，‘换桌’等类型，可参考下面的枚举类型
     * @see com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum
     */
    private Integer type;
    /**
     * 日志描述
     */
    private String description;
    /**
     * 服务订单主键
     */
    private String serverOrderId;

    @Basic
    @Column(name = "server_order_id", nullable = true)
    public String getServerOrderId() {
        return serverOrderId;
    }

    public void setServerOrderId(String serverOrderId) {
        this.serverOrderId = serverOrderId;
    }

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "happen_time", nullable = true)
    public Long getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Long happenTime) {
        this.happenTime = happenTime;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaroClientServerorderlogDO that = (MaroClientServerorderlogDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (happenTime != null ? !happenTime.equals(that.happenTime) : that.happenTime != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (happenTime != null ? happenTime.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
