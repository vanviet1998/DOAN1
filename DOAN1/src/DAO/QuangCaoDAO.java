package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.QuangCao;
import model.SanPham;


public class QuangCaoDAO {
	public ArrayList<QuangCao> getListQuangCao() throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From QuangCao";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<QuangCao> list = new ArrayList<>();
		while(rs.next()) {
			QuangCao qc = new QuangCao();
			qc.setMaQC(rs.getString("MaQC"));
			qc.setTenQC(rs.getString("TenQC"));
			qc.setHinh(rs.getString("Hinh"));
			qc.setLink(rs.getString("Link"));
		
			list.add(qc);
					}
		return list;
		
	}
	public ArrayList<QuangCao> getListQuangCaobymaQC(String MaQC) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From QuangCao where MaQC='"+MaQC+"'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<QuangCao> list = new ArrayList<>();
		while(rs.next()) {
			QuangCao qc = new QuangCao();
			qc.setMaQC(rs.getString("MaQC"));
			qc.setTenQC(rs.getString("TenQC"));
			qc.setHinh(rs.getString("Hinh"));
			qc.setLink(rs.getString("Link"));
		
			list.add(qc);
					}
		return list;
		
	}
	public boolean insertQC(QuangCao qc) throws SQLException {
	    try {
	         Connection connection = DBConnect.getConnection();
	         String sql = "{call sp_dangkyctQC (?,?,?)}";
	         PreparedStatement ps = connection.prepareCall(sql);
	         ps.setString(1, qc.getTenQC());
	         ps.setString(2, qc.getHinh());
	         ps.setString(3, qc.getLink());
	    
	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	    	 Logger.getLogger(QuangCaoDAO.class.getName()).log(Level.SEVERE, null, e);
	        
	    }
	    return false;
	}
	public boolean deleteQC(String MaQC) throws SQLException {
	    try {
	        Connection connection = DBConnect.getConnection();
	        String sql = "DELETE FROM QuangCao WHERE MaQC = '"+MaQC+"'";
	        PreparedStatement ps = connection.prepareCall(sql);
	       
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean updateQC(QuangCao qc) throws SQLException {
	    try {
	         Connection connection = DBConnect.getConnection();
	         String sql = "update  QuangCao  set TenQC=? ,Hinh=? ,Link =? where MaQC = ?";
	         PreparedStatement ps = connection.prepareCall(sql);
	         ps.setString(1, qc.getTenQC());
	         ps.setString(2, qc.getHinh());
	         ps.setString(3, qc.getLink());
	         ps.setString(4, qc.getMaQC());

	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	    	 Logger.getLogger(QuangCaoDAO.class.getName()).log(Level.SEVERE, null, e);
	        
	    }
	    return false;
	}
public static void main (String arg[]) throws SQLException {
	QuangCaoDAO qc = new QuangCaoDAO();
qc.updateQC(new QuangCao("QC2","sss","ss","sad"));
	
}

}
