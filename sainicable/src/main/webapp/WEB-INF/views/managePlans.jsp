<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container" style="margin-top: 60px;">

	 <c:if test="${not empty message}">	
		<div class="row">			
			<div class="col-xs-12 ">			
				<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				
				${message}</div>				
			</div>
		</div>
	</c:if>

	<div class="row">

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Plan Management</h4>

				</div>

				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="plan"
						action="${contextRoot}/manage/plans" method="POST" enctype="multipart/form-data">
						
						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Plan Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter description here!" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="price" class="form-control"
									placeholder="Enter Price" />
								<sf:errors path="price" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Active</label>
							<div class="col-md-8">
								<sf:select path="active" class="form-control">
									<sf:option value="true" label="Active" />
									<sf:option value="false" label="Not Active" />
								</sf:select>
							</div>
						</div>


						<div class="text-right">
							<br />
							<sf:hidden path="id" />
							<sf:hidden path="code" />
						</div>
						
						
						
						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">

								<input type="submit" name="submit" value="Submit"
									class="btn btn-primary" />

							</div>
						</div>
				</div>



			</div>




			</sf:form>

		</div>

	</div>


	<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog" >
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span>&times;</span></button>
	        <h4 class="modal-title" >Add New Category</h4>
	      </div>
	      <div class="modal-body">
	        
	       <sf:form class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>       	        
	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit"  value="Add Category" class="btn btn-primary"/>						
					</div>
				</div>	       
	        </sf:form> 
	      </div>
	    </div>
	  </div>
	</div> 
	
	<hr/>	
	<h1>Available Plans</h1>
	<hr/>
	
	<div class="row">
				
		
		<div class='col-xs-12'>
		
		
			<table id="adminPlansTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Active</th>			
						<th>Edit</th>
					</tr>					
				</thead>
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Active</th>			
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
		
		
		</div>
	
	
	</div>

</div>
