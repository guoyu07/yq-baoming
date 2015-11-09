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
      <p align="center"><form action="?status=1" method="post">操作密码: <input type="password" name="opPass" size="20" value="${opPass}" />搜索用户名或订购人或身份证号码或姓名<input type="text" name="suser" size="20" value="${suser}" />
      <select name="sheng"  id="sheng">
                      <option <c:if test="${empty sheng }">selected= "selected"</c:if> value="">==不限制省份==</option>
		<s:iterator var="data" value="provinceList">
		                      <option value="${data.b}"  <c:if test="${data.b==sheng}">selected= "selected"</c:if>>${data.b}</option>
		</s:iterator>
                    </select>
        <select name="upvip"  id="upvip">
                      <option selected="selected" value="0">==不限制所属vip==</option>
                      <option value="1" <c:if test="${upvip==1}">selected= "selected"</c:if>>赵利明（北京）</option>
                      <option value="2" <c:if test="${upvip==2}">selected= "selected"</c:if>>赵杰（山西朔州）</option>
                      <option value="3" <c:if test="${upvip==3}">selected= "selected"</c:if>>郭银霞（山西大同）</option>
                      <option value="4" <c:if test="${upvip==4}">selected= "selected"</c:if>>刘美君（山东青岛）</option>
                      <option value="5" <c:if test="${upvip==5}">selected= "selected"</c:if>>李昆原（山东青岛）</option>
                      <option value="6" <c:if test="${upvip==6}">selected= "selected"</c:if>>李永利（山东德州）</option>
                      <option value="7" <c:if test="${upvip==7}">selected= "selected"</c:if>>祁敬哲（辽宁）</option>
                      <option value="8" <c:if test="${upvip==8}">selected= "selected"</c:if>>黄志成（福建）</option>
                      <option value="9" <c:if test="${upvip==9}">selected= "selected"</c:if>>齐爱绿（浙江温州）</option>
                      <option value="10" <c:if test="${upvip==10}">selected= "selected"</c:if>>董丽芬（浙江杭州）</option>
                      <option value="11" <c:if test="${upvip==11}">selected= "selected"</c:if>>刘昱君（河北唐山）</option>
                      <option value="12" <c:if test="${upvip==12}">selected= "selected"</c:if>>马京敏（石家庄）</option>
                      <option value="13" <c:if test="${upvip==13}">selected= "selected"</c:if>>李展开（广东）</option>
                      <option value="14" <c:if test="${upvip==14}">selected= "selected"</c:if>>张意社（上海）</option>
                      <option value="15" <c:if test="${upvip==15}">selected= "selected"</c:if>>吴成勤（内蒙古）</option>
                      <option value="16" <c:if test="${upvip==16}">selected= "selected"</c:if>>总部（未指定）</option>
                    </select>            
                    <input type="submit" name="b12" size="20" value="提交" /></form></p></td> 
  </tr> 
   
 
  <tr> 
    <td width="100%" style="border-left: 0px solid #E5EAC2; border-right: 0px solid #E5EAC2; border-bottom: 0px solid #E5EAC2" height="117"><br> 

<div align="center">
            
          <table border="1" cellspacing="0" width="100%" bordercolor="#FFFFFF" style="border-collapse: collapse" cellpadding="0">
            <tr> 
                
              <td  align="center" height="28" bgcolor="#C3DAF9"> 
				<strong><font face="Arial">序号</font></strong></td>
              <td  align="center" height="28" bgcolor="#C3DAF9"> 
				<strong>用户名</strong></td>
              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <div align="center"><b>姓名</b></div>
                </td>
              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>性别</b></td>
              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>身份证</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>地区</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>手机</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>服码</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>鞋码</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>订购人</b></td>
                 <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>所属vip</b></td>
                              <td  align="center" height="28" bgcolor="#C3DAF9"> 
                <b>提交时间</b></td>
              </tr>
              <s:iterator var="data" value="dataList">
              <tr> 
                <td valign="middle" height="23" align="center"> 
                  <p><font color="#000000" size="2">${data.id} 
                </font> 
                </td>
                <td valign="middle"  align="center"> 
                  <p><font color="#000000" size="2"> 
                	${data.userName}</font></td>
                	                <td valign="middle"  align="center"> 
                  <p><font color="#000000" size="2"> 
                	${data.name}</font></td>
                <td valign="middle" align="center" > 
                  <div align="center"><font color="#000000" size="2"><c:if test="${data.sex==1 }">男</c:if> <c:if test="${data.sex==2 }">女</c:if></font></div>
                </td>
                <td valign="middle" align="center"> 
                  <font size="2">　${data.idCard}</font></td>
                <td valign="middle" align="center" > 
                  <font color="#000000" size="2">
					${data.sheng}${data.shi}${data.qu}</font></td>
					<td valign="middle" align="center"> 
                  <font color="#000000" size="2">
					${data.phone}</font></td><td valign="middle" align="center"> 
                  <font color="#000000" size="2">
					${data.clothSize}</font></td><td valign="middle" align="center"> 
                  <font color="#000000" size="2">
					${data.shoesSize}</font></td><td valign="middle" align="center"> 
                  <font color="#000000" size="2">
					${data.orderName}</font></td>
					<td valign="middle" align="center"> 
                  <font color="#000000" size="2">
				  <c:if test="${data.upvip==1}">赵利明（北京）</c:if>
				  <c:if test="${data.upvip==2}">赵杰（山西朔州）</c:if>
				  <c:if test="${data.upvip==3}">郭银霞（山西大同）</c:if>
				  <c:if test="${data.upvip==4}">刘美君（山东青岛）</c:if>
				  <c:if test="${data.upvip==5}">李昆原（山东青岛）</c:if>
				  <c:if test="${data.upvip==6}">李永利（山东德州）</c:if>
				  <c:if test="${data.upvip==7}">祁敬哲（辽宁）</c:if>
				  <c:if test="${data.upvip==8}">黄志成（福建）</c:if>
				  <c:if test="${data.upvip==9}">齐爱绿（浙江温州）</c:if>
				  <c:if test="${data.upvip==10}">董丽芬（浙江杭州）</c:if>
				  <c:if test="${data.upvip==11}">刘昱君（河北唐山）</c:if>
				  <c:if test="${data.upvip==12}">马京敏（石家庄）</c:if>
				  <c:if test="${data.upvip==13}">李展开（广东）</c:if>
				  <c:if test="${data.upvip==14}">张意社（上海）</c:if>
				  <c:if test="${data.upvip==15}">吴成勤（内蒙古）</c:if>
				  <c:if test="${data.upvip==16}">总部（未指定）</c:if>
				  </font></td>
					<td valign="middle" align="center"> 
                  <font color="#000000" size="2">
					${data.time}</font></td>
             </s:iterator></table> 
</div> <aldtags:pageTag paraStr="opPass,${opPass},suser,${suser},status,1,sheng,${sheng},upvip,${upvip}"/>
<p>　</td> 
  </tr> 
</table> 
</div> 
</body> 
</html>