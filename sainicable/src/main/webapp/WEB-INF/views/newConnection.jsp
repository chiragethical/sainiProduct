<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container" style="margin-top: 80px;">

	 <c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 ">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>

					<strong>${message}</strong>
				</div>
			</div>
		</div>
	</c:if>
 
	<div class="row">

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Apply for connection</h4>

				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="newConnection"
						action="${contextRoot}/apply/newConnection" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Enter your name here" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">E-mail</label>
							<div class="col-md-8">
								<sf:input type="email" path="email" class="form-control"
									placeholder="Provide your Email Id" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Contact No.</label>
							<div class="col-md-8">
								<sf:input type="number" path="phone" class="form-control"
									placeholder="Provide your contact number" />
								<sf:errors path="phone" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Address</label>
							<div class="col-md-8">
								<sf:input type="text" path="address" class="form-control"
									placeholder="Enter address for connection" />
								<sf:errors path="address" cssClass="help-block" element="em" />
							</div>
						</div>

						


						<div class="text-right">
							<br />
							<sf:hidden path="id" />
							<sf:hidden path="requestId" />
							<sf:hidden path="dateOfRequest" />

						</div>
						
						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">

								<input type="submit" name="submit" value="Submit your Request"
									class="btn btn-primary" />

							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>


