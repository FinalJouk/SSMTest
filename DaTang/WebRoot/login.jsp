<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="commons/mytaglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录页面</title>
<style type="text/css">
.login {
	color: #5E5E5E;
	height: 185px;
	text-align: left;
	line-height: 10px;
	padding: 0px 0px 0 800px;
}

.button {
	width: 150px;
	height: 30px;
}
</style>
</head>

<body>
<div align="center">
<div id="logo"><img src="images/logo.jpg" alt="大唐电信首页" width="1002" height="392" /></div>
<div class="login" id="middle">
	<spf:form modelAttribute="loyee"  action="myLogin.do" method="post" name="form001">
    <table>
    	<tr>
    		<td>用户名：</td>
    		<td><spf:input path="employeeName" /></td>
    		<td><spf:errors path="employeeName" cssStyle="color:red"/></td>
    	</tr>
    	<tr></tr>
    	<tr>
    		<td>密 码：</td>
    		<td> <spf:password path="password" /></td>
    		<td><spf:errors path="password" cssStyle="color:red;size:2px"/></td>
    	</tr>
    	<tr></tr>
    	<tr>
    		<td>角 色：</td>
    		<td> 
    		<select name="admin">
        		<option value="manager" selected="selected">主管</option>
        		<option value="admin">系统管理员</option>
        		<option value="employees">员工</option>
      		</select>
      		</td>
      		<td></td>
    	</tr>
    	<tr>
    		<td colspan="3">
    			<input name="" type="submit" class="menu1" value="提交" align="left"/>
    		</td>
    	</tr>
    </table>
	</spf:form>
</div>
<div id="nutton"><img src="images/button.jpg" width="1002" height="17" /></div>
</div>
</body>
</html>
