function packSelections (){
	'use strict'
	var value = 
	$(this).parent().children(':checked').not('#selectAll').map(function(){
		return this.value
	}).get();
	
	$('#selections').attr('value',value);
} 




function confirmDelete(){
	'use strict'
	var value = $('#selections').attr('value');
	
	if (value === undefined || value === null || value === ''){
		alert('select at least one')
		return false;
	}
	
	return confirm('You are about to delete ids: ['  + $('#selections').attr('value') +']')
}

function toggleAll(){
	
	var checkboxes = $(this).parent().children(':checkbox').not(this);
	
	if (this.checked) {
		checkboxes.prop("checked", true);
	} else {
		checkboxes.prop("checked", false);
	}
} 

$(document).ready(function(){
	 $('#deleteForm #selectAll').change(toggleAll);
	 $('#deleteForm :checkbox').change(packSelections);
	// $('#deleteForm :submit').click(packSelections);
	 $('#deleteForm :submit').click(confirmDelete);
	
 });
