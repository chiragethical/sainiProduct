$(function() {

	// solving the active menu problem
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
		
	case 'Products':
		$('#products').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;

	case 'About us':
		$('#about').addClass('active');
		break;

	default:
		$('#products').addClass('active');
		$('#a_'+menu).addClass('active');
	    break;
		}
	


	var $table = $('#showAllProducts');
	if($table.length)
		{
//		console.log('table inserted');
		
		var jsonUrl = '';
		if(window.categoryId == '')
			{
			jsonUrl = window.contextRoot + '/json/data/all/products';
			}
		else
			{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
			}
		
		
		$table.DataTable(
				{
					lengthMenu : [[5,10,15,20,-1],['FIVE','TEN','FIFTEEN','TWENTY','ALL']],
					pageLength :15,
					
					ajax:{
						url: jsonUrl, 
						dataSrc: ''
					},
					columns:
						[
						 {
							 data: 'code',
							 mRender: function(data, type, row)
							 {
								 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
							 }
						 },
						 {
							 data: 'name'
						 },
						 {
							 data: 'unitPrice',
							 mRender : function(data, type, row)
							 {
								 return '&#8377; ' + data
							 } 
						 },
						 {
							 data: 'quantity',
							 mRender : function(data , type, row)
							 {
								 if(data <1)
									 {
									 return '<span style="color:red">Out of Stock !</span>';
									 }
								 return data;
							 }
						 },
						 {
							 data: 'id',
							 bSortable: false,
							 mRender: function(data, type, row)
							 {
								 var str = '';
								 
								 str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span> </a>'+ '  ';
								 
								if(row.quantity <1)
									{
									
									 str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
									 
									}
								 
								else
									{
									 str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
									}
								
								 
								 return str;
							 }
								 
						 }
						 
						 ]
					
					
					
				})
		}
	
	
});