package com.bookutil;

import com.book.Book;
import com.book.InvalidBookException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BookUtil bookUtil = new BookUtil();
        List<Book> b = new ArrayList<>();
        try {
            b.add(new Book("B678", "HarryPotter", "xyz", "Fiction", 250));
            b.add(new Book("B579","Game of Thrones","def","Fiction",250));
            b.add(new Book("B478","Adams Project","def","Science",250));

            bookUtil.add3books(b);
            bookUtil.searchByAuthor("def");
            bookUtil.searchByTitle("Adams Project");
            bookUtil.displayAllBooks();
        }
        catch(InvalidBookException e){
            System.out.println("Provide Proper Book Details");
        }
    }
}