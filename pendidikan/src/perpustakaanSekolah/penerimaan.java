/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanSekolah;


/**
 *
 * @author ASUS
 */
public class penerimaan {
  private String no_terima;
  private String tgl_terima;
  private String jumlah_terima;
  private String no_pengajuan;
  private String subtotal;
  
  public penerimaan(String no_terima, String tgl_terima, String jumlah_terima, String no_pengajuan, String subtotal) {
      this.no_terima = no_terima;
      this.tgl_terima = tgl_terima;
      this.jumlah_terima = jumlah_terima;
      this.no_pengajuan = no_pengajuan;
      this.subtotal = subtotal;
  }
  
  public String getNo_terima() {
      return no_terima;
  }
  
  public String getTgl_terima() {
      return tgl_terima;
  }
  public String getJumlah_terima() {
      return jumlah_terima;
  }
  public String getNo_pengajuan() {
      return no_pengajuan;
  }
  public String getSubtotal() {
      return subtotal;
  }
}  

