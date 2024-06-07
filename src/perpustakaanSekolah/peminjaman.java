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
public class peminjaman {
    private String databaseName = "2210010182";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public peminjaman(){
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
}
