/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanSekolah;

/**
 *
 * @author ASUS
 */
public class peminjaman {
  private String no_pinjam;
  private String tgl_pinjam;
  private String jumlah;
  
  public peminjaman(String no_pinjam, String tgl_pinjam, String jumlah) {
      this.no_pinjam = no_pinjam;
      this.tgl_pinjam = tgl_pinjam;
      this.jumlah = jumlah;
  }
  
  public String getNo_pinjam() {
      return no_pinjam;
  }
  
  public String getTgl_pinjam() {
      return tgl_pinjam;
  }
  public String getJumlah() {
      return jumlah;
  }
}
