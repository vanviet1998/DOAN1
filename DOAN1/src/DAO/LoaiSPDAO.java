package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.LoaiSP;
import model.SanPham;

public class LoaiSPDAO {
public LoaiSP getloaispbyMaLoai(String MaLoai) throws SQLException {
	Connection connection = DBConnect.getConnection();
	String sql = "select * From LoaiSP where MaLoai='"+MaLoai+"'";
	PreparedStatement ps =connection.prepareStatement(sql); 
	ResultSet rs = ps.executeQuery();
	LoaiSP sp  = new LoaiSP();
	while(rs.next()) {
	
		sp.setMaLoai(rs.getString("MaLoai"));
		sp.setTenLoai(rs.getString("TenLoai"));
	
	
				}
	return sp;
}

	public ArrayList<LoaiSP> getlistLoaiSP() throws SQLException
	{
	
		Connection connection = DBConnect.getConnection();
		String sql = "Select * From LoaiSP";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(); 
		ArrayList<LoaiSP> list = new ArrayList<LoaiSP>();
		while(rs.next()) {
			LoaiSP loaisp = new LoaiSP();
			loaisp.setMaLoai(rs.getString("MaLoai"));
			loaisp.setTenLoai(rs.getString("TenLoai"));
			list.add(loaisp);
			}
		return list;
	}
public boolean insertLoaiSP(LoaiSP c) throws SQLException {
    try {
         Connection connection = DBConnect.getConnection();
         String sql = "{call sp_DangkyLoaiSP (?)}";
         PreparedStatement ps = connection.prepareCall(sql);
         ps.setString(1, c.getTenLoai());
         int temp = ps.executeUpdate();
         return temp == 1;
    } catch (Exception e) {
    	 Logger.getLogger(LoaiSPDAO.class.getName()).log(Level.SEVERE, null, e);
        
    }
    return false;
}
public boolean updateLoaiSP(LoaiSP c) throws SQLException {
    try {
         Connection connection = DBConnect.getConnection();
         String sql = "UPDATE LoaiSP SET TenLoai = ? WHERE MaLoai = ?";
         PreparedStatement ps = connection.prepareCall(sql);
         ps.setString(2, c.getMaLoai());
         ps.setString(1, c.getTenLoai());
         int temp = ps.executeUpdate();
         return temp == 1;
    } catch (Exception e) {
    	 Logger.getLogger(LoaiSPDAO.class.getName()).log(Level.SEVERE, null, e);
        
    }
    return false;
}
public boolean deleteLoaiSP(String MaLoai) throws SQLException {
    try {
        Connection connection = DBConnect.getConnection();
        String sql = "DELETE FROM LoaiSP WHERE MaLoai = ?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, MaLoai);
        int temp = ps.executeUpdate();
            return temp == 1;
    } catch (Exception e) {
        return false;
    }
}

	public static void main(String[] arg) throws SQLException{
		LoaiSPDAO dao = new LoaiSPDAO();
		
		dao.insertLoaiSP(new LoaiSP( "Dây Leo"));
		
	}
}

