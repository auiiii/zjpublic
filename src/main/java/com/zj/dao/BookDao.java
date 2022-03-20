package com.zj.dao;

import java.util.List;

public interface BookDao {
    public Book selectById(int id);

    public List<Book> selectAll();
}
