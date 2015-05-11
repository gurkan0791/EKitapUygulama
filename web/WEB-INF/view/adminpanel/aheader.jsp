<%-- 
    Document   : aheader
    Created on : 08.May.2015, 09:27:43
    Author     : Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<header>
        <div id="uygulamaAdi">Yönetim Paneli</div>
        <div id="oturumBilgi">
            <div class="oturumclass" id="oturumResim">
               <img src="" width="40px;" height="40px;"></img>
            </div>
            <div class="oturumclass" id="oturumIsım">
                <c:out value="${sessionScope.calisanlar.ad}"></c:out>
                <c:out value="${sessionScope.calisanlar.soyad}"></c:out></br>
            </div>
            <div style="clear:both;"></div>
            <div id="oturumKapa">
                <img src="" height="100px;" width="100px;" ></img>
                <c:if test="${not empty sessionScope.calisanlar}" >
                    <form id="logout" action="${pageContext.request.contextPath}/logout" method="post">
                        <input type="submit" value="Logout" />
                    </form>
                </c:if>
            </div>
            <div style="clear:both;"></div>
        </div>
        
</header>    
