package com.wzh.spring.controller;

import com.wzh.spring.service.BookService;
import com.wzh.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId, Integer bookId) {
        bookService.buyBook(userId, bookId);
    }

    public void checkOut(Integer userId,Integer[] bookIds){
        checkoutService.checkOut(userId,bookIds);
    }
}
