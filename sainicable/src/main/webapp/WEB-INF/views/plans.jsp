<div class="container" style="margin-top: 90px;">

	<div class="row">

		
				<div class="col-lg-12">

					<c:if test="${userClickAllPlans== true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Plans</li>


						</ol>
					</c:if>
				</div>


			</div>


			<div class="row">

				<div class="col-xs-12">


					<table id="showAllPlans"
						class="table table-striped table-borderd">


						<thead>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</thead>


						<tfoot>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>

							</tr>

						</tfoot>
					</table>

				</div>

			</div>


		</div>
	</div>

</div>