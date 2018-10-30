package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.HoaDonDAO;

/**
 * Servlet implementation class QUANLYHOADONsevlet
 */
@WebServlet("/QUANLYHOADONsevlet")
public class QUANLYHOADONsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 HoaDonDAO dao = new HoaDonDAO();
    public QUANLYHOADONsevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String MaHD = request.getParameter("MaHD");
		String url="";
		try {
					dao.deleteHD(MaHD);
			
					url="admin/manager_bill.jsp";
			
				}
		
		catch(Exception e) {
			url="admin/manager_bill.jsp";
		}
		response.sendRedirect(url);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
