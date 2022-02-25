package com.ug3.soal2;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class UG3Soal2 {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            lampuMerah();
            System.out.println("Akan berganti ke lampu kuning \n");
            try{
                TimeUnit.SECONDS.sleep(2);}
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

            lampuKuning();
            System.out.println("\nAkan berganti ke lampu hijau\n");
            try{
                TimeUnit.SECONDS.sleep(1);}
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
            lampuHijau();

            System.out.println("Akan berganti ke lampu kuning \n");
            try{
                TimeUnit.SECONDS.sleep(2);}
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
            lampuKuning();
        }
    }

    public static void lampuMerah(){
        System.out.println("Lampu merah menyala selama");
        for(int i=20;i>=1;i--){
            System.out.println(i);
            try{
                TimeUnit.SECONDS.sleep(1);}
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void lampuKuning(){
        System.out.println("Lampu kuning menyala selama");
        for(int i=2;i>=1;i--){
            System.out.println(i);
            try{
                TimeUnit.SECONDS.sleep(1);}
            catch (InterruptedException ex){
                ex.printStackTrace();
        }
        }
    }

    public static void lampuHijau(){
        System.out.println("Lampu hijau menyala selama");
        for(int i=15;i>=1;i--){
            System.out.println(i);
            try{
                TimeUnit.SECONDS.sleep(1);}
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
