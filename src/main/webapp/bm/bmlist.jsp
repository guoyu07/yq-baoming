<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${erroCodeNum==1}"><script language=javascript>alert('操作密码不正确！');history.go(-1);</script></c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>报名列表查询</title>
<meta name="GENERATOR" content="Microsoft FrontPage 6.0">
<LINK 
href="adminstyle.css" type=text/css rel=StyleSheet>
</head>
<SCRIPT>
<!--
function openwindow(url) {
   window.open(url,'new','toolbar=no,scrollbars=yes,width=200,height=120');
    }
//-->
</SCRIPT>


<body bgcolor="#DDECFE" topmargin="5" leftmargin="5">
<div align="center">

  <table border="1" width="100%" style="border-collapse: collapse" bordercolor="#006699" cellpadding="0" height="143">
    <tr>
      <td width="100%" height="26" bgcolor="#C3DAF9"> 
      <p align="center"><form action="?status=1" method="post">操作密码: <input type="password" name="opPass" size="20" value="${opPass}" />搜索用户名 或订购人姓名<input type="text" name="suser" size="20" value="${suser}" /><input type="submit" name="b12" size="20" value="提交" /></form></p></td> 
  </tr> 
   
 
  <tr> 
    <td width="100%" style="border-left: 0px solid #E5EAC2; border-right: 0px solid #E5EAC2; border-bottom: 0px solid #E5EAC2" height="117"><br> 

<div align="center">
            
          <table border="1" cellspacing="0" width="100%" bordercolor="#FFFFFF" style="border-collapse: collapse" cellpadding="0">
            <tr> 
                
              <td width="84" align="center" height="28" bgcolor="#C3DAF9"> 
				<strong><font face="Arial">序号</font></strong></td>
              <td width="100" align="center" height="28" bgcolor="#C3DAF9"> 
				<strong>用户名</strong></td>
              <td width="402" align="center" height="28" bgcolor="#C3DAF9"> 
                <div align="center"><b>姓名</b></div>
                </td>
              <td width="266" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>性别</b></td>
              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>身份证</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>地区</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>手机</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>服码</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>鞋码</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>订购人</b></td>
                              <td width="274" align="center" height="28" bgcolor="#C3DAF9"> 
                <b>提交时间</b></td>
              </tr>
              <s:iterator var="data" value="dataList">
              <tr> 
                <td valign="middle" height="23" width="84" align="center"> 
                  <p><font color="#000000" size="2">${data.id} 
                </font> 
                </td>
                <td valign="middle" width="100" align="center"> 
                  <p><font color="#000000" size="2"> 
                	${data.userName}</font></td>
                	                <td valign="middle" width="100" align="center"> 
                  <p><font color="#000000" size="2"> 
                	${data.name}</font></td>
                <td valign="middle" align="center" width="402"> 
                  <div align="center"><font color="#000000" size="2"><c:if test="${data.sex==1 }">男</c:if> <c:if test="${data.sex==2 }">女</c:if></font></div>
                </td>
                <td valign="middle" align="center" width="266"> 
                  <font size="2">　${data.idCard}</font></td>
                <td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.sheng}${data.shi}${data.qu}</font></td>
					<td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.phone}</font></td><td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.clothSize}</font></td><td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.shoesSize}</font></td><td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.orderName}</font></td><td valign="middle" align="center" width="274"> 
                  <font color="#000000" size="2">
					${data.time}</font></td>
             </s:iterator></table> 
</div> <aldtags:pageTag para1="opPass" value1="${opPass}" para2="suser" value2="${suser}" para3="status" value3="1"/>
<p>　</td> 
  </tr> 
</table> 
</div> 
</body> 
</html>