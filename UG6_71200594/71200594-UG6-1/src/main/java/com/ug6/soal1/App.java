package com.ug6.soal1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner inp = new Scanner(System.in);
    private static String companyCode;
    private static String androidCode;
    private static String phoneName;
    private static String phoneCode;
    private static int ramCapacity;
    private static int romCapacity;
    private static int cameraResolution;
    private static float screenSize;
    private static Production production;
    private static Phones hp;

    public static void main( String[] args ) {
        System.out.println("Produce Your Phone");
        System.out.println("\n\n");
        System.out.println("Phone Detail");
        System.out.println("Pick Company Code");
        for (int i = 0; i < Codes.COMPANYCODES.size(); i++) {
            System.out.println((i + 1) + ". " + Codes.COMPANYCODES.get(i));
        }
        System.out.print("Your choice (1/2/...): ");
        String pilCompany = inp.nextLine();
        App.companyCode = Codes.COMPANYCODES.get(Integer.parseInt(pilCompany) - 1);
        System.out.print("Phone Name: ");
        App.phoneName = inp.nextLine();

        System.out.print("Configure android level now?\nYes (y) or No (n): ");
        String pilihLevel = inp.nextLine();
        if (pilihLevel.equalsIgnoreCase("y")) {
            System.out.println("Pick your android level");
            for (int i = 0; i < Codes.ANDROIDCODES.size(); i++) {
                System.out.println((i + 1) + ". " + Codes.ANDROIDCODES.get(i));
            }
            System.out.print("Your choice (1/2/...): ");
            int pilCodes = inp.nextInt();
            App.androidCode = Codes.ANDROIDCODES.get(pilCodes - 1);
            System.out.println("Generating Phone Code\nPlease Wait a moment");
            App.phoneCode = Codes.generatePhoneCode(App.companyCode, App.androidCode);
            System.out.println("Phone code: " + App.phoneCode);
        } else if (pilihLevel.equalsIgnoreCase("n")) {
            System.out.println("Generating Phone Code\nPlease Wait a moment");

            App.phoneCode = Codes.generatePhoneCode(App.companyCode, App.androidCode);
            System.out.println("Phone code: " + App.phoneCode);
        } else {
            System.out.println("Wrong Input");
        }
        System.out.print("Add specification to phone ?\nyes (y) or no (n): ");
        String pilihSpek = inp.next();
        if (pilihSpek.equalsIgnoreCase("y")) {
            System.out.print("RAM Capacity: ");
            int ram = inp.nextInt();
            System.out.print("ROM Capacity: ");
            int rom = inp.nextInt();
            System.out.print("Screen Size (Inch): ");
            float screenSize = inp.nextFloat();
            System.out.print("Camera Resolution: ");
            int resCamera = inp.nextInt();
            App.ramCapacity = ram;
            App.romCapacity = rom;
            App.screenSize = screenSize;
            App.cameraResolution = resCamera;
            Phones hp = new Phones(App.phoneCode, App.companyCode, App.androidCode, App.ramCapacity, App.romCapacity, (float) App.screenSize,App.cameraResolution);
        } else {
            Phones hp = new Phones(App.phoneCode, App.companyCode, App.androidCode);
        }
        ArrayList<LocalDate> listProd = new ArrayList<LocalDate>();
        System.out.println("\n\n");
        System.out.println("Begin to Start");
        System.out.print("How much production capacity that can produce: ");
        int kapasitas = inp.nextInt();
        production = new Production(kapasitas, listProd);
        System.out.println("Check Specification Requirement");

        if (App.screenSize == 0.0 && App.ramCapacity == 0 && App.romCapacity == 0 && App.cameraResolution == 0){
            if (production.cekPhonesSpecification(androidCode)) {
                System.out.println("Starting To Production");
                System.out.println("Do you want to add production rate (faster production higher cost)");
                System.out.print("Yes (y) or No (n): ");
                String pilRate = inp.nextLine();
                switch (pilRate.toLowerCase()) {
                    case "y" -> {
                        System.out.print("Production rate (0.1 - 2.0): ");
                        float rate = inp.nextFloat();
                        App.production.conductProduction(hp, rate);
                    }
                    case "n" -> App.production.conductProduction(hp);
                }
            }
    }
        else if(production.cekPhonesSpecification(androidCode, ramCapacity, romCapacity)){
                if (production.cekPhonesSpecification(androidCode)) {
                    System.out.println("Starting To Production");
                    System.out.println("Do you want to add production rate (faster production higher cost)");
                    System.out.print("Yes (y) or No (n): ");
                    String pilRate = inp.nextLine();
                    switch (pilRate.toLowerCase()) {
                        case "y" -> {
                            System.out.print("Production rate (0.1 - 2.0): ");
                            float rate = inp.nextFloat();
                            App.production.conductProduction(hp, rate);
                        }
                        case "n" -> App.production.conductProduction(hp);
                    }
                }
        }
        else {
            System.out.println("Failed to pass specification requirement");
        }
    }
}
