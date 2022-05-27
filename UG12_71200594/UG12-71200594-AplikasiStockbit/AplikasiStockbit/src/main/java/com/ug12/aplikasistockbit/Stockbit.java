package com.ug12.aplikasistockbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stockbit {
    private ArrayList<Investor> arrInvestor = new ArrayList<Investor>();
    private Investor investor;

    public void login(String username, String password){
        boolean loginInvestor = false;
        for(Investor dataInvestor:arrInvestor){
            if(dataInvestor.getUsername().equals(username) && dataInvestor.getPassword().equals(password)){
                this.investor = dataInvestor;
                loginInvestor = true;
                System.out.println("Login berhasil!");
            }
        }
        if(!loginInvestor){
            System.out.println("Username/password Anda salah!");
        }
    }

    public void orderBeli(Saham saham, int lot){
        investor.getPortfolio().put(saham,lot);
        System.out.println("Order beli "+saham.getKode()+" sebanyak "+lot+" lot sukses!");
    }

    public void orderJual(Saham saham, int lot){
        HashMap<Saham,Integer> porto = investor.getPortfolio();
        if(porto.get(saham) == lot){
            porto.remove(saham);
            System.out.println("Order jual "+saham.getKode()+" sebanyak "+lot+" lot sukses!");
        } else if (porto.get(saham) > lot) {
            porto.replace(saham,porto.get(saham)-lot);
            System.out.println("Order jual "+saham.getKode()+" sebanyak "+lot+" lot sukses!");
        } else if (porto.get(saham) < lot) {
            System.out.println("Order jual gagal!");
        }
    }

    public void printPortfolio(){
        HashMap<Saham,Integer> printPorto = investor.getPortfolio();
        System.out.println("================Portfolio Client================");
        System.out.println("Client : "+investor.getNama());
        System.out.println("No. Kode Saham\tJumlah Lot\t\tHarga\t\tSub Total");
        int counter = 1;
        long total = 0;
        for (Map.Entry dataPorto : printPorto.entrySet()) {
            Saham saham = (Saham) dataPorto.getKey();
            int jumlahLot = (int) dataPorto.getValue();
            long hargaLot = saham.getHarga();
            long subTotal = hargaLot * jumlahLot * 100;
            System.out.println(counter + ".\t" + saham.getKode() + "\t\t" + jumlahLot + "x" + "\t\t\t\t" + hargaLot + "\t\t" + subTotal);
            total += subTotal;
            counter += 1;
        }
        System.out.println("Total Investasi: Rp"+total);
    }

    public void register(Investor investor){
        arrInvestor.add(investor);
        System.out.println("Registrasi akun atas nama "+investor.getNama()+" sukses!");
    }
}
