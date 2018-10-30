<%-- 
    Document   : manager_category
    Created on : 19-May-2016, 7:30:15 PM
    Author     : TUNGDUONG
--%>


<%@page import="model.QuangCao"%>
<%@page import="DAO.QuangCaoDAO"%>
<%@page import="model.LoaiSP"%>
<%@page import="DAO.LoaiSPDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý quảng cáo</title>

        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>

        <%
            QuangCaoDAO qcdao = new QuangCaoDAO();
            ArrayList<QuangCao> listqc = qcdao.getListQuangCao();
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Quản lý quảng cáo</h3>
                    
                    <a href="${root}/admin/insert_quangcao.jsp">Thêm QC</a>

                    <table class="data">

                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data">Mã QC</th>
                            <th class="data">Tên QC</th>
                                   <th class="data">Hinh</th>
                                          <th class="data">Link</th>
                            <th class="data" width="90px">Tùy chọn</th>
                        </tr>

                        <%
                            int count = 0;
                            for(QuangCao qc : listqc){
                                count++;
                        %>
                        <tr class="data">
                            <td class="data" width="30px"><%=count%></td>
                            <td class="data"><%=qc.getMaQC()%></td>
                              <td class="data"><%=qc.getTenQC()%></td>
                                               <td class="data"><%=qc.getHinh()%></td>
                                                                <td class="data"><%=qc.getLink()%></td>
                            <td class="data" width="90px">
                            <center>
                          <a href="${root}/admin/update_quangcao.jsp?command=update&MaQC=<%=qc.getMaQC()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                                  <a href="/DOAN1/QUANLYQUANGCAOsevlet?command=delete&MaQC=<%=qc.getMaQC()%>">Xóa</a>
                            </center>
                            </td>
                        </tr>
                        <%}%>

                    </table>
                </div>
                <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>

    </body>
</html>
