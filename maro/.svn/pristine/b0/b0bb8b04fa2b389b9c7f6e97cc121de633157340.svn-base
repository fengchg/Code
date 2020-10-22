package com.maro.client.module.reserve.pojo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "maro_client_reserve_foodorder", schema = "", catalog = "")
public class MaroClientReserveFoodorderDO {
    private String id;
    private String reserveId;
    private String foodType;
    private String foodTypeCode;
    private String foodName;
    private String foodCode;
    private BigDecimal quantity;
    private String unitCode;
    private String unitName;
    private BigDecimal price;
    private BigDecimal totalPrice;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reserve_id", nullable = true, length = 36)
    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    @Basic
    @Column(name = "food_type", nullable = true, length = 20)
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Basic
    @Column(name = "food_type_code", nullable = true, length = 36)
    public String getFoodTypeCode() {
        return foodTypeCode;
    }

    public void setFoodTypeCode(String foodTypeCode) {
        this.foodTypeCode = foodTypeCode;
    }

    @Basic
    @Column(name = "food_name", nullable = true, length = 20)
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "food_code", nullable = true, length = 36)
    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    @Basic
    @Column(name = "quantity", nullable = true, precision = 2)
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_code", nullable = true, length = 10)
    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @Basic
    @Column(name = "unit_name", nullable = true, length = 5)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 2)
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaroClientReserveFoodorderDO that = (MaroClientReserveFoodorderDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reserveId != null ? !reserveId.equals(that.reserveId) : that.reserveId != null) return false;
        if (foodType != null ? !foodType.equals(that.foodType) : that.foodType != null) return false;
        if (foodTypeCode != null ? !foodTypeCode.equals(that.foodTypeCode) : that.foodTypeCode != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (unitCode != null ? !unitCode.equals(that.unitCode) : that.unitCode != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reserveId != null ? reserveId.hashCode() : 0);
        result = 31 * result + (foodType != null ? foodType.hashCode() : 0);
        result = 31 * result + (foodTypeCode != null ? foodTypeCode.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (unitCode != null ? unitCode.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
