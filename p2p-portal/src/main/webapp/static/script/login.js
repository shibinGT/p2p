$().ready(function() {
  $("#LonginForm").validate({
	  //验证方式，鼠标离开就验证
	  onfocusout: function(element) { $(element).valid(); }, 
    rules: {
      jpgVerify: { //图片验证码
        required: true,   
        remote:{
        	 url: "checkJpgVerify",     //后台处理程序
     	    type: "post",               //数据发送方式
     	    dataType: "json",           //接受数据格式   
     	    data: {                     //要传递的数据
     	    	jpgVerify: function() {
     	            return $("#jpgVerify").val();
     	        }
     	    }
        }     
      }   
    },
    messages: { 
      jpgVerify: {
          required: "请输入验证码",       
          remote:"验证码不正确"
        }
    }
})

//提交注册
$('#loginSubmit').click(function() {
		if($("#LonginForm").valid()){
	// md5 对密码进行加密24次
		var password = $("#userPassword").val();
		for (var i = 0; i < 24; i++) {
			password = hex_md5(password);
		}
		$("#userPassword").val(password);	
		$('#LonginForm').submit();
		}
});

});