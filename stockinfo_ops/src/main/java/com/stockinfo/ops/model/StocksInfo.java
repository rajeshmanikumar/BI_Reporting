package com.stockinfo.ops.model;
import javax.persistence.*;
@Entity
@Table(name = "stocks_info")
public class StocksInfo {
    @Id
    private Long stock_num;
    @Column(name = "stock_id")
    private String stock_id;
    @Column(name = "stock_name")
    private String stock_name;
    @Column(name = "stock_price")
    private Double stock_price;
    @Column(name = "stock_lastupdatedon")
    private java.sql.Timestamp stock_lastupdatedon;

    public Long getStock_num() {
        return this.stock_num;
    }

    public void setStock_num(Long stock_num) {
        this.stock_num = stock_num;
    }

    public String getStock_id() {
        return this.stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_name() {
        return this.stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public Double getStock_price() {
        return this.stock_price;
    }

    public void setStock_price(Double stock_price) {
        this.stock_price = stock_price;
    }

    public java.sql.Timestamp getStock_lastupdatedon() {
        return this.stock_lastupdatedon;
    }

    public void setStock_lastupdatedon(java.sql.Timestamp stock_lastupdatedon) {
        this.stock_lastupdatedon = stock_lastupdatedon;
    }

}
