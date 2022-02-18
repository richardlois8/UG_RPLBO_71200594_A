import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pilihan : ");
        System.out.println("1.Penyetora");
        System.out.println("2.Penarikan");
        System.out.println("3.Lihat Saldo");

        TabunganKonvensional K_71200594 = new TabunganKonvensional();
        TabunganBerjangka B_71200594 = new TabunganBerjangka();

        Scanner inp = new Scanner(System.in);
        System.out.println("Masukan Pilihan : ");
        int pilihan = inp.nextInt();

        if (pilihan == 1){
            K_71200594.penyetoran(200000);
            B_71200594.penyetoran(1000000);
        }
        else if (pilihan == 2){
            K_71200594.penarikan(50000);
            B_71200594.penarikan(0);
        }
        else if (pilihan == 3){
            System.out.print("Saldo K_71200594: ");
            K_71200594.getSaldo();
            System.out.print("Saldo B_71200594: ");
            B_71200594.getSaldo();
        }
        else{
            System.out.println("Inputan tidak valid");
        }
        inp.close();
    }
}
