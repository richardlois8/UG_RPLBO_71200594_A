package com.ug13.sakitrumah;

public class Perawat {
    private String nama;

    public Perawat(String nama) {
        this.nama = nama;
    }

    public void screening(Pengunjung pengunjung,Jadwal jadwal){
        if(jadwal.getPengunjung().equals(pengunjung) && jadwal.getStatusDaftar()){
            jadwal.setStatusScreening(true);
            System.out.println("Proses Screening Suster Berhasil!");
        }
        else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }
}
