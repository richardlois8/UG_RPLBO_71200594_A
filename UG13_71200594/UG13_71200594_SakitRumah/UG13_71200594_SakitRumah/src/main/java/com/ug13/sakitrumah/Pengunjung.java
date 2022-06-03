package com.ug13.sakitrumah;

public class Pengunjung {
    private String nama;
    private int usia;
    private String alamat;
    private String penyakit;
    private int levelPenyakit = 3;
    private boolean status;

    public Pengunjung(String nama, int usia, String alamat) {
        this.nama = nama;
        this.usia = usia;
        this.alamat = alamat;
    }

    public Pengunjung(String nama, int usia, String alamat, String penyakit) {
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
}
