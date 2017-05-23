package com.nile.VO;

import java.math.BigDecimal;
import java.util.List;

public class CartVO {

    private List<CartBookVO> cartBookVOList;
    private BigDecimal cartTotalPrice;
    private Boolean allChecked;//是否已经都勾选
    private String imageHost;

    public List<CartBookVO> getCartBookVOList() {
        return cartBookVOList;
    }

    public void setCartBookVOList(List<CartBookVO> cartBookVOList) {
        this.cartBookVOList = cartBookVOList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
