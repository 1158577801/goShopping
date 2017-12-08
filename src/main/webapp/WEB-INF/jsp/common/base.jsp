<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery-1.7.2.min.js"></script>
<c:set var="ctx" value="<%=request.getContextPath()%>"/>
<script type="text/javascript">
var ctx = "${ctx}";
function isNotNull( value){
	if(null!=value && ""!=value && "null"!=value && undefined!=value){
		return true;
	}else{
		return false;
	}
}
function isEmail(str){ 
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
	return reg.test(str); 
	} 
</script>
