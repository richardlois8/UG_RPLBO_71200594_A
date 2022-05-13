package com.ug10.twitter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App 
{
    private static boolean loginCheck = false;
    private static boolean usernameCheck = false;
    private static boolean tweetCheck = false;
    private static boolean bioCheck = false;
    private static String bio;

    public static void main( String[] args )
    {
        User user = new User("u71200594","p71200594");
        System.out.println( "Selamat datang di Twitter\nSilahkan login dengan akun Anda.");

//        login
        while (!loginCheck) {
            try {
                login(user);
                loginCheck = true;
            } catch (LoginException e) {

            }
        }
        
//        change username
        while (!usernameCheck) {
            try {
                username(user);
            } catch (UsernameException e) {

            }
        }

//        change username
        System.out.println("\nMaaf, "+user.getUsername()+" kamu diminta untuk mengisi bio. Silahkan masukkan bio kamu");
        while (!bioCheck) {
            try {
                bio(user);
            } catch (BioException e) {

            }
        }

//        post tweet
        System.out.println("\nSelamat, "+user.getUsername()+" kamu sudah dapat memposting tweet pertama kamu");
        while (!tweetCheck) {
            try {
                tweet(user);
            } catch (TweetException e) {

            }
        }

        info(user);
    }

    public static void login(User user) throws LoginException {
        Scanner inp = new Scanner(System.in);
        System.out.print("\nUsername : ");
        String usernameLogin = inp.nextLine();
        System.out.print("Password : ");
        String pwLogin = inp.nextLine();

        if(usernameLogin.isEmpty()){
            throw new LoginException(1);
        }
        else if(pwLogin.isEmpty()){
            throw new LoginException(2);
        }
        else if(!usernameLogin.equals(user.getUsername()) || !pwLogin.equals(user.getPassword())){
            throw new LoginException(3);
        }
        else{
            System.out.println("Selamat datang di Twitter, "+user.getUsername());
        }
    }

    public static void username(User user) throws UsernameException{
        System.out.println("\nKamu diminta mengganti username. Silahkan masukkan username kamu");

        Scanner inp = new Scanner(System.in);
        System.out.print("Username\t: ");
        String username = inp.nextLine();

        String regex = "^[A-Za-z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        boolean isValidPattern = matcher.matches();

        try {
            if (username.isEmpty()) {
                throw new UsernameException(1);
            } else if (username.length() < 6) {
                throw new UsernameException(2);
            } else if (!isValidPattern) {
                throw new UsernameException(3);
            }
            else{
                user.setUsername(username);
                usernameCheck = true;
                System.out.println("Username kamu berhasil diperbaharui, "+username);
            }
        } catch (UsernameException e) {
            usernameCheck = false;
        }
    }

    public static void bio(User user) throws BioException{
        Scanner inp = new Scanner(System.in);
        System.out.print("Bio\t: ");
        String inpBio = inp.nextLine();

        String regex = "^[A-Za-z0-9.@\\u0020]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inpBio);
        boolean isValidPattern = matcher.matches();

        try {
            if (inpBio.isEmpty()) {
                throw new BioException(1);
            } else if (!(inpBio.length() >= 6 && inpBio.length() <= 30)) {
                throw new BioException(2);
            } else if (!isValidPattern) {
                throw new BioException(3);
            }
            else{
                bio = inpBio;
                bioCheck = true;
                System.out.println("Bio kamu berhasil diperbaharui, "+bio);
            }
        } catch (BioException e) {
            bioCheck = false;
        }
    }

    public static void tweet(User user) throws TweetException{
        Scanner inp = new Scanner(System.in);
        System.out.print("Tweet\t: ");
        String tweet = inp.nextLine();

        try {
            if (tweet.isEmpty()) {
                throw new TweetException(1);
            } else if (!(tweet.length() >= 8 && tweet.length() <= 140)) {
                throw new TweetException(2);
            }
            else{
                tweetCheck = true;
                System.out.println(user.getUsername()+" : "+tweet);
            }
        } catch (TweetException e) {
            tweetCheck = false;
        }
    }

    public static void info(User user){
        System.out.println("\n");
        System.out.println("Username\t: "+user.getUsername());
        System.out.println("Password\t: "+user.getPassword());
        System.out.println("Bio\t: "+bio);
    }
}
