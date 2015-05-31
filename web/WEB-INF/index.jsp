<%--
    Document   : index
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<script>
    $(document).ready(function() {
    $("body").tooltip({ selector: '[data-toggle=tooltip]' });
    
    
});
    
</script>

<div class="container" >
    
    <section class="pageslider">
        <div class="row">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="<%=request.getContextPath()%>/resimler/slider2.jpg" alt="Chania">
          <div class="carousel-caption">
          <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
        </div>
    </div>

    <div class="item">
            <img src="<%=request.getContextPath()%>/resimler/slider2.jpg" alt="Chania">

    </div>

    <div class="item">
           <img src="<%=request.getContextPath()%>/resimler/slider2.jpg" alt="Chania">

    </div>

    <div class="item">
           <img src="<%=request.getContextPath()%>/resimler/slider2.jpg" alt="Chania">

    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
        
        
        </div>
        
    </section>

    
</div>
           
 <div class="container">
    <div class="well well-sm">
        <strong>Yeni Kitaplar</strong>

    </div>
    <div id="products" class="row list-group">
        <c:forEach items="${yeniurunliste}" var="urun">
        <div class="item  col-xs-3 col-lg-2 col-md-2" >
            <div class="thumbnail">
                <img class="group list-group-image" src="<%=request.getContextPath()%>/resimler/${urun.urunResim}" width="147px" height="100px" alt="http://placehold.it/400x250/000/fff" />
                <div class="caption" style="text-align: center;">
                    <h4 class="text-center group inner list-group-item-heading">
                        ${urun.urunAD}</h4>
                    
                    <div class="row">
                        <div class="text-center ">
                            <p class="lead">
                                ${urun.urunFiyat} TL</p>
                        </div>
                        
                    </div>
                    <div class="row goster" >
                        
                        <div class="group list-group-item">
                            <a  data-toggle="tooltip" data-placement="bottom" href="/kitap?urunID=${urun.urunID}" title="detay"><span style="font-size:30px" class="glyphicon glyphicon-share"></span></a>
                            <a href="" data-toggle="tooltip" data-placement="bottom" title="Sepet" > <span style="font-size: 30px" class="glyphicon glyphicon-shopping-cart"></span></a>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        
        
    </div>
     
     <div class="well well-sm">
        <strong>En çok Satanlar</strong>

    </div>
     
     <div id="products" class="row list-group">
        <c:forEach items="${yeniurunliste}" var="urun">
        <div class="item  col-xs-3 col-lg-2 col-md-2" >
            <div class="thumbnail">
                <img class="group list-group-image" src="<%=request.getContextPath()%>/resimler/${urun.urunResim}" width="147px" height="100px" alt="http://placehold.it/400x250/000/fff" />
                <div class="caption" style="text-align: center;">
                    <h4 class="text-center group inner list-group-item-heading">
                        ${urun.urunAD}</h4>
                    
                    <div class="row">
                        <div class="text-center ">
                            <p class="lead">
                                ${urun.urunFiyat} TL</p>
                        </div>
                        
                    </div>
                    <div class="row goster" >
                        
                        <div class="group list-group-item">
                            <a  data-toggle="tooltip" data-placement="bottom" href="/kitap?urunID=${urun.urunID}" title="detay"><span style="font-size:30px" class="glyphicon glyphicon-share"></span></a>
                            <a href="" data-toggle="tooltip" data-placement="bottom" title="Sepet" > <span style="font-size: 30px" class="glyphicon glyphicon-shopping-cart"></span></a>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        
        
    </div>
     
</div>
          