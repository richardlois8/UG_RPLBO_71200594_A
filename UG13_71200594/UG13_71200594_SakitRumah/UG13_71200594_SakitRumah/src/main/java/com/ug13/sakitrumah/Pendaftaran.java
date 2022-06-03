package com.ug13.sakitrumah;

import java.util.Scanner;

public class Pendaftaran {
    private String nama;

    public Pendaftaran(String nama) {
    }

    public void mengaturJadwal(Pengunjung pengunjung,Pemeriksa pemeriksa, Jadwal jadwal) {
        if(!pengunjung.getStatus()) {
            jadwal.setPengunjung(pengunjung);
            jadwal.setPemeriksa(pemeriksa);
            jadwal.setPendaftaran(this);
            jadwal.setStatusDaftar(true);
            System.out.println("Proses Pengaturan Jadwal Berhasil!");
        } else {
            System.out.println("Pengunjung masih sehat");
        }

    }

    public Pengunjung registrasi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nama: ");
        String nama = inp.nextLine();
        System.out.print("Usia: ");
        int usia = inp.nextInt();
        inp.nextLine();
        System.out.print("Alamat: ");
        String alamat = inp.nextLine();
        System.out.print("Penyakit: ");
        String penyakit = inp.nextLine();

        Pengunjung pengunjung = new Pengunjung(nama, usia, alamat,penyakit);
        pengunjung.setStatus(false);
        System.out.println("Proses Registrasi Berhasil!");
        return pengunjung;
    }
}
