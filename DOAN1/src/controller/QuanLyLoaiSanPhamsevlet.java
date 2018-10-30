package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoaiSPDAO;
import model.LoaiSP;

/**
 * Servlet implementation class QuanLyLoaiSanPhamsevlet
 */
@WebServlet("/QuanLyLoaiSanPhamsevlet")
public class QuanLyLoaiSanPhamsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 LoaiSPDAO loaiSPDAO = new LoaiSPDAO();
    public QuanLyLoaiSanPhamsevlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String MaLoai = request.getParameter("MaLoai");
		String url="";
		try {

			
				switch (command) {
				case "delete":
					loaiSPDAO.deleteLoaiSP(MaLoai);
					url="admin/manager_category.jsp";
					break;
				}
		
		}catch(Exception e) {
			
		}
		response.sendRedirect(url);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		String tendanhmuc = request.getParameter("tendanhmuc");
		
		String url="";
		String error="";
		if(tendanhmuc.equals("")) {
			error="vui lòng nhập tên loại sản phẩm";
			request.setAttribute("error", error);
		}
		try {
			if(error.length()==0)
			{
				switch (command) {
				case "insert":
					loaiSPDAO.insertLoaiSP(new LoaiSP(tendanhmuc));
					url="admin/manager_category.jsp";
					break;
				case "update":
					loaiSPDAO.updateLoaiSP(new LoaiSP(request.getParameter("MaLoai"),request.getParameter("tendanhmuc")));
					url="admin/manager_category.jsp";
					break;
				}
			}else {
				url="admin/insert_category.jsp";
			}
		}catch(Exception e) {
			
		}
		response.sendRedirect(url);
		
	}

}
