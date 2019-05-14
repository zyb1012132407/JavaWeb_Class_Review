package cn.edu.bdu.test.Chapter06.Test2;

public class Book {

    //定义成员变量
    private String id;
    private String name;

    public Book(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
