package web.struts.chartdirector;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.apache.struts2.StrutsStatics;

import ChartDirector.WebChartViewer;
import ChartDirector.XYChart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloChartDirector extends ActionSupport{

	private String imgHTML;
	
    public String execute() {
 
    	List<double[]> tChartInputs = new ArrayList<double[]>();
    	double[] a = {10,15,20,25,30};
    	double[] b = {15,20,30,20,15};
    	tChartInputs.add(a);
    	tChartInputs.add(b);
    	
    	String tLableX[] = {"1","2","3","4","5"};
    	String displayAry[] = {"number 1","number 2"};
    	
    	//1. 產生一張 ChartDirector 圖片 
    	XYChart myChart = ReportUtil.getXYChart("ChartDirector 測試", tLableX, "",tChartInputs, "縱軸單位", displayAry);
    	
    	//2. 生成 WebChartViewer 物件，設定圖片路徑及圖片類型等資訊
    	HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
    	WebChartViewer myViewer = new WebChartViewer(request, "chart1");
    	String myChartQuery = myChart.makeSession(myViewer.getRequest(),myViewer.getId());
    	myViewer.setImageUrl("getchart.jsp?" + myChartQuery);
    	myViewer.setChartModel(myChart.getJsChartModel());
    			
    	//3.將 WebChartViewer 物件透過 renderHTML 轉換成 String 物件，前端透過 <s:property value="angusRenderTest" escapeHtml="false" /> 取得圖片描述即可呈現
    	ActionContext tContext = ActionContext.getContext();
		HttpServletResponse tResponse = (HttpServletResponse)tContext.get(StrutsStatics.HTTP_RESPONSE); 
		tResponse.setCharacterEncoding("UTF-8");
    	imgHTML = myViewer.renderHTML(tResponse);
    	
        return SUCCESS;
    }

	public String getImgHTML() {
		return imgHTML;
	}

	public void setImgHTML(String imgHTML) {
		this.imgHTML = imgHTML;
	}
} 