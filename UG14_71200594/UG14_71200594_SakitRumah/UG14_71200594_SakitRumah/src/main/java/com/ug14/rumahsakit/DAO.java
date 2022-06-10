package com.ug14.rumahsakit;

import java.sql.*;

public class DAO {
    private final String url = "jdbc:sqlite:sakitrumah.db";
    private Connection conn = null;

    public DAO() {
        try {
            conn = DriverManager.getConnection(url);
//            System.out.println("Koneksi ke database berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal");
        }
    }

    public static DAO getConnection() {
        return new DAO();
    }

    public Dokter getDokterByID(int id) {
        String sql = "SELECT * FROM dokter WHERE idDokter = " + id;
        String nama = "";
        String spesialis = "";
        String ruangan = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
                spesialis = result.getString("spesialis");
                ruangan = result.getString("ruangan");
            }
            Dokter dokter = new Dokter(nama, spesialis, ruangan);
            return dokter;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Suster getSusterByID(int id) {
        String sql = "SELECT * FROM suster WHERE idSuster = " + id;
        String nama = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
            }
            Suster suster = new Suster(nama);
            return suster;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Pelayanan getPelayananByID(int id) {
        String sql = "SELECT * FROM pelayanan WHERE idPelayan = " + id;
        String nama = "";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                nama = result.getString("nama");
            }
            Pelayanan pelayanan = new Pelayanan(nama);
            return pelayanan;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void inputPasien(Pasien pasien) {
        String sql = "INSERT INTO pasien (rm, nama, usia, alamat) VALUES (" + pasien.getRm() + ", '" + pasien.getNama() + "', " + pasien.getUsia() + ", '" + pasien.getAlamat() + "')";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Insert berhasil");
        } catch (SQLException e) {
            System.out.println("Insert gagal");
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void inputJadwal(Jadwal jadwal) {
        int status = jadwal.getPasien().getStatus() ? 1 : 0;
        String sql = "INSERT INTO jadwal VALUES (" + jadwal.getIdPemeriksaan() + ", " + jadwal.getPasien().getRm() + ", " + jadwal.getDokter().getIdDokter() + ", " + jadwal.getSuster().getIdSuster() + ", " + jadwal.getPelayanan().getIdPelayanan() + ", " + status + ")";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Insert berhasil");
        } catch (SQLException e) {
            System.out.println("Insert gagal");
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void getPasienSembuh() {
        String sql = "SELECT rm FROM jadwal WHERE status = 1";
        try(Statement stat = conn.createStatement()){
            ResultSet result =  stat.executeQuery(sql);
            while (result.next()){
                System.out.println("Pasien dengan ID " + result.getInt("rm") + " telah sembuh");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void updateStatusPasien(Jadwal jadwal) {
        String sql = "UPDATE jadwal SET status = 1 WHERE idPemeriksaan = " + jadwal.getIdPemeriksaan();
        try(Statement stat = conn.createStatement()){
            stat.execute(sql);
            System.out.println("Update berhasil");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (conn != null) {
                try {
                    conn.close(); // <-- This is important
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void createTablePasien(){
        String sql = "CREATE TABLE IF NOT EXISTS pasien (rm INTEGER PRIMARY KEY, nama VARCHAR(255), usia INTEGER, alamat VARCHAR(255))";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Tabel pasien berhasil dibuat");
        } catch (Exception e) {
            System.out.println("Tabel pasien gagal dibuat");
        }
    }

    public void createTableJadwal(){
        String sql = "CREATE TABLE IF NOT EXISTS jadwal (idPemeriksaan INTEGER PRIMARY KEY, rm INTEGER, idDokter INTEGER, idSuster INTEGER, idPelayanan INTEGER, status INETEGER)";
        try {
            conn.createStatement().execute(sql);
            System.out.println("Tabel jadwal berhasil dibuat");
        } catch (Exception e) {
            System.out.println("Tabel jadwal gagal dibuat");
        }
    }
}
