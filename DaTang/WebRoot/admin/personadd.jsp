<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建用户</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
  	<script type="text/javascript">
  		function formSubmit(){
  			var result = true;
  			var reg =/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
  			var confirmPassword = $("#confirmPassword").val().trim();
	  		var password = $("#password").val().trim();
	  		$("input").each(function () {
	  			if($(this).val()==""){
	  				alert("请将所有信息完善之后再提交！");
	  				result = false;
	  				return false;
	  			}
	  		});
	  			
	  		if(!result){
	  			return false;
	  		}
	  		
	  		if($("#select ").val() == "--请选择角色--"){
	  			alert("请为添加的员工选择角色");
	  			return false;
	  		}
	  		
	  		if(password.length<3 || password.length>6){
	  			alert("密码长度必须为3-6位");
	  			return false;
	  		}
	  		
	  		if(confirmPassword!=password){
	  			alert("密码必须是3-6位 且 两次密码必须一致！");
	  			return false;
	  		}
	  	}
  		$(document).ready(function(){
  			$("#employeeName").blur(function(){
  				$(this).nextAll().remove();
  				var employeeName = $(this).val().trim();
  				if(employeeName==""){
  					$(this).after("<span class='error' style='color: red;size: 3px'>用户名不能为空</span>");
  				}
			});
			
			$("#realName").blur(function(){
				$(this).nextAll().remove();
  				var realName = $(this).val().trim();
  				if(realName==""){
  					$(this).after("<span class='error' style='color: red;size: 3px'>真实姓名不能为空</span>");
  				}
			});
  				
  				$("#birthDay").blur(function(){
	  				$(this).nextAll().remove();
	  				var birthDay = $(this).val().trim();
	  				if(birthDay==""){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>出生日期不能为空</span>");
	  				}
	  			});
  				
  				$("#duty").blur(function(){
	  				$(this).nextAll().remove();
	  				var duty = $(this).val().trim();
	  				if(duty==""){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>职位信息不能为空</span>");
	  				}
	  			});
  				
  				$("#endrolldDate").blur(function(){
  					$(this).nextAll().remove();
	  				var endrolldDate = $(this).val().trim();
	  				if(endrolldDate==""){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>入职时间不能为空</span>");
	  				}
	  			});
	  			
	  			$("#experience").blur(function(){
	  				$(this).nextAll().remove();
	  				var experience = $(this).val().trim();
	  				if(experience==""){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>行业经验不能为空</span>");
	  				}
	  			});
	  			
	  			$("#password").blur(function(){
	  				$(this).nextAll().remove();
	  				var password = $(this).val().trim();
	  				if(password.length<3 || password.length>6){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>密码长度必须为3-6位</span>");
	  				}
	  			});
	  			
	  			$("#confirmPassword").blur(function(){
	  				$(this).nextAll().remove();
	  				var confirmPassword = $(this).val().trim();
	  				var password = $("#password").val().trim();
	  				if(confirmPassword!=password){
	  					$(this).after("<span class='error' style='color: red;size: 3px'>两次密码必须一致</span>");
	  				}
	  			});
        });
  	</script>
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<div align="center">
<div id="logo"><img src="${pageContext.request.contextPath }/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left3.lbi" -->
<div id="left2">
      <p><a href="selectEmpLoyeeByPage.do" target="_self" >用户管理</a></p>
      <p><a href="empadminQuery.do" target="_self">员工管理</a></p>
      <p><a href="queryPersonForPage.do" target="_self">分配人员</a></p>
      <p><a href="input_login.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 添加人员 &gt;&gt; 人员详细信息</p>
        <h1>人员详细信息:</h1>
	  
	  <form id="employeeAdd" action="addPerson.do" method="post" onsubmit="return formSubmit()">
          <p>
							用户名称： <input id="employeeName" name="employeeName" type="text" size="16" />
						</p>
						<p>
							真实姓名： <input id="realName"  name="realName" type="text" size="16" />
						</p>
						<p>
							性&nbsp;&nbsp;&nbsp; 别： <input name="sex" type="radio"
								value="男" checked="checked" /> 男 <input type="radio"
								name="sex" value="女" /> 女
						</p>
						<p>
							出生年月(yyyy-MM-dd)： <input id="birthDay"  name="birthDay" type="text"
								size="16" />
						</p>
						<p>
							职位信息： <input id="duty"  name="duty" type="text" size="16" />
						</p>
						<p>
							入职时间： <input id="endrolldDate"  name="endrolldDate"  type="text" size="16" />
						</p>
						<p>
							学历信息： <select name="education" size="1">
								<option value="小学">小学</option>
								<option value="初中">初中</option>
								<option value="高中">高中</option>
								<option value="大专">大专</option>
								<option value="大学">大学</option>
								<option value="硕士">硕士</option>
								<option value="博士">博士</option>
								<option value="博士后">博士后</option> 
							</select> <span class="marginleft">专业信息：</span> <select name="major"
								size="1">
								<option value="市场营销">市场营销</option>
								<option value="金融管理">金融管理</option>
								<option value="会计">会计</option>
							</select>
						</p>
						<p>
							行业经验： <label> <textarea id="experience"  name="experience" cols="44"></textarea>
							</label>
						</p>
						<p>
							所属角色： 
							<label> 
								<select id="select" name="roleId">
									<option>--请选择角色--</option>
									<c:forEach items="${allAddRoles}" var="role">
										<option value="${role.roleId}">${role.roleName}</option>
									</c:forEach>
								</select>
							</label>
						</p>
						<p>
							初始密码： <input id="password"  name="password" type="password" size="16"  maxlength="6" />
						</p>
						<p>
							确认密码： <input id="confirmPassword"  name="confirmPassword" type="password" size="16"  maxlength="6" />
						</p>
						<p>&nbsp;</p>
						<p>

							<input id="submit"  name="Submit" type="reset"  value="重置" />

							&nbsp; <input name="Submit2" type="submit"  
								value="提交" />
						</p>
      </form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</div>
</body>
</html>
