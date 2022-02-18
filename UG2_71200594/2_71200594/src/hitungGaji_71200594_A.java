import java.util.Scanner;

public class hitungGaji_71200594_A {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Berapa karyawan : ");
        int jmlKaryawan = inp.nextInt();

        for (int i = 1;i <= jmlKaryawan;i++){
            System.out.print("Masukan jumlah jam kerja : ");
            int jamKerja = inp.nextInt();
            float gajiIdeal = 300000;

            if (jamKerja == 8){
                System.out.println("Total: Rp. " + gajiIdeal);
            }
            else if(jamKerja > 8){
                int extraJam = jamKerja - 8;
                System.out.println("Extra jam :" + extraJam);
                float extraPay = extraJam * 15000;
                System.out.println("Extra Payments : " + extraPay);
                System.out.println("Total : Rp. " + (gajiIdeal+extraPay));
            }
            else if(jamKerja < 8){
                int lessJam = 8 - jamKerja;
                System.out.println("Less hours : " + lessJam);
                float potongan = lessJam * 15000;
                System.out.println("Potongan : " + potongan);
                System.out.println("Total : Rp. " + (gajiIdeal - potongan));
            }
            System.out.println("------------------");
        }
        inp.close();
    }
}
