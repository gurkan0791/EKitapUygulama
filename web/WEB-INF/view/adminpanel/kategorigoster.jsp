<%-- 
    Document   : kategorigoster
    Created on : 18.Nis.2015, 23:51:46
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0;">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpanel.css">
        <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
    
</head>
<body>
    <jsp:include page="aheader.jsp"></jsp:include>
<div class="container" style="width: 100%;">
    <div class="row">
 <div class="col-md-3 col-lg-2">
    <ul  class="nav nav-pills nav-stacked">
    <li  class="active"><a href="#">GÖSTERGE PANELİ</a></li>
    <li ><a href="/kategorigoster">KATALOG</a>
        <ul >
            <li><a href="#" data-toggle="tab">Ürünler</a></li>
            <li><a href="/kategorigoster?altKatID=0" >Kategoriler</a></li>
            <li><a href="" data-toggle="tab">Kategori</a></li>
            <li><a href="#" data-toggle="tab">Css</a></li>
            <li><a href="#" data-toggle="tab">JavaScript</a></li>
        </ul>
    </li>
    <li ><a href="/kategorigoster" >İLETİŞİM</a>
    </ul>
 </div>
        <div class="col-md-9 col-lg-10">
            <div id="katblog">
    <a href="/kategoriekle" >KategoriEkle</a>
    
</div>
   <c:if test="${not empty requestScope.durum}">
        <c:out value="${requestScope.durum}"></c:out>
    </c:if>
<table  class="table table-hover">
    <tr>
    <th>ID</th>
    <th>ALTID</th>
    <th>AD</th>
    <th>Açıklama</th>
    <th>Güncelle</th>
    </tr>

    <c:forEach items="${katliste}" var="i">
        <c:if test="${i.altKategoriID eq param.altKatID}">
            
        <tr>
            
            <td> <c:out value="${i.kategoriID}"></c:out> </td>
            <td><c:out value="${i.altKategoriID}"></c:out></td>
            <td><a href="/kategorigoster?altKatID=<c:out value="${i.kategoriID}"></c:out>"> <c:out value="${i.kategoriADI}"></c:out></a></td>
            <td> <c:out value="${i.kategoriAciklama}"></c:out></td>
            </a>
            <%--<c:out value="${i.kategoriResimUrl}"></c:out>--%>
            <td><a href="/kategoriguncelle?katID=<c:out value="${i.kategoriID}"></c:out>">Düzenle</a></td>
        </tr>
        
        </c:if>
    </c:forEach>
</table>  

            
        </div>  
        
        
    </div>       
</div>

</body>
</html>
