package web.struts.chartdirector;


import javax.servlet.http.*;

import org.apache.struts2.StrutsStatics;

import ChartDirector.Chart;
import ChartDirector.LegendBox;
import ChartDirector.PolarChart;
import ChartDirector.WebChartViewer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWindRoesChart extends ActionSupport{

	private String imgWindRoseChart;
	
    public String execute() {
 
    	// 1. 產生 Wind Rose Chart
    	
    	 // Data for the chart
        double[] data0 = {5, 3, 10, 4, 3, 5, 2, 5};
        double[] data1 = {12, 6, 17, 6, 7, 9, 4, 7};
        double[] data2 = {17, 7, 22, 7, 18, 13, 5, 11};

        double[] angles = {0, 45, 90, 135, 180, 225, 270, 315};
        String[] labels = {"North", "North\nEast", "East", "South\nEast", "South",
            "South\nWest", "West", "North\nWest"};

        // Create a PolarChart object of size 460 x 500 pixels, with a grey (e0e0e0)
        // background and a 1 pixel 3D border
        PolarChart myChart = new PolarChart(460, 500, 0xe0e0e0, 0x000000, 1);

        // Add a title to the chart at the top left corner using 15pts Arial Bold
        // Italic font. Use white text on deep blue background.
        myChart.addTitle("Wind Direction", "Arial Bold Italic", 15, 0xffffff
            ).setBackground(0x000080);

        LegendBox legendBox = myChart.addLegend(230, 35, false, "Arial Bold", 9);
        legendBox.setAlignment(Chart.TopCenter);
        legendBox.setBackground(Chart.Transparent, Chart.Transparent, 1);

        legendBox.addKey("5 m/s or above", 0xff3333);
        legendBox.addKey("1 - 5 m/s", 0x33ff33);
        legendBox.addKey("less than 1 m/s", 0x3333ff);

        // Set plot area center at (230, 280) with radius 180 pixels and white
        // background
        myChart.setPlotArea(230, 280, 180, 0xffffff);

        // Set the grid style to circular grid
        myChart.setGridStyle(false);

        // Set angular axis as 0 - 360, with a spoke every 30 units
        myChart.angularAxis().setLinearScale2(0, 360, labels);

        for (int i = 0; i < angles.length; ++i) {
            myChart.angularAxis().addZone(angles[i] - 10, angles[i] + 10, 0, data0[i],
                0x3333ff, 0);
            myChart.angularAxis().addZone(angles[i] - 10, angles[i] + 10, data0[i], data1[i
                ], 0x33ff33, 0);
            myChart.angularAxis().addZone(angles[i] - 10, angles[i] + 10, data1[i], data2[i
                ], 0xff3333, 0);
        }

        // Add an Transparent invisible layer to ensure the axis is auto-scaled using
        // the data
        myChart.addLineLayer(data2, Chart.Transparent);

        
        //2. 生成 WebChartViewer 物件，設定圖片路徑及圖片類型等資訊
    	HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
    	WebChartViewer myViewer = new WebChartViewer(request, "windrosechart");
    	String myChartQuery = myChart.makeSession(myViewer.getRequest(),myViewer.getId());
    	myViewer.setImageUrl("getchart.jsp?" + myChartQuery);
    	myViewer.setChartModel(myChart.getJsChartModel());
    	
    	
    	//3.將 WebChartViewer 物件透過 renderHTML 轉換成 String 物件，前端透過 <s:property value="angusRenderTest" escapeHtml="false" /> 取得圖片描述即可呈現
    	ActionContext tContext = ActionContext.getContext();
		HttpServletResponse tResponse = (HttpServletResponse)tContext.get(StrutsStatics.HTTP_RESPONSE); 
		tResponse.setCharacterEncoding("UTF-8");
		imgWindRoseChart = myViewer.renderHTML(tResponse);
    	
        return SUCCESS;
    }

	public String getImgWindRoseChart() {
		return imgWindRoseChart;
	}

	public void setImgWindRoseChart(String imgWindRoseChart) {
		this.imgWindRoseChart = imgWindRoseChart;
	}


} 