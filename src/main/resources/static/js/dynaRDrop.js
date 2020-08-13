$(document).ready(function() {
   $("#countries").change(function() {
      var countryId = $(this).val();
      var s = '<option value=' + -1 + '>SELECT</option>';
      if (countryId > 0) {
      	$.ajax({
        url : 'getStates',
        data : { "countryId" : countryId },
        success : function(result) {
        	var result = JSON.parse(result);
        	for (var i = 0; i < result.length; i++) {
        	  s += '<option value="' + result[i][0] + '">'+ result[i][1]+ '</option>';
        	}
        	$('#states').html(s);
        }
      });
     }
     //reset data
     $('#states').html(s);
     $('#cities').html(s);

   });

   $("#states").change(function() {
      var stateId = $(this).val();
      var s = '<option value=' + -1 + '>SELECT</option>';
      if (stateId > 0) {
      	$.ajax({
        url : 'getCities',
        data : {"stateId" : stateId},
        success : function(result) {
        	var result = JSON.parse(result);
        	for (var i = 0; i < result.length; i++) {
        		s += '<option value="' + result[i][0] + '">'+ result[i][1]+ '</option>';
        	}
        	$('#cities').html(s);
        }
       });
     }
     //reset data
     $('#cities').html(s);
  });
});