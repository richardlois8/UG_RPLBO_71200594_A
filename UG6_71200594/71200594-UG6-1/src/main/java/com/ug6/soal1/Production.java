package com.ug6.soal1;

import java.sql.Struct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Production {
    private int productionCapacity;
    private ArrayList<LocalDate> productionDate;
    private ArrayList<Long> productionDueDays;
    private double costCalculation;

    public Production(int productionCapacity, ArrayList<LocalDate> productionDate) {
        this.productionCapacity = productionCapacity;
        this.productionDate = productionDate;
    }

    public boolean cekPhonesSpecification(String androidCode){
        int indexCode = Codes.ANDROIDCODES.size();
        for(int i=0;i<indexCode-1;i++){
            if (androidCode.equalsIgnoreCase(Codes.ANDROIDCODES.get(i)) && i <= 2){
                return true;
            }
        }
        return false;
    }

    public boolean cekPhonesSpecification(String androidCode,int ramCapacity,int romCapacity){
        boolean cek = false;
        System.out.println("Starting with status "+cek);
        int indexCode = Codes.ANDROIDCODES.size();
        for(int i=0;i<indexCode-1;i++){
            if (androidCode.equalsIgnoreCase(Codes.ANDROIDCODES.get(i)) && i >=4 && ramCapacity <= 16 && ramCapacity >= 4 && romCapacity <= 256 && romCapacity >= 64){
                cek = true;
            }
            else if (androidCode.equalsIgnoreCase(Codes.ANDROIDCODES.get(i)) &&i < 4 && ramCapacity <=8 && ramCapacity >= 1 && romCapacity <= 128 && romCapacity >= 32){
                cek = true;
            }
        }
        System.out.println("Finish checking with status "+cek);
        return cek;
    }

    public void conductProduction(Phones phone){
        int lamaProduksi = this.getProductionCapacity() * 3;
        LocalDate hariProduksi = LocalDate.now();
        this.productionDate.add(hariProduksi);
        LocalDate prodSelesai = hariProduksi.plusDays((long) lamaProduksi);
        long selisihHari = ChronoUnit.DAYS.between(hariProduksi, prodSelesai);
        productionDueDays.add(selisihHari);
        double cost = (double)this.getProductionCapacity() * 1000.0 * (double) selisihHari;
        this.setCostCalculation(cost);
        System.out.println("Congratulation\nBegin To Produce Phone " + phone.getPhoneName());
        System.out.println("With code: " + phone.getPhoneCode());
        System.out.println("Production Date: " + hariProduksi);
        System.out.println("Production Due date: " + prodSelesai);
        System.out.println("Days Before Due Date = " + selisihHari + " Days");
        System.out.println("Calculation Production Cost: Rp " + this.getCostCalculation());
    }

    public void conductProduction(Phones phone,float productionRate){
        if (productionRate < 0.1 || productionRate > 2.0){
            System.out.println("Please Input valid Production Rate");
        }
        else{
            int lamaProduksi = (int) ((float)(this.getProductionCapacity() * 3) * productionRate);
            LocalDate hariProduksi = LocalDate.now();
            this.productionDate.add(hariProduksi);
            LocalDate prodSelesai = hariProduksi.plusDays((long) lamaProduksi);
            long selisihHari = ChronoUnit.DAYS.between(hariProduksi, prodSelesai);
            productionDueDays.add(selisihHari);
            double cost = (double)this.getProductionCapacity() * 1000.0 * (double) selisihHari * 2.0;
            this.setCostCalculation(cost);
            System.out.println("Congratulation\nBegin To Produce Phone " + phone.getPhoneName());
            System.out.println("With code: " + phone.getPhoneCode());
            System.out.println("Production Date: " + hariProduksi);
            System.out.println("Production Due date: " + prodSelesai);
            System.out.println("Days Before Due Date = " + selisihHari + " Days");
            System.out.println("Calculation Production Cost: Rp " + this.getCostCalculation());
        }
    }

    public int getProductionCapacity() {
        return productionCapacity;
    }

    public void setProductionCapacity(int productionCapacity) {
        this.productionCapacity = productionCapacity;
    }

    public ArrayList<LocalDate> getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(ArrayList<LocalDate> productionDate) {
        this.productionDate = productionDate;
    }

    public ArrayList<Long> getProductionDueDays() {
        return productionDueDays;
    }

    public void setProductionDueDays(ArrayList<Long> productionDueDays) {
        this.productionDueDays = productionDueDays;
    }

    public double getCostCalculation() {
        return costCalculation;
    }

    public void setCostCalculation(double costCalculation) {
        this.costCalculation = costCalculation;
    }
}
