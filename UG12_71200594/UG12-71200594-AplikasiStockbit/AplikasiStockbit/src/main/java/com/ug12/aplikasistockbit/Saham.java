package com.ug12.aplikasistockbit;

public class Saham {
    private String kode;
    private long harga;

    public Saham(String kode, long harga) {
        this.kode = kode;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public long getHarga() {
        return harga;
    }
}
