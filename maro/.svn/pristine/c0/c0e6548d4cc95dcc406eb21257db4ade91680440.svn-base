package com.maro.client.module.evaluate.pojo.entity;

import javax.persistence.*;

@Entity
@Table(name = "maro_client__evaluate", schema = "", catalog = "")
public class MaroClientEvaluateDO {
    private String id;
    private String restaurantId;
    private String serverOrderId;
    private String foodOrderId;
    private Long happenTime;
    private Integer lever;
    private String content;
    private String customerName;
    private String phone;

    @Id
    @Column(name = "id", nullable = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "restaurant_id", nullable = true, length = 36)
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "server_order_id", nullable = true, length = 36)
    public String getServerOrderId() {
        return serverOrderId;
    }

    public void setServerOrderId(String serverOrderId) {
        this.serverOrderId = serverOrderId;
    }

    @Basic
    @Column(name = "food_order_id", nullable = true, length = 36)
    public String getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(String foodOrderId) {
        this.foodOrderId = foodOrderId;
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
    @Column(name = "lever", nullable = true)
    public Integer getLever() {
        return lever;
    }

    public void setLever(Integer lever) {
        this.lever = lever;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 1000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 20)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaroClientEvaluateDO that = (MaroClientEvaluateDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;
        if (serverOrderId != null ? !serverOrderId.equals(that.serverOrderId) : that.serverOrderId != null)
            return false;
        if (foodOrderId != null ? !foodOrderId.equals(that.foodOrderId) : that.foodOrderId != null) return false;
        if (happenTime != null ? !happenTime.equals(that.happenTime) : that.happenTime != null) return false;
        if (lever != null ? !lever.equals(that.lever) : that.lever != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (serverOrderId != null ? serverOrderId.hashCode() : 0);
        result = 31 * result + (foodOrderId != null ? foodOrderId.hashCode() : 0);
        result = 31 * result + (happenTime != null ? happenTime.hashCode() : 0);
        result = 31 * result + (lever != null ? lever.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
