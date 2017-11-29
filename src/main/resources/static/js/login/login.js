var code; //在全局 定义验证码  
//验证码
function createCode() {
	  code = "";
	  var codeLength = 4;//验证码的长度  
	  var checkCode = document.getElementById("checkCode");
	  var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y');//所有候选组成验证码的字符，当然也可以用中文的  
	
	  for (var i = 0; i < codeLength; i++) {
	    var charIndex = Math.floor(Math.random() * selectChar.length);
	    code += selectChar[charIndex];
	  }
	 
	  if (checkCode) {
	    //checkCode.className = "code";
	    checkCode.value = code;
	  }

  	  var s=$("#errorMessageId").val();
	  if(s==""){
		  
	  }else{
		 $(".diagWrap").show();
		 $("#errorMessageId").val('');
	  }
}

function checked(){
	var cc=$("#user_name").val();
	if(''==cc){
		 $("#his").text('请输入用户名');
		 $(".diagWrap2").show();
		 return false;
	}
	
	var cc1=$("#password").val();
	if(''==cc1){
		 $("#his").text('请输入密码');
		 $(".diagWrap2").show();
		 return false;
	}
	
	var cc2=$("#yzm").val();
	if(''==cc2){
		 $("#his").text('请输入验证码');
		 $(".diagWrap2").show();
		 return false;
	}
	if(code==cc2.toUpperCase()){
		
		document.forms[0].submit();
	}else{
		$("#checkCode").val('');
		$("#yzm").val('');
		$("#his").text('验证码不正确');
		$(".diagWrap2").show();
		createCode();
	}
	return false;
}

function back(){
	$(".diagWrap").hide();
	$(".diagWrap2").hide();
}