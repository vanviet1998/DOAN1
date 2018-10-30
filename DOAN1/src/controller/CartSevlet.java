package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SanPhamDAO;
import model.Cart;
import model.Item;
import model.SanPham;

/**
 * Servlet implementation class CartSevlet
 */
@WebServlet("/CartSevlet")
public class CartSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SanPhamDAO spdao = new SanPhamDAO();

	public CartSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String MaSP = request.getParameter("MaSP");
		Cart cart = (Cart) session.getAttribute("cart");
		try {
			SanPham sp = spdao.getSanPham((MaSP));
			switch (command) {
			case "plus":
				if (cart.getCartItem().containsKey(MaSP)) {

					cart.plusToCart(MaSP, new Item(sp, cart.getCartItem().get(MaSP).getSoLuong()));
				} else {
					cart.plusToCart(MaSP, new Item(sp, 1));
				}
				break;
			case "remove":
				cart.removeToCart(MaSP);
				break;

			}

			session.setAttribute("cart", cart);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			response.sendRedirect("/DOAN1/index.jsp");
		}
	}

}
