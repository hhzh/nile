package com.nile.VO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
public class OrderProductVO {
    private List<OrderItemVO> orderItemVOList;
    private BigDecimal productTotalPrice;
    private String imageHost;

    public List<OrderItemVO> getOrderItemVoList() {
        return orderItemVOList;
    }

    public void setOrderItemVoList(List<OrderItemVO> orderItemVOList) {
        this.orderItemVOList = orderItemVOList;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
