package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

   // HashMap<Integer , Book> db = new HashMap<>();

    List<Book> bookList;
    private int id;

    public BookRepository(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book save(Book book){

        bookList.add(book);
        //return null;
        return book;
    }

    public Book findBookById(int id){

        for (Book nums : bookList){
            if (nums.getId() == id)
                return nums;
        }
       // return null;
        return null;
    }

    public List<Book> findAll(){

        return bookList;
        //return null;
    }

    public void deleteBookById(int id){

        for (Book nums : bookList){
            if (nums.getId() == id) {
                bookList.remove(nums);
                return;
            }
        }

    }

    public void deleteAll(){
        bookList.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){

        List<Book> list = new ArrayList<>();
        for (Book nums : bookList){
            if (nums.getAuthor().equals(author)){
                list.add(nums);
            }
        }
        return list;
        //return null;
    }

    public List<Book> findBooksByGenre(String genre){

        List<Book> list=new ArrayList<>();
        for(Book book: bookList){
            if(book.getGenre().equals(genre)){
                list.add(book);
            }
        }
        return list;
        //return null;
    }
}
