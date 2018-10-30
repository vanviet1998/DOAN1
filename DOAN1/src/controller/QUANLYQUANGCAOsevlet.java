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

import DAO.QuangCaoDAO;
import DAO.SanPhamDAO;
import model.QuangCao;
import model.SanPham;
////

/**
 * Servlet implementation class QUANLYSANPHAMsevlet
 */
@WebServlet("/QUANLYQUANGCAOsevlet")
@MultipartConfig
public class QUANLYQUANGCAOsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

QuangCaoDAO qcdao = new QuangCaoDAO();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String MaQC = request.getParameter("MaQC");
		String url="";
		try {

					switch (command) {
				case "delete":
					qcdao.deleteQC(MaQC);
					url="admin/manager_quangcao.jsp";
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
		String MaQC = request.getParameter("MaQC");
		String TenQC = request.getParameter("TenQC");
		String Link = request.getParameter("Link");
		String fileanh="";
		Part part = request.getPart("file");	
		String filename =extractFileName(part);	
	if( filename.length() >0)
	{
			
		String savePatch= "C:\\Users\\viet\\eclipse-workspace\\DOAN1\\WebContent\\images" + File.separator +filename;
	
			part.write(savePatch + File.separator);
			 fileanh ="images" + File.separator +filename;
	}else if( filename.length() ==0) {
		 fileanh = request.getParameter("hinhqc");
	}
		
		
		
		String error="";
		if(TenQC.equals("") && Link.equals("")   
				  ) {
			error="vui lòng nhập hết thông tin";
			
		}
	
		if(error.length()==0)
		{
			switch (command) {
			case "insert":
				
					qcdao.insertQC(new QuangCao(TenQC,fileanh,Link));
				
				url="admin/manager_quangcao.jsp";
				break;
			case "update":
				qcdao.updateQC(new QuangCao(MaQC,TenQC,fileanh,Link));
				url="admin/manager_quangcao.jsp";
				break;
		
			}
			   
			
		}else {
			url="admin/insert_quangcao3.jsp";
		}
		} catch (NumberFormatException | SQLException exception) {
		
			url="admin/insert_quangcao3.jsp";
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
