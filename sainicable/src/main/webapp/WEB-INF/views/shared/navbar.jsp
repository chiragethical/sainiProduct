<nav class=" my-navbar navbar-default navbar-fixed-top" style="bg-color:red"; >
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${contextRoot}/home"> <img alt="Brand" src="">
			</a>
		</div>
				<ul class="nav navbar-nav navbar-right ">
			<li>
				<div id="" search-btn" class="form-group">
					<input type="text" class="form-control" placeholder="Search"
						style="display: none;">
				</div>
			</li>
			<li><a href=" "><span class="glyphicon glyphicon-search"></span>
					Search</a></li>
		</ul>
	</div>
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li id="home"><a href="${contextRoot}/home">Home</a></li>
			<li id="products"><a href="${contextRoot}/all/products">Products</a></li>
			<li id="manageProducts"><a href="${contextRoot}/manage/products">Manage Products</a></li>
			<li id="plans"><a href="${contextRoot}/all/plans">Plans</a></li>
			<li id="newConnection"><a href="${contextRoot}/new/connection">New Connection</a></li>
			<li id="complaint"><a href="${contextRoot}/complaint">Complaint</a></li>
			<li id="contact"><a href="${contextRoot}/contact">Contact Us</a></li>
			<li id="about"><a href="${contextRoot}/about">About Us</a></li> 
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<li><a href="register"><button type="button"
						class="btn btn-info btn-sm"
						style="padding: 0px; height: 23px; width: 70px">
						<span class="glyphicon glyphicon-user"></span> Sign Up
					</button></a></li>


			<li><a href="login">
					<button type="button" class="btn btn-info btn-sm"
						style="padding: 0px; height: 23px; width: 70px">
						<span class="glyphicon glyphicon-log-in"></span>&nbsp;Login
					</button>
			</a></li>
		</ul>
	</div>
</nav>