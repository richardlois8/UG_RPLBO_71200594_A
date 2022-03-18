package com.ug6.soal1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Codes {
    public static final ArrayList<String> ANDROIDCODES = new ArrayList<String>(Arrays.asList("Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "10 Q", "Red Velvet Cake", "Snow Cone", "Tiramisu"));
    public static final ArrayList<String> COMPANYCODES = new ArrayList<String>(Arrays.asList("XM","SG","AP","RM","OP","VV"));

    public static String generatePhoneCode(String companyCode){
        Random rand = new Random();
        int randNumber = rand.nextInt(1,21);
        return companyCode+"X"+randNumber;
    }

    public static String generatePhoneCode(String companyCode, String androidCode){
        Random rand = new Random();
        int randNumber = rand.nextInt(1,21);
        androidCode = androidCode.toUpperCase();
        return companyCode+androidCode.charAt(0)+androidCode.charAt(androidCode.length()-1)+randNumber;
    }
}
