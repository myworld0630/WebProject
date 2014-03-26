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
		
		// function query 單純用來測試第一個 Struts 範例
		function query(){
	
			$("#form0").attr("action","index.action").submit();
		}
		
		//function queryReport 用來測試 Jasper Report
		function queryReport(actionType){
			
			if(actionType =="query")
				$("#form0").attr("action", "query.action").submit();
			else if(actionType =="excel")
				$("#form0").attr("action", "excel.action").submit();
			else if(actionType =="pdf")
				$("#form0").attr("action", "pdf.action").submit();
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
	<input type="button" value="Test" onclick="query()" class="input_button"><br />
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br />
	下列的範例是用來測試 struts 後端多國語系的設定，在專案中加入下列檔案: <br /><br />
	1. 在 Java src 資料夾建立 web.struts.multilanguage Package，並在裡面建立 Locales Bean 物件，此物件回傳可供設定的語系 <br />
	2. 在 Java struts-config 資料夾建立 struts.properties，在裡面指定存取的 i18n 檔案路徑 struts.custom.i18n.resources=HelloLocale <br />
	        這個路徑會對應到 src 資料夾地下的 HelloLocale properties 檔案，注意名稱一定要對應 <br />
	3. 在 WebContent 中新增 locale 資料夾，在裡面建立 HelloLocale.jsp 以及 LocaleSelector.jsp 用來做後續的 Demo 使用 <br />
	4. 在 index.jsp 中新增一下程式碼，用到 Demo 多語系功能，在 LocaleSelector.jsp 中有一段程式碼如下: <br>
	   value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE" <br />
	        主要就是透過這段程式碼進行多語系的設定，因為設定在 Session 中，所以即使頁面轉換，Session 中的內容仍然不會改變，往後的頁面都能套用多語系的設定<br />
	5. 在 WebContent 中有新增 i18n 資料夾，用來存放多語系的檔案，將來希望能夠把多語系檔案都收納在這個資料夾，但根據季昌的說法，需要重新編譯 struts 原始碼才能達成，後續再進一步研究 <br /><br />        
	
	下面這段是用來測試多國語系所使用，不需要再額外的導入其它的 jar 檔　<br />
	如果今天網址只打http://localhost:4321/WebProject/，選擇語系後網址會變成 http://localhost:4321/WebProject/?request_locale=zh <br />
	因為網址後面只有 ?request_locale=zh，沒有呼叫到 action，所以並不會觸發 struts 內建 i18n 攔截器，所以功能不正常 <br />
	如果要能夠正常運作的話，需要再網址列鍵入 http://localhost:4321/WebProject/index.action，才不會有問題 <br />
	這也帶出了一個問題，當今天鍵入 http://localhost:4321/WebProject/，需要自動 redirect 到 http://localhost:4321/WebProject/index.action <br />
	後續仍需要完成自動跳轉這個部分!! <br />
	
	<s:include value="/locale/LocaleSelector.jsp"/>
	<h2><s:text name="locale.HelloLocale"/></h2>
	<h2><s:property value="%{getText('locale.HelloLocale')}"/></h2>
	<a href="http://localhost:4321/WebProject/locale/HelloLocale.action">測試跳轉 Session Locale 是否仍然有效</a>	<br /><br />
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br />
	下面的範例是用來測試 jasper report 報表的設定 <br /><br />
	1. 除原本 Struts 必要的 jar 檔外，尚需要加入與 Jasper 相關的 jar 檔:	<br />
	   struts2-jasperreport-plugin-2.2.3.1.jar	<br />
	   jasperreport-3.7.5.jar	<br />
	   iText-2.1.7.jar	<br />
	   iTextAsian.jar	<br />
	   commons-logging-1.1.1.jar	<br />
	   commons-collections-3.1.jar	<br />
	   commons-digester-2.0.jar	<br />
	2. 如果只要匯出 PDF 檔，上面的 jar 檔已經夠用，若要再匯出 EXCEL 檔案，需要再加入 POI.jar 檔	<br />
	   poi-3.7.jar	<br /><br />
	3. 修改 struts.xml，加入處理 Jasper Report 所需要的 Result Type <br />
	   &lt;aresult-typesa&gt;	<br />
	   		&lt;result-type name="jasper" class="org.apache.struts2.views.jasperreports.JasperReportsResult" /&gt;	<br />
	   &lt;/result-types&gt;
	4. 在 src 資料夾底下建立 web.struts.jasperreport Package，並在裡面建立處理 Jasper Action 所對應的 HelloJasper.java Class <br /><br />
	5. 在 struts.xml 中建立 HelloJasper Action，並完成相關設定，於網址列鍵入:	<br />
	   http://localhost:4321/WebProject/HelloJasper.action 驗證是否能夠成功下載 Jasper Report 所產生的檔案	<br /><br />
	6. 修改 index.jsp，建立一個表格，用來取得傳入 Jasper Report 中的 Bean 物件，並加入按鈕，有按鈕直接呼叫 Action，取得 Jasper Report 所產生的 EXCEL 及 PDE 檔案	<br />
	7. 最後使用 iReport 編輯 test.jrxml 的時候，要特別的注意不會重複的 Parameter 要貼齊 Column Head，會重複的 Field 要貼齊 Detail，不然表格會生成預期外的樣式	<br /><br />
	
	<form name="form0" id="form0" method="post">
	<fieldset class="fieldset_container">
		
		<s:if test="#request.queryList!=null" > <!-- && #request.list.queryList >0" > -->
		<table class="table_result" cellspacing="0" cellpadding="0" width="96%" align="center">
			<tr class="table_header">
				<td>測試字串1</td>
				<td>測試字串2</td>
				<td>測試字串3</td>
			</tr>
			<s:iterator value="queryList" status="stat">
			<tr class="table_content">
				<td><s:property value="testString1" /></td>
				<td><s:property value="testString2" /></td>
				<td><s:property value="testString3" /></td>
			</tr>
			</s:iterator>
			<tr class="table_footer">
				<td colspan="3"></td>
			</tr>
		</table>
		</s:if>
		
		<input type="button" value="查詢"  onclick="queryReport('query')" 	class="input_button">
		<input type="button" value="EXCEL" onclick="queryReport('excel')"   class="input_button">
		<input type="button" value="PDF"   onclick="queryReport('pdf')"     class="input_button">
		
	</fieldset>
	</form>
	
	
</body>
</html>