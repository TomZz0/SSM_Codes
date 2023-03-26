package com.wzh.spring.service.impl;

import com.wzh.spring.dao.BookDao;
import com.wzh.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(
     //   readOnly = true 只读
     //   timeout = 3 时间限制 默认为-1表示无限制 若超时 就会强制回滚 抛出异常
     //   noRollbackFor = ArithmeticException.class 不因为什么而回滚(后跟数组 只有一个元素时可以不加大括号)
     //   因为默认出现运行时异常都会回滚 但在某些情况下 数据库正常操作完毕 后边又出现了诸如
     //  by zero 的操作 属于运行异常但是不会影响数据库信息的正确性 就可以设置不因为
     //   这个ArithmeticException.class而回滚 也可以 用全类名noRollbackForClassName = ""
     //   isolation = Isolation.DEFAULT 设置隔离级别
     //   propagation = Propagation.REQUIRES_NEW //设置传播行为 使用当前方法的事务
//        propagation = Propagation.REQUIRED 默认使用调用者的事务
//)
//Service层需要加上事务管理
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getPrice(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(price,userId);
    }
}
