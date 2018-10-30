package model;

public class Item {
	
	private SanPham sanpham;
	private int SoLuong;
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		this.SoLuong = soLuong;
	}
	public Item(SanPham sanpham, int soLuong) {
		
		this.sanpham = sanpham;
		this.SoLuong = soLuong;
	}
}
