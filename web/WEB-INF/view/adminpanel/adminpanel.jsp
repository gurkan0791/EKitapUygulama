<%-- 
    Document   : adminpanel
    Created on : 12.Nis.2015, 17:17:47
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hoşgeldiniz: <c:out value="${sessionScope.calisanlar.ad}"></c:out></h1>
    <c:if test="${not empty sessionScope.calisanlar}" >
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout" />
        </form>
    </c:if>
</body>
</html>
