(function($, undefined) {
    $(document).ready(function() {
//    	姓名
    	$("#applyName").blur(function(){
    		applyName();
    		submit();
    	});
    
//    	隐藏显示
    	$("#applyName").focus(function(){
    		$("#name").hide();
    	});
//    	电话
        	$("#applyCall").blur(function(){
        		applyCall();
        		submit();
                });
        	
//        	隐藏显示
        	$("#applyCall").focus(function(){
        		$("#call").hide();
        	});
        		
//        	借款金额
        	$("#applyMoney").blur(function(){
        		applyMoney();
        		submit();
                });
        	
//        	隐藏显示
        	$("#applyMoney").focus(function(){
        		$("#money").hide();
        	});
        	
//        	借款期限
        	$("#applyDeadline").blur(function(){
        		applyDeadline();
        		submit();
                });
        	
//        	隐藏显示
        	$("#applyDeadline").focus(function(){
        		$("#deadline").hide();
        	});

        	
//        	所在地区
        	$("#applyLocation").blur(function(){
        		applyLocation();
        		submit();
              });
        	
//        	隐藏显示
        	$("#applyLocation").focus(function(){
        		$("#location").hide();
        	});
        	
//        	验证码图片
        	$("#changeCode").click(function(){
        	    // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
        	    var time = new Date();
        	    document.getElementById("yanzheng").src = ctx+"/client/getCode?time="+time;
        	});
        	
//        	校验验证码
        	$("#code").blur(function(){
        		showCode();
        		submit();
        });
        	
//        	隐藏显示
        	$("#code").focus(function(){
        		$("#showCode").hide();
        	});
        	
        	
        	
    })
})(jQuery)

function applyName(){
    		$("#name").show();
    		var applyName = $("#applyName");
    		var trimName = $.trim($("#applyName").val());
    		var regPartton = /[\u4E00-\u9FA5]{2,7}/g;
//    		判断用户名不为空，长度大于0
    		if(trimName.length<=0 || trimName == null){
    			$("#name").text("");
                $("#name").append("<span style=color:#ff7800>用户名不能为空</span>");
                flag = 1;
                return false;
    		}
    		 if (!regPartton.test(trimName)) {
                 $("#name").text("");
                 $("#name").append("<span style=color:#ff7800>用户名长度范围在2到6位汉字</span>");
                 flag = 1;
                 return false;
             } else {
                 $("#name").text("");
                 $("#name").append("<span style=color:green>用户名格式正确</span>");
                 flag = 0;
                 return true;
             }
    }

function applyCall(){
	$("#call").show();
	var applyCall = $("#applyCall");
	var trimCall = $.trim($("#applyCall").val());
	var regPartton = /^1[0-9]\d{9}$/;
	 if (trimCall.length<=0 || trimCall == null) {
         $("#call").text("");
         $("#call").append("<span style=color:#ff7800>手机号不可为空</span>");
         flag = 1;
         return false;
     } 
    if (trimCall.length != 11) {
        $("#call").text("");
        $("#call").append("<span style=color:#ff7800>请输入以1开头11位数字的手机号</span>");
        flag = 1;
        return false;
    }
    else if (!regPartton.test(trimCall)) {
        $("#call").text("");
        $("#call").append("<span style=color:#ff7800>请输入以1开头11位数字的手机号</span>");
        flag = 1;
        return false;
    } else {
        $("#call").text("");
        $("#call").append("<span style=color:green>手机号格式正确</span>");
        flag = 0;
        return true;
    }
}
function applyMoney() {
	$("#money").show();
	var applyMoney = $("#applyMoney");
	var trimMoney = $.trim($("#applyMoney").val());
	var regPartton = /^[1-9]\d*$/;
	 if (trimMoney.length<=0 || trimMoney == null) {
         $("#money").text("");
         $("#money").append("<span style=color:#ff7800>借款金额不能为空</span>");
         flag = 1;
         return false;
     } 
     if (!regPartton.test(trimMoney)) {
        $("#money").text("");
        $("#money").append("<span style=color:#ff7800>输入金额不正确，请输入首位大于0的数字</span>");
        flag = 1;
        return false;
    } else {
        $("#money").text("");
        $("#money").append("<span style=color:green>金额格式正确</span>");
        flag = 0;
        return true;
    }
}

function applyDeadline() {
	$("#deadline").show();
	var applyDeadline = $("#applyDeadline");
	var trimDeadline = $.trim($("#applyDeadline").val());
	var regPartton = /^[1-9]\d*$/;
	 if (trimDeadline.length<=0 || trimDeadline == null) {
         $("#deadline").text("");
         $("#deadline").append("<span style=color:#ff7800>借款期限不能为空</span>");
         flag = 1;
         return false;
     } 
     if (!regPartton.test(trimDeadline)) {
        $("#deadline").text("");
        $("#deadline").append("<span style=color:#ff7800>借款期限不正确，请输入全数字</span>");
        flag = 1;
        return false;
    } else {
        $("#deadline").text("");
        $("#deadline").append("<span style=color:green>输入正确</span>");
        flag = 0;
        return true;
    }
}

function applyLocation() {
	$("#location").show();
	var applyLocation = $("#applyLocation");
	var trimLocation = $.trim($("#applyLocation").val());
	var regPartton = /^1[1-9]\d{9}$/;
	 if (trimLocation.length<=0 || trimLocation == null) {
         $("#location").text("");
         $("#location").append("<span style=color:#ff7800>填写的地区不能为空</span>");
         flag = 1;
         return false;
     } 
     else {
        $("#location").text("");
        $("#location").append("<span style=color:green>输入正确</span>");
        flag = 0;
        return true;
    }
}

var codeFlag =false;
function showCode() {
	$("#showCode").show();
	var flag = false;
	var code = $.trim($("#code").val());
	var html = "";
	if(code !=null && code.length>0){
	//ajax执行体
	$.ajax({
		//提交方式
		type : "get",
		//访问servleturl
		url : ctx+"/client/verifyCode?code="+code,
		async:false,
		//服务器成功返回结果后，会把结果保存到data中
		success : function(data) {
			//先把表体部分清空
			$("#showCode").empty();
			//eval获取返回的JSON对象集合
			var result = eval('(' + data + ')');
			if(result == 100){
				html = '<span style="color: red">验证码不能为空</span>';
                flag = false;
                codeFlag=false;
			}
			if(result == 200){
				html = '<span style="color: green">验证码正确</span>';
                flag = true;
                codeFlag=true;
			}
			if(result == 300){
				html = '<span style="color: red">验证码不正确</span>';
                flag = false;
                codeFlag=false;
			}
			//把数据显示到页面的方法
			$("#showCode").append(html);
			return flag;
		}
	});
}else{
	//先把表体部分清空
	$("#showCode").empty();
	html = '<span style="color: red">验证码不能为空</span>';
	$("#showCode").append(html);
    flag = false;
    codeFlag=false;
    return flag;
}
}

function submit() {
	if(applyName() &&applyCall()&&applyMoney()&&applyDeadline()&&applyLocation()&& codeFlag){
		$("#submitBtn").removeAttr("disabled");//将按钮可用
	}
}
