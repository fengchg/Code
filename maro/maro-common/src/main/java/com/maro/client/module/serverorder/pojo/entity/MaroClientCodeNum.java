package com.maro.client.module.serverorder.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "maro_client_code_num", schema = "", catalog = "")
public class MaroClientCodeNum {
    private Date createDate;
    private Integer codeNum;
    private String id;
    private String shopId;

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "code_num")
    public Integer getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(Integer codeNum) {
        this.codeNum = codeNum;
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
    @Column(name = "shop_id")
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
