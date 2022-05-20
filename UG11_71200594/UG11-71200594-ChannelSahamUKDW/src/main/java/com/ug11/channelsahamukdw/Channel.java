package com.ug11.channelsahamukdw;

import java.util.ArrayList;

public class Channel {
    private String email;
    private String namaDepan;
    private String namaBelakang;
    private int totalTag;

    public void login(String email){
        String[] split = email.split("@",2);
        String[] splitNama = split[0].split("\\.");
        try{
            if(!split[1].equals("students.ukdw.ac.id")){
                throw new EmailException(1);
            }
            else if(splitNama.length != 2){
                throw new EmailException(2);
            }
            else {
                this.email = email;
                this.namaDepan = splitNama[0].toUpperCase();
                this.namaBelakang = splitNama[1].toUpperCase();
                System.out.println("Login berhasil!");
            }
        }catch (EmailException e){
            System.out.println("Error : "+e.getErrorMessage());
        }
    }

    public void bagikanIde(String ide){
        System.out.println("Ide : "+ide);
        String[] split = ide.split(" ");
        ArrayList<String> tagged = new ArrayList<String>();
        for(String kata:split){
            if(kata.contains("#")){
                tagged.add(kata);
                this.totalTag += 1;
            }
        }
        System.out.print("Saham yang Anda tag : ");
        if (tagged.size() != 0) {
            System.out.println(String.join(", ",tagged));
//            for(int i=0;i < tagged.size();i++){
//                System.out.print(tagged.get(i));
//                if(i != tagged.size()-1){
//                    System.out.print(", ");
//                }
//            }
        }
        else {
            System.out.print("-\n");
        }

        System.out.print("Total saham yang Anda tag : ");
        if(tagged.size() == 0){
            System.out.print("0"+"\n");
        }
        else{
            System.out.print(tagged.size()+"\n");
        }
    }

    public void printInfo(){
        System.out.println("Nama Depan\t\t: "+this.getNamaDepan());
        System.out.println("Nama Belakang\t: "+this.getNamaBelakang());
        System.out.println("Email\t\t\t: "+this.getEmail());
        System.out.println("Total Tag\t\t: "+this.getTotalTag());
    }

    public String getEmail() {
        return email;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public int getTotalTag() {
        return totalTag;
    }
}
