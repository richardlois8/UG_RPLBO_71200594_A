package com.ug10.twitter;

public class LoginException extends Exception{
    public LoginException(int errorCode) {
        super();
        switch (errorCode) {
            case 1 -> System.out.println("Maaf, username atau password tidak boleh kosong");
            case 2 -> System.out.println("Maaf, username atau password tidak boleh kosong");
            case 3 -> System.out.println("Maaf, username atau password salah! Silahkan coba lagi!");
        }
    }
}
