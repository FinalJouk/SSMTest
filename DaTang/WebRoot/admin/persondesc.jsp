<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分配人员</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function formSubmit(){
		var name = $("#employeeId").html();
		var parentName = $("#select option:selected").text();
		if(parentName=="--请选择--"){
			alert("请选择分配的主管");
			return false;
		}
		if(!confirm("是否确定将员工  "+name+"  分配给主管  "+parentName+"  ？")){
			return false;
		}
	}
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
      <p ><a href="input_login.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 分配人员</p>
        <h1>用户详细信息:</h1>
		<form id="form0" name="form1" method="post" action="updateParentById.do" onsubmit="return formSubmit()">
        <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
          <tr>
            <td class="tdcolor">用户名称</td>
            <td id="employeeId">${person.employeeName}</td>
          </tr>
          <tr>
            <td width="15%" class="tdcolor">真实姓名</td>
            <td>${person.realName}</td>
          </tr>
          <tr>
            <td class="tdcolor">行业角色</td>
            <td>${person.role.roleName}</td>
          </tr>
          <tr>
            <td class="tdcolor">性&nbsp;&nbsp;&nbsp; 别</td>
            <td>${person.sex}</td>
          </tr>
          <tr>
            <td class="tdcolor">入职时间</td>
            <td><fmt:formatDate value="${person.endrolldDate}" pattern="yyyy-MM-dd"/></td>
          </tr>
          <tr>
            <td class="tdcolor">职位信息</td>
            <td>${person.duty}</td>
          </tr>
          <tr>
            <td class="tdcolor">出生年月</td>
            <td><fmt:formatDate value="${person.birthDay}" pattern="yyyy-MM-dd"/></td>
          </tr>
          <tr>
            <td class="tdcolor">学历信息</td>
            <td>${person.education}</td>
          </tr>
          <tr>
            <td class="tdcolor">专业信息</td>
            <td>${person.major}</td>
          </tr>
          <tr>
            <td class="tdcolor">行业经验</td>
            <td>${person.experience}</td>
          </tr>
          <tr>
            <td class="tdcolor">上级主管</td>
            <td><label>
             	<select id="select" name="parent">
             	         <option>--请选择--</option>
             		<c:forEach items="${loyeeList}" var="loyee">
						<option value="${loyee.employeeId}">${loyee.employeeName}</option>
             		</c:forEach>
             	</select>
            </label></td>
          </tr>
        </table>
        <p>&nbsp;</p>
        <input  type="hidden" name="id" value="${person.employeeId}" />
          <p>
            <input name="Submit" type="reset"  value="取消" />
            <label>
            <input name="Submit2" type="submit"  value="提交" />
            </label>
          </p>
      </form>
    </div></td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
	</div>
</body>
</html>
