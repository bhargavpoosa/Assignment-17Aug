package com.bookutil;

import com.book.Book;
import com.book.BookStore;

import java.util.List;

public class BookUtil {
    BookStore bookStore = null;
    public BookUtil(){
         bookStore = new BookStore();
    }

    public void add3books(List<Book> books){
        for(Book b : books) {
            if (bookStore.addBook(b))
                System.out.println("Successfully added");
            else
                System.out.println("FAILURE");
        }
    }

    public void searchByTitle(String title){
        System.out.println(bookStore.searchByTitle(title));
    }

    public void searchByAuthor(String author){
        for (Book b: bookStore.serachByAuthor(author)){
            System.out.println(b);
        }
    }

    public void displayAllBooks(){
        for (Book b: bookStore.displayAll()){
            System.out.println(b);
        }
    }

}
