package com.ug14.rumahsakit;

public class Suster {
    private int idSuster;
    private String nama;

    public Suster(String nama) {
        this.nama = nama;
    }

    public void screening(Pasien pasien,Jadwal jadwal){
        if(jadwal.getSuster().equals(this) && jadwal.getPasien().equals(pasien) && jadwal.getStatusDaftar()){
            jadwal.setStatusScreening(true);
            System.out.println("Proses Screening Suster Berhasil!");
        }
        else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public int getIdSuster() {
        return idSuster;
    }
}
