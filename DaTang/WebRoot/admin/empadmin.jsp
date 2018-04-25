<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spf"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function formSubmit(){
		var rad= $('input:radio[name="radio"]:checked');
        if(rad.val()==null){
        	alert("请选择要删除的员工");
            return false;
        }else{
            var name = rad.parent().prev().prev().prev().prev().prev().prev().html();
            if(name=="admin"){
            	alert("无法删除管理员！");
            	return false;
            }
            if(!confirm("是否确认删除员工："+name+"？")){
            	return false;
            }
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
        <p>您现在的位置 &gt;&gt; 员工管理 &gt;&gt; 员工列表</p>
        <h1>用户详细信息:</h1>
	  
	    <form id="form1" name="form1" method="post" action="deleteEmpLoyee.do" onsubmit="return formSubmit()">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">用户名称</td>
              <td class="tdcolor">用户密码</td>
              <td class="tdcolor">用户角色</td>
              <td class="tdcolor">真实姓名</td>
              <td class="tdcolor">入职时间</td>
              <td class="tdcolor">职位信息</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${pd.data}" var="empLoyee">
            <tr>
              <td>${empLoyee.employeeName}</td>
              <td>${empLoyee.password}</td>
              <td>${empLoyee.role.roleName}</td>
              <td>${empLoyee.realName}</td>
              <td><fmt:formatDate value="${empLoyee.endrolldDate}" pattern="yyyy-MM-dd"/></td>
              <td>${empLoyee.duty}</td>
              <td>
                <input type="radio" name="radio" value="${empLoyee.employeeId}" />
              </td>
            </tr>
            </c:forEach>
            <tr>
            	<td colspan="8" align="center">
            		<a href="empadminQuery.do?pageNo=${pd.firstPage}&pageSize=${pd.pageSize}">首页</a>
      				<a href="empadminQuery.do?pageNo=${pd.previousPage}&pageSize=${pd.pageSize}">上一页</a>
					<a href="empadminQuery.do?pageNo=${pd.nextPage}&pageSize=${pd.pageSize}">下一页</a>
					<a href="empadminQuery.do?pageNo=${pd.lastPage}&pageSize=${pd.pageSize}">末页</a>
					<a>共${pd.totalRecords }条记录</a>
					<a>共${pd.lastPage }页</a>
					<a>第${pd.pageNo }页</a>
					<a>每页显示${pd.pageSize }条记录</a>
            	</td>
            </tr>
          </table>
	      <p>
            <label>
            <input name="Submit" type="submit" class="menu3" value="删除人员" />
            </label>
            <label></label>
	      </p>
        </form>
	    <p>&nbsp;</p>
</div></td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</div>
</body>
</html>
