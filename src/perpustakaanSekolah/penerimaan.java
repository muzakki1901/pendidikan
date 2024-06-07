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
public class penerimaan {
    private String databaseName = "2210010182";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public penerimaan(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    
}
