package com.nile.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.nile.VO.BookListVO;
import com.nile.common.Const;
import com.nile.common.ResponseCode;
import com.nile.common.ServerResponse;
import com.nile.dao.BookMapper;
import com.nile.dao.CategoryMapper;
import com.nile.pojo.Book;
import com.nile.pojo.Category;
import com.nile.service.IBookService;
import com.nile.service.ICategoryService;
import com.nile.util.DateTimeUtil;
import com.nile.util.PropertiesUtil;
import com.nile.VO.BookDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("iBookService")
public class BookServiceImpl implements IBookService {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ICategoryService iCategoryService;

    public ServerResponse saveOrUpdateBook(Book book){
        if(book != null)
        {
            if(StringUtils.isNotBlank(book.getSubImages())){
                String[] subImageArray = book.getSubImages().split(",");
                if(subImageArray.length > 0){
                    book.setMainImage(subImageArray[0]);
                }
            }

            if(book.getId() != null){
                int rowCount = bookMapper.updateByPrimaryKey(book);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新产品成功");
                }
                return ServerResponse.createBySuccess("更新产品失败");
            }else{
                int rowCount = bookMapper.insert(book);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增产品成功");
                }
                return ServerResponse.createBySuccess("新增产品失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }


    public ServerResponse<String> setSaleStatus(Integer bookId,Integer status){
        if(bookId == null || status == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Book book = new Book();
        book.setId(bookId);
        book.setStatus(status);
        int rowCount = bookMapper.updateByPrimaryKeySelective(book);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("修改产品销售状态成功");
        }
        return ServerResponse.createByErrorMessage("修改产品销售状态失败");
    }


    public ServerResponse<BookDetailVO> manageBookDetail(Integer bookId){
        if(bookId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if(book == null){
            return ServerResponse.createByErrorMessage("产品已下架或者删除");
        }
        BookDetailVO bookDetailVO = assembleBookDetailVO(book);
        return ServerResponse.createBySuccess(bookDetailVO);
    }

    private BookDetailVO assembleBookDetailVO(Book book){
        BookDetailVO bookDetailVO = new BookDetailVO();
        bookDetailVO.setId(book.getId());
        bookDetailVO.setSubtitle(book.getSubtitle());
        bookDetailVO.setPrice(book.getPrice());
        bookDetailVO.setMainImage(book.getMainImage());
        bookDetailVO.setSubImages(book.getSubImages());
        bookDetailVO.setCategoryId(book.getCategoryId());
        bookDetailVO.setDetail(book.getDetail());
        bookDetailVO.setName(book.getName());
        bookDetailVO.setStatus(book.getStatus());
        bookDetailVO.setStock(book.getStock());

        bookDetailVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));

        Category category = categoryMapper.selectByPrimaryKey(book.getCategoryId());
        if(category == null){
            bookDetailVO.setParentCategoryId(0);//默认根节点
        }else{
            bookDetailVO.setParentCategoryId(category.getParentId());
        }

        bookDetailVO.setCreateTime(DateTimeUtil.dateToStr(book.getCreateTime()));
        bookDetailVO.setUpdateTime(DateTimeUtil.dateToStr(book.getUpdateTime()));
        return bookDetailVO;
    }



    public ServerResponse<PageInfo> getBookList(int pageNum,int pageSize){
        //startPage--start
        //填充自己的sql查询逻辑
        //pageHelper-收尾
        PageHelper.startPage(pageNum,pageSize);
        List<Book> bookList = bookMapper.selectList();

        List<BookListVO> bookListVOList = Lists.newArrayList();
        for(Book bookItem : bookList){
            BookListVO bookListVO = assembleBookListVO(bookItem);
            bookListVOList.add(bookListVO);
        }
        PageInfo pageResult = new PageInfo(bookList);
        pageResult.setList(bookListVOList);
        return ServerResponse.createBySuccess(pageResult);
    }

    private BookListVO assembleBookListVO(Book book){
        BookListVO bookListVO = new BookListVO();
        bookListVO.setId(book.getId());
        bookListVO.setName(book.getName());
        bookListVO.setCategoryId(book.getCategoryId());
        bookListVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));
        bookListVO.setMainImage(book.getMainImage());
        bookListVO.setPrice(book.getPrice());
        bookListVO.setSubtitle(book.getSubtitle());
        bookListVO.setStatus(book.getStatus());
        return bookListVO;
    }



    public ServerResponse<PageInfo> searchBook(String bookName,Integer bookId,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(bookName)){
            bookName = new StringBuilder().append("%").append(bookName).append("%").toString();
        }
        List<Book> bookList = bookMapper.selectByNameAndBookId(bookName,bookId);
        List<BookListVO> bookListVOList = Lists.newArrayList();
        for(Book bookItem : bookList){
            BookListVO bookListVO = assembleBookListVO(bookItem);
            bookListVOList.add(bookListVO);
        }
        PageInfo pageResult = new PageInfo(bookList);
        pageResult.setList(bookListVOList);
        return ServerResponse.createBySuccess(pageResult);
    }


    public ServerResponse<BookDetailVO> getBookDetail(Integer bookId){
        if(bookId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if(book == null){
            return ServerResponse.createByErrorMessage("产品已下架或者删除");
        }
        if(book.getStatus() != Const.BookStatusEnum.ON_SALE.getCode()){
            return ServerResponse.createByErrorMessage("产品已下架或者删除");
        }
        BookDetailVO bookDetailVO = assembleBookDetailVO(book);
        return ServerResponse.createBySuccess(bookDetailVO);
    }


    public ServerResponse<PageInfo> getBookByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy){
        if(StringUtils.isBlank(keyword) && categoryId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<Integer> categoryIdList = new ArrayList<Integer>();

        if(categoryId != null){
            Category category = categoryMapper.selectByPrimaryKey(categoryId);
            if(category == null && StringUtils.isBlank(keyword)){
                //没有该分类,并且还没有关键字,这个时候返回一个空的结果集,不报错
                PageHelper.startPage(pageNum,pageSize);
                List<BookListVO> bookListVOList = Lists.newArrayList();
                PageInfo pageInfo = new PageInfo(bookListVOList);
                return ServerResponse.createBySuccess(pageInfo);
            }
            categoryIdList = iCategoryService.selectCategoryAndChildrenById(category.getId()).getData();
        }
        if(StringUtils.isNotBlank(keyword)){
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();
        }

        PageHelper.startPage(pageNum,pageSize);
        //排序处理
        if(StringUtils.isNotBlank(orderBy)){
            if(Const.BookListOrderBy.PRICE_ASC_DESC.contains(orderBy)){
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0]+" "+orderByArray[1]);
            }
        }
        List<Book> bookList = bookMapper.selectByNameAndCategoryIds(StringUtils.isBlank(keyword)?null:keyword,categoryIdList.size()==0?null:categoryIdList);

        List<BookListVO> bookListVOList = Lists.newArrayList();
        for(Book book : bookList){
            BookListVO bookListVO = assembleBookListVO(book);
            bookListVOList.add(bookListVO);
        }

        PageInfo pageInfo = new PageInfo(bookList);
        pageInfo.setList(bookListVOList);
        return ServerResponse.createBySuccess(pageInfo);
    }

}
