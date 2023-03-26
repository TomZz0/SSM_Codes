package com.wzh.spring.dao;

public interface BookDao {
    /**
     * 根据图书id查询图书价格 并返回
     * @param bookId
     * @return
     */
    Integer getPrice(Integer bookId);

    /**
     * 更新图书库存 默认每次只能购买一本图书
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户余额
     * @param price
     * @param userId
     */
    void updateBalance(Integer price, Integer userId);
}
