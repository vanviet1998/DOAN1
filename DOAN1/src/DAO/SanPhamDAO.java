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

public class SanPhamDAO {
	public ArrayList<SanPham> getListSanPham() throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From SanPham";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<SanPham> list = new ArrayList<>();
		while(rs.next()) {
			SanPham sp = new SanPham();
			sp.setMaSP(rs.getString("MaSP"));
			sp.setTenSP(rs.getString("TenSP"));
			sp.setMaLoai(rs.getString("MaLoai"));
			sp.setNoiSanXuat(rs.getString("NoiSanXuat"));
			sp.setGiaSP(rs.getFloat("GiaSP"));
			sp.setAnhSP(rs.getString("AnhSP"));
			sp.setChiTietSP(rs.getString("ChiTietSP"));
			list.add(sp);
					}
		return list;
		
	}
	public ArrayList<SanPham> getListSanPhamByMaSP(String MaLoai) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From SanPham where MaLoai='"+MaLoai+"'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<SanPham> list = new ArrayList<>();
		while(rs.next()) {
			SanPham sp = new SanPham();
			sp.setMaSP(rs.getString("MaSP"));
			sp.setTenSP(rs.getString("TenSP"));
			sp.setNoiSanXuat(rs.getString("NoiSanXuat"));
			sp.setGiaSP(rs.getFloat("GiaSP"));
			sp.setAnhSP(rs.getString("AnhSP"));
			list.add(sp);
					}
		return list;
		
	}

	public SanPham getSanPham(String MaSP)
			throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From SanPham where MaSP='"+MaSP+"'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		SanPham sp  = new SanPham();
		while(rs.next()) {
		
			sp.setMaSP(rs.getString("MaSP"));
			sp.setTenSP(rs.getString("TenSP"));
			sp.setNoiSanXuat(rs.getString("NoiSanXuat"));
			sp.setGiaSP(rs.getFloat("GiaSP"));
			sp.setAnhSP(rs.getString("AnhSP"));
			sp.setChiTietSP(rs.getString("ChiTietSP"));
		
					}
		return sp;
	}
	public ArrayList<SanPham> getListProductByPages(String MaLoai, int firstResult, int maxResult) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY MaSP) as row FROM SanPham  WHERE MaLoai= '" + MaLoai + "')a WHERE (a.row > ? and a.row <= ?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, firstResult);
        ps.setInt(2, maxResult);
        ResultSet rs = ps.executeQuery();
        ArrayList<SanPham> list = new ArrayList<>();
        while (rs.next()) {
        	SanPham sp = new SanPham();
        	sp.setMaSP(rs.getString("MaSP"));
			sp.setTenSP(rs.getString("TenSP"));
			sp.setNoiSanXuat(rs.getString("NoiSanXuat"));
			sp.setGiaSP(rs.getFloat("GiaSP"));
			sp.setAnhSP(rs.getString("AnhSP"));
			sp.setChiTietSP(rs.getString("ChiTietSP"));
            list.add(sp);
        }
        return list;
}
	public int CountSanPhamByMaLoai(String MaLoai) throws SQLException {
		  Connection connection = DBConnect.getConnection();
	        String sql = "SELECT count(MaSP) FROM SanPham WHERE MaLoai= '" + MaLoai + "'";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        while (rs.next()) {
	        count = rs.getInt(1);
	        }
	        return count;
	}
	public boolean insertSanPham(SanPham sp) throws SQLException {
	    try {
	         Connection connection = DBConnect.getConnection();
	         String sql = "{call sp_dangkysp (?,?,?,?,?,?)}";
	         PreparedStatement ps = connection.prepareCall(sql);
	         ps.setString(1, sp.getTenSP());
	         ps.setString(2, sp.getMaLoai());
	         ps.setString(3, sp.getNoiSanXuat());
	         ps.setFloat(4, sp.getGiaSP());
	         ps.setString(5, sp.getAnhSP());
	         ps.setString(6, sp.getChiTietSP());
	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	    	 Logger.getLogger(LoaiSPDAO.class.getName()).log(Level.SEVERE, null, e);
	        
	    }
	    return false;
	}
	public boolean updateSP(SanPham sp) throws SQLException {
	    try {
	         Connection connection = DBConnect.getConnection();
	         String sql = "UPDATE SanPham SET TenSP = ?,MaLoai=?,NoiSanXuat=?,GiaSP=?,AnhSP=?,ChiTietSP=? WHERE MaSP = ?";
	         PreparedStatement ps = connection.prepareCall(sql);
	         ps.setString(1, sp.getTenSP());
	         ps.setString(2, sp.getMaLoai());
	         ps.setString(3, sp.getNoiSanXuat());
	         ps.setFloat(4, sp.getGiaSP());
	         ps.setString(5, sp.getAnhSP());
	         ps.setString(6, sp.getChiTietSP());
	         ps.setString(7, sp.getMaSP());
	         int temp = ps.executeUpdate();
	         return temp == 1;
	    } catch (Exception e) {
	    	 Logger.getLogger(LoaiSPDAO.class.getName()).log(Level.SEVERE, null, e);
	        
	    }
	    return false;
	}
	public boolean deleteLoaiSP(String MaSP) throws SQLException {
	    try {
	        Connection connection = DBConnect.getConnection();
	        String sql = "DELETE FROM SanPham WHERE MaSP = ?";
	        PreparedStatement ps = connection.prepareCall(sql);
	        ps.setString(1, MaSP);
	        int temp = ps.executeUpdate();
	            return temp == 1;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public ArrayList<SanPham> getListSanPhamByTenSP(String TenSP) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "select * From SanPham where TenSP like N'"+TenSP+"%'";
		PreparedStatement ps =connection.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		ArrayList<SanPham> list = new ArrayList<>();
		while(rs.next()) {
			SanPham sp = new SanPham();
			sp.setMaSP(rs.getString("MaSP"));
			sp.setTenSP(rs.getString("TenSP"));
			sp.setNoiSanXuat(rs.getString("NoiSanXuat"));
			sp.setGiaSP(rs.getFloat("GiaSP"));
			sp.setAnhSP(rs.getString("AnhSP"));
			list.add(sp);
					}
		return list;
		
	}
	public static void main(String[] arg) throws SQLException{
		SanPhamDAO dao = new SanPhamDAO();
	
	ArrayList<SanPham> list = dao.getListSanPhamByTenSP("Củ");
	for(SanPham sp :list) {
	System.out.println(sp.getTenSP());
	}
}
}
	
	

