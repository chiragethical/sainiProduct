$(function() {

	// solving the active menu problem
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;

	case 'Products':
		$('#products').addClass('active');
		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;
	
	case 'Plans':
		$('#plans').addClass('active');
		break;
		
	case 'Manage Plans':
		$('#managePlans').addClass('active');
		break;

	case 'About us':
		$('#about').addClass('active');
		break;

	case 'New Connection':
		$('#newConnection').addClass('active');
		break;

	case 'Manage Connections':
		$('#manageConnections').addClass('active');
		break;

	default:
		$('#products').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// --------------------------------------------------------------
	// PRODUCT TABLE FOR USER
	// --------------------------------------------------------------
	var $table = $('#showAllProducts');
	if ($table.length) {
		// console.log('table inserted');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 5, 10, 15, 20, -1 ],
							[ 'FIVE', 'TEN', 'FIFTEEN', 'TWENTY', 'ALL' ] ],
					pageLength : 15,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock !</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span> </a>'
											+ '  ';

									if (row.quantity < 1) {

										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';

									}

									else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
									}

									return str;
								}

							}

					]

				})
	}

	
	// --------------------------------------------------------------
	// PLAN TABLE FOR USER
	// --------------------------------------------------------------
	var $showAllPlans = $('#showAllPlans');
	if ($showAllPlans.length) {
		// console.log('table inserted');

		var jsonUrl = window.contextRoot + '/json/data/all/plans';

		$showAllPlans
				.DataTable({
					lengthMenu : [ [ 5, 10, -1 ],
							[ 'FIVE', 'TEN', 'ALL' ] ],
					pageLength : 10,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code'
							},
							{
								data : 'name'
							},
							{
								data : 'description'								
							},
							{
								data : 'price'
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									
										str += '<a href="javascript:void(0)" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>  Buy Plan</a>';
										return str;
								}

							}

					]

				})
	}
	// ---------------------------------------------
	// PRODUCT TABLE FOR ADMIN
	// ---------------------------------------------

	var $adminProductsTable = $('#adminProductsTable');
	if ($adminProductsTable.length) {
		// console.log('table inserted');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ 'Ten Records', 'Thirty Records', 'Fifty Records',
									'All' ] ],
					pageLength : 10,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminProductTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock !</span>';
									}
									return data;
								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					]

				})
	}
	
	
	// --------------------------------------------------------------
	// PLAN TABLE FOR ADMIN
	// --------------------------------------------------------------
	var $adminPlansTable = $('#adminPlansTable');
	if ($adminPlansTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/plans';

		$adminPlansTable
				.DataTable({
					lengthMenu : [ [ 5, 10, -1 ],
							[ 'FIVE', 'TEN', 'ALL' ] ],
					pageLength : 10,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
					        {
					        	data : 'id'
					        },	   
							{
								data : 'code'
							},
							{
								data : 'name'
							},
							{
								data : 'description'								
							},
							{
								data : 'price'
							},
							{
								data : 'active',
								mRender : function(data , type , row){
									if(data == true)
										{
										return "Active";
										}
									else
										{
										return "Not Active";
										}
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/plan" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					]

				})
	}

	var $newConnectionTable = $('#newConnectionTable');
	if ($newConnectionTable.length) {
		// console.log('table inserted');

		var jsonUrl = window.contextRoot
				+ '/json/data/show/connection/requests';

		$newConnectionTable
				.DataTable({
					lengthMenu : [ [ 5, 10, 15, 20, -1 ],
							[ 'FIVE', 'TEN', 'FIFTEEN', 'TWENTY', 'ALL' ] ],
					pageLength : 15,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'requestId'
							},
							{
								data : 'name'
							},
							{
								data : 'email'
							},
							{
								data : 'phone'
							},
							{
								data : 'address'
							},
							{
								data : 'dateOfRequest'
							},
							{
								data : 'status'
							},
							{
								data : 'active',
								mRender : function(data , type , row){
									if(data == true)
										{
										return "Active";
										}
									else
										{
										return "Not Active";
										}
								}
									
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '<a href="'
											+ window.contextRoot
											+ '/manage/new/connection/'
											+ data
											+ '/request" class="btn btn-danger"><span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}

							}

					]

				})
	}

});