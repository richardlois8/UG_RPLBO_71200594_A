package com.ug11.kalkulasipersentase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukkan teks : ");
        String teks = inp.nextLine();

        String[] split = teks.split(" ");

        ArrayList<String> persentase = new ArrayList<String>();
        for(String kata:split){
            if(kata.contains("%")){
                persentase.add(kata);
            }
        }

        float total = 0;
        for(String persenSaham:persentase){
            persenSaham = persenSaham.substring(0,persenSaham.length()-1);
            total += Float.parseFloat(persenSaham);
        }

        System.out.print("Rincian perhitungan : "+String.join(" + ",persentase));
        System.out.println("\nTotal kenaikan (Dalam Persen) : "+total+"%");
    }
}
