package com.zj.service;

import com.zj.dao.Book;
import com.zj.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getBookList()
    {
        return bookDao.selectAll();
    }

    public Book getBookById(int id)
    {
        return bookDao.selectById(id);
    }

}
