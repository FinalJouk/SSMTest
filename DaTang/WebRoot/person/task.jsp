<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>我的任务</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function formSubmit(){
		var val=$("input:radio[name='id']:checked").val();
		if(val==null){
			alert("请选择查看的任务");
			return false;
		}
	}
</script>
</head>

<body>
<div align="center">
<div id="logo"><img src="${pageContext.request.contextPath }/images/top.jpg" width="1002" height="258" /></div>
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg">
<div id="left">
      <p><a href="queryAllTask.do" target="_self" >计划管理</a></p>
      <p><a href="inputSelectTask.do" target="_self">查询计划</a></p>
      <p><a href="queryAllTask.do" target="_self">我的任务</a></p>
      <p ><a href="input_login.do" target="_self">退出系统</a></p>
</div><div id="right">
        <p>您现在的位置 &gt;&gt; 我的任务 &gt;&gt; 任务信息</p>
        <h1>任务信息:</h1>
        <form id="form1" name="form1" method="post" action="managementTask.do" onsubmit="return formSubmit()">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="15%" class="tdcolor">制定人</td>
              <td width="15%" class="tdcolor">开始时间</td>
              <td width="15%" class="tdcolor">结束时间</td>
              <td width="15%" class="tdcolor">任务状态</td>
              <td width="15%" class="tdcolor">计划数目</td>
              <td width="10%" class="tdcolor">&nbsp;</td>
            </tr>
             <c:forEach items="${pd.data}" var="task">
            <tr>
              <td>${task.taskName}</td>
              <td>${task.assigner.employeeName}</td>
              <td><fmt:formatDate value="${task.beginDate}" pattern="yyyy-MM-dd"/></td>
              <td><fmt:formatDate value="${task.endDate}" pattern="yyyy-MM-dd"/></td>
              <td>${task.status}</td>
              <td>${task.planCount}</td>
              <td><label>
                <input type="radio" name="id" value="${task.taskId}" />
              </label></td>
            </tr>
            </c:forEach>
            <tr>
            	<td colspan="8" align="center">
            		<a href="queryAllTask.do?pageNo=${pd.firstPage}&pageSize=${pd.pageSize}">首页</a>
      				<a href="queryAllTask.do?pageNo=${pd.previousPage}&pageSize=${pd.pageSize}">上一页</a>
					<a href="queryAllTask.do?pageNo=${pd.nextPage}&pageSize=${pd.pageSize}">下一页</a>
					<a href="queryAllTask.do?pageNo=${pd.lastPage}&pageSize=${pd.pageSize}">末页</a>
					<a>共${pd.totalRecords }条记录</a>
					<a>共${pd.lastPage }页</a>
					<a>第${pd.pageNo }页</a>
					<a>每页显示${pd.pageSize }条记录</a>
            	</td>
            </tr>
          </table>
    <p>
              <label>
              <input name="Submit" type="submit" class="menu3" value="计划管理" />
            </label>
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</div>
</body>
</html>
