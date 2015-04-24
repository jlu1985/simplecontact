function packSelections (){
	'use strict'
	var value = 
	$(this).parent().children(':checked').map(function(){
		return this.value
	}).get();
	
	$('#selections').attr('value',value);
} 



function selectionCheck(){
	
	
}

function confirmDelete(){
	'use strict'
	var value = $('#selections').attr('value');
	
	if (value === undefined || value === null){
		alert('select at least one')
		return false;
	}
	
	return confirm('You are about to delete ids: ['  + $('#selections').attr('value') +']')
}

$(document).ready(function(){
	 $('#deleteForm :checkbox').change(packSelections);
	 
	 $('#deleteForm :submit').click(confirmDelete);
 });
