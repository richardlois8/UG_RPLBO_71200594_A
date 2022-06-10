package com.ug14.rumahsakit;

public class Pasien     {
    private int rm;
    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 3;
    private boolean status;

    public Pasien(String nama, int usia, String alamat) {
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
    }

    public Pasien(int rm,String nama, int usia, String alamat, String penyakit) {
        this.rm = rm;
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
        this.penyakit = penyakit;
    }

    public int getLevelPenyakit() {
        return levelPenyakit;
    }

    public boolean getStatus() {
        return status;
    }

    public void setLevelPenyakit(int levelPenyakit) {
        this.levelPenyakit = levelPenyakit;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRm() {
        return rm;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public boolean isStatus() {
        return status;
    }
}
