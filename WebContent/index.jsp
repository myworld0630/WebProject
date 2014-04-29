<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hello Struts</title>
	
	<!-- 導入 jquery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/cdjcv.js"></script>
	<script language="javascript">
		
		$(function(){
			trackLineEventInit();
			hellojsonajax();
		});
	
		// function query 單純用來測試第一個 Struts 範例
		function query(){
	
			$("#form0").attr("action","index.action").submit();
		}
		
		// function transfer  頁面跳轉帶參數範例
		function middleware(){
	
			$("#form0").attr("action","middleware.action").submit();
		}
		
		//function queryReport 用來測試 Jasper Report 以及 ChartDirector
		function queryReport(actionType){
			
			if(actionType =="query")
				$("#form0").attr("action", "query.action").submit();
			else if(actionType =="excel")
				$("#form0").attr("action", "excel.action").submit();
			else if(actionType =="pdf")
				$("#form0").attr("action", "pdf.action").submit();
			else if(actionType =="chart")
				$("#form1").attr("action", "chart.action").submit();
			else if(actionType =="windrosechart")
				$("#form2").attr("action", "windrosechart.action").submit();
		}		
		
		function trackLineEventInit(){
			console.log("trackLineEventInit 1");
			JsChartViewer.addEventListener(window, 'load', function() {
				var viewer = JsChartViewer.get('chart1');
				if(viewer != null){
					console.log("trackLineEventInit 2");
					viewer.attachHandler("MouseMovePlotArea", function(e) {
				        trackLineLabel(viewer, viewer.getPlotAreaMouseX());
				        viewer.setAutoHide("all", "MouseOutPlotArea");
				    });
				}
			});
		}
		
		function trackLineLabel(viewer, mouseX) {
			// Remove all previously drawn tracking object
			viewer.hideObj("all");

			// The chart and its plot area
			var c = viewer.getChart();
			var plotArea = c.getPlotArea();

			// Get the data x-value that is nearest to the mouse, and find its pixel coordinate.
			var xValue = c.getNearestXValue(mouseX);
			var xCoor = c.getXCoor(xValue);
			
			// Draw a vertical track line at the x-position
			viewer.drawVLine("trackLine", xCoor, plotArea.getTopY(), plotArea.getBottomY(), "black 1px solid");

			//Draw a label on the x-axis to show the track line position
			//viewer.showTextBox("xAxisLabel", xCoor, plotArea.getBottomY() + 4, JsChartViewer.Top, c.xAxis().getFormattedLabel(xValue, ""),"font:bold 11px Arial;color:#FFFFFF;background-color:#000000;padding:0px 3px");
			
			// Iterate through all layers to draw the data labels
			for ( var i = 0; i < c.getLayerCount(); ++i) {
				var layer = c.getLayerByZ(i);

				// The data array index of the x-value
				var xIndex = layer.getXIndexOf(xValue);

				// Iterate through all the data sets in the layer
				for ( var j = 0; j < layer.getDataSetCount(); ++j) {
					var dataSet = layer.getDataSetByZ(j);

					// Get the color and position of the data label
					var color = dataSet.getDataColor();
					var yCoor = c.getYCoor(dataSet.getPosition(xIndex), dataSet.getUseYAxis());
					// Draw a track dot with a label next to it for visible data points in the plot area
					if ((yCoor != null) && (yCoor >= plotArea.getTopY()) && (yCoor <= plotArea.getBottomY()) && (color != null)) {
						viewer.showTextBox("dataPoint" + i + "_" + j, xCoor, yCoor, JsChartViewer.Center, viewer.htmlRect(7, 7, color));
						viewer.showTextBox("dataLabel" + i + "_" + j, xCoor + 5, yCoor, JsChartViewer.Left, dataSet.getValue(xIndex).toFixed(2),
								"padding:0px 3px;font:bold 10px Arial;background-color:" + color + ";color:#FFFFFF");
					}
				}
			}
		}
		
		//用來測試  Json Asynchrony 非同步處理機制
		function hellojsonajax(){		
			
			//console.info("[execute] hellojsonajax");
			$.ajax({
				type:"POST", 
				url: "HelloJsonAJAX.action",
				data:{"myCurrent.id": "testString" }, //前端透過 POST 傳遞到後端的參數，要記得 myCurrent 對應的是後端變數的名稱，不是物件的型態!!
				dataType: "json",
				async: true, //預設就是 true，表示要以非同步的方式進行
				success: function(pData){
					var tAry = eval("(" + pData + ")"); //eval() 將 JSON 字串轉換成 JavaScript 可以處理的物件 
					//console.info(tAry.myList); // 觀察轉換後 tAry 的物件內容
					populateDropdownKeyValue($("#dropdownlist"),tAry.myList);
				},
				error : function(){
					//console.info("false");
				}
			});
		}
		
		//動態把內容填入下拉式選單，為了配合 Json 測試而撰寫
		function populateDropdownKeyValue(select, data) {
			if(select !=null || typeof select!="undefined"){
				select.empty();
				$.each(data, function(id, option) {
					select.append($('<option></option>\n').val(option.key).html(option.value));
				});
			}
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
	xwork-core-2.2.3.1.jar<br /><br />
	<form id="form0" name="form0" method="POST">
		<s:select list="{'hello angus','hello alex'}" theme="simple" name="value1"></s:select> <!-- select name 傳到後端可以 -->
		<s:set name="value2" value='hello'/> <!-- select name 卻不行，詭異 -->
	</form>
	<input type="button" value="Test" onclick="query()" class="input_button"><br />
	<input type="button" value="網頁及Action參數傳遞測試" onclick="middleware()" class="input_button"><br />
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
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br />
	下面的範例是用來測試 ChartDirector 報表的設定 <br /><br />
	1. ChartDirector 與 struts 較無關聯，只要導入 ChartDirector.jar 檔即可使用 <br />
	2. 在 WebContent 底下加入 getchart.jsp	<br />
	3. 有了以上兩個檔案就可以在網頁上產生圖檔，為了能夠進一步在前端對圖表進行操作，在 WebContent/js 下加入  cdjcv.js 檔案	<br />
	4. 在 src 資料夾底下建立 web.struts.chartdirector Package， 並在裡面建立處理圖表 ChartDirector Action 所對應的 HelloChartDirector.java Class	<br />
	        為了方便產生圖檔，導入 ReportUtil.java，ReportUtil 依賴 StringUtil.java，故一併導入StringUtil.java<br />
	5. 在 HelloChartDirector.java 中透過下列三個步驟，即可製作一張圖片:
	   (1)透過  ReportUtil 產生一張 ChartDirector 圖片物件
	   (2)透過 WebChartViewer 物件，設定圖片路徑及圖片類型等資訊
	   (3)將 WebChartViewer 物件透過 renderHTML 方法轉換成 String 物件，前端透過 &lt;s:property value="angusRenderTest" escapeHtml="false" /&gt; 取得字串物件即可呈現  <br />
	                後端 angusRenderTest 字串物件對應前端 struts property value <br />
	6. 修改 struts.xml，建立 HelloChartDirector Action，並完成相關設定，在 index.jsp 中建立一個按鈕，透過此按鈕 Demo HelloChartDirector
	7. 在前端建立 trackLineEventInit() 及 trackLineLabel() Jquery 方法，即可在圖表上產生 cursor	<br /><br />
	
	<form name="form1" id="form1" method="post">
	
	<fieldset class="fieldset_container">
		<s:if test="#request.imgHTML!=null" >
			<s:property value="imgHTML" escapeHtml="false" /> <!-- 加 escapeHtml="false" 圖才會出現-->
		</s:if>
		<br />
		<input type="button" value="圖表"  onclick="queryReport('chart')" class="input_button">
	</fieldset>
	</form>
	
	<br />
	新增風花圖測試:
	<br />
	
	<form name="form2" id="form2" method="post">
	
	<fieldset class="fieldset_container">
		<s:if test="#request.imgWindRoseChart!=null" >
			<s:property value="imgWindRoseChart" escapeHtml="false" /> <!-- 加 escapeHtml="false" 圖才會出現-->
		</s:if>
		<br />
		<input type="button" value="風花圖"  onclick="queryReport('windrosechart')" class="input_button">
	</fieldset>
	</form>
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br />
	下面的範例是用來測試導入 spring 套件的登入測試: <br /><br />
	1. 除原本 Struts 必要的 jar 檔外，尚需要加入與 Spring 相關的 jar 檔:	<br />
	   struts2-spring-plugin-2.2.3.1.jar	<br />
	   spring-web-3.0.0.RELEASE.jar	<br />
	   org.springframework.asm-3.0.2.RELEASE.jar	<br />
	   org.springframework.brans-3.0.2.RELEASE.jar	<br />
	   org.springframework.context-3.0.2.RELEASE.jar	<br />
	   org.springframework.core-3.0.2.RELEASE.jar	<br />
	   org.springframework.expression-3.0.2.RELEASE.jar	<br /><br />
	   
	2. 修改 /WEB-INF/web.xml，加入 	<br />
	   &lt;context-param&gt;	<br />
	   		&lt;param-name&gt;contextConfigLocation&lt;/param-name&gt;	<br />
	   		&lt;param-value&gt;/WEB-INF/applicationContext.xml&lt;/param-value&gt;	這行描述 spring 設定檔的檔名及位置<br />
       &lt;/context-param&gt;	<br />
       &lt;listener&gt;	<br />
       		&lt;listener-class&gt;	<br />
          		org.springframework.web.context.ContextLoaderListener	//ContextLoaderListener implements ServletContextListener<br />
       		&lt;/listener-class&gt;	<br />
       &lt;/listener&gt; <br /><br />
     
    3. 在 WEB-INF/ 下加入 applicationContext.xml 檔案，對應到 web.xml 對於 spring 設定檔檔名及位置的描述   <br />
	4. 修改 struts.mxl 加入 &lt;constant name="struts.objectFactory" value="spring"/&gt; <br />
	5. 以上為設定檔的配置，要測試尚需要:	<br />
	        新增 web.struts.spring.login Package，在其下加入 LoginAction.java，MyServer.java 及 MyServerImpl.java <br />
	   Spring 規範需先產生 Interface 介面 xxx.java，再由 Class xxxImpl.java 來 Instance 這個物件 <br /><br />
	6. 在WebContent下新增 login 資料夾，在裡面新增 welcome.jsp 及 error.jsp，在 index.jsp 中新增登入區塊及按鈕 <br />
	        指定按下按鈕後對應到 login Action，在 struts.xml 中新增 login Action 的描述，登入成功導向 welcome.jsp，失敗則導向 error.jsp <br /><br />
	
	<form id="login" action="login.action" method="post">
	<fieldset class="fieldset_container">
    	<table>
        	<caption>用戶登入</caption>
        	<tr>
            	<td>帳號：</td>
            	<td><input type="text" name="username"/></td>
        	</tr>
        	<tr>
            	<td>密碼：</td>
            	<td><input type="text" name="password"/></td>
        	</tr>
        	<tr>
            	<td><input value="登入" type="submit"/></td>
        	</tr>
    </table>
    </fieldset>
    </form>
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br />
	下面的範例說明 Struts JSON interceptor 的用途，主要是用來處理一些非同步(Asynchrony)網頁更新的案例: <br /><br />
	<select id='dropdownlist'></select> : 會延遲 5 秒取得內容的下拉式選單<br /><br />
	
	新增一個下拉式選單， id="dropdownlist"，利用 hellojsonajax javascript 函示，在函示裡面使用 jquery.ajax 方法進行網頁非同步處理，<br />
	hellojsonajax 中呼叫 HelloJsonAJAX.action，HelloJsonAJAX.action 需要依照 struts.xml 中定義呼叫後端的 HelloJSON Class 中的 <br />
	HelloJsonAJAX method，在 HelloJsonAJAX() 中故意使用 Thread.sleep(5000)延遲 5 秒回傳，讓 dropdownlist 的選單內容完 5 秒取得，如果改成
	同步方式取得選單內容(可將 jquery.ajax 中的 async 改為 false)，會發現整個網頁中的其他內容也會一起延遲 5 秒才能秀出來，這就是為什麼要使用<br />
	非同步寫法的原因，因為有時候僅是部分的內容延遲，所以只需要再針對局部的網頁內容更新即可，這也就是非同步寫法的精神，也就是 AJAX <br /><br />
	
	而 AJAX 前端與後端溝通則通常是使用 javascript 來處理，而後端的回傳值型態通常會使用 JSON 格式，JSON 也是一個 String 物件，前端取得 JSON String 後，<br />
	為了方便讓 JavaScript 處理，會使用 eval() 函式將 JSON String 拆解組合成 JavaScript 物件以方便使用<br /><br />
	
	而在 Struts2 中，可加入 struts-json-plugin.jar 檔進行整合，導入這個 lib 後，需要在 struts.xml 檔案中定義 JSON 的 result-types: <br />
 	&lt;result-types&gt;&lt;result-type name="json"   class="org.apache.struts2.json.JSONResult"/&gt; &lt;/result-types&gt;<br />
 	並且定義對於 JSON 各式的攔截器，詳情請看 struts.xml 中的定義 <br /><br />
	

</body>
</html>