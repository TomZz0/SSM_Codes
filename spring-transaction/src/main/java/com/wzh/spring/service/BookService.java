package com.wzh.spring.service;

public interface BookService {
    /**
     * 购置图书
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId, Integer bookId);
}
