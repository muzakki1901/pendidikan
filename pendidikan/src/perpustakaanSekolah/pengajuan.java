/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaanSekolah;

/**
 *
 * @author ASUS
 */
public class pengajuan {
  private String no_pengajuan;
  private String tgl_pengajuan;
  private String total;
  
  public pengajuan(String no_pengajuan, String tgl_pengajuan, String total) {
      this.no_pengajuan = no_pengajuan;
      this.tgl_pengajuan = tgl_pengajuan;
      this.total = total;
  }
  
  public String getNo_pengajuan() {
      return no_pengajuan;
  }
  
  public String getTgl_pengajuan() {
      return tgl_pengajuan;
  }
  public String getTotal() {
      return total;
  }
}
