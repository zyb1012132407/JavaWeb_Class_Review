package cn.edu.bdu.test.Chapter06.Test2;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    //定义一个Map<String,Book>用来模拟数据库的存储
    private static Map<String,Book> books = new LinkedHashMap<String, Book>();
    static{
        books.put("1",new Book("1","javaweb开发"));
        books.put("2",new Book("2","jdbc开发"));
        books.put("3",new Book("3","java基础"));
        books.put("4",new Book("4","struts开发"));
        books.put("5",new Book("5","spring开发"));
    }

    //返回所有图书Collection
    public static Collection<Book> getAll(){
        return books.values();
    }

    //通过Id获取书籍
    public static Book getBook(String id){
        return books.get(id);
    }
}
