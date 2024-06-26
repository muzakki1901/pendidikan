/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanSekolah;

/**
 *
 * @author ASUS
 */
public class pengembalian {
    private String no_pengembalian;
  private String tgl_pengembalian;
  private String jumlah;
  private String no_pinjam;
  
  public pengembalian(String no_pengembalian, String tgl_pengembalian, String jumlah, String no_pinjam) {
      this.no_pengembalian = no_pengembalian;
      this.tgl_pengembalian = tgl_pengembalian;
      this.jumlah = jumlah;
      this.no_pinjam = no_pinjam;
  }
  
  public String getNo_pengembalian() {
      return no_pinjam;
  }
  
  public String getTgl_pengembalian() {
      return tgl_pengembalian;
  }
  public String getJumlah() {
      return jumlah;
  }
    public String getNo_pinjam() {
      return no_pinjam;
  }
}
