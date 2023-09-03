package com.book;
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;

    public Book(String bookId, String title, String author, String category, double price) throws InvalidBookException {
        if(isValid(category,price,bookId)){
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.category = category;
            this.price = price;
        }
        else throw new InvalidBookException("Invalid Book Exception");
    }

    public boolean isValid(String category, double price, String bookId){
        if(!category.equals("Science") && !category.equals("Fiction") && !category.equals("Technology") && !category.equals("Others") )
            return false;
        if(price<0)
            return false;
        if(!bookId.startsWith("B") || bookId.length()!=4)
            return false;
        return true;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bookId + " " + title + " " + author + " " + category + " " + price;
    }
}
