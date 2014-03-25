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
	Hello Struts<br /><br />
	
	建立一個 Struts 專案，至少需要以下幾個 jar 檔:<br />
	asm-3.1.jar<br />
	asm-common-3.1.jar<br />
	asm-tree-3.1.jar<br />
	commons-fileupload-1.2.2.jar<br />
	commons-io-2.0.1.jar<br />
	commons-lang-2.5.jar<br />
	freemaker-2.3.16.jar<br />
	javassist-3.11.0.GA.jar<br />
	ognl-3.0.1.jar<br />
	struts2-core-2.2.3.1.jar<br />
	xwork-core-2.2.3.1.jar<br />
	
	
	<form id="form0" name="form0" method="POST">
	</form>
	<input type="button" value="Test" onclick="query()" class="input_button">
	
</body>
</html>