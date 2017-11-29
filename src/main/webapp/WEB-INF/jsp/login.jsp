<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱购物,就上牛掰人生商城</title>

	<%-- <link rel="shortcut icon" href="${ctx}/images/index/favicon.ico" type="image/x-icon" />
	 --%><link rel="stylesheet" href="<%=request.getContextPath()%>/css/login/style.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/login.js"></script>
	<script language="JavaScript"> 
		if (window != top) 
		top.location.href = location.href; 
	</script>
</head>
<body onload="createCode()">
	<div class="form">
		<form  action="<%=request.getContextPath()%>/getLogin" method="post" > 
			<label class="user"><input type="text" name="accountNumber" id="user_name"  placeholder="请输入用户名"  autocomplete="off"></label>
			<label class="psw"><input type="password" name="passWord" id="password"  placeholder="请输入密码" autocomplete="off"></label>
	
			<label><input type="text"  id="yzm" placeholder="请输入验证码" class="code" autocomplete="off" maxlength="4" value=""/>
				   <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" />
			</label>
			
			<input type="hidden" value="${errorMessage}" id="errorMessageId"/>
			<button  name="" value="登 录" style="width:180px; height:30px;" onclick="return checked()">登 录</button>
		</form>
	</div>
<div class="diagWrap">
	<div class="diag">
		<div class="box">
			<h3 class="error">${errorMessage}</h3>
			<p><a class="btnOK" onclick="back()">确定</a></p>
		</div>
	</div>
</div>
<div class="diagWrap2">
	<div class="diag">
		<div class="box">
			<h3 class="error"><label id="his"></label></h3>
			<p><a class="btnOK" onclick="back()">确定</a></p>
		</div>
	</div>
</div>
</body>
</html>