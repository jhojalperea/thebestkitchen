$(document).ready(function() {
    $('#invoiced').DataTable({
    	"columnDefs": [
            {
            	"targets": [3],
                "render": function (data, type, row) {
                     return format(data);
                }	                
            }
        ]
    });
    
    $('#invoices').DataTable({
    	"columnDefs": [
            {
            	"targets": [6],
                "render": function (data, type, row) {
                     return format(data);
                }	                
            }
        ]
    });
    
    $('#purchases').DataTable({
    	"columnDefs": [
            {
            	"targets": [2],
                "render": function (data, type, row) {
                     return format(data);
                }	                
            }
        ]
    });
    
    $(".add").click(function(){    	
		var newRow="<tr>"+
			"<td>"+									
			"<select id='chefId' class='col-12 custom-select' name='chefId[]' required>"+
			fillSelectChefs(chefs)+
			"</select>"+
			"</td>"+
			"<td><input required class='col-12' type='text' name='plate[]'></td>"+
			"<td><input pattern='[0-9]+' required class='col-12' type='text' name='amount[]'></td>"+
			"<td>"+
			"<a class='del text-white btn btn-primary'>"+
			"<i class='fas fa-trash-alt'></i>"+
			"</a>"+
			"</td>"+
			"</tr>";
		$("#itemInvoice tbody").append(newRow);		
	});

	$("#itemInvoice").on("click", ".del", function(){
		$(this).parents("tr").remove();		
	});	
	
});

function format(val) {			
    while (/(\d+)(\d{3})/.test(val.toString())) {
        val = val.toString().replace(/(\d+)(\d{3})/, '$1' + ',' + '$2');
    }
	return "$ "+val+".00";
}

function fillSelectChefs(chefList) {
	var html = '<option></option>';
	var chefName;
	for( var i=0; i<chefList.length; i++ ){		
		chefName = chefList[i].name+' '+chefList[i].surname+' '+(chefList[i].secondSurname != null ? chefList[i].secondSurname: '');
		html += '<option value="'+chefList[i].chefId+'">'+chefName+'</option>';
	}
	return html;			
}