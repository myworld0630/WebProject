<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	這是 sitemesh 測試頁面 ，補件 sitemesh 的步驟如下<br />
	1. 除原本必須的 struts jar 檔外，需在 lib 中引入 (1)struts2-sitemesh-plugin-2.2.3.1.jar 及(2)sitemesh-2.4.2.jar <br /><br />
	2. 修改 /WEB-INF/web.xml 加入 (1)struts-cleanup 及 (2) sitemesh 兩個過濾器	<br />
	         特別注意過濾器在檔案中的出現順序為 (1)struts-cleanup 及 (2) sitemesh (3)struts2	<br /><br />
	3. 在 /WEB-INF 資料夾底下加入 decorators.xml 以及 sitemesh.xml	<br />
	   (a) decorators.xml 描述公版的資料夾及檔案的位置	<br />
	   (b) sitemesh.xml 描述 decorators.xml 在檔案中的位置	<br /><br />
	4. 新增模板資訊，這個範例將所有需要用到的模板資訊放在 /WebContent/sitemesh 資料夾中，檔案說明如下:	<br />
	   (a) layout.jsp : sitemesh 的公版，這個公版的資料夾及檔案資訊會出現在 decorators.xml	<br />
	   (b) header.jsp : 測試用，放到公版的 head 標籤裡面	<br />
	   (c) navigation.jsp : 測試用，放到公版的 navigation 標籤裡面	<br />
	   (d) pagefooter.jsp : 測試用，放到公版的 footer 標籤裡面	<br />
	   (e) HelloSiteMesh.jsp : 測試用，放到公版的 body 標籤裡面	<br />
	   (f) skin.css : layout 所套用的 css 檔案	<br /><br />
	5. 將這段網址貼到網址列即可測試 : http://localhost:8080/WebProject/HelloSiteMesh.action	<br />
	         並比較與 http://localhost:8080/WebProject/sitemesh/HelloSiteMesh.action 結果的差異<br /><br />
	6. 為了達成以上測試的目的，所以需要修改 struts.xml 的內容，加入查詢 HelloSiteMesh 的 struts 相關設定
	
</body>

</html>