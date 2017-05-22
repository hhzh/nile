package com.nile.service;

import com.github.pagehelper.PageInfo;
import com.nile.common.ServerResponse;
import com.nile.pojo.Book;
import com.nile.vo.BookDetailVo;

public interface IBookService {

    ServerResponse saveOrUpdateBook(Book Book);

    ServerResponse<String> setSaleStatus(Integer BookId, Integer status);

    ServerResponse<BookDetailVo> manageBookDetail(Integer BookId);

    ServerResponse<PageInfo> getBookList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchBook(String BookName, Integer BookId, int pageNum, int pageSize);

    ServerResponse<BookDetailVo> getBookDetail(Integer BookId);

    ServerResponse<PageInfo> getBookByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);



}
