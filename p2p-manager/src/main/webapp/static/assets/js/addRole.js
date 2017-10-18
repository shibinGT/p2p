// 注册与登录将的切换的方法
function show_box(id) {
	jQuery('.widget-box.visible').removeClass('visible');
	jQuery('#' + id).addClass('visible');
}
// 输入框获得焦点的时候隐藏错误警告
$("form input").focus(function() {
	$(this).siblings("span[id*='rrors']").hide();
})

// 注册按钮是否可使用的判断变量
var nameTrue = false;
var pswTrue = false;
var psw2True = false;
var agreeTrue = false;

// 判断是否是去注册页面，而非登录页面
if ('${isRegister }' == 'true') {
	show_box('signup-box');
}

// 判断不为空的方法
$(function() {
	function inputOnblur(id, spanId) {
		if (/^\s*$/g.test($('#' + id).val())) {
			$('#' + spanId).show();
			$('#' + spanId).text("不能为空");
		} else {
			return true;
		}

	}
	// 校验用户名
	$("#inputCode").blur(function() {// 事件
		var element = document.getElementById("inputCode");
		var spanElement = document.getElementById("codeErrors");
		
		if (/^\s*$/g.test(element.value)) {
			$('#codeErrors').show();
			spanElement.innerText = "不能为空";
		} 
	});
	
	
	
	// 校验用户名
	$("#inputDesc").blur(function() {// 事件
		var element = document.getElementById("inputDesc");
		var spanElement = document.getElementById("descErrors");
		if (/^\s*$/g.test(element.value)) {
			$('#descErrors').show();
			spanElement.innerText = "不能为空";
		}
	});
	
	
	

	// 检验是否勾选同意
	$('#agreeCheckbox').mouseleave(function() {
		if ($("#agreeCheckbox").is(":checked")) {
			agreeTrue = true;
		} else {
			agreeTrue = false;
		}
		registerTrue();
	});

	
	
	

	
});
