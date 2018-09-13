$(function(){
	
	//solving the active menu problem
	switch(menu){
		case 'Boxes':
			$('#boxes').addClass('active');
			break;
			
		case 'Cables':
		$('#cables').addClass('active');
		break;
		
		case 'Remotes':
			$('#remotes').addClass('active');
			break;
			
		case 'Contact':
			$('#contact').addClass('active');
			break;
			
		case 'About us':
			$('#about').addClass('active');
			break;
			
			default:
				$('#home').addClass('active');
		
			break;
	}
	});
	
