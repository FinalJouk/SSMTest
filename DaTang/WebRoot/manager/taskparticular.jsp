<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>任务详细信息</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<div align="center">
<div id="logo"><img src="${pageContext.request.contextPath }/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left.lbi" --><div id="left">
				      <p><a href="queryAllTaskForManager.do" target="_self">查看任务</a></p>
				      <p><a href="inputAddTask.do" target="_self">制定任务</a></p>
				      <p><a href="inputTrimTask.do" target="_self">调整任务</a></p>
				      <p><a href="selectAllTaskByCondition.do" target="_self">跟踪任务</a></p>
				      <p><a href="selectAllPerson.do" target="_self">查看人员</a></p>
				      <p><a href="input_login.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 任务详细信息</p>
        <h1>任务详细信息:</h1>
        
        
		<form id="form1" name="form1" method="post" action="managerSelectPlanById.do">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="579" colspan="5">${task.taskName}</td>
            </tr>
            <tr>
              <td class="tdcolor">任务描述</td>
              <td colspan="5">${task.taskDesc}</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="15%"><fmt:formatDate value="${task.beginDate}" pattern="yyyy-MM-dd"/></td>
              <td width="20%" class="tdcolor">结束时间</td>
              <td width="50%" colspan="3"><p><fmt:formatDate value="${task.endDate}" pattern="yyyy-MM-dd"/></p></td>
            </tr>
            <tr>
              <td class="tdcolor">实际开始时间</td>
              <td><fmt:formatDate value="${task.realBeginDate}" pattern="yyyy-MM-dd"/></td>
              <td class="tdcolor">实际结束时间</td>
              <td colspan="3"><fmt:formatDate value="${task.realEndDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
              <td class="tdcolor">实施人</td>
              <td>${task.implementor.employeeName}</td>
              <td class="tdcolor">任务状态</td>
              <td>${task.status}</td>
              <td class="tdcolor">计划数目</td>
              <td>${task.planCount}</td>
            </tr>
        </table>
	    
		  <h1>实施计划：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">完成状态</td>
              <td width="20%" class="tdcolor">是否反馈</td>
              <td class="tdcolor">开始时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${pd.data}" var="plan">
	            <tr>
	              <td><a href="queryPlanById.do?id=${plan.planId}" target="_self">${plan.planName}</a></td>
	              <td>${plan.status}</td>
	              <td>${plan.isFeedback}</td>
	              <td>${plan.beginDate} </td>
	              <td>${plan.endDate}</td>
	              <td><input type="radio" name="planId" value="${plan.planId}" /></td>
	            </tr>	
	            </c:forEach>
	            <tr>
            	<td colspan="6" align="center">
            		<a href="managementTask.do?pageNo=${pd.firstPage}&pageSize=${pd.pageSize}">首页</a>
      				<a href="managementTask.do?pageNo=${pd.previousPage}&pageSize=${pd.pageSize}">上一页</a>
					<a href="managementTask.do?pageNo=${pd.nextPage}&pageSize=${pd.pageSize}">下一页</a>
					<a href="managementTask.do?pageNo=${pd.lastPage}&pageSize=${pd.pageSize}">末页</a>
					<a>共${pd.totalRecords }条记录</a>
					<a>共${pd.lastPage }页</a>
					<a>第${pd.pageNo }页</a>
					<a>每页显示${pd.pageSize }条记录</a>
            	</td>
            </tr>
          </table>
		  <p>
              <label>
              <input name="Submit" type="submit" class="menu3" value="详细信息" />
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
