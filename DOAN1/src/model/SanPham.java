package model;

public class SanPham {
	public String MaSP;	
	public String TenSP;
	public String MaLoai;
	public String NoiSanXuat;
	public float GiaSP;
	public String AnhSP;
	public String ChiTietSP;
	public String getChiTietSP() {
		return ChiTietSP;
	}
	public void setChiTietSP(String chiTietSP) {
		ChiTietSP = chiTietSP;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public SanPham(String tenSP, String maLoai, String noiSanXuat, float giaSP, String anhSP, String chiTietSP) {
				TenSP = tenSP;
		MaLoai = maLoai;
		NoiSanXuat = noiSanXuat;
		GiaSP = giaSP;
		AnhSP = anhSP;
		ChiTietSP = chiTietSP;
	}
	public SanPham() {

	}
	public SanPham(String maSP, String tenSP, String maLoai, String noiSanXuat, float giaSP, String anhSP,
			String chiTietSP) {
		MaSP = maSP;
		TenSP = tenSP;
		MaLoai = maLoai;
		NoiSanXuat = noiSanXuat;
		GiaSP = giaSP;
		AnhSP = anhSP;
		ChiTietSP = chiTietSP;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getNoiSanXuat() {
		return NoiSanXuat;
	}
	public void setNoiSanXuat(String noiSanXuat) {
		NoiSanXuat = noiSanXuat;
	}
	public float getGiaSP() {
		return GiaSP;
	}
	public void setGiaSP(float giaSP) {
		GiaSP = giaSP;
	}
	public String getAnhSP() {
		return AnhSP;
	}
	public void setAnhSP(String anhSP) {
		AnhSP = anhSP;
	}

	

}
