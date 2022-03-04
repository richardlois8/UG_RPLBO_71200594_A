package com.ug4.soal1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================================================");
        System.out.println("Pohon kehidupan");
        System.out.println("Mari menyiapkan pohon kehidupanmu");
        System.out.println("=====================================================================");
        System.out.print("Berapa banyak daun yang akan dimiliki: ");
        int daun = inp.nextInt();
        System.out.print("Berapa banyak akar yang akan tumbuh: ");
        int akar = inp.nextInt();
        System.out.print("Berapa banyak dahan yang akan dimiliki: ");
        int dahan = inp.nextInt();
        System.out.print("Berapa umur mulai pohon kamu (tahun): ");
        int umurAwal = inp.nextInt();
        if (umurAwal > Pohon.getMASAHIDUP()) {
            System.out.println("Maaf umur melebihi masa hidup pohon kamu");
            System.out.println("\n\n");
        }
        else {
            Pohon pohon = new Pohon(daun, akar, dahan, umurAwal);
            System.out.println("Pohon kehidupan kamu sudah tumbuh");
            System.out.println("=====================================================================================================================");
            System.out.println("\n\n");
            tampilanPohon(pohon);
        }
    }

    private static void tampilanPohon(Pohon pohon){
        System.out.println("=====================================================================");
        System.out.println("Pohon kehidupan");
        System.out.println("Atur pohon kamu agar menjadi pohon yang bermanfaat");
        System.out.println("=====================================================================");
        System.out.println("1. Tampilkan informasi pohon");
        System.out.println("2. Masukan musim sekarang");
        System.out.println("3. Panen buah");
        System.out.println("4. Keluar");
        System.out.print("Pilihan kamu: ");
        int pilihan = inp.nextInt();
        if (pilihan == 1){
            infoPohon(pohon);
        }
        else if (pilihan == 2){
            setMusim(pohon);
        }
        else if (pilihan == 3){
            panenBuah(pohon);
        }
        else if (pilihan == 4){
            System.out.println("Makasih sudah membuat pohon kehidupan");
            System.out.println("Sampai jumpa dilain waktu");
        }
        else{
            System.out.println("Pilihan tidak ada");
            tampilanPohon(pohon);
        }
    }

    private static void infoPohon(Pohon pohon){
        System.out.println("Intip Pohonmu Yuk");
        System.out.println("1. Tampilkan jumlah daun");
        System.out.println("2. Tampilkan jumlah akar");
        System.out.println("3. Tampilkan jumlah dahan");
        System.out.println("4. Tampilkan umur pohon kamu sekarang");
        System.out.println("5. Tampilkan rentang hidup pohon kamu");
        System.out.println("6. Tampilkan musim apa sekarang");
        System.out.println("7. Tampilkan berapa banyak buah yang sudah dipanen");
        System.out.println("8. Kembali");
        System.out.print("Pilihan kamu: ");
        int pilihan = inp.nextInt();
        if (pilihan == 1){
            System.out.println("Jumlah daun pohon kamu sebanyak "+pohon.getDaun(pohon)+" helai");
            infoPohon(pohon);
        }
        else if (pilihan == 2){
            System.out.println("Jumlah akar pohon kamu sebanyak "+pohon.getAkar(pohon)+" akar");
            infoPohon(pohon);
        }
        else if (pilihan == 3){
            System.out.println("Jumlah daun pohon kamu sebanyak "+pohon.getDahan(pohon)+" dahan");
            infoPohon(pohon);
        }
        else if (pilihan == 4){
            System.out.println("Umur pohon kamu sekarang "+pohon.getUmur(pohon)+" tahun");
            infoPohon(pohon);
        }
        else if (pilihan == 5){
            System.out.println("Rentang masa hidup pohon kamu selama "+ Pohon.getMASAHIDUP()+" tahun");
            infoPohon(pohon);
        }
        else if (pilihan == 6){
            if (pohon.getMusim(pohon) == null){
                System.out.println("Maaf kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
                System.out.println("Atur musim dulu gih");
            }
            else{
                System.out.println("Musim pohon kamu "+pohon.getMusim(pohon));
            }
            infoPohon(pohon);
        }
        else if (pilihan == 7){
            pohon.getBuah(pohon);

        }
        else if (pilihan == 8){
            tampilanPohon(pohon);
        }
        else{
            System.out.println("Pilihan tidak ada");
            infoPohon(pohon);
        }
    }

    private static void setMusim(Pohon pohon){
        System.out.print("Masukan musim apa sekarang (Kemarau, Penghujan, Dingin): ");
        String musim = inp.nextLine().toLowerCase();
        int hari = 0;
        if (musim.equals("kemarau")) {
                hari = 40;}
        else if(musim.equals("penghujan")){
                hari = 30;}
        else if(musim.equals("dingin")){
            hari = 60;}
        else if (musim.isEmpty()) {
            System.out.println("Kamu belum memasukkan musim");
            setMusim(pohon);}
        else {
            System.out.println("Musim yang kamu masukan ga sesuai");
            setMusim(pohon);
        }
        Musim musimPohon = new Musim(musim,hari);
        System.out.println("Berhasil memasukkan musim untuk pohonmu");
    }

    private static void panenBuah(Pohon pohon) {
        if (pohon.getMusim(pohon) != null) {
            System.out.println("=====================================================================");
            System.out.println("Ayo panen buahnya");
            LocalDate tglSekarang = LocalDate.now();
            LocalDate tglPanen = pohon.getTanggalMusim(pohon);
            tglPanen = tglPanen.plusDays(pohon.getBuah(pohon).getMasaPanen());
            String today = tglSekarang.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            String harvestDay = tglPanen.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            String tanggalMusim = pohon.getTanggalMusim(pohon).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.println("Tanggal musim: "+tanggalMusim);
            System.out.println("Tanggal hari ini : "+today);
            System.out.println("Tanggal panen : "+harvestDay);
            System.out.println("Hari sebelum masa panen : "+pohon.getBuah(pohon).getMasaPanen());
            System.out.println("Pohon kamu akan berbuah "+pohon.getBuah(pohon).getNama()+" setiap "+pohon.getBuah(pohon).getMasaPanen()+"" +
                    " dan kamu dapat memetik buah tersebut dalam "+pohon.getBuah(pohon).getLamaBertahan()+ "sebelum buah "+pohon.getBuah(pohon).getNama()+" busuk");
            System.out.println("=====================================================================");
        }
        else{
            System.out.println("Maaf kamu belum mengatur musim apa yang akan berlangsung untuk pohon kehidupanmu");
            System.out.println("Atur musim dulu gin");
        }
        tampilanPohon(pohon);
    }
}
