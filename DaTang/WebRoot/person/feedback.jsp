<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>反馈信息</title>
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
        <p>您现在的位置 &gt;&gt; 计划管理 &gt;&gt; 反馈信息</p>
        <form id="form1" name="form1" method="post" action="updatePlanById.do">
		<h1>输入反馈信息:</h1>
          
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="579" colspan="3">${plan.planName}</td>
            </tr>
            <tr>
              <td class="tdcolor">计划描述</td>
              <td colspan="3">${plan.planDesc}</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="579">${plan.beginDate}</td>
              <td width="579" class="tdcolor">结束时间</td>
              <td width="579"><p>${plan.endDate}</p>              </td>
            </tr>
            
            <tr>
              <td class="tdcolor">计划状态</td>
              <td colspan="3">
                  <select name="status">
                    <option value="未实施">未实施</option>
                    <option value="实施中">实施中</option>
                    <option value="已完成">已完成</option>
                  </select></td>
            </tr>
            <tr>
              <td class="tdcolor">是否反馈</td>
              <td colspan="3"><select name="isFeedback">
                <option value="否">未反馈</option>
                <option value="是">已反馈</option>
              </select></td>
            </tr>
            <tr>
              <td class="tdcolor">反馈信息</td>
              <td colspan="3"><label>
                <textarea name="feedbackInfo" cols="60" rows="4" >${plan.feedbackInfo}</textarea>
              </label></td>
            </tr>
        </table>
		<input type="hidden" name="planId" value="${plan.planId}"/>
		  <p>
              		<input name="Submit" type="reset" class="menu2" value="取消" />
					<input name="Submit" type="submit" class="menu1" value="提交" />
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath }/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</div>
</body>
</html>
