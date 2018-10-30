package model;



import java.sql.Date;

import com.sun.jmx.snmp.Timestamp;


public class HoaDon {
	private String MaHD;
	private String MaKH;
	private Date NgayMua;
	private double TongTien;
	private String TenKH;
	private String DiaChi;
	private String SDT;
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public HoaDon( String maKH, Date date, double tongTien, String tenKH, String diaChi, String sDT) {
	
		MaKH = maKH;
		NgayMua = date;
		TongTien = tongTien;
		TenKH = tenKH;
		DiaChi = diaChi;
		SDT = sDT;
	}
	public HoaDon() {
		
	}
	
}
