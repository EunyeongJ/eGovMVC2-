$("#group_cd").change(changeSelectCheck=function(){	
	$.ajax({
		type:"POST",
		url:'../board/selectChangeCheck',
		data:{"groupCodeCD" : $(this).val()},
		success:function(data){
			console.log("성공");
		}
	}); 
});