$().ready(function() {
	// 手机号码验证  
	jQuery.validator.addMethod("isMobile", function(value, element) {  
	    var length = value.length;  
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;  
	    return this.optional(element) || (length == 11 && mobile.test(value));  
	}, "请正确填写您的手机号码"); 
	
  $("#updatepasswordForm").validate({
	  //验证方式，鼠标离开就验证
	  onfocusout: function(element) { $(element).valid(); }, 
    rules: {
      userName: {
        required: true,
        minlength: 2,
      },
      userPassword: {
        required: true,
        minlength: 5
      },
      repeatPassword: {
        required: true,
        minlength: 5,
        equalTo: "#userPassword"
      },
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
      },
      userPhone:{
    	  isMobile:true,
    	  required: true,
      },
      phonVerify:{ //手机验证码
    	   required: true,
      },

    },
    messages: {
      userName: {
        required: "请输入用户名",
        minlength: "用户名必需由两个字母组成",    
      },
 
      userPassword: {
        required: "请输入密码",
        minlength: "密码长度不能小于 5 个字母"
      },
      repeatPassword: {
        required: "请确认密码",
        minlength: "密码长度不能小于 5 个字母",
        equalTo: "两次密码输入不一致"
      },
      jpgVerify: {
          required: "请输入验证码",       
          remote:"验证码不正确"
        }, 
        userPhone: {
            required: "请输入手机号",    
            isMobile:"请正确填写您的手机号码",
         
          }, 
        phonVerify: {
            required: "请输入验证码",
          }
    }
})	
//提交修改
$('#updatepasswordFormSubmit').click(function() {		
	// md5 对密码进行加密24次
		var password = $("#userPassword").val();
		for (var i = 0; i < 24; i++) {
			password = hex_md5(password);
		}
		$("#userPassword").val(password);
		$("#repeatPassword").val(password);			
		$('#updatepasswordForm').submit();		
});
});