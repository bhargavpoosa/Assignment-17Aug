package com.book;

import java.io.IOException;

public class InvalidBookException extends IOException {
    private String message;
    public InvalidBookException(String message){
        this.message = message;
    }

    public String toString(){
        return this.message;
    }
}
