<%@page import="model.Item"%>
<%@page import="org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry"%>
<%@page import="java.util.Map"%>

<%@page import="model.Cart"%>
<%@page import="model.DangNhap"%>
<%@page import="DAO.DangNhapDAO"%>
<%@page import="model.LoaiSP"%>
<%@page import="DAO.LoaiSPDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>header</title>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
</head>
<body>
<%

LoaiSPDAO loaiSPDAO = new LoaiSPDAO();
Cart cart = (Cart)session.getAttribute("cart");
if(cart == null)
{
	 
	cart = new Cart();
	 session.setAttribute("cart",cart);
}
DangNhap dn = null;

if (session.getAttribute("dn") != null) {
    
	 dn = (DangNhap)session.getAttribute("dn");
  }

%>
<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
						<a href="index.jsp"><img src="images/1.png" alt="" style="width: 250px"></a>
					</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
					<%if (dn != null) {%>
							     <li><a href="login.jsp"> Xin Chào: <%=dn.getTenDangNhap() %></a></li>
							        <li><a href="Dangxuat?command=web">Đăng Xuất</a></li>
							      
							      <%}%>
    			
                       
      		
                          <li><a href="Checkout.jsp" >Giỏ Hàng</a> 	
							<li><div class="cart">
<a href="#" class="cart-in" style="padding:0"><img src="images/cart.png" style="width:34px"/> </a> 									<span> <%= cart.countItem() %></span>
								</div>
								<ul class="sub-icon1 list">
						  <h3>Sản Phẩm Trong Giỏ Hàng</h3>
						  <div class="shopping_cart">
						  
						  <%for (Map.Entry<String,Item> list : cart.getCartItem().entrySet()) { %>
							  <div class="cart_box">
							   	 <div class="message">
							   	     <div class="alert-close"> </div> 
					                <div class="list_img"><img src=<%=list.getValue().getSanpham().getAnhSP() %> 
					                class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="CartSevlet?command=remove&MaSP=<%=list.getValue().getSanpham().getMaSP()%>"><%=list.getValue().getSanpham().getTenSP()%></a></h4>
								    <%=list.getValue().getSoLuong() %>x<span class="actual">
		                             <%= list.getValue().getSanpham().getGiaSP() %></span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                          
	                         
	                          
	                               <%} %>
	                               
	                            
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">Tổng Giá Trong Giỏ Hàng</div>
	                        	<div class="total_right"><%= cart.totalCart() %></div>
	                        	<div class="clearfix"> </div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="Checkout.jsp">Check out</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
						</ul>
							</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="index.jsp"><i> </i>Trang Chủ</a></li>
					<li ><a href="#" >Loại Sản Phẩm</a>
						<ul class="drop">
						<% 
						for(LoaiSP l : loaiSPDAO.getlistLoaiSP()) {
						%>
						
							<li><a href="product.jsp?MaLoai=<%=l.getMaLoai()%>&pages=1"><%= l.getTenLoai() %></a></li>
							<%} %>
							</ul>
							<%if(dn != null){%>
						<li ><a href="lichsu.jsp?MaDN=<%=dn.getMaDangNhap()%>">Lịch Sử Mua Hàng</a>
						<%} %>
				
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
			<div class="header-bottom-on">
			<p class="wel"><a href="login.jsp">Welcome visitor you can login or create an account.</a></p>
			<div class="header-can">
			
				
					<div class="search">
						<form action="product2.jsp" method="post">
							<input type="text" value="Search" name ="Search" >
							<input type="submit" value="">
						</form>
					</div>

					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>
	<script type="text/javascript">


//-->
</script>
	
	
	<!-- Subiz -->
<script>
  (function(s, u, b, i, z){
    u[i]=u[i]||function(){
      u[i].t=+new Date();
      (u[i].q=u[i].q||[]).push(arguments);
    };
    z=s.createElement('script');
    var zz=s.getElementsByTagName('script')[0];
    z.async=1; z.src=b; z.id='subiz-script';
    zz.parentNode.insertBefore(z,zz);
  })(document, window, 'https://widgetv4.subiz.com/static/js/app.js', 'subiz');
  subiz('setAccount', 'acqdnmuuysfvfkgavfft');
</script>
<!-- End Subiz -->
</body>
</html>