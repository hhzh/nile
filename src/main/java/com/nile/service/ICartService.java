package com.nile.service;


import com.nile.common.ServerResponse;
import com.nile.VO.CartVO;

public interface ICartService {

    ServerResponse<CartVO> add(Integer userId, Integer bookId, Integer count);

    ServerResponse<CartVO> update(Integer userId, Integer bookId, Integer count);

    ServerResponse<CartVO> deleteBook(Integer userId, String bookIds);

    ServerResponse<CartVO> list(Integer userId);

    ServerResponse<CartVO> selectOrUnSelect(Integer userId, Integer bookId, Integer checked);

    ServerResponse<Integer> getCartBookCount(Integer userId);
}
