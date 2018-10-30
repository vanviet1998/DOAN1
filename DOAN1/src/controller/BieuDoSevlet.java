package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BIEUDODAO;

/**
 * Servlet implementation class BieuDoSevlet
 */
@WebServlet("/BieuDoSevlet")
public class BieuDoSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BIEUDODAO bieudodao =  new BIEUDODAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BieuDoSevlet() {
        super();
 
    }

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("listitem",bieudodao.getAll());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("manager_bietdo.jsp");
			rd.forward(request, response);
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
