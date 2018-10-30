package model;

public class LoaiSP {
	private String MaLoai ;
	private String TenLoai;
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	public LoaiSP(String maLoai, String tenLoai) {
	
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	public LoaiSP() {
	
	}
	public LoaiSP( String tenLoai) {
		

		TenLoai = tenLoai;
	}


}
