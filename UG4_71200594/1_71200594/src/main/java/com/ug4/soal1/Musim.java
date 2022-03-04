package com.ug4.soal1;

public class Musim {
    private String nama;
    private int hari;

    public Musim(String nama, int hari) {
        this.nama = nama;
        this.hari = hari;
    }

    public String getNama(Musim musim) {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHari() {
        return hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }
}
