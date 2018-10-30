<%@page import="model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.SanPhamDAO"%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>content</title>
</head>
<body>
<!---->
	<%
	SanPhamDAO dao = new SanPhamDAO();
	ArrayList<SanPham> list = dao.getListSanPham();
	%>

		<div class="container">
			<div class="content">
				<div class="content-top">
				
					
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="content-middle">
				
					<div class="content-middle-in">
					
            		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>

					</div>
				</div>
				<!---->
				
				<div class="content-bottom">
					<h3 class="future">Sản Phẩm</h3>
			
					<div class="content-bottom-in">
							
					<ul id="flexiselDemo2">			
					
					
					<% for(SanPham sp : list) {%>
						<li><div class="col-md men">
							<div style="height:167px">
								<a href="single.jsp?MaSP=<%=sp.getMaSP() %>&LoaiSP<%=sp.getMaLoai() %>"><img src="<%=sp.getAnhSP() %>" alt="<%= sp.getTenSP() %>"/></a>
							</div>
									
								<div class="compare in-compare">
							
								</div>
								<div class="top-content bag">
										<h5><a href="single.jsp?MaSP=<%=sp.getMaSP() %>&LoaiSP<%=sp.getMaLoai() %>"><%=sp.getTenSP() %></a></h5>
									<div class="white">
									<a href="CartSevlet?command=plus&MaSP=<%=sp.getMaSP()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Thêm Vào Giỏ Hàng</a>
										<p class="dollar"><span class="in-dollar">Giá</span><span><%=sp.getGiaSP() %></span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
						<%} %>
					</ul>
					
					<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>

					</div>
				</div>
			
			</div>
		</div>
		<!---->
		<div class="footer">
			<div class="footer-top">
				<div class="container">
					<div class="col-md-4 footer-in">
						<h4><i> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="col-md-4 footer-in">
						<h4><i class="cross"> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="col-md-4 footer-in">
						<h4><i class="down"> </i>Suspendisse sed</h4>
						<p>Aliquam dignissim porttitor tortor non fermentum. Curabitur in magna lectus. Duis sed eros diam. Lorem ipsum dolor sit amet, consectetur.</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
</body>
</html>