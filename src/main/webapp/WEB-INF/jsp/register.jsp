<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../jsp/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" contect="zh-CN">
<meta http-equiv="windows-Target" contect="_top">
<!--强制页面在当前窗口中以独立页面显示，可以防止自己的网页被别人当作一个frame页调用-->
<title>爱购物,就上牛掰人生商城</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login/register.css">
<script language="JavaScript">
	function checkRegister() {
		var accountNumber = $("#accountNumber").val();
		var password = $("#password").val();
		var nickName = $("#nickName").val();
		var email = $("#email").val();
		if (isNotNull(accountNumber) && isNotNull(password)
				&& isNotNull(nickName) && isNotNull(email)) {
			if(!isEmail(email)){
				alert("邮箱格式不和法！");
				return ;
			}
			document.forms[0].submit();
		} else {
			alert("请填写完整的信息！");
		}

	}
</script>
</head>
<body>
	<div class="form">
		<form action="<%=request.getContextPath()%>/toRegister" method="post">
			<label class="psw">用户名：<input type="text"
				name="accountNumber" id="accountNumber" maxlength="10"></label>
			<label class="psw">密&nbsp;&nbsp;&nbsp;码：<input type="text"
				name="passWord" id="password" maxlength="15"></label> 
			<label
				class="psw">昵&nbsp;&nbsp;&nbsp;称：<input type="text"
				name="nickName" id="nickName" maxlength="8"></label> 
			<label
				class="psw">邮&nbsp;&nbsp;&nbsp;箱：<input type="text"
				name="email" id="email" maxlength="30"></label>
			<button onclick="return checkRegister()">注 册</button>
		</form>
	</div>
</body>
</html>