package com.ug4.soal1;

import java.time.LocalDate;

public class Pohon {
    private int daun;
    private int akar;
    private int dahan;
//    read only
    static final private int MASAHIDUP = 10;
    private int umur;
    private Buah buah;
    private Musim musim;
    private LocalDate tanggalMusim;

    public Pohon(int daun, int akar, int dahan, int umur) {
        this.daun = daun;
        this.akar = akar;
        this.dahan = dahan;
        this.umur = umur;
    }

    public int getDaun(Pohon pohon) {
        return daun;
    }

    private void setDaun(int daun) {
        this.daun = daun;
    }

    public int getAkar(Pohon pohon) {
        return akar;
    }

    private void setAkar(int akar) {
        this.akar = akar;
    }

    public int getDahan(Pohon pohon) {
        return dahan;
    }

    private void setDahan(int dahan) {
        this.dahan = dahan;
    }

    public static int getMASAHIDUP() {
        return MASAHIDUP;
    }

    public int getUmur(Pohon pohon) {
        return umur;
    }

    private void setUmur(int umur) {
        this.umur = umur;
    }

    public Buah getBuah(Pohon pohon) {
        return buah;
    }

    private void setBuah(Buah buah) {
        this.buah = buah;
    }

    public Musim getMusim(Pohon pohon) {
        return musim;
    }

    public void setMusim(Musim musim) {
        this.musim = musim;
        String namaBuah =" null";
        int banyakBuah = 0;
        int masaTahan = 0;
        int masaPanen = 0;
        int jumlah = 0;
        if (musim.getNama(musim).equals("kemarau")){
            namaBuah = "Apel";
            banyakBuah = 5;
            masaTahan = 7;
            masaPanen = 1;
            jumlah = (musim.getHari() / masaPanen) * banyakBuah;
        }
        else if (musim.getNama(musim).equals("penghujan")){
            namaBuah = "Pisang";
            banyakBuah = 10;
            masaTahan = 5;
            masaPanen = 10;
            jumlah = (musim.getHari() / masaPanen) * banyakBuah;
        }
        else if (musim.getNama(musim).equals("dingin")){
            namaBuah = "Jeruk";
            banyakBuah = 20;
            masaTahan = 13;
            masaPanen = 20;
            jumlah = (musim.getHari() / masaPanen) * banyakBuah;
        }
        Buah buah = new Buah(namaBuah,jumlah, masaPanen,masaTahan);
        this.setBuah(buah);
        this.setTanggalMusim(LocalDate.now());
    }

    public LocalDate getTanggalMusim(Pohon pohon) {
        return this.tanggalMusim;
    }

    public void setTanggalMusim(LocalDate tanggalMusim) {
        this.tanggalMusim = tanggalMusim;
    }
}
