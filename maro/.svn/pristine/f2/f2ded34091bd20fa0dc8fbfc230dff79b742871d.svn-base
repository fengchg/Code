package com.maro.client.module.serverorder.pojo.vo;

import com.maro.client.common.annotation.EnumDescription;
import com.maro.client.common.annotation.TimeFieldDescription;
import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.module.serverorder.pojo.entity.MaroClientSeatchangeDO;

public class MaroClientSeatchangeVO extends MaroClientSeatchangeDO{

    private String happenTimeString;
    private String typeString;
    /**
     * 当桌位并桌的时候，所属的分组号
     */
    private Integer group;
    /**
     * 当桌位并桌的时候，所属的分组号字符串表示

     */
    private String groupString;

    /**
     * 如果有并桌时，该属性表示是否是主桌，如果是主桌则表示是在这个桌位上，并桌了其他的桌位

     */
    private Boolean groupLead;


    /**
     * 服务订单VO信息

     */
    private MaroClientServerorderVO maroClientServerorderVO;

    public MaroClientServerorderVO getMaroClientServerorderVO() {
        return maroClientServerorderVO;
    }

    public void setMaroClientServerorderVO(MaroClientServerorderVO maroClientServerorderVO) {
        this.maroClientServerorderVO = maroClientServerorderVO;
    }


    public Boolean getGroupLead() {
        return groupLead;
    }

    @TimeFieldDescription(timeFieldName = "happenTime",pattern = "yyyy-MM-dd")
    public void setHappenTimeString(String happenTimeString) {
        this.happenTimeString = happenTimeString;
    }

    @EnumDescription(enumFieldName = "type",targetEnum = ServerOrderLogTypeEnum.class)
    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public void setGroupLead(Boolean groupLead) {
        this.groupLead = groupLead;
    }


    public String getHappenTimeString() {
        return happenTimeString;
    }

    public String getTypeString() {
        return typeString;
    }
    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getGroupString() {
        return groupString;
    }

    public void setGroupString(String groupString) {
        this.groupString = groupString;
    }
}
