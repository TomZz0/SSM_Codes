package com.wzh.spring.service;

public interface CheckoutService {
    /**
     * 结账功能
     * @param userId
     * @param bookIds
     */
    void checkOut(Integer userId, Integer[] bookIds);
}
