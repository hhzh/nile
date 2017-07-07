package com.nile.controller.frontend;


import com.github.pagehelper.PageInfo;
import com.nile.VO.BookDetailVO;
import com.nile.common.ServerResponse;
import com.nile.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("detail")
    @ResponseBody
    public ServerResponse<BookDetailVO> detail(Integer bookId) {
        return bookService.getBookDetail(bookId);
    }

    @RequestMapping("list")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return bookService.getBookByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }

}
