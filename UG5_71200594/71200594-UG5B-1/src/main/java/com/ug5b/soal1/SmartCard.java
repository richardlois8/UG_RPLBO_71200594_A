package com.ug5b.soal1;

public class SmartCard {
    private String nama;
    private long saldo;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public void topUp(Voucher vch){
        if(vch.getKode().equals("VC")){
            System.out.println("Kode Voucher: "+vch.getKode()+" || Top up gagal! Kode voucher tidak valid.");
        }
        else{
            long nominalVch = Long.parseLong(vch.getKode().substring(2));
            this.setSaldo(this.getSaldo()+nominalVch);
            System.out.println("Kode Voucher: "+vch.getKode()+" || Top up sukses!");
        }
    }
}
