package com.ug10.twitter;

public class TweetException extends Exception{
    public TweetException(int errorCode) {
        super();
        switch (errorCode) {
            case 1 -> System.out.println("Maaf, Tweet tidak boleh kosong!");
            case 2 -> System.out.println("Maaf, Tweet minimal harus 8 karakter dan maksimal 140 karakter");
        }
    }
}
