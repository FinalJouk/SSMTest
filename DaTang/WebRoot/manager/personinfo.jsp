<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>人员详细信息</title>
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
        <p>您现在的位置 &gt;&gt; 查看人员 &gt;&gt; 人员详细信息</p>
        <h1>人员详细信息:</h1>
        <form id="form1" name="form1" method="post" action="selectAllPerson.do">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">姓名</td>
              <td>${loyee.employeeName}</td>
            </tr>
            <tr>
              <td class="tdcolor">性别</td>
              <td>${loyee.sex}</td>
            </tr>
			<tr>
              <td class="tdcolor">入职时间</td>
              <td><fmt:formatDate value="${loyee.endrolldDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
			<tr>
			  <td class="tdcolor">职位</td>
			  <td>${loyee.duty}</td>
		    </tr>
			<tr>
			  <td class="tdcolor">出生年月</td>
			  <td><fmt:formatDate value="${loyee.birthDay}" pattern="yyyy-MM-dd"/></td>
		    </tr>
			<tr>
			  <td class="tdcolor">学历</td>
			  <td>${loyee.education}</td>
		    </tr>
			<tr>
			  <td class="tdcolor">专业</td>
			  <td>${loyee.major}</td>
		    </tr>
			<tr>
			  <td class="tdcolor">行业经验</td>
			  <td>${loyee.experience}</td>
		    </tr>
          </table>
    <p>
              <label>
              <input name="Submit" type="submit" class="menu4" value="返回" />
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
