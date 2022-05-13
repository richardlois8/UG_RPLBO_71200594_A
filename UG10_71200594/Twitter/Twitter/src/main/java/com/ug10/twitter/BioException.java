package com.ug10.twitter;

public class BioException extends Exception{
    public BioException(int errorCode) {
        super();
        switch (errorCode) {
            case 1 -> System.out.println("Maaf, Bio tidak boleh kosong!");
            case 2 -> System.out.println("Maaf, Bio minimal harus 5 karakter dan maksimal 30 karakter");
            case 3 ->
                    System.out.println("Maaf, bio tidak boleh mengandung karakter spesial selain titik, et (@), serta spasi");
        }
    }
}
