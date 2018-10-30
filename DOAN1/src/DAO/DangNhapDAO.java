package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.DangNhap;
import model.LoaiSP;


public class DangNhapDAO {
	public boolean cheakTaiKhoan(String TenDangNhap)
	{
		Connection connection =DBConnect.getConnection();
		String sql="Select * from DangNhap where TenDangNhap='"+TenDangNhap+"'";
		PreparedStatement ps; 
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				connection.close();
				return true;
			}
		}
		catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public boolean checkTaiKhoanlogin(String TenDangNhap,String MatKhau) throws SQLException
	{
		Connection connection =DBConnect.getConnection();
	
	
		String sql="Select * from DangNhap where TenDangNhap='"+TenDangNhap+"'and MatKhau ='"+MatKhau+" 'and LoaiTaiKhoan= 0";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				connection.close();
				return true;
			}
		}
		catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public boolean checkTaiKhoanadmin(String TenDangNhap,String MatKhau) throws SQLException
	{
		Connection connection =DBConnect.getConnection();
	
	
		String sql="Select * from DangNhap where TenDangNhap='"+TenDangNhap+"'and MatKhau ='"+MatKhau+" ' and LoaiTaiKhoan= 1";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				connection.close();
				return true;
			}
		}
		catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
public void ThemTaiKhoan(String TenDangNhap,String MatKhau)  
{
	try {
	Connection connection =DBConnect.getConnection();
	CallableStatement command = connection.prepareCall("{call sp_DangKyTaiKhoan (?,?)}");
	command.setString(1, TenDangNhap);
	command.setString(2, MatKhau);
	if(command.executeUpdate()>0)
	System.out.println("thanhcong");
	}
	catch (Exception ex) {
        ex.printStackTrace();
  }

      
}
public String laymadn(String TenDangNhap) throws SQLException
{
	Connection connection =DBConnect.getConnection();
	String MaDangNhap = null;
	String sql="Select * from DangNhap where TenDangNhap='"+TenDangNhap+"'";
	PreparedStatement ps = connection.prepareCall(sql);
	ResultSet rs = ps.executeQuery();
    while (rs.next()) {
	
		 MaDangNhap = rs.getString("MaDangNhap");	
    }
	return MaDangNhap;
	
}
public static void main(String[] arg) throws SQLException{
	DangNhapDAO dao = new DangNhapDAO();
if(dao.checkTaiKhoanadmin("vanviet", "123"))
{	
		System.out.println("1");;
	}
else {
	System.out.println("0");;
	}
}
}

	
	




