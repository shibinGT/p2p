$.validator.setDefaults({
	submitHandler: function() {
		form.submit();
	}
});
$().ready(function() {
			// 在键盘按下并释放及提交后验证提交表单
			$("#auth-addForm").validate({
					rules: {

						authCode: {
							required: true

						},
						authDesc: {
							required: true

						},
						resource: {
							required: true

						},
						sort: {
							required: true,
							digits:true
						},
						authType: {
							required: true

						}
					},
					messages: {

						authCode: {
							required: "请输入权限名"

						},
						authDesc: {
							required: "请输入描述"

						},
						resource: {
							required: "请输入资源"

						},
						sort: {
							required: "请输入排序",
								digits:"请输入正整数"
						},
						authType: {
							required: "请选择类型"

						}
					}
					});

	});