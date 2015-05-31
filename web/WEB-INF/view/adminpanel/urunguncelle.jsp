<%-- 
    Document   : urunguncelle
    Created on : 11.May.2015, 21:57:02
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
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.ajaxfileupload.js"></script>
    <title>JSP Page</title>
    
</head>
<body >
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
             <!-- Nav tabs -->
        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">Bilgi</a></li>
            <li><a href="#profile" data-toggle="tab">Fiyat</a></li>
            <li><a href="#stokid" data-toggle="tab">Stok</a></li>
            <li><a href="#messages" data-toggle="tab">Ozellik</a></li>
            <li><a href="#settings" data-toggle="tab">Resim</a></li>
        </ul>
 
        <!-- Tab panes -->
        <form class="tab-content" action="urunekle" id="yazarform" method="GET">
            
                <div class="tab-pane active" id="home">
                    
                   
                    <br />
                    <!---->
                    <label for="scrollkategori"> Ana Kategori</label>    
                <div id="scrollkategori" style="height: 150px; overflow: scroll;">
                    <ul>
                     <li><input type="radio" name="katidd" value="0"></input>Root
                    <c:forEach items="${katliste}" var="i">
        
            
<!--        <tr>
            
            <td> <c:out value="${i.kategoriID}"></c:out> </td>
            <td><c:out value="${i.altKategoriID}"></c:out></td>
            <td><a href="/kategorigoster?altKatID=<c:out value="${i.kategoriID}"></c:out>"> <c:out value="${i.kategoriADI}"></c:out></a></td>
            <td> <c:out value="${i.kategoriAciklama}"></c:out></td>
            </a>
            <%--<c:out value="${i.kategoriResimUrl}"></c:out>--%>
            <td><a href="/kategoriguncelle?katID=<c:out value="${i.kategoriID}"></c:out>">Düzenle</a></td>
        </tr>-->
            
            <ul style="margin-left: 20px;">
            <c:set value="${i.kategoriID}" var="ustID"></c:set>    
            <c:if test="${i.altKategoriID eq 0}">
                <li><input id="${i.kategoriID}" type="radio" name="katidd" value="${i.kategoriID}"></input> ${i.kategoriADI}
                    <c:forEach items="${katliste}" var="j">
                        <c:set value="${j.kategoriID}" var="austID"></c:set>
                    <ul style="margin-left: 40px;">
                        <c:if test="${ustID eq j.altKategoriID}">
                            <li><input type="radio" id="${j.kategoriID}" name="katidd" value="${j.kategoriID}"></input>${j.kategoriADI}
                                <c:forEach items="${katliste}" var="k">
                                    <ul style="margin-left:60px;">
                                        <c:if test="${austID eq k.altKategoriID}">
                                        <li><input id="${k.kategoriID}" type="radio" name="katidd" value="${k.kategoriID}"</input>${k.kategoriADI}</li>
                                        </c:if>
                                    </ul>
                                </c:forEach>
                            </li>
                        </c:if>
                    </ul>
                    </c:forEach>
                </li>
                
            </c:if>
       
            </ul>
    </c:forEach>
</li>
</ul>
            
</div>    
                    
                        <script type='text/javascript'>
                            $(document).ready(function (){
                                var button = "${guncelurun[0].kategoriID}";
                                <c:forEach items="${katliste}" var="i">
                                    
                                    if(button == ${i.kategoriID})
                                    {
                                       
                                       // document.getElementById(button).checked = true;
                                        $("#"+button).prop("checked", true)
                                    }
                                </c:forEach>
                                
                            });
            
            
                        
                    </script>
                <div class="form-group">
                  <label for="adi">*ADI</label>
                  <input type="text" class="form-control" name="adi" id="adi" placeholder="Ürün Adı" value="${guncelurun[0].kitapAD}" required>
                </div>
                <div class="form-group">
                  <label for="aciklama">Açıklama</label>
                  <textarea class="form-control" id="aciklama" name="aciklama" rows="3" placeholder="Ürün Açıklama Yazısı">${guncelurun[0].aciklama}</textarea>
                </div>
                    
                    
                    
                
                    <input type="button" id="urunbilgiekle" value="Kaydet">

                </div>
                <div class="tab-pane" id="profile">
                    
                    <div class="form-group">
                        <%--<c:forEach items="${fiyatliste}" var="i">--%>
                 <label for="yazaradi">Vergi öncesi satış fiyatı</label>
                 <input type="text" class="form-control" name="vergionce" id="vergionce" value="${fiyatliste[0].vergisiz}">
                     <label for="yazaradi">Vergi dahil satış fiyatı KDV %18</label>
                 <input type="text" class="form-control" name="vergisonra" id="vergisonra" value="${fiyatliste[0].vergili}">
                     <input id="fiyatekle" type="button" value="Kaydet">
                         <%--</c:forEach>--%>
                    </div>
                    
                     
                     
                 
                    
                </div>
                 
                <script>
                    //kdv hesapla
                  $(document).ready(function () {
                        $('#vergionce').keyup(function () { 
                          var a=  Number($('#vergionce').val())+ Number($('#vergionce').val()*(18/100));
                          $('#vergisonra').val(a);
                         });
                         $('#vergisonra').keyup(function () { 
                          var a=  Number($('#vergisonra').val())+ Number($('#vergisonra').val()*(18/100));
                          $('#vergionce').val(a);
                         });
                    });
                    
                </script>
                    <div class="tab-pane" id="stokid">
                        <div class="form-group">
                        <%--<c:forEach items="${fiyatliste}" var="i">--%>
                 <label for="stok">Stok</label>
                 <input type="text" class="form-control" name="stok" id="stok" value="${stokliste[0].stok}">
                     
                     <input id="stokekle" type="button" value="Kaydet">
                         <%--</c:forEach>--%>
                    </div>
                    </div>
            <div class="tab-pane" id="messages">
<!--                3. içerik alanı
                <div class="form-group">
                 <label for="yazaradi">Yazar Adı</label>
                 <input type="text" class="form-control" name="field1" id="yazaradi" >
  
                 <label for="yayinadi">YayinEvi</label>
                 <input type="text" class="form-control" name="field2" id="yayinadi" >
                 
                     <label for="isbn">ISBN/BARKOD</label>
                 <input type="text" class="form-control" name="field3" id="isbn" >
                     
                     <label for="ksayfa">Sayfa</label>
                 <input type="text" class="form-control" name="field4" id="ksayfa" >
                     
                     <label for="ebat">Ebat</label>
                 <input type="text" class="form-control" name="field5" id="ebat" >
               </div>
              -->
              
                  <div class="form-group">
                      <c:set value="0" var="sayac" scope="page"></c:set>    
                  <c:forEach items="${ozellikliste}" var="i">
                    <c:set value="${sayac +1}" var="sayac" scope="page"></c:set>
                    <label for="${i.ozellik}">${i.gorunurAD}</label>
                    <input type="hidden" name="ofield${sayac}" value="${i.ID}"></input>
                    <input type="text" class="form-control" name="field${sayac}" id="field${sayac}" value="${urunozellikliste[sayac-1].deger}">  
                  </c:forEach>
                  </div>
                  <input type="button" value="Kaydet" id="ozellikekle">  
            </div>
            <div class="tab-pane" id="settings">Resim
            
                 <div class="form-group">
                  <label for="exampleInputFile">File input</label>
                  <input type="file" name=file id="exampleInputFile">
                  <p class="help-block">Example block-level help text here.</p>
                  <div id="upload" style="display: none;">Uploading..</div>
                        <div id="message"></div>
                </div>
                
                        <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Ürün Resim</div>
                        <div class="panel-body">
                          <p>Ürün Resimleri Listelenmektedir</p>
                        </div>

                        <!-- Table -->
                        <table class="table">
                           <c:forEach items="${resimliste}" var="i">
                     
                               <tr>
                                   <td>
                        <img  width="100" height="100" src="<%=request.getContextPath()%>/resimler/${i.url}" alt="Smiley face" >
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger urunsil" value="${i.resimID}" >Sil</button>
                        </td>
                        </tr>
                        </c:forEach>
                        </table>
                      </div> 
            </div>
            
        </form>

        </div>       
        
</div>
    </div>
   </div>
   
   <script>
      //resim ekle
       $('input[type="file"]').click(function() {
      
    var a= ${param.urunID};
    if(typeof a == "undefined" || a == null || a.length<0){
        alert("Lütfen Urun Seçin");
        return;
    }
  $('input[type="file"]').ajaxfileupload({
      'action' : "<%=request.getContextPath()%>/"+'resimekle?urunID='+a,
  'onComplete' : function(response) {
      $('#upload').hide();
      $('#message').show();
                        
      var statusVal = JSON.stringify(response.status);

     if(statusVal == "false")
     {
     $("#message").html("<font color='red'>"+JSON.stringify(response.message)+"</font>");
     }  
     if(statusVal == "true")
     {
     $("#message").html("<font color='green'>"+JSON.stringify(response.message)+"</font>");
     }        
     setTimeout(function() { location.reload() },2000);
},
'onStart' : function() {
        $('#upload').show();
        $('#message').hide();
}
});

});
      
       $(document).ready(function(){
           $('#yazarekleclick').click(function (){
               
               $('#yazarekledisp').show(1000);
           });
           $('#yayinekleclick').click(function (){
               
               $('#yayinekledisp').show(1000);
           });
       });
    function loadXMLDoc(){
        
       var a  = document.getElementById('yazarad').value;
        var b  = document.getElementById('yazarsoyad').value;
         var c  = document.getElementById('yazarmail').value;
          
        var xmlhttp;

               var url= "<c:url value = "yazarekle" />";
                if (window.XMLHttpRequest)
                {
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {

//                        document.getElementById("mid_title").innerHTML=xmlhttp.responseText;
                    }
                }

                xmlhttp.open("GET", url+"?yazarad="+a+"&yazarsoyad="+b+"&yazarmail="+c, true);
                xmlhttp.send();
               
               
//                var url = "urunekle";  
//                $(location).attr('href', url);
                 setTimeout(function() { location.reload() },1000);
               
                
    }
    
   
    
     $(document).ready(function(){
        
      
                $("#yazekle").click(function(){
                     var a  = document.getElementById('adi').value;
                    var b  = document.getElementById('aciklama').value;
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/yazarekle",
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                  $("#yayekle").click(function(){
                     var a  = document.getElementById('adi').value;
                    var b  = document.getElementById('aciklama').value;
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/yayineviekle",
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                 
                 $("#fiyatekle").click(function(){
                    // var a  = document.getElementById('vergionce').value;
                    //var b  = document.getElementById('vergisonra').value;
                    var a= ${param.urunID};
                  
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/fiyatekle?urunID="+a,
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                
                $("#stokekle").click(function(){
                    // var a  = document.getElementById('vergionce').value;
                    //var b  = document.getElementById('vergisonra').value;
                    var a= ${param.urunID};
                  
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/stokekle?urunID="+a,
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                
                
               $('.urunsil').click(function (){
               var id = $(this).attr("value");
               
               });
              
                $("#ozellikekle").click(function(){
                   //  var a  = document.getElementById('vergionce').value;
                   // var b  = document.getElementById('vergisonra').value;
                    var a= ${param.urunID};
                  
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/ozellikekle?urunID="+a,
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
                     $("#urunbilgiekle").click(function(){
                   //  var a  = document.getElementById('vergionce').value;
                   // var b  = document.getElementById('vergisonra').value;
                    var a= ${param.urunID};
                  
                           var form_data = $("#yazarform").serialize();
                           $.ajax({
                           url: "<%=request.getContextPath()%>/urunekle?urunID="+a,
                           type: 'GET',
                           data: form_data,
                           success: function (data) {
                               setTimeout(function() { location.reload() },1000);
                              
                               
                           }
                         
                   });
                   return false;
                 });
               
               });
               
               
   </script>
</body>
</html>
