package com.ug13.sakitrumah;

public class Pemeriksa {
    private String nama;
    private String spesialis;
    private String ruangan;

    public Pemeriksa(String nama, String spesialis, String ruangan) {
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }

    public void memeriksa(Pengunjung pengunjung, Jadwal jadwal){
        if(jadwal.getPengunjung().equals(pengunjung) && jadwal.getStatusScreening()) {
            if(pengunjung.getLevelPenyakit() <= 0) {
                pengunjung.setStatus(true);
            }
            else if(pengunjung.getLevelPenyakit() > 0){
                int newLevel = pengunjung.getLevelPenyakit() - 1;
                pengunjung.setLevelPenyakit(newLevel);
            }
        }else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public void cekStatus(Pengunjung pengunjung){
        if(pengunjung.getStatus()){
            System.out.println("Selamat Pasien Anda Sudah Sembuh dan Sehat");
        }
        else{
            System.out.println("Pasien Anda Masih Sakit");
        }
    }
}
