package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BookStore {
    static HashSet<Book> books = new HashSet<>();
    private static String url = "jdbc:mysql://localhost:3306/Gainsight";
     public boolean addBook(Book b){
         int count=0;
         try(Connection con = DriverManager.getConnection(url, "root", "Bh@rgav2811");
             PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?)")){
             pst.setString(1,b.getBookId());
             pst.setString(2,b.getTitle());
             pst.setString(3,b.getAuthor());
             pst.setString(4,b.getCategory());
             pst.setDouble(5,b.getPrice());
             count = pst.executeUpdate();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         books.add(b);
         return count==1;
     }

    public Book searchByTitle(String title){
         Book b = null;
         try(Connection con = DriverManager.getConnection(url, "root", "Bh@rgav2811");
             PreparedStatement pst = con.prepareStatement("select * from book where title=?")){
             pst.setString(1,title);
             ResultSet rs = pst.executeQuery();
             if(rs.next())
                b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return b;
    }

    public List<Book> serachByAuthor(String author){
        List<Book> b = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url, "root", "Bh@rgav2811");
            PreparedStatement pst = con.prepareStatement("select * from book where author=?")){
            pst.setString(1,author);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                b.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public List<Book> displayAll() {
        return new ArrayList<>(books);
    }
}
