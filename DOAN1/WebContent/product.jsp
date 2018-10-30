<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%> 
	



<!DOCTYPE html>
<html>
<head>

 
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>product</title>
</head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true,
				  });
				});
			</script>
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
<body>
<%
	SanPhamDAO sanPhamDAO = new SanPhamDAO();
	String MaLoai= "";
	if(request.getParameter("MaLoai")!=null)
	{
		MaLoai = request.getParameter("MaLoai");
	}
	Cart cart =(Cart) session.getAttribute("cart");
	if(cart == null)
	{
		 
		cart = new Cart();
		 session.setAttribute("cart",cart);
	}
	int pages = 0, firstResult=0,maxResult=0,total=0;
	if(request.getParameter("pages")!=null){
		pages=(int) Integer.parseInt(request.getParameter("pages"));
	}
	total = sanPhamDAO.CountSanPhamByMaLoai(MaLoai);
	if(total <=10)
	{
		firstResult=0;
		maxResult = total;
	}else{
		firstResult=(pages-1)*10;
		maxResult = pages*10;
	}
	
	ArrayList<SanPham> listSanPham = sanPhamDAO.getListProductByPages(MaLoai, firstResult, maxResult);
%>


<jsp:include page="header.jsp"></jsp:include>

<!---->
		<div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">DANHSACHSP</h3>
					<div class="content-top-in">
						
						<%
						for(SanPham s :listSanPham){
						%>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.jsp?MaSP=<%=s.getMaSP() %>"><img src="<%=s.getAnhSP() %>" alt="<%= s.getTenSP() %>"/></a>	
								<div class="top-content">
									<h5><a href="single.jsp?MaSP=<%=s.getMaSP() %>"><%=s.getTenSP() %></a></h5>
									<div class="White">
										<a href="CartSevlet?command=plus&MaSP=<%=s.getMaSP()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Thêm Vào Giỏ Hàng</a>
										<p class="dollar"><span class="in-dollar">Giá</span><span><%= s.getGiaSP() %></span></p>
                                  <div class="clearfix"></div>
									</div>
								</div>					
							</div>
						</div>
					<%} %>
					<div class="clearfix"></div>
					</div>
				</div>
				<ul class="start">
				 <li><a href="#"><i></i></a></li>
   
					
					<%for(int i=1;i<=(total/10)+1;i++){ %>
							<li class="arrow"><a href="product.jsp?MaLoai=<%=MaLoai%>&pages=<%=i%>"><%=i%></a></li>
<%-- 							<li class="arrow"><a href="product.jsp?categoryID=<%=categoryID%>&pages=<%=i%>"><%=i%></a></li> --%>
  
							<%} %>			
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
			</div>
		</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>