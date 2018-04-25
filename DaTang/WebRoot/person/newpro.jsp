<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新建计划</title>
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
        <p>您现在的位置 &gt;&gt; 计划管理 &gt;&gt; 新建计划</p>
                <h1>输入新计划信息</h1>
        
          <form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/addPlanByTaskId.do">
          <p>计划名称：
            <label>
          <input name="planName" type="text" size="50" />
          </label></p>
          <p>计划描述：
            <label>
            <textarea name="planDesc"></textarea>
            </label>
          </p>
            <p>开始时间：
              <label>
                <input name="beginDate" type="text" size="16" />
              </label>
             <span class="marginleft1">结束时间：
              <label>
                <input name="endDate" type="text" size="16" />
              </label></span>
          </p>
          <p>任务状态：
             未完成            </p>
          <p>是否反馈： 未反馈</p>
          	<div align="right"><label>
              <input name="Submit" type="reset"  value="重置" />
              </label>
           &nbsp; 
              <label>
              <input name="Submit2" type="submit"  value="提交" />
              </label></div>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</div>
</body>
</html>
