<div class="container-fluid" style="margin-top: 110px; paddig: 0px;">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
 		<div class="carousel-inner">
 			<div class="item active">
				<img src="${images}/download_app.jpg" alt="download_app"
					style="width: 100%;">
			</div>
 			<div class="item">
				<img src="${images}/geographical_print.jpg" alt="geographical_print"
					style="width: 100%;">
			</div>
 			<div class="item">
				<img src="${images}/HD-Entertainment.jpg" alt="HD-Entertainment"
					style="width: 100%;">
			</div>
 			<div class="item">
				<img src="${images}/home-the-theatr.jpg" alt="home-the-theatr"
					style="width: 100%;">
 			</div>
		</div>
 		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>

<div class="col-md-3">
<%@include file="./shared/sidebar.jsp" %>

</div>


 <!-- Bestseller Products -->
 <div class="container">
 <div class="row" id="bestSeller">
	<div class="col-lg-10">
		<h2 class="page-header">Bestseller</h2>
	</div>
</div>
<!-- Products -->
<div class="row">
	<c:forEach var="i" begin="0" end="7">
			<div class="col-md-3 portfolio-item" style="border: 5pt;">
				<a href="#"> <img class="img-responsive"
					src="http://placehold.it/700x400" alt="">
				</a>
				<h3 class="pull-right">Rs. ${p.product_price}</h3>
				<h3>
					<a href="#">${p.product_name}</a>
				</h3>
				<h5>${p.key_feature}</h5>
				<p>${p.product_desc}</p>
			</div>
		</c:forEach>
</div>
</div> 