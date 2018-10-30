package model;

import java.util.Date;


public class ChiTietHoaDon {
	private String MaChiTietHD;
	public ChiTietHoaDon(String maChiTietHD, String maHD, String maSP, int soLuong, float gia, Date ngayNhan) {
		super();
		MaChiTietHD = maChiTietHD;
		MaHD = maHD;
		MaSP = maSP;
		SoLuong = soLuong;
		Gia = gia;
		NgayNhan = ngayNhan;
	}
	public String getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(String maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	private String MaHD;
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public ChiTietHoaDon() {
		
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getGia() {
		return Gia;
	}
	public ChiTietHoaDon(String maHD, String maSP, int soLuong, float gia, Date ngayNhan) {
		super();
		MaHD = maHD;
		MaSP = maSP;
		SoLuong = soLuong;
		Gia = gia;
		NgayNhan = null;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	public Date getNgayNhan() {
		return NgayNhan;
	}
	public void setNgayNhan(Date ngayNhan) {
		NgayNhan = ngayNhan;
	}
	private String MaSP;
	private int SoLuong;
	private float Gia;
	private Date NgayNhan;
	private String TenSP;
	private String NSX;
	public ChiTietHoaDon(int soLuong, float gia, Date ngayNhan, String tenSP, String nSX) {
	
		SoLuong = soLuong;
		Gia = gia;
		NgayNhan = ngayNhan;
		TenSP = tenSP;
		NSX = nSX;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getNSX() {
		return NSX;
	}
	public void setNSX(String nSX) {
		NSX = nSX;
	}
	

}
