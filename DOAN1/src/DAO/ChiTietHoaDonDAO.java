package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.ChiTietHoaDon;
import model.HoaDon;

public class ChiTietHoaDonDAO {
	public void insertChiTietHD(ChiTietHoaDon chitiethoadon) throws SQLException {
		
		Connection connection =DBConnect.getConnection();
		String sql = "{call sp_dangkyctHD (?,?,?,?,?)}";
		PreparedStatement command = connection.prepareStatement(sql);
		
		command.setString(1, chitiethoadon.getMaHD());
		command.setString(2,chitiethoadon.getMaSP());
		command.setInt(3,chitiethoadon.getSoLuong());
		command.setFloat(4, chitiethoadon.getGia());
		command.setDate(5, (Date) chitiethoadon.getNgayNhan());
		command.executeUpdate();
		
		
	}
	public ArrayList<ChiTietHoaDon> getlistHoaDOn(String MaHd) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From ChiTietHD where MaHD = '"+MaHd+"'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<ChiTietHoaDon> list = new ArrayList<>();
		while(rs.next()) {
			ChiTietHoaDon hd = new ChiTietHoaDon();
			hd.setMaChiTietHD(rs.getString("MaChiTietHD"));
			hd.setMaHD(rs.getString("MaHD"));
			hd.setMaSP(rs.getString("MaSP"));
			hd.setSoLuong(rs.getInt("SoLuong"));
			hd.setGia(rs.getFloat("DonGia"));
			hd.setNgayNhan(rs.getDate("NgayNhan"));
			list.add(hd);
			
		
					}
		return list;
		
	}
	public ArrayList<ChiTietHoaDon> getlistChiTietHoaDOn(String MaHd) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "{call sp_listcthd (?)}";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ps.setString(1,MaHd);
		ResultSet rs = ps.executeQuery();
		ArrayList<ChiTietHoaDon> list = new ArrayList<>();
		while(rs.next()) {
			ChiTietHoaDon hd = new ChiTietHoaDon();
			hd.setTenSP(rs.getString("TenSP"));
			hd.setNSX(rs.getString("NoiSanXuat"));
		
			hd.setSoLuong(rs.getInt("SoLuong"));
			hd.setGia(rs.getFloat("DonGia"));
			hd.setNgayNhan(rs.getDate("NgayNhan"));
			list.add(hd);
			
		
					}
		return list;
		
	}
	public static void main(String[] args) throws SQLException {
	
		for(ChiTietHoaDon ct: new ChiTietHoaDonDAO().getlistHoaDOn("HD001")) {
			System.out.println(ct.getMaSP()+ "----"+ct.getSoLuong());
		}
	}


}
