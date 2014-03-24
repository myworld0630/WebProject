<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hello Struts</title>
	
	<!-- 引入 jquery -->
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
	<script language="javascript">
		function query(){
			$("#form0").attr("action","index.action").submit();
		}
	</script>
</head>
<body>
	Hello Struts
	
	<form id="form0" name="form0" method="POST">
	</form>
	<input type="button" value="Test" onclick="query()" class="input_button">
	
</body>
</html>