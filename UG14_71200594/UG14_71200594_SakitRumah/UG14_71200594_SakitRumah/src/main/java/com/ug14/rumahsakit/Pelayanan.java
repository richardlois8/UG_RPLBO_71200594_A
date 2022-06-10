package com.ug14.rumahsakit;

import java.util.Scanner;

public class Pelayanan {
    private int idPelayanan;
    private String nama;

    public Pelayanan(String nama) {
        this.nama = nama;
    }

    public void mengaturJadwal(Pasien pasien,Dokter dokter,Suster suster, Jadwal jadwal) {
        if(!pasien.getStatus()) {
            jadwal.setPasien(pasien);
            jadwal.setDokter(dokter);
            jadwal.setSuster(suster);
            jadwal.setPelayanan(this);
            jadwal.setStatusDaftar(true);
            DAO.getConnection().inputJadwal(jadwal);
            System.out.println("Data jadwal berhasil disimpan");
        } else {
            System.out.println("Pasien masih sehat");
        }

    }

    public Pasien registrasi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Rm: ");
        int rm = inp.nextInt();
        inp.nextLine();
        System.out.print("Nama: ");
        String nama = inp.nextLine();
        System.out.print("Usia: ");
        int usia = inp.nextInt();
        inp.nextLine();
        System.out.print("Alamat: ");
        String alamat = inp.nextLine();
        System.out.print("Penyakit: ");
        String penyakit = inp.nextLine();
        Pasien pasien = new Pasien(rm,nama, usia, alamat,penyakit);
        DAO.getConnection().inputPasien(pasien);
        pasien.setStatus(false);
        System.out.println("Data pasien berhasil disimpan!");
        return pasien;
    }

    public int getIdPelayanan() {
        return idPelayanan;
    }
}
