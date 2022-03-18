package com.ug6.soal1;

public class Phones {
    private String phoneName;
    private String phoneCode;
    private String companyCode;
    private String androidCode;
    private int ramCapacity;
    private int romCapacity;
    private float screenSize;
    private int cameraResolution;

    public Phones(String phoneCode, String companyCode, String androidCode) {
        this.phoneCode = phoneCode;
        this.companyCode = companyCode;
        this.androidCode = androidCode;
    }

    public Phones(String phoneCode, String companyCode, String androidCode, int ramCapacity, int romCapacity, float screenSize, int cameraResolution) {
        this.phoneCode = phoneCode;
        this.companyCode = companyCode;
        this.androidCode = androidCode;
        this.ramCapacity = ramCapacity;
        this.romCapacity = romCapacity;
        this.cameraResolution = cameraResolution;
        this.screenSize = screenSize;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getAndroidCode() {
        return androidCode;
    }

    public void setAndroidCode(String androidCode) {
        this.androidCode = androidCode;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public int getRomCapacity() {
        return romCapacity;
    }

    public void setRomCapacity(int romCapacity) {
        this.romCapacity = romCapacity;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
}
