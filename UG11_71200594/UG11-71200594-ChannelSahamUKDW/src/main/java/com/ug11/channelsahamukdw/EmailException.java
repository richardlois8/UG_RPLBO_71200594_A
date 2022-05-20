package com.ug11.channelsahamukdw;

public class EmailException extends Exception{
    private String errorMessage;
    private int errorCode;

    public EmailException(int errorCode) {
        this.errorCode = errorCode;
        switch (errorCode){
            case 1:
                this.errorMessage = "Login gagal! Email Anda tidak terdaftar dalam UKDW.";
                break;
            case 2:
                this.errorMessage = "Login gagal! Email UKDW anda tidak valid.";
                break;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
