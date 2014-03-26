<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@page contentType="text/html; charset=UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title><decorator:title default="Personal budget management system"/></title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    
    <!-- 為了解決上一個 commit 所遇到CSS無法套用的問題，將路徑修改為以下的寫法，struts 就能夠順利的解析 ，原本寫法會有問題，原寫法如下-->
    <!-- <link rel="stylesheet" type="text/css" href="/sitemesh/skin.css"/> -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sitemesh/skin.css" />
    <decorator:head/>
</head>

<body>
	<table id="page-container" cellpadding="0" cellspacing="0" border="1" >
	<tr>
		<td colspan="2" id="page-header" >
			<%@ include file="header.jsp"%>
		</td>
	</tr><tr>
		<td id="nav-container">
			<%@ include file="navigation.jsp" %>
		</td>
		<td id="content-container">
			<decorator:body/>
		</td>
	</tr><tr>
		<td colspan="2" id="page-footer">
			<%@ include file="pagefooter.jsp" %>
		</td>
	</tr></table>
</body>
</html>

