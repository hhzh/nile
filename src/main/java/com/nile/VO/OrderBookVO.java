package com.nile.VO;

import java.math.BigDecimal;
import java.util.List;

public class OrderBookVO {
    private List<OrderItemVO> orderItemVOList;
    private BigDecimal bookTotalPrice;
    private String imageHost;

    public List<OrderItemVO> getOrderItemVoList() {
        return orderItemVOList;
    }

    public void setOrderItemVoList(List<OrderItemVO> orderItemVOList) {
        this.orderItemVOList = orderItemVOList;
    }

    public BigDecimal getBookTotalPrice() {
        return bookTotalPrice;
    }

    public void setBookTotalPrice(BigDecimal bookTotalPrice) {
        this.bookTotalPrice = bookTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
