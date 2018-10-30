package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import model.Cart;
import model.ChiTietHoaDon;
import model.DangNhap;
import model.HoaDon;
import model.Item;
import tools.sendMail;


/**
 * Servlet implementation class CheckoutServelet
 */
@WebServlet("/CheckoutServelet")
public class CheckoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private HoaDonDAO hoaDonDAO = new HoaDonDAO();
   private ChiTietHoaDonDAO chiTietHoaDonDAO= new ChiTietHoaDonDAO();

    public CheckoutServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String TenKH = request.getParameter("TenKH");
		String DiaChi = request.getParameter("DCKH");
		String SDT = request.getParameter("SDT");
		HttpSession session= request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		DangNhap dangnhap = (DangNhap)session.getAttribute("dn");
		String url="";
		if(TenKH.equals("") || DiaChi.equals("") || SDT.equals(""))
		{
			url="Checkout2.jsp";
		}else {
		try {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);
			HoaDon hd = new HoaDon();			
			hd.setMaKH(dangnhap.getMaDangNhap());
			hd.setNgayMua(date);
			hd.setTongTien(cart.totalCart());
			hd.setTenKH(TenKH);
			hd.setDiaChi(DiaChi);
			hd.setSDT(SDT);
			hoaDonDAO.insertHoaDon(hd);
			
		for(Entry<String, Item> list: cart.getCartItem().entrySet()) {
			chiTietHoaDonDAO.insertChiTietHD(new ChiTietHoaDon(hd.getMaHD(),list.getValue().getSanpham().getMaSP(),
					list.getValue().getSoLuong(),list.getValue().getSanpham().getGiaSP(),null));
	}
		
		sendMail.SendMail(dangnhap.getTenDangNhap(), "Shop Rau Sach", "Xin Chào: "+TenKH+"\n Cảm ơn bạn đã mua hàng \n Tổng số tiền của bạn là:"+cart.totalCart());
			
		cart  = new Cart();
		session.setAttribute("cart", cart);
		} catch (SQLException ex) {
		
			ex.printStackTrace();
		}
		url="index.jsp";
		}
		
		
		response.sendRedirect(url);
	}

}
