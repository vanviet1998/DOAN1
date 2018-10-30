<%@page import="model.QuangCao"%>
<%@page import="DAO.QuangCaoDAO"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>detail</title>
<style>
.hinh{
width:100%;
height:100%;}
</style>
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
 SanPhamDAO spdao = new SanPhamDAO();
	String MaSP = "";
	SanPham sp = new SanPham();
	if(request.getParameter("MaSP")!=null)
	{
		MaSP = request.getParameter("MaSP");
		sp = spdao.getSanPham(MaSP);
	}
	String MaLoai= "";
	if(request.getParameter("MaLoai")!=null)
	{
		MaLoai = request.getParameter("MaLoai");
	}

QuangCaoDAO qcdao = new QuangCaoDAO();
ArrayList<QuangCao> listqc = qcdao.getListQuangCao();


%>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
			<div class="single">
			
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
				
							
								<a >
									<img class="etalage_thumb_image img-responsive" src=<%=sp.getAnhSP() %> alt="" >
							
					
					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4><%= sp.getTenSP() %></h4>
							<div class="para-grid">
								<span  class="add-to"><%=sp.getGiaSP() %></span>
<a href="CartSevlet?command=plus&MaSP=<%=sp.getMaSP()%>" class="hvr-shutter-in-vertical cart-to">Thêm Vào Giỏ Hàng</a>
												
								<div class="clearfix"></div>
							 </div>
							
							<p> <%= sp.getChiTietSP() %></p>
							
							
						</div>
					</div>
										<div class="fb-comments" data-href="http://localhost:8080/DOAN1/single.jsp?MaSP=<%=sp.MaSP %>" data-width="800" data-numposts="5"></div>
					
				<div class="clearfix"> </div>
				
												
					<div class="clearfix"></div>
					</div>
					<div>
				</div>
				</div>
				<div class="col-md-3">
	
					<div class="single-bottom">
						
				<% for(QuangCao qc : listqc){ %>
				<h4><%= qc.getTenQC() %></h4>
					<a href="<%=qc.getLink()%>" target="_blank"><img alt="hinh" class="hinh" src="<%=qc.getHinh() %>"></a> <br>
					<%} %>
					</div>
					
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
		<!---->
<jsp:include page="footer.jsp"></jsp:include>

</html>