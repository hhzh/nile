package com.nile.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.nile.common.Const;
import com.nile.common.ResponseCode;
import com.nile.common.ServerResponse;
import com.nile.dao.BookMapper;
import com.nile.dao.CartMapper;
import com.nile.pojo.Book;
import com.nile.pojo.Cart;
import com.nile.service.ICartService;
import com.nile.util.BigDecimalUtil;
import com.nile.util.PropertiesUtil;
import com.nile.VO.CartBookVO;
import com.nile.VO.CartVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private BookMapper bookMapper;

    public ServerResponse<CartVO> add(Integer userId, Integer bookId, Integer count) {
        if (bookId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }


        Cart cart = cartMapper.selectCartByUserIdBookId(userId, bookId);
        if (cart == null) {
            //这个产品不在这个购物车里,需要新增一个这个产品的记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setBookId(bookId);
            cartItem.setUserId(userId);
            cartMapper.insert(cartItem);
        } else {
            //这个产品已经在购物车里了.
            //如果产品已存在,数量相加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }

    public ServerResponse<CartVO> update(Integer userId, Integer bookId, Integer count) {
        if (bookId == null || count == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdBookId(userId, bookId);
        if (cart != null) {
            cart.setQuantity(count);
        }
        cartMapper.updateByPrimaryKey(cart);
        return this.list(userId);
    }

    public ServerResponse<CartVO> deleteBook(Integer userId, String bookIds) {
        List<String> bookList = Splitter.on(",").splitToList(bookIds);
        if (CollectionUtils.isEmpty(bookList)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        cartMapper.deleteByUserIdBookIds(userId, bookList);
        return this.list(userId);
    }


    public ServerResponse<CartVO> list(Integer userId) {
        CartVO cartVO = this.getCartVOLimit(userId);
        return ServerResponse.createBySuccess(cartVO);
    }


    public ServerResponse<CartVO> selectOrUnSelect(Integer userId, Integer bookId, Integer checked) {
        cartMapper.checkedOrUncheckedBook(userId, bookId, checked);
        return this.list(userId);
    }

    public ServerResponse<Integer> getCartBookCount(Integer userId) {
        if (userId == null) {
            return ServerResponse.createBySuccess(0);
        }
        return ServerResponse.createBySuccess(cartMapper.selectCartBookCount(userId));
    }


    private CartVO getCartVOLimit(Integer userId) {
        CartVO cartVO = new CartVO();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartBookVO> cartBookVOList = Lists.newArrayList();

        BigDecimal cartTotalPrice = new BigDecimal("0");

        if (CollectionUtils.isNotEmpty(cartList)) {
            for (Cart cartItem : cartList) {
                CartBookVO cartBookVO = new CartBookVO();
                cartBookVO.setId(cartItem.getId());
                cartBookVO.setUserId(userId);
                cartBookVO.setBookId(cartItem.getBookId());

                Book book = bookMapper.selectByPrimaryKey(cartItem.getBookId());
                if (book != null) {
                    cartBookVO.setBookMainImage(book.getMainImage());
                    cartBookVO.setBookName(book.getName());
                    cartBookVO.setBookSubtitle(book.getSubtitle());
                    cartBookVO.setBookStatus(book.getStatus());
                    cartBookVO.setBookPrice(book.getPrice());
                    cartBookVO.setBookStock(book.getStock());
                    //判断库存
                    if (book.getStock() >= cartItem.getQuantity()) {
                        //库存充足的时候
                        cartBookVO.setQuantity(cartItem.getQuantity());
                        cartBookVO.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    } else {
                        cartBookVO.setQuantity(book.getStock());
                        cartBookVO.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(book.getStock());
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }

                    //计算总价
                    cartBookVO.setBookTotalPrice(BigDecimalUtil.mul(book.getPrice().doubleValue(), cartBookVO.getQuantity()));
                    cartBookVO.setBookChecked(cartItem.getChecked());
                }

                if (cartItem.getChecked() == Const.Cart.CHECKED) {
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(), cartBookVO.getBookTotalPrice().doubleValue());
                }
                cartBookVOList.add(cartBookVO);
            }
        }
        cartVO.setCartTotalPrice(cartTotalPrice);
        cartVO.setCartBookVOList(cartBookVOList);
        cartVO.setAllChecked(this.getAllCheckedStatus(userId));
        cartVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVO;
    }

    private boolean getAllCheckedStatus(Integer userId) {
        if (userId == null) {
            return false;
        }
        return cartMapper.selectCartBookCheckedStatusByUserId(userId) == 0;

    }


}
