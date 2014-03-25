<%@ page  contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Hello MultiLanguage</title>
</head>
<body>
	<s:include value="/locale/LocaleSelector.jsp"/>
    <h2><s:text name="locale.HelloLocale"/></h2>
    <h2><s:property value="%{getText('locale.HelloLocale')}"/></h2>
</body>
</html>