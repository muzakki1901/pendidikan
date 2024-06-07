/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanSekolah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ASUS
 */
public class pengembalian {
    private String databaseName = "2210010182";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public pengembalian(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
