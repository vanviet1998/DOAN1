package model;

public class QuangCao {
	private String MaQC;
	private String TenQC;
	private String Hinh;
	private String Link;
	public String getMaQC() {
		return MaQC;
	}
	public void setMaQC(String maQC) {
		MaQC = maQC;
	}
	public String getTenQC() {
		return TenQC;
	}
	public QuangCao() {

	}
	public void setTenQC(String tenQC) {
		TenQC = tenQC;
	}
	public String getHinh() {
		return Hinh;
	}
	public QuangCao(String tenQC, String hinh, String link) {
	
		TenQC = tenQC;
		Hinh = hinh;
		Link = link;
	}
	public void setHinh(String hinh) {
		Hinh = hinh;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public QuangCao(String maQC, String tenQC, String hinh, String link) {
		MaQC = maQC;
		TenQC = tenQC;
		Hinh = hinh;
		Link = link;
	}

}
