package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.SanPhamDAO;
import model.SanPham;
////

/**
 * Servlet implementation class QUANLYSANPHAMsevlet
 */
@WebServlet("/QUANLYSANPHAMsevlet")
@MultipartConfig
public class QUANLYSANPHAMsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       SanPhamDAO sp = new SanPhamDAO();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String MaLoai = request.getParameter("MaSP");
		String url="";
		try {

			
				switch (command) {
				case "delete":
					sp.deleteLoaiSP(MaLoai);
					url="admin/manager_product.jsp";
					break;
				}
		
		}catch(Exception e) {
		
		}
		response.sendRedirect(url);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String masp = request.getParameter("MaSP");
		String TenSanPham = request.getParameter("TenSanPham");
		String NoiSanXuat = request.getParameter("NoiSanXuat");
		float GiaSanPham =Float.parseFloat(request.getParameter("GiaSanPham"));
		String ChiTietSanPham = request.getParameter("ChiTietSanPham");
		String maloai = request.getParameter("maloai");
		String fileanh="";
		Part part = request.getPart("file");	
		String filename =extractFileName(part);	
	if( filename.length() >0)
	{
			
		String savePatch= "C:\\Users\\viet\\eclipse-workspace\\DOAN1\\WebContent\\images" + File.separator +filename;
	
			part.write(savePatch + File.separator);
			 fileanh ="images" + File.separator +filename;
	}else if( filename.length() ==0) {
		 fileanh = request.getParameter("anhsp");
	}
		
		
		
		String error="";
		if(TenSanPham.equals("") && NoiSanXuat.equals("")  &&  
				   ChiTietSanPham.equals("")) {
			error="vui lòng nhập hết thông tin";
			
		}
	
		if(error.length()==0)
		{
			switch (command) {
			case "insert":
				
					sp.insertSanPham(new SanPham(TenSanPham,maloai,NoiSanXuat,GiaSanPham,fileanh,ChiTietSanPham));
				
				url="admin/manager_product.jsp";
				break;
			case "update":
				sp.updateSP(new SanPham(masp,TenSanPham,maloai,NoiSanXuat,GiaSanPham,fileanh,ChiTietSanPham));
				url="admin/manager_product.jsp";
				break;
		
			}
			   
			
		}else {
			url="admin/insert_product2.jsp";
		}
		} catch (NumberFormatException | SQLException exception) {
		
			url="admin/insert_product2.jsp";
		}
		response.sendRedirect(url);
	

  }
private String extractFileName(Part part) {
	String contentdip= part.getHeader("content-disposition");
	
	String[] items = contentdip.split(";");
	for(String s: items) {
		if(s.trim().startsWith("filename")) {
			return s.substring(s.indexOf("=")+2,s.length()-1);
			
		}
	}
	return "";
	
}
}
