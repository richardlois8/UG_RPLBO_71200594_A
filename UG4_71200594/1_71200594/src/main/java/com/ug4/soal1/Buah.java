package com.ug4.soal1;

public class Buah {
    private String nama;
    private int jumlah;
    private int masaPanen;
    private int lamaBertahan;

    public Buah(String nama, int jumlah, int masaPanen, int lamaBertahan) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.masaPanen = masaPanen;
        this.lamaBertahan = lamaBertahan;
    }

    public String getNama() {
        return nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    private void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getMasaPanen() {
        return masaPanen;
    }

    private void setMasaPanen(int masaPAnen) {
        this.masaPanen = masaPAnen;
    }

    public int getLamaBertahan() {
        return lamaBertahan;
    }

    private void setLamaBertahan(int lamaBertahan) {
        this.lamaBertahan = lamaBertahan;
    }
}
