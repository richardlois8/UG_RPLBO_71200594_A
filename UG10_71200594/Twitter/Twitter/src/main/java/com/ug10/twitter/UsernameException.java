package com.ug10.twitter;

public class UsernameException extends Exception{
    public UsernameException(int errorCode) {
        super();
        switch (errorCode) {
            case 1 -> System.out.println("Maaf, Username tidak boleh kosong!");
            case 2 -> System.out.println("Maaf, Username minimal harus terdiri dari 6 karakter");
            case 3 -> System.out.println("Maaf, username hanya boleh mengandung huruf, angka, dan _ (underscore)");
        }
    }

}
