<div class="container" style="margin-top: 90px;">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/all/products">Products</a></li>
				<li class="active">${product.name}</li>

			</ol>


		</div>


	</div>


	<div class="row">

		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>


		<!-- Display the product description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
						<hr/>
						<a href="javaScript:void()" class="btn btn-success disabled"><strike>
								<span class="glyphicon glyphicon-shopping-cart"> </span>Add to Cart</strike></a> 
						<a href="${contextRoot}/all/products" class="btn btn-primary">
							<span class=""></span>Back</a>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${product.quantity}</h6>
					<hr/>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"> </span>Add to Cart
					</a>
					<a href="${contextRoot}/all/products" class="btn btn-primary">
		 				<span class=""></span>Back
					</a>

				</c:otherwise>

			</c:choose>



			<%-- <security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product"
					class="btn btn-success"> <span
					class="glyphicon glyphicon-pencil"></span> Edit
				</a>
			</security:authorize>



			<a href="${contextRoot}/show/all/products" class="btn btn-warning">
				Continue Shopping</a> --%>

		</div>


	</div>

</div>