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
public class pengajuan {
    private String databaseName = "2210010182";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public pengajuan(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            perintah.setString(1, total);
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
}
