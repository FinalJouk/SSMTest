<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询计划</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<div align="center">
<div id="logo"><img src="${pageContext.request.contextPath }/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left2.lbi" -->
<div id="left">
      <p><a href="queryAllTask.do" target="_self" >计划管理</a></p>
      <p><a href="inputSelectTask.do" target="_self">查询计划</a></p>
      <p><a href="queryAllTask.do" target="_self">我的任务</a></p>
      <p ><a href="input_login.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 查询计划 &gt;&gt; 查询</p>
        <form id="form1" name="form1" method="post" action="queryTaskAdv.do">
          <h1>查询信息:</h1>
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="579">任务一</td>
            </tr>
            <tr>
              <td class="tdcolor">所属任务</td>
              <td><select name="taskId">
                	<c:forEach items="${tasks}" var="task">
                		<option value="${task.taskId}">${task.taskName}</option>
                	</c:forEach>
                            </select></td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td>从
                <input name="beginDateBefore" type="text" size="15" />
              到
              <input name="beginDateAfter" type="text" size="15" />              </td>
            </tr>
            <tr>
              <td class="tdcolor">结束时间</td>
              <td>从
                <input name="endDateBefore" type="text" size="15" />
到
<input name="endDateAfter" type="text" size="15" /></td>
            </tr>
            <tr>
              <td class="tdcolor">是否反馈</td>
              <td>
              	<select name="isFeedback">
              		<option value="是">是</option>
              		<option value="否">否</option>
              	</select>
              </td>
            </tr>
          </table>
          <p>
            <input name="Submit" type="submit" class="menu3" value="查询计划" />
          </p>
		  
		  		  <h1>计划信息：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">所属任务</td>
              <td class="tdcolor">开始时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">计划状态</td>
              <td class="tdcolor">是否反馈</td>
            </tr>
            <c:forEach items="${pd.data}" var="plan">
	            <tr>
	              <td><a href="queryPlanById.do?id=${plan.planId}" target="_self">${plan.planName}</a></td>
	              <td>${superTask.taskName}</td>
	              <td>${plan.beginDate}</td>
	              <td>${plan.endDate}</td>
	              <td>${plan.status}</td>
	              <td><label>${plan.isFeedback}</label></td>
	            </tr>	
	            </c:forEach>
	            <tr>
            	<td colspan="6" align="center">
            		<a href="queryTaskAdv.do?pageNo=${pd.firstPage}&pageSize=${pd.pageSize}">首页</a>
      				<a href="queryTaskAdv.do?pageNo=${pd.previousPage}&pageSize=${pd.pageSize}">上一页</a>
					<a href="queryTaskAdv.do?pageNo=${pd.nextPage}&pageSize=${pd.pageSize}">下一页</a>
					<a href="queryTaskAdv.do?pageNo=${pd.lastPage}&pageSize=${pd.pageSize}">末页</a>
					<a>共${pd.totalRecords }条记录</a>
					<a>共${pd.lastPage }页</a>
					<a>第${pd.pageNo }页</a>
					<a>每页显示${pd.pageSize }条记录</a>
            	</td>
            </tr>
          </table>
        </form>
      </div>    </td>
  </tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->

</div></body>
</html>
