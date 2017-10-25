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
	$("#inputName").blur(function() {// 事件
		var element = document.getElementById("inputName");
		var spanElement = document.getElementById("rNameErrors");
		$('#rNameErrors').show();
		if (/^\s*$/g.test(element.value)) {
			spanElement.innerText = "不能为空";
		} else {
			$.get(ctx+"/user/checkServlet"/* 发送到的url */, {value : $("#inputName").val()
			}/* 传过去的参数json */, function(tip) {
				if (tip == 1) {
					$('#rNameErrors').text("该用户名可用");
					nameTrue = true;
				} else {
					$('#rNameErrors').text("该用户名已被注册");
					nameTrue = false;
				}
				registerTrue();

			}/* 后台返回来的处理方法，tip为变量名，接收到的为String */);
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

	// 校验密码
	$("#inputPassword").blur(function() {// 事件
		if (inputOnblur('inputPassword', 'rPasswordErrors')) {
			if ($(this).val().length < 6 || $(this).val().length > 12) {
				$('#rPasswordErrors').show();
				$('#rPasswordErrors').text("密码长度必须在6-12位间");
				pswTrue = false;
			} else {
				pswTrue = true;
			}

		} else {
			pswTrue = false;
		}
		;
		registerTrue();
	});
	// 再次校验密码
	$("#inputPassword2")
			.blur(
					function() {// 事件
						inputOnblur('inputPassword2', 'rPassword2Errors');
						if ($("#inputPassword").val() != $("#inputPassword2")
								.val()) {
							document.getElementById('rPassword2Errors').innerText = "两次输入的密码不一致";
							psw2True = false;
						} else {
							psw2True = true;
						}
						registerTrue();
					});
	// 检验是否符合提交条件
	function registerTrue() {
		if (nameTrue && psw2True && pswTrue && agreeTrue) {
			$('#registerSubmit').removeAttr("disabled");
		} else {
			$('#registerSubmit').attr("disabled", "disabled");
		}
	}
	;
	// 提交注册
	$('#registerSubmit').click(function() {
		// md5 对密码进行加密24次
		var password = $("#inputPassword").val();
		for (var i = 0; i < 24; i++) {
			password = hex_md5(password);
		}
		$("#inputPassword").val(password);
		$("#inputPassword2").val(password);
		$("#registerForm").submit();
	});

	// 提交登录
	$('#loginSubmint').click(function() {
		// md5 对密码进行加密24次
		var password2 = $("#employeePassword").val();
		for (var i = 0; i < 24; i++) {
			password2 = hex_md5(password2);
		}
		$("#employeePassword").val(password2);
		$("#loginForm").submit();
	});
	//回车密码输入框，触发登录的点击事件
	$("#employeePassword").keyup(function(event){
	  if(event.keyCode ==13){
	    $('#loginSubmint').trigger("click");
	  }
	});

});
