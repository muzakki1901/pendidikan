/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author ACER
 */
public class koneksi {
    private String databaseName = "2210010182";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public koneksi(){
        try {
            String location = "jdbc:mysql://localhost/"+databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanPeminjaman(String no_pinjam, String tgl_pinjam, String jumlah){
        try {
            String sql = "insert into peminjaman (no_pinjam, tgl_pinjam, jumlah) value (?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pinjam);
            perintah.setString(2, tgl_pinjam);
            perintah.setString(3, jumlah);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public void ubahPeminjaman(String no_pinjam, String tgl_pinjam, String jumlah){
        try {
            String sql = "update peminjaman set tgl_pinjam = ?, jumlah = ? where no_pinjam = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, tgl_pinjam);
            perintah.setString(2, jumlah);
            perintah.setString(3, no_pinjam);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPeminjaman(String no_pinjam){
        try {
            String sql = "delete from peminjaman where no_pinjam = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pinjam);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariPeminjaman(String no_pinjam){
        try {
            String sql = "select * from peminjaman where no_pinjam = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pinjam);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("NO PINJAM : "+data.getString("no_pinjam"));
                System.out.println("TANGGAL PINJAM : "+data.getString("tgl_pinjam"));
                System.out.println("JUMLAH : "+data.getString("jumlah"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPeminjaman(String no_pinjam){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from peminjaman order by no_pinjam asc");
            while(baris.next()){
                System.out.println(baris.getString("no_pinjam")+" | "+
                        baris.getString("tgl_pinjam")+" | "+
                        baris.getString("jumlah"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
     public void simpanPenerimaan(String no_terima, String tgl_terima, String jumlah_terima, String no_pengajuan, String subtotal){
        try {
            String sql = "insert into penerimaan (no_terima, tgl_terima, jumlah_terima, no_pengajuan, subtotal) value (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_terima);
            perintah.setString(2, tgl_terima);
            perintah.setString(3, jumlah_terima);
            perintah.setString(4, no_pengajuan);
            perintah.setString(5, subtotal);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahPenerimaan(String no_terima, String tgl_terima, String jumlah_terima, String no_pengajuan, String subtotal){
        try {
            String sql = "update penerimaan set tgl_terima = ?, jumlah_terima = ?, no_pengajuan = ?, subtotal = ? where no_terima = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, tgl_terima);
            perintah.setString(2, jumlah_terima);
            perintah.setString(3, no_pengajuan);
            perintah.setString(4, subtotal);
            perintah.setString(5, no_terima);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPenerimaan(String no_terima){
        try {
            String sql = "delete from penerimaan where no_terima = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_terima);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariPenerimaan (String no_terima){
        try {
            String sql = "select * from penerimaan where no_terima = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_terima);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("NO TERIMA : "+data.getString("no_terima"));
                System.out.println("TANGGAL TERIMA : "+data.getString("tgl_terima"));
                System.out.println("JUMLAH TERIMA : "+data.getString("jumlah_terima"));
                System.out.println("NO PENGAJUAN : "+data.getString("no_pengajuan"));
                System.out.println("SUBTOTAL : "+data.getString("subtotal"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPenerimaan(String no_terima){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from penerimaan order by no_terima asc");
            while(baris.next()){
                System.out.println(baris.getString("no_terima")+" | "+
                        baris.getString("tgl_terima")+" | "+
                        baris.getString("jumlah_terima")+" | "+
                        baris.getString("no_pengajuan")+" | "+
                        baris.getString("subtotal"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
     public void simpanPengajuan(String no_pengajuan, String tgl_pengajuan, String total){
        try {
            String sql = "insert into pengajuan (no_pengajuan, tgl_pengajuan, total) value (?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pengajuan);
            perintah.setString(2, tgl_pengajuan);
            perintah.setString(3, total);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahPengajuan(String no_pengajuan, String tgl_pengajuan, String total){
        try {
            String sql = "update pengajuan set tgl_pengajuan = ?, total = ? where no_pengajuan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, tgl_pengajuan);
            perintah.setString(2, total);
            perintah.setString(3, no_pengajuan);
                    
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPengajuan(String no_pengajuan){
        try {
            String sql = "delete from pengajuan where no_pengajuan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pengajuan);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public void cariPengajuan(String no_pengajuan){
        try {
            String sql = "select * from pengajuan where no_pengajuan = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_pengajuan);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("NO PENGAJUAN : "+data.getString("no_pengajuan"));
                System.out.println("TANGGAL PENGAJUAN : "+data.getString("tgl_penjualan"));
                System.out.println("TOTAL : "+data.getString("total"));
            }           
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPengajuan(String no_pengajuan){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from pengajuan order by no_pengajuan asc");
            while(baris.next()){
                System.out.println(baris.getString("no_pengajuan")+" | "+
                        baris.getString("tgl_pengajuan")+" | "+
                        baris.getString("total")+" | ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }
    
    public void simpanPengembalian(String no_kembali, String tgl_kembali, String jumlah, String no_pinjam){
        try {
            String sql = "insert into pengembalian (no_kembali, tgl_kembali, jumlah, no_pinjam) value (?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_kembali);
            perintah.setString(2, tgl_kembali);
            perintah.setString(3, jumlah);
            perintah.setString(4, no_pinjam);
            
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahPengembalian(String no_kembali, String tgl_kembali, String jumlah, String no_pinjam){
        try {
            String sql = "update pengembalian set tgl_kembali = ?, jumlah = ?, no_pinjam = ? where no_kembali = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, tgl_kembali);
            perintah.setString(2, jumlah);
            perintah.setString(3, no_pinjam);
            perintah.setString(4, no_kembali);
            
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPengembalian(String no_kembali){
        try {
            String sql = "delete from pengembalian where no_kembali = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_kembali);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariPengembalian(String no_kembali){
        try {
            String sql = "select * from pengembalian where no_kembali = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, no_kembali);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("NO PENGEMBALIAN : "+data.getString("no_kembali"));
                System.out.println("TANGGAL PENGEMBALIAN : "+data.getString("tgl_kembali"));
                System.out.println("JUMLAH : "+data.getString("jumlah"));
                System.out.println("NO PEMINJAMAN : "+data.getString("no_pinjam"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPengembalian(String no_kembali){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from pengembalian order by no_kembali asc");
            while(baris.next()){
                System.out.println(baris.getString("no_kembali")+" | "+
                        baris.getString("tgl_kembali")+" | "+
                        baris.getString("jumlah")+" | "+
                        baris.getString("no_pinjam"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
