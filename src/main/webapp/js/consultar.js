$(document).ready(function(){
    alert("wenas");
	function consultarusuarios(){
    	alert("en la funcion");
		$.ajax({
    		type:"post",
    		url:"ServletGestionusuario",
    		type:"post",
    		dataType:'json',
    		success: function(result){
        		console.log("success");
        		console.log(result);
    		}
    	});
	}
	$('.con').on('click',function(){
    	consultarusuarios();
	});
});