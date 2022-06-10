package com.ug14.rumahsakit;

public class Dokter {
    private int idDokter;
    private String nama;
    private String spesialis;
    private String ruangan;

    public Dokter(String nama, String spesialis, String ruangan) {
        this.nama = nama;
        this.spesialis = spesialis;
        this.ruangan = ruangan;
    }

    public void memeriksa(Pasien pasien, Jadwal jadwal){
        if(jadwal.getPasien().equals(pasien) && jadwal.getStatusScreening()) {
            if(pasien.getLevelPenyakit() <= 0) {
                pasien.setStatus(true);
                DAO.getConnection().updateStatusPasien(jadwal);
            }
            else if(pasien.getLevelPenyakit() > 0){
                int newLevel = pasien.getLevelPenyakit() - 1;
                pasien.setLevelPenyakit(newLevel);
            }
        }else{
            System.out.println("ANDA HARUS MELAKUKAN PROSES PENDAFTARAN TERLEBIH DAHULU DI BAGIAN PELAYANAN");
        }
    }

    public void cekStatus(Pasien pasien, Jadwal jadwal){
        if(pasien.getStatus()){
            System.out.println("Selamat Pasien Anda Sudah Sembuh dan Sehat");
            System.out.println("Status Pasien Berhasil Diubah");
        }
        else{
            System.out.println("Pasien Anda Masih Sakit");
        }
    }

    public int getIdDokter() {
        return idDokter;
    }

    public String getNama() {
        return nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public String getRuangan() {
        return ruangan;
    }
}
