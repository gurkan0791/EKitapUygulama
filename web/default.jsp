<%-- 
    Document   : default
    Created on : 11.Nis.2015, 23:27:40
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hello World!</h1>
    
    <c:choose>
  <c:when test="${!empty selam}">
     //print the list 
     <c:out value="${requestScope.selam}"> </c:out>
  </c:when>
  <c:otherwise>
     //call the servlet
    <jsp:forward page="/UrunlerServlet"></jsp:forward> 
  </c:otherwise>
</c:choose>  
     
     <c:choose>
  <c:when test="${!empty kategori}">
     //print the list 
     <c:out value="${requestScope.kategori}"> </c:out>
  </c:when>
  <c:otherwise>
     //call the servlet
    <jsp:forward page="/KategoriServlet"></jsp:forward> 
  </c:otherwise>
</c:choose>  
</body>
</html>
