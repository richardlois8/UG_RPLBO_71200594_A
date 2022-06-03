package com.ug13.sakitrumah;

public class Jadwal {
    private Pengunjung pengunjung;
    private Pemeriksa pemeriksa;
    private Perawat perawat;
    private Pendaftaran pendaftaran;
    private boolean statusDaftar;
    private boolean statusScreening;

    public Pengunjung getPengunjung() {
        return pengunjung;
    }

    public boolean getStatusDaftar() {
        return statusDaftar;
    }

    public void setStatusDaftar(boolean statusDaftar) {
        this.statusDaftar = statusDaftar;
    }

    public boolean getStatusScreening() {
        return statusScreening;
    }

    public void setStatusScreening(boolean statusScreening) {
        this.statusScreening = statusScreening;
    }

    public void setPengunjung(Pengunjung pengunjung) {
        this.pengunjung = pengunjung;
    }

    public Pemeriksa getPemeriksa() {
        return pemeriksa;
    }

    public void setPemeriksa(Pemeriksa pemeriksa) {
        this.pemeriksa = pemeriksa;
    }

    public Perawat getPerawat() {
        return perawat;
    }

    public void setPerawat(Perawat perawat) {
        this.perawat = perawat;
    }

    public Pendaftaran getPendaftaran() {
        return pendaftaran;
    }

    public void setPendaftaran(Pendaftaran pendaftaran) {
        this.pendaftaran = pendaftaran;
    }
}
