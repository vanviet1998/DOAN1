package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DangNhapDAO;
import model.DangNhap;


@WebServlet("/Login")
public class DangNhapservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
 
	  DangNhapDAO dangNhapDAO = new DangNhapDAO();
   
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/htm;charset=utf-8");
			DangNhap dn = new DangNhap();

			String action = request.getParameter("action");
			if(action == null) {
				System.out.println("không làm gì hết");
			}
				else if(action.equals ("login")) {
					
					
							
					String TenDangNhap = request.getParameter("TenDangNhap");
					String MatKhau = request.getParameter("pass");
					dn.setTenDangNhap(TenDangNhap);
					
			
							try {
								if ( dangNhapDAO.checkTaiKhoanlogin(TenDangNhap, MatKhau)) {
								
									dn.setMaDangNhap(dangNhapDAO.laymadn(TenDangNhap));
									response.sendRedirect("index.jsp");
									session.setAttribute("dn", dn);
								
								}else
								response.sendRedirect("login2.jsp");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								response.sendRedirect("register2.jsp");
							}
						
						
				}else if(action.equals("res")) {
					 
						String TenDangNhap = request.getParameter("TenDangNhap");
						String MatKhau = request.getParameter("pass");
						try {
							if(dangNhapDAO.cheakTaiKhoan(TenDangNhap))
							{
								response.sendRedirect("register2.jsp");
						
						}
							else {
								dangNhapDAO.ThemTaiKhoan(TenDangNhap, MatKhau);
								response.sendRedirect("index.jsp");
							}
						}
						catch(Exception ex ) {
						
							response.sendRedirect("register.jsp");

						}
				
					
				}else if(action.equals("logout")) {	
					

					
					    //session.invalidate();
					    response.sendRedirect("index.jsp");
					    return; // <--- Here.
					
				}else if(action.equals("admin")) {
					String TenDangNhap = request.getParameter("TenDangNhap");
					String MatKhau = request.getParameter("pass");
					try {
						if(dangNhapDAO.checkTaiKhoanadmin(TenDangNhap, MatKhau)) {
							dn.setTenDangNhap(TenDangNhap);

							session.setAttribute("dn", dn);
						
							response.sendRedirect("admin/indexadmin.jsp");
							
							
						}else {
						
							response.sendRedirect("admin/loginadmin2.jsp");
						}
					} catch (SQLException e) {
						
				
						e.printStackTrace();
					}
				}
				
			
		
		
	}

}

