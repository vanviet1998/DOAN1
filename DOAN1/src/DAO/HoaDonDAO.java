package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connect.DBConnect;
import model.HoaDon;
import model.SanPham;


public class HoaDonDAO {

	public  void insertHoaDon(HoaDon hoadon) throws SQLException {
		
		Connection connection =DBConnect.getConnection();
		CallableStatement  command = connection.prepareCall("{call sp_dangkyHD (?,?,?,?,?,?,?)}");
		command.setString(1,hoadon.getMaKH());
		command.setDate(2,hoadon.getNgayMua());
		command.setFloat(3,(float) hoadon.getTongTien());
		command.setString(4, hoadon.getTenKH());
		command.setString(5, hoadon.getDiaChi());
		command.setString(6, hoadon.getSDT());
		command.registerOutParameter(7, java.sql.Types.NVARCHAR);
		command.execute();  
		hoadon.setMaHD(command.getString(7));
	
	}
	public boolean deleteHD(String MaHD) throws SQLException {
	    try {
	        Connection connection = DBConnect.getConnection();
	        String sql = "{call sp_DeleteHD(?)}";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ps.setString(1, MaHD);
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public ArrayList<HoaDon> getlistHoaDOn() throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From HoaDon";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<HoaDon> list = new ArrayList<>();
		while(rs.next()) {
			HoaDon hd = new HoaDon();
			hd.setMaHD(rs.getString("MaHD"));
			hd.setMaKH(rs.getString("MaKH"));
			hd.setNgayMua(rs.getDate("NgayMua"));
			hd.setTongTien(rs.getDouble("TongTien"));
			hd.setTenKH(rs.getString("TenKH"));
			hd.setDiaChi(rs.getString("DiaChi"));
			hd.setSDT(rs.getString("SDT"));
			list.add(hd);
			
		
					}
		return list;
		
	}
	public ArrayList<HoaDon> getlistHoaDOntheomakh(String makh) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From HoaDon where MaKH = '"+makh+"'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<HoaDon> list = new ArrayList<>();
		while(rs.next()) {
			HoaDon hd = new HoaDon();
			hd.setMaHD(rs.getString("MaHD"));
			hd.setMaKH(rs.getString("MaKH"));
			hd.setNgayMua(rs.getDate("NgayMua"));
			hd.setTongTien(rs.getDouble("TongTien"));
			hd.setTenKH(rs.getString("TenKH"));
			hd.setDiaChi(rs.getString("DiaChi"));
			hd.setSDT(rs.getString("SDT"));
			list.add(hd);
			
		
					}
		return list;
		
	}
				
	
public static void main(String[] args) throws SQLException {

//	long millis=System.currentTimeMillis();  
//	java.sql.Date date=new java.sql.Date(millis);
	HoaDonDAO hoadon = new HoaDonDAO();
//	for (HoaDon hd : hoadon.getlistHoaDOn()) {
//	System.out.println(hd.getTenKH());
//	}
//	hoadon.deleteHD("HD005");
	for (HoaDon hd : hoadon.getlistHoaDOntheomakh("TK019")) {
	System.out.println(hd.getTenKH());
}
}
}
