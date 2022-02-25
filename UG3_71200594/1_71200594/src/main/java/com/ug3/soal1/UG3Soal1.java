package com.ug3.soal1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UG3Soal1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("===============absensi karyawan===============");
        System.out.println("Absen disini");
        System.out.print("Nama karyawan : ");
        String nama = inp.nextLine();

        System.out.println("");
        System.out.println("berhasil absensi");
        System.out.println("Atas nama : " + nama);
        DateFormat formatDate = new SimpleDateFormat("dd-MMMM-yyyy");
        Date date = new Date();
        System.out.println("Pada tanggal : " + formatDate.format(date));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss a");
        String time = formatTime.format(calendar.getTime());
        System.out.println("Pukul : " + time);
    }
}
