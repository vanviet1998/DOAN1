<%@page import="model.HoaDon"%>
<%@page import="DAO.HoaDonDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="model.SanPham"%>
<%@page import="DAO.SanPhamDAO"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%> 
	



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
     <style>
     	.data {
     	padding: 15px;
     	border: 1px solid #ddd;
     	}
     	.table1 {
     	margin: auto;
     	}
     	.header-table {
     	background: #ff6600;
     	color: #fff;
     	border: none;	
     	}
     	.content-table {
     	
     	}
     </style>
 
<meta charset="ISO-8859-1">

<title>Lịch Sử</title>
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
HoaDonDAO hddao = new HoaDonDAO();

String MaKH = request.getParameter("MaDN");

ArrayList<HoaDon> listhd= hddao.getlistHoaDOntheomakh(MaKH);
%>

<jsp:include page="header.jsp"></jsp:include>

     <div id="rightContent">
                    <h3 style="text-align: center; margin: 20px 0;">Lịch Sử Mua Hàng</h3>
                  
                    <table class="data table1">
                        <tr class="data header-table">
                            <th class="data">STT</th>
                            <th class="data">Ngày Mua</th>
                             <th class="data">Tổng Tiền</th>
                              <th class="data">Tên KH</th>
                               <th class="data">Địa Chỉ</th>
                                <th class="data">SĐT</th>
                            <th class="data" width="100px">Tùy Chọn</th>
                        </tr>
                      
                        <% int count=0;
                        for(HoaDon hd : listhd) {
                        count++;
                        %>
                        <tr class="data content-table">
                            <td class="data" width="30px"><%= count%></td>
                            <td class="data"><%= hd.getNgayMua() %></td>
                              <td class="data"><%= hd.getTongTien()%></td>
                                <td class="data"><%= hd.getTenKH() %></td>
                                  <td class="data"><%= hd.getDiaChi()%></td>
                                    <td class="data"><%= hd.getSDT() %></td>
                            <td class="data" width="75px">
                        <center>
                            <a href="lichsu2.jsp?&MaHD=<%=hd.getMaHD()%>"><img src="">Chi Tiết</a>&nbsp;&nbsp; &nbsp;&nbsp;
                        </center>
                        </td>
                        </tr>
                        <%} %>
                   
                    </table>
                </div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>