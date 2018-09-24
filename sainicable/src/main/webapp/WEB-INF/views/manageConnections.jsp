<div class="container" style="margin-top: 60px;">

<c:if test="${updateNewConnection == true}">
	<div class="row">

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Update New Connection Request Status</h4>

				</div>
				<div class="panel-body">

					<sf:form class="form-horizontal" modelAttribute="newConnection"
						action="${contextRoot}/manage/update/newConnection" method="POST">

						<div class="form-group">
							<label class="control-label col-md-4">Connection Status</label>
							<div class="col-md-8 validate">
								<sf:textarea path="status" class="form-control"
									 placeholder="Status Of connection" />
									
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Active Status</label>
							<div class="col-md-8">
								<sf:select path="active" class="form-control">
									<sf:option value="true" label="Active" />
									<sf:option value="false" label="Not Active" />
								</sf:select>
							</div>
						</div>

						<sf:hidden path="id" />
						<sf:hidden path="name" />
						<sf:hidden path="address" />
						<sf:hidden path="email" />


						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit " value="Update"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</c:if>
<hr>
<h2>Connection Requests</h2>
<hr></br>

	<div class="row">

		<div class='col-xs-12'>

			<table id="newConnectionTable"
				class="table table-bordered table-striped">
 
				<thead>
					<tr>
						<th>Id</th>
						<th>Request Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Contact</th>
						<th>Address</th>
						<th>Date of Request</th>
						<th>Connection Status</th>
						<th>Active Status</th>
						<th>Edit</th>

					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Id</th>
						<th>Request Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Contact</th>
						<th>Address</th>
						<th>Date of Request</th>
						<th>Connection Status</th>
						<th>Active Status</th>
						<th>Edit</th>
				</tfoot>

			</table>

		</div>

	</div>

</div>