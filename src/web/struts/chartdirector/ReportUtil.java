package web.struts.chartdirector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ChartDirector.ArrayMath;
import ChartDirector.Axis;
import ChartDirector.Chart;
import ChartDirector.LegendBox;
import ChartDirector.LineLayer;
import ChartDirector.PieChart;
import ChartDirector.XYChart;

//import com.chttl.ienc.bean.Interval;
//import com.chttl.ienc.portal.action.LoginAction;
//import com.chttl.ienc.portal.bean.reporting.ShrinkResult;
//import com.chttl.ienc.portal.bean.reporting.chart.ChartSetting;
//import com.chttl.ienc.portal.bean.reporting.fill.ReportItemAdapter;

/**
 * 取得 ChartDirector 的 Chart
 * 
 * @author Jichang
 */
public class ReportUtil {

//	public static final int INIT_WIDTH = (int) (1080 / 1.4); // 預設寬度
//	public static final int INIT_HEIGHT = (int) (INIT_WIDTH / 1.618); // 預設寬度

	private static final int COLOR_ARY[] = new int[] { 0x00B050, 0xFF0000, 0x0070C0, 0xE46C0A, 0x7030A0, 0x00B0F0, 0xFF7C80, 0xA6A6A6 };

	private static final int HEIGHT_TITLE = 24; // 標題的高度
	private static final int HEIGHT_ROW = 20; // 每一筆資料的高度
	private static final int ITMES_ROW = 1; // 每一行有幾筆資料

	private static final int LEGEND_START_X = 40; // 數列說明文字的起點位置
	private static final int LEGEND_START_Y = 0; // 數列說明文字的起點位置

	private static final int PLOTAREA_START_X = 45; // 左邊包含 刻度
	private static final int PLOTAREA_START_Y = 12; // 上面留白
	private static final int PLOTAREA_END_OFFSET_X = 20; // 右邊留白
	private static final int PLOTAREA_END_OFFSET_Y = 30; // 下面包含 單位
	
	private static final int Y_AXIS_WIDTH = 50; // y軸的寬度

	private static final String FONT_LEGEND = "msjh.ttf";
	private static final String FONT_TITLE = "微軟正黑體";

	public static final int SHRINK_DATA_SIZE = 100;
	public static final int SHRINK_MAX_LABEL_LENGTH = 150;
	
	public static final int AGGREGATE_BOUND = 1000; 

	/**
	 * 產生 XYChart
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null);
	//}
	
	/**
	 * 產生 XYChart
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param dashline
	 * 			     以虛線表示平均值及上下限
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, boolean dashline) {
		//return getXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, dashline);
	//}

	/**
	 * 匯出報表使用
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @return 圖表存放的URL
	 */
	//public static String getReportXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getReportXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null);
	//}

	/**
	 * 產生 XYChart
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param pChartSetting
	 *            可以設定一些報表的東西
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//return getXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true);
	//}

	/**
	 * 產生 XYChart
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param dashline
	 * 			     以虛線表示平均值及上下限
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean dashline) {
		//return getXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true, dashline);
	//}
	/**
	 * 匯出報表使用
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param pChartSetting
	 *            可以設定一些報表的東西
	 * @return 圖表存放的URL
	 */
	//public static String getReportXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//return getReportXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, false);
	//}

	/**
	 * 產生 XYChart
	 * 
	 * @param pWidth
	 *            圖的寬度
	 * @param pHeight
	 *            圖的高度
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @return XYChart
	 */
	//public static XYChart getXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, true);
	//}

	/**
	 * 匯出報表使用
	 * 
	 * @param pWidth
	 *            圖的寬度
	 * @param pHeight
	 *            圖的高度
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @return 圖表存放的URL
	 */
	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, boolean dashline) {
		//return getReportXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, dashline);
	//}
	
	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getReportXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, false);
	//}
	
	/**
	 * 產生 DynamicXYChart
	 * 
	 * @param pWidth
	 *            圖的寬度
	 * @param pHeight
	 *            圖的高度
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param pChartSetting
	 *            可以設定一些報表的東西
	 * @return XYChart
	 */
	//public static XYChart getDynamicXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, Double max, Double min) {

		//int pWidth = (int) (1080 / 1.4);
		//int pHeight = (int) ((int) (1080 / 1.4) / 1.618);
		
		//XYChart tXYChart = getDynamicXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true, max, min);
		//return tXYChart;
	//}
	
	//public static XYChart getDynamicXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {	
		//XYChart tXYChart = getDynamicXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, null, null);
		//return tXYChart;
	//}

	//public static XYChart getDynamicXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean show) {
		//XYChart tXYChart = getDynamicXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true, null, null);
		//return tXYChart;
	//}
	/*public static XYChart getDynamicXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean show, Double max, Double min) {
		XYChart tXYChart = initDynamicXYChart(pWidth, pHeight, pTitle, pUnitX, pData, pUnitY, 1, show);

		// 調整圖例文字長度
		String[] tAdjDataDesc = new String[pLegend.length];
		int tLength = 75;
		for (int i = 0; i < pLegend.length; i++) {
			tAdjDataDesc[i] = StringUtil.paddingRight(pLegend[i].trim(), tLength - pLegend[i].length() * 2, " ");
		}

		// 調整的時間軸
		Date[] tAdjTimeStamps = pTimeStamp;

		// 繪製每一條線
		drawLayer(pData, pInterval, tXYChart, tAdjDataDesc, tAdjTimeStamps, false);

		// 設定顯示格式
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);

		// 設定預設軸設定
		setDefaultAxis(pUnitX, pUnitY, tXYChart);

		if (pChartSetting != null) {
			pChartSetting.doChartSetting(tXYChart);
		} else {
			tXYChart.yAxis().setLabelFormat("{value}");
		}

		if(max != null && min != null){
			setReportScale(max, min, tXYChart);
		}
		return tXYChart;
	}*/
	/**
	 * 產生 XYChart
	 * 
	 * @param pWidth
	 *            圖的寬度
	 * @param pHeight
	 *            圖的高度
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param pChartSetting
	 *            可以設定一些報表的東西
	 * @return XYChart
	 */
	/*public static XYChart getXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean show, boolean dashline) {
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, pUnitY, show);

		// 調整圖例文字長度
		String[] tAdjDataDesc = getAdjDataDesc(pLegend);

		// 調整的時間軸
		Date[] tAdjTimeStamps = pTimeStamp;

		// 繪製每一條線
		drawLayer(pData, pInterval, tXYChart, tAdjDataDesc, tAdjTimeStamps, dashline);

		// 設定顯示格式
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);

		// 設定預設軸設定
		setDefaultAxis(pUnitX, pUnitY, tXYChart);

		// 因為有個奇怪的bug...
		if(pData.size() == 1 && pData.get(0).length > 0){
			setAxisScale(tXYChart.yAxis(), pData.get(0));
		}		
		
		if (pChartSetting != null) {
			pChartSetting.doChartSetting(tXYChart);
		} else {
			tXYChart.yAxis().setLabelFormat("{value}");
		}

		return tXYChart;
	}*/
	//public static XYChart getXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean show) {
		//return getXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY,  pLegend, pInterval, pChartSetting, show, false);		
	//}
	
	/**
	 * 產生 四Y軸 XYChart
	 */
	/*public static XYChart getMultipleAxesChart(int pWidth, int pHeight, String pTitle, Date[] pTimeStamp, String pUnitX, List<double[]> pData, String yUnit, String[] yTitle, Interval pInterval, boolean show){
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, yTitle[0], pData.size(), show);
		
		// 調整的時間軸
		Date[] tAdjTimeStamps = pTimeStamp;
		ArrayMath tArrayMath = new ArrayMath(tAdjTimeStamps);
		
		tXYChart.xAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);				
		tXYChart.xAxis().setDateScale(pInterval.getStartTime(), pInterval.getEndTime());
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);
		boolean aggregate = false;
		if (tAdjTimeStamps.length > AGGREGATE_BOUND) {			
			tArrayMath.selectRegularSpacing((tAdjTimeStamps.length) / 100);
			tAdjTimeStamps = tArrayMath.aggregate(tAdjTimeStamps, Chart.AggregateFirst);
			aggregate = true;
		} 
		
		if(pData.size() > 0 && yTitle.length > 0 ){
			tXYChart.yAxis().setTitle(yTitle[0] + yUnit);
			tXYChart.yAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
			LineLayer lineLayer = tXYChart.addLineLayer();
			lineLayer.setLineWidth(3);
			if (aggregate) 
				lineLayer.addDataSet(tArrayMath.aggregate(pData.get(0), Chart.AggregateAvg), COLOR_ARY[0], yTitle[0]);
			else 
				lineLayer.addDataSet(pData.get(0), COLOR_ARY[0], yTitle[0]);
			if(Configuration.getInstance().isChartSymbols())
				lineLayer.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			lineLayer.setXData(tAdjTimeStamps);
			lineLayer.setHTMLImageMap("", "", "title='{x|yyyy/mm/dd hh:nn}, " + yTitle[0] + "={value}'" );
			
			setAxisScale(tXYChart.yAxis(), pData.get(0));
		}
		if(pData.size() > 1 && yTitle.length > 1){
			tXYChart.yAxis2().setTitle(yTitle[1] + yUnit);
			tXYChart.yAxis2().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
			LineLayer lineLayer2 = tXYChart.addLineLayer();
			lineLayer2.setLineWidth(3);
			lineLayer2.setUseYAxis2();
			if (aggregate) 
				lineLayer2.addDataSet(tArrayMath.aggregate(pData.get(1), Chart.AggregateAvg), COLOR_ARY[1], yTitle[1]);
			else 
				lineLayer2.addDataSet(pData.get(1), COLOR_ARY[1], yTitle[1]);
			if(Configuration.getInstance().isChartSymbols())
				lineLayer2.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			lineLayer2.setXData(tAdjTimeStamps);
			lineLayer2.setHTMLImageMap("", "", "title='{x|yyyy/mm/dd hh:nn}, " + yTitle[1] + "={value}'");
			
			setAxisScale(tXYChart.yAxis2(), pData.get(1));
		}
		
		if(pData.size() > 2 && yTitle.length > 2 ){
			Axis leftAxis = tXYChart.addAxis(Chart.Left, 80);
			leftAxis.setTitle(yTitle[2] + yUnit);
			leftAxis.setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
			
			LineLayer lineLayer3 = tXYChart.addLineLayer();
			lineLayer3.setLineWidth(3);
			lineLayer3.setUseYAxis(leftAxis);
			if (aggregate) 
				lineLayer3.addDataSet(tArrayMath.aggregate(pData.get(2), Chart.AggregateAvg), COLOR_ARY[2], yTitle[2]);
			else 
				lineLayer3.addDataSet(pData.get(2), COLOR_ARY[2], yTitle[2]);
			
			if(Configuration.getInstance().isChartSymbols())
				lineLayer3.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			lineLayer3.setXData(tAdjTimeStamps);
			lineLayer3.setHTMLImageMap("", "", "title='{x|yyyy/mm/dd hh:nn}, " + yTitle[2] + "={value}'" );
			
			setAxisScale(leftAxis, pData.get(2));
		}
		if(pData.size() > 3 && yTitle.length > 3){
			Axis rightAxis = tXYChart.addAxis(Chart.Right, 80);
			rightAxis.setTitle(yTitle[3] + yUnit);
			rightAxis.setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);

			LineLayer lineLayer4 = tXYChart.addLineLayer();
			lineLayer4.setLineWidth(3);
			lineLayer4.setUseYAxis(rightAxis);
			if (aggregate) 
				lineLayer4.addDataSet(tArrayMath.aggregate(pData.get(3), Chart.AggregateAvg), COLOR_ARY[3], yTitle[3]);
			else 
				lineLayer4.addDataSet(pData.get(3), COLOR_ARY[3], yTitle[3]);
			if(Configuration.getInstance().isChartSymbols())
				lineLayer4.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			lineLayer4.setXData(tAdjTimeStamps);
			lineLayer4.setHTMLImageMap("", "", "title='{x|yyyy/mm/dd hh:nn}, " + yTitle[3] + "={value}'");
			
			setAxisScale(rightAxis, pData.get(3));
		}
		return tXYChart;
	}*/

	private static void setAxisScale(Axis pAxis, double[] values){
		// 修正數值相同但線條不是直線問題 2013-12-26 update by ycyeh
		double value = Chart.NoValue;
		for(double v: values){
			if(v != Chart.NoValue){
				value = v;
			}		
		}
		if(value == Chart.NoValue){
			return;
		}
			
		int max = (int)(value * 1.05);
		int min = (int)(value * 0.95);
		int scale = (int)(value * 0.025);
		boolean same = true;
		for(double v: values){
			if(v != Chart.NoValue && (v > (max - scale) || v < (min + scale))){
				same = false;
			}
		}
		if(same){
			pAxis.setLinearScale(min, max, scale);
		}
		
	}
	//public static XYChart getMultipleAxesChart(String pTitle, Date[] pTimeStamp, String pUnitX, List<double[]> pData, String yUnit, String[] yTitle, Interval pInterval){
		//int pWidth = (int) (1080 / 1.4);
		//int pHeight = (int) ((int) (1080 / 1.4) / 1.618);
		//return getMultipleAxesChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, yUnit, yTitle, pInterval, true);
	//}
	
	/**
	 * 產生 雙Y軸 XYChart
	 * 
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pData0
	 *            圖表上每一個點的資料
	 * @param pData1
	 *            圖表上每一個點的資料            
	 * @param xTitle
	 *            下方時間軸標題
	 * @param y1Title
	 *            左側標題
	 * @param y2Title
	 *            右側標題
	 * @return XYChart
	 */
	public static XYChart getDualYChart(int pWidth, int pHeight, String pTitle,  String[] pLabelX, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title, boolean show){
		XYChart tXYChart = initXYChart(pWidth, (int) ((int) (1080 / 1.4) / 1.618), pTitle, xTitle, Arrays.asList(pData0), y1Title, 2, show);
		LineLayer lineLayer = tXYChart.addLineLayer();
		LineLayer lineLayer2 = tXYChart.addLineLayer();
		lineLayer2.setUseYAxis2();
		
		lineLayer.addDataSet(pData0, COLOR_ARY[0], y1Title);
		lineLayer2.addDataSet(pData1, COLOR_ARY[1], y2Title);
		
		//if(Configuration.getInstance().isChartSymbols()){
			//lineLayer.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			//lineLayer2.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
		//}
		tXYChart.xAxis().setLabels(pLabelX);
		setDefaultAxis(xTitle, y1Title, y2Title, tXYChart);
		return tXYChart;
	}
	public static XYChart getDualYChart(String pTitle, String[] pLabelX, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title){
		int pWidth = (int) (1080 / 1.4);
		int pHeight = (int) ((int) (1080 / 1.4) / 1.618);
		return getDualYChart(pWidth, pHeight, pTitle, pLabelX, pData0, pData1, xTitle, y1Title, y2Title, true);
			
	}
	
	/*public static XYChart getDualYChart(int pWidth, int pHeight, String pTitle, Date[] pTimeStamp, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title, Interval pInterval, boolean show){
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, xTitle, Arrays.asList(pData0), y1Title, 2, show);
		
		// 調整的時間軸
		Date[] tAdjTimeStamps = pTimeStamp;
		
		LineLayer lineLayer = tXYChart.addLineLayer();
		LineLayer lineLayer2 = tXYChart.addLineLayer();
		lineLayer2.setUseYAxis2();
				
		if (tAdjTimeStamps.length > AGGREGATE_BOUND) {
			ArrayMath tArrayMath = new ArrayMath(tAdjTimeStamps);
			tArrayMath.selectRegularSpacing((tAdjTimeStamps.length) / 100);
			tAdjTimeStamps = tArrayMath.aggregate(tAdjTimeStamps, Chart.AggregateFirst);
			lineLayer.addDataSet(tArrayMath.aggregate(pData0, Chart.AggregateAvg), COLOR_ARY[0], y1Title);
			lineLayer2.addDataSet(tArrayMath.aggregate(pData1, Chart.AggregateAvg), COLOR_ARY[1], y2Title);
		} else {
			lineLayer.addDataSet(pData0, COLOR_ARY[0], y1Title);
			lineLayer2.addDataSet(pData1, COLOR_ARY[1], y2Title);
		}
		
		if(Configuration.getInstance().isChartSymbols()){
			lineLayer.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
			lineLayer2.getDataSet(0).setDataSymbol(Chart.GlassSphere2Shape, 8);
		}
		lineLayer.setXData(tAdjTimeStamps);
		lineLayer2.setXData(tAdjTimeStamps);
		tXYChart.xAxis().setDateScale(pInterval.getStartTime(), pInterval.getEndTime());

		// 設定顯示格式
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);		
		setDefaultAxis(xTitle, y1Title, y2Title, tXYChart);
		
		lineLayer.setHTMLImageMap("", "", "title='" + xTitle + "={x|yyyy/mm/dd hh:nn}, " + y1Title + "={value}'" );
		lineLayer2.setHTMLImageMap("", "", "title='" + xTitle + "={x|yyyy/mm/dd hh:nn}, " + y2Title + "={value}'");

		return tXYChart;	
	}*/
	//public static XYChart getDualYChart(String pTitle, Date[] pTimeStamp, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title, Interval pInterval){
		//int pWidth = (int) (1080 / 1.4);
		//int pHeight = (int) ((int) (1080 / 1.4) / 1.618);
		//return getDualYChart(pWidth, pHeight, pTitle, pTimeStamp, pData0, pData1, xTitle, y1Title, y2Title, pInterval, true);	
	//}
	
	//public static String getReportDualYChart(int pWidth, int pHeight, String pTitle, Date[] pTimeStamp, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title, Interval pInterval){
		//XYChart tXYChart = getDualYChart(pWidth, pHeight, pTitle, pTimeStamp, pData0, pData1, xTitle, y1Title, y2Title, pInterval, false);
		//return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	//}
	
	public static String getReportDualYChart(int pWidth, int pHeight, String pTitle, String[] pLabelX, double[] pData0, double[] pData1, String xTitle, String y1Title, String y2Title){
		XYChart tXYChart = getDualYChart(pWidth, pHeight, pTitle, pLabelX, pData0, pData1, xTitle, y1Title, y2Title, false);
		return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	}
	/**
	 * 設定預設軸設定
	 * 
	 * @param pUnitX
	 * @param pUnitY
	 * @param tXYChart
	 */
	private static void setDefaultAxis(String pUnitX, String pUnitY, XYChart tXYChart) {
		tXYChart.xAxis().setTitle(pUnitX);
		tXYChart.xAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
		tXYChart.yAxis().setTitle(pUnitY);
		tXYChart.yAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
	}

	private static void setDefaultAxis(String xTitle, String y1Title, String y2Title, XYChart tXYChart) {
		tXYChart.xAxis().setTitle(xTitle);
		tXYChart.xAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
		tXYChart.yAxis().setTitle(y1Title);
		tXYChart.yAxis().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
		tXYChart.yAxis2().setTitle(y2Title);
		tXYChart.yAxis2().setLabelStyle("Arial Bold", 10, Chart.TextColor, 0);
	}
	
	/**
	 * 設定Y軸上下限
	 * 
	 * @param pUnitX
	 * @param pUnitY
	 * @param tXYChart
	 */
	private static void setReportScale(Double max, Double min, XYChart tXYChart){
		tXYChart.yAxis().setLinearScale(min, max);
	}
	
	/**
	 * 繪製每一條線
	 * 
	 * @param pData
	 * @param pInterval
	 * @param tXYChart
	 * @param tAdjDataDesc
	 * @param tAdjTimeStamps
	 */
	/*private static void drawLayer(final List<double[]> pData, final Interval pInterval, XYChart tXYChart, String[] tAdjDataDesc, Date[] tAdjTimeStamps, boolean dashline) {
		LineLayer tLayer = tXYChart.addLineLayer();
		if (tAdjTimeStamps.length > AGGREGATE_BOUND) {
			ArrayMath tArrayMath = new ArrayMath(tAdjTimeStamps);
			tArrayMath.selectRegularSpacing((tAdjTimeStamps.length) / 100);
			tAdjTimeStamps = tArrayMath.aggregate(tAdjTimeStamps, Chart.AggregateFirst);
			for (int i = 0; i < pData.size(); i++) {
				//tLayer.addDataSet(tArrayMath.aggregate(pData.get(i), Chart.AggregateAvg), COLOR_ARY[i % 8], tAdjDataDesc[i]).setDataSymbol((i + 1), 8);
				// 圖表修改 : 漸層
				if(i > 0 && dashline){
					tLayer.addDataSet(tArrayMath.aggregate(pData.get(i), Chart.AggregateFirst), tXYChart.dashLineColor(COLOR_ARY[i % 8], Chart.DashLine), tAdjDataDesc[i]);					
				}else{
					tLayer.addDataSet(tArrayMath.aggregate(pData.get(i), Chart.AggregateFirst), COLOR_ARY[i % 8], tAdjDataDesc[i]);
				}
			}
		} else {
			for (int i = 0; i < pData.size(); i++) {
				//tLayer.addDataSet(pData.get(i), COLOR_ARY[i % 8], tAdjDataDesc[i]).setDataSymbol((i + 1), 8);
				// 圖表修改 : 漸層
				if(i > 0 && dashline){
					tLayer.addDataSet(pData.get(i), tXYChart.dashLineColor(COLOR_ARY[i % 8], Chart.DashLine), tAdjDataDesc[i]);					
				}else{
					tLayer.addDataSet(pData.get(i), COLOR_ARY[i % 8], tAdjDataDesc[i]);
				}
			}
		}
		if(Configuration.getInstance().isChartSymbols()){
			for (int i = 0; i < pData.size(); i++) {
				tLayer.getDataSet(i).setDataSymbol(Chart.GlassSphere2Shape, 8);
			}
		}
		tLayer.setLineWidth(3);
		tLayer.setXData(tAdjTimeStamps);
		tXYChart.xAxis().setDateScale(pInterval.getStartTime(), pInterval.getEndTime());
	}*/

	/**
	 * 圖的初始化
	 * 
	 * @param pWidth
	 * @param pHeight
	 * @param pTitle
	 * @param pUnitX
	 * @param pData
	 * @param pUnitY
	 * @return
	 */
	private static XYChart initXYChart(int pWidth, int pHeight, final String pTitle, String pUnitX, final List<double[]> pData, String pUnitY, boolean show){
		return initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, pUnitY, 1, show); 
	}
	
	/**
	 *  圖的初始化
	 * 
	 * @param pWidth
	 * @param pHeight
	 * @param pTitle
	 * @param pUnitX
	 * @param pData
	 * @param pUnitY
	 * @param yAxisCount 多Y軸
	 */
	private static XYChart initDynamicXYChart(int pWidth, int pHeight, final String pTitle, String pUnitX, final List<double[]> pData, String pUnitY, int yAxisCount, boolean show) {
		int tLineCount = (int) Math.ceil(((double) pData.size() / (double) ITMES_ROW) / 2); // 一共幾行
		// 目前是用簡單的方式判斷,應該考慮輸入字的長度
		XYChart tXYChart = null;
		
		if(show){
			tXYChart = new XYChart(pWidth, pHeight + HEIGHT_ROW * tLineCount , Chart.brushedSilverColor(), Chart.Transparent, 1);
		}else{			
			tXYChart = new XYChart(pWidth, pHeight + HEIGHT_ROW * tLineCount , 0xffffc0, 0x000000, 1);
		}
		
		
		// 設定預設字型
		tXYChart.setDefaultFonts("simsun.ttc", "simsun.ttc", "simsun.ttc", "simsun.ttc");
		// 外框是圓角
		tXYChart.setRoundedFrame();
		// 有陰影
		tXYChart.setDropShadow();

		// 圖例
		int tLegendStartX = LEGEND_START_X;
		int tLegendStartY = LEGEND_START_Y + HEIGHT_TITLE;
		// 圖表起始位置
		int tPlotAreaStartX = PLOTAREA_START_X + (StringUtil.isEmptyOrSpace(pUnitY) ? 0 : 20) + (yAxisCount >= 3 ? 75 : 0);
		int tPlotAreaStartY = PLOTAREA_START_Y + tLegendStartY + HEIGHT_ROW * tLineCount;
		// 折線圖的大小
		int pInnerWidth = pWidth - tPlotAreaStartX - PLOTAREA_END_OFFSET_X - (yAxisCount -1) * Y_AXIS_WIDTH;
		int pInnerHeight = pHeight - PLOTAREA_START_Y - tLegendStartY - PLOTAREA_END_OFFSET_Y - (StringUtil.isEmptyOrSpace(pUnitX) ? 0 : 20);

		// 標題 (標題文字,字型,大小,顏色)
		tXYChart.addTitle(pTitle, FONT_TITLE, 18, 0x000000);
		// 圖例的說明 (起始點X,起始點Y,是否垂直,字型,字型大小)
		tXYChart.addLegend2(tLegendStartX, tLegendStartY, 2, FONT_LEGEND + " Bold", 10).setBackground(Chart.Transparent, Chart.Transparent);
		// 折線圖位置 (起始點X,起始點Y,寬度,高度,背景顏色,第二背景顏色(水平交錯),邊界顏色,水平格線顏色,垂直格線顏色)

		// 圖表修改 : 漸層
		if(show){
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, Chart.brushedSilverColor(), -1, -1, 0xc0c0c0, -1);
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, -1, -1, Chart.Transparent, tXYChart.dashLineColor(0x444444, 0x000101), -1);
		}else{			
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, 0xffffff, -1, -1, 0xc0c0c0, -1);
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, -1, -1, Chart.Transparent, tXYChart.dashLineColor(0x444444, 0x000101), -1);
			tXYChart.setBackground(tXYChart.linearGradientColor(0, 0, 0, 100, 0x99ccff, 0xffffff),0x888888);
		}		
		return tXYChart;
	}
	
	/**
	 *  圖的初始化
	 * 
	 * @param pWidth
	 * @param pHeight
	 * @param pTitle
	 * @param pUnitX
	 * @param pData
	 * @param pUnitY
	 * @param yAxisCount 多Y軸
	 * @param show 是否為網頁顯示
	 * 
	 */
	private static XYChart initXYChart(int pWidth, int pHeight, final String pTitle, String pUnitX, final List<double[]> pData, String pUnitY, int yAxisCount, boolean show) {
		XYChart tXYChart = null;
		if(show){
			tXYChart = new XYChart(pWidth, pHeight, Chart.brushedSilverColor(), Chart.Transparent, 1);
		}else{			
			tXYChart = new XYChart(pWidth, pHeight, 0xffffc0, 0x000000, 1);
		}
		// 設定預設字型
		tXYChart.setDefaultFonts("simsun.ttc", "simsun.ttc", "simsun.ttc", "simsun.ttc");
		// 外框是圓角
		tXYChart.setRoundedFrame();
		// 有陰影
		tXYChart.setDropShadow();
		int tLineCount = (int) Math.ceil(((double) pData.size() / (double) ITMES_ROW)); // 一共幾行
																						// 目前是用簡單的方式判斷,應該考慮輸入字的長度
		// 圖例
		int tLegendStartX = LEGEND_START_X;
		int tLegendStartY = LEGEND_START_Y + HEIGHT_TITLE;
		// 圖表起始位置
		int tPlotAreaStartX = PLOTAREA_START_X + (StringUtil.isEmptyOrSpace(pUnitY) ? 0 : 20) + (yAxisCount >= 3 ? 75 : 0);
		int tPlotAreaStartY = PLOTAREA_START_Y + tLegendStartY + HEIGHT_ROW * tLineCount;
		// 折線圖的大小
		int pInnerWidth = pWidth - tPlotAreaStartX - PLOTAREA_END_OFFSET_X - (yAxisCount -1) * Y_AXIS_WIDTH;
		int pInnerHeight = pHeight - tPlotAreaStartY - PLOTAREA_END_OFFSET_Y - (StringUtil.isEmptyOrSpace(pUnitX) ? 0 : 20);

		// 標題 (標題文字,字型,大小,顏色)
		tXYChart.addTitle(pTitle, FONT_TITLE, 18, 0x000000);
		// 圖例的說明 (起始點X,起始點Y,是否垂直,字型,字型大小)		
		tXYChart.addLegend(tLegendStartX, tLegendStartY, false, FONT_LEGEND + " Bold", 10).setBackground(Chart.Transparent);
		// 折線圖位置 (起始點X,起始點Y,寬度,高度,背景顏色,第二背景顏色(水平交錯),邊界顏色,水平格線顏色,垂直格線顏色)
				
		// 圖表修改 : 漸層
		if(show){
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, Chart.brushedSilverColor(), -1, -1, 0xc0c0c0, -1);
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, -1, -1, Chart.Transparent, tXYChart.dashLineColor(0x444444, 0x000101), -1);
		}else{			
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, 0xffffff, -1, -1, 0xc0c0c0, -1);
			tXYChart.setPlotArea(tPlotAreaStartX, tPlotAreaStartY, pInnerWidth, pInnerHeight, -1, -1, Chart.Transparent, tXYChart.dashLineColor(0x444444, 0x000101), -1);
			tXYChart.setBackground(tXYChart.linearGradientColor(0, 0, 0, 100, 0x99ccff, 0xffffff),0x888888);
		}
		
		return tXYChart;
	}

	/**
	 * 匯出報表使用
	 * 
	 * @param pWidth
	 *            圖的寬度
	 * @param pHeight
	 *            圖的高度
	 * @param pTitle
	 *            報表名稱
	 * @param pTimeStamp
	 *            下方時間軸 new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            下方時間軸單位
	 * @param pData
	 *            圖表上每一個點的資料
	 * @param pUnitY
	 *            左側單位
	 * @param pLegend
	 *            每一條線的說明,圖例
	 * @param pInterval
	 *            取樣區間
	 * @param pChartSetting
	 *            可以設定一些報表的東西
	 * @return 圖表存放的URL
	 */

	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean dashline) {
		//XYChart tXYChart = getXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, false, dashline);
		//return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	//}
	
	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//XYChart tXYChart = getXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, false, false);
		//return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	//}
	
	//public static String getReportMultipleAxes(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//XYChart tXYChart = getMultipleAxesChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, false);
		//return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	//}
	
	//public static String getDynamicReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//XYChart tXYChart = getDynamicXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, false);
		//return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	//}

	/*private static void autoSetMultiFormat(Axis pXAxis, Interval pInterval) {
		try {
			long tDiff = ((pInterval.getEndTime().getTime() - pInterval.getStartTime().getTime()) / (1000 * 60 * 60 * 24)) + 1;
			if (tDiff <= 3) { // 日報表
				pXAxis.setMultiFormat(Chart.StartOfDayFilter(), "{value|hh:nn}", Chart.AllPassFilter(), "{value|hh:nn}");
				pXAxis.setLabelFormat("{value|hh:nn}");
			} else if (3 < tDiff && tDiff <= 8) { // 週報表
				pXAxis.setMultiFormat(Chart.StartOfWeekFilter(), "{value|mm/dd}", Chart.AllPassFilter(), "{value|mm/dd}");
				pXAxis.setLabelFormat("{value|mm/dd}");
			} else if (8 < tDiff && tDiff <= 32) { // 月報表
				pXAxis.setMultiFormat(Chart.StartOfMonthFilter(), "{value|mm/dd}", Chart.AllPassFilter(), "{value|mm/dd}");
				pXAxis.setLabelFormat("{value|mm/dd}");
			} else if (32 < tDiff && tDiff < 360) { // 年報表
				pXAxis.setMultiFormat(Chart.StartOfYearFilter(), "{value|yy/mm/dd}", Chart.AllPassFilter(), "{value|yy/mm/dd}");
				pXAxis.setLabelFormat("{value|yy/mm/dd}");
			} else { // 其他
				pXAxis.setMultiFormat(Chart.AllPassFilter(), "{value|yy/mm/dd}");
				pXAxis.setLabelFormat("{value|yy/mm/dd}");
			}
		} catch (Exception e) {
		}
	}*/

	/**
	 * 將每一個圖例說明文字調整成相同長度
	 * 
	 * @param pDataDesc
	 * @return
	 */
	private static String[] getAdjDataDesc(String[] pDataDesc) {
		String[] tOut = new String[pDataDesc.length];
		int tLength = 150;
		// for (String s : pDataDesc) {
		// tLength =
		// tLength>StringUtil.getChineseStrLength(s)?tLength:StringUtil.getChineseStrLength(s);
		// }
		for (int i = 0; i < pDataDesc.length; i++) {
			tOut[i] = StringUtil.paddingRight(pDataDesc[i].trim(), tLength, " ");
		}
		return tOut;
	}

	public static PieChart getPieChart(String pTitle, double[] totalUsage, String[] deviceNames) {
		
		return getPieChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 2.5), pTitle, totalUsage, deviceNames);
	}

	public static PieChart getPieChart(int pWidth, int pHeight, String pTitle, double[] totalUsage, String[] deviceNames) {
		int[] colors = {0x66aaee, 0xeebb22, 0xbbbbbb, 0x8844ff, 0xdd2222, 0x009900};
		int chartHeight = pHeight + (deviceNames.length  > 5 ? (deviceNames.length - 5) * 20 : 0);
		PieChart c = new PieChart(pWidth, chartHeight);
		c.setBackground(c.linearGradientColor(0, 0, 0, 100, Chart.brushedSilverColor(), Chart.Transparent), 0x888888);
		c.setRoundedFrame();
		c.setDropShadow();
		c.setExplode(0);
		c.addTitle(pTitle, FONT_LEGEND, 18).setMargin2(0, 0, 16, 0);
		//c.addTitle("<*block,valign=absmiddle*><*img=doc.png*> " + pTitle, FONT_LEGEND, 12, 0x000080).setBackground(0xa0c8ff, 0x000000, Chart.glassEffect());
		c.setPieSize((int)(pWidth / 5), chartHeight / 2, pWidth / 9);
		c.set3D(25);
		c.setData(totalUsage, deviceNames);
		c.setColors2(Chart.DataColor, colors);
		c.setSectorStyle(Chart.GlobalGradientShading);
		c.setLabelLayout(Chart.SideLayout, 35);
		c.setLabelFormat("{={sector}+1}");
		c.setLabelStyle(FONT_LEGEND, 10).setBackground(Chart.Transparent, 0x444444);

		LegendBox b = c.addLegend(pWidth * 3 / 7  , chartHeight / 2 , true, FONT_LEGEND, 8);
		b.setAlignment(Chart.Left);
		b.setBackground(Chart.Transparent, 0x444444);
		b.setRoundedCorners();
		b.setMargin(35);
		b.setKeySpacing(0, 5);
		b.setFontColor(0x000000);
		b.setKeyBorder(Chart.SameAsMainColor);
		b.setText("<*block,valign=top*>{={sector}+1}.<*advanceTo=22*><*block,width=" + pWidth/3 + "*>{label}" + "<*/*><*block,width=" + pWidth/15 + ",halign=right*>{percent}<*/*>%");
		return c;
	}

	public static String getPieChartForReport(int pWidth, int pHeight, String pTitle, double[] totalUsage, String[] deviceNames) {
		int[] colors = { 0xAA0000, 0xeebb22, 0xbbbbbb, 0x8844ff, 0xdd2222, 0x009900 };		
		int chartHeight = pHeight + (deviceNames.length  > 10 ? (deviceNames.length - 5) * 20 : 0);
		PieChart c = new PieChart(pWidth, chartHeight);
		c.setBackground(c.linearGradientColor(0, 0, 0, 100, 0x99ccff, 0xffffff), 0x888888);
		c.setRoundedFrame();
		c.setDropShadow();
		c.setExplode(0);
		c.addTitle("<*block,valign=absmiddle*><*img=doc.png*> " + pTitle, FONT_LEGEND, 10, 0x000080).setBackground(0xa0c8ff, 0x000000, Chart.glassEffect());
		c.setPieSize((int)(pWidth / 5), chartHeight / 2, pWidth / 8);
		c.set3D(12);
		c.setData(totalUsage, deviceNames);
		c.setColors2(Chart.DataColor, colors);
		c.setSectorStyle(Chart.GlobalGradientShading);
		c.setLabelLayout(Chart.SideLayout, 15);
		c.setLabelFormat("{={sector}+1}");
		c.setLabelStyle(FONT_LEGEND, 8).setBackground(Chart.Transparent, 0x444444);

		LegendBox b = c.addLegend(pWidth * 3 / 7  , chartHeight / 2 , true, FONT_LEGEND, 8);
		b.setAlignment(Chart.Left);
		b.setBackground(Chart.Transparent, 0x444444);
		b.setRoundedCorners();
		b.setMargin(16);
		b.setKeySpacing(0, 5);
		b.setFontColor(0x000000);
		b.setKeyBorder(Chart.SameAsMainColor);
		b.setText("<*block,valign=top*>{={sector}+1}.<*advanceTo=22*><*block,width=" + + pWidth/3 + "*>{label}" + "<*/*><*block,width=" + pWidth/15 + ",halign=right*>{percent}<*/*>%");

		String picUrl = c.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
		picUrl = System.getProperty("java.io.tmpdir") + "/" + picUrl;
		return picUrl;
	}

	/*
	public static ShrinkResult shrinkLabel(String[] tLabelX) {
		List<String> labelXList = new ArrayList<String>();
		List<String> realLabelXList = new ArrayList<String>();
		for (int i = 0; i < tLabelX.length; i++) {
			labelXList.add(tLabelX[i]);
			realLabelXList.add(tLabelX[i]);
		}
		if (!labelXList.isEmpty()) {// 處理labelX
			int length = labelXList.get(0).length();
			int labelNum = SHRINK_MAX_LABEL_LENGTH / (2 * length);
			if (labelXList.size() / labelNum > 1) {
				for (int i = 0; i < labelXList.size(); i++) {
					if (i % (labelXList.size() / labelNum) != 0) {
						labelXList.set(i, "");
					}
				}
			}
		}
		return new ShrinkResult(labelXList.toArray(new String[labelXList.size()]), realLabelXList.toArray(new String[realLabelXList.size()]));
	}*/

	public static XYChart getXYChart(String pTitle, String[] pLabelX, String pUnitX, List<double[]> pData, String pUnitY, String[] pLegend) {
		XYChart tXYChart = initXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pUnitX, pData, pUnitY, true);
		LineLayer layer = tXYChart.addLineLayer();
		for (int i = 0; i < pData.size(); i++) {
			//if(Configuration.getInstance().isChartSymbols())
				//layer.addDataSet(pData.get(i), COLOR_ARY[i % 8], pLegend[i]).setDataSymbol((i + 1), 8);				
			//else
				layer.addDataSet(pData.get(i), COLOR_ARY[i % 8], pLegend[i]);
		}
		layer.setLineWidth(3);
		tXYChart.xAxis().setLabels(pLabelX);
		setDefaultAxis(pUnitX, pUnitY, tXYChart);
		return tXYChart;
	}

	public static String getReportXYChart(String pTitle, String[] pLabelX, String pUnitX, List<double[]> pData, String pUnitY, String[] pLegend) {
		XYChart tXYChart = getXYChart(pTitle, pLabelX, pUnitX, pData, pUnitY, pLegend);
		return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	}

	public static String getReportXYChart(int pWidth, int pHeight, String pTitle, String[] pLabelX, String pUnitX, List<double[]> pData, String pUnitY, String[] pLegend) {
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, pUnitY, false);
		LineLayer layer = tXYChart.addLineLayer();
		for (int i = 0; i < pData.size(); i++) {
			//if(Configuration.getInstance().isChartSymbols())
				//layer.addDataSet(pData.get(i), COLOR_ARY[i % 8], pLegend[i]).setDataSymbol((i + 1), 8);
			//else
				layer.addDataSet(pData.get(i), COLOR_ARY[i % 8], pLegend[i]);
		}
		tXYChart.xAxis().setLabels(pLabelX);
		setDefaultAxis(pUnitX, pUnitY, tXYChart);
		return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	}

	public static XYChart getMultiLineChart(int pWidth, int pHeight, List<double[]> pDataList, Date[] pLabels, String pXTitle, String pYTitle, String pChartTitle, String[] pLegend) {
		return getMultiLineChart(pWidth, pHeight, pDataList, pLabels, pXTitle, pYTitle, pChartTitle, pLegend, true);		
	}
	public static XYChart getMultiLineChart(int pWidth, int pHeight, List<double[]> pDataList, Date[] pLabels, String pXTitle, String pYTitle, String pChartTitle, String[] pLegend, boolean show) {
		int[] colors = { 0x488ac7, 0xd4a017, 0xAA0000, 0xbbbbbb };
		XYChart c = null;
		if(show){
			c = new XYChart(pWidth, pHeight, Chart.brushedSilverColor(), Chart.Transparent, 1);
		}else{			
			c = new XYChart(pWidth, pHeight, 0xeeeeff, 0x000000, 1);
		}
		
		LineLayer layer = c.addLineLayer2();
		layer.setLineWidth(2);
		layer.setAggregateLabelStyle(FONT_TITLE, 12, 0x3333ff);
		for (int i = 0; i < pDataList.size(); i++) {
			layer.addDataSet(pDataList.get(i), colors[i], pLegend[i]);
		}
		c.xAxis().setLabelStyle(FONT_TITLE, 10);
		c.xAxis().setLabelStyle(FONT_TITLE, 10, Chart.TextColor, 45);
		c.xAxis().setTitle(pXTitle, FONT_TITLE, 10);
		c.yAxis().setTitle(pYTitle, FONT_TITLE, 10);
		c.xAxis().setLabelFormat("{value|hh:nn}");
		c.addTitle(pChartTitle, FONT_TITLE, 18);
		layer.setXData(pLabels);

		if(show){
			c.setPlotArea(65, 70, pWidth - 100, pHeight - 150, Chart.brushedSilverColor(), -1, -1, 0xcccccc, 0xcccccc);
		}else{			
			c.setPlotArea(65, 70, pWidth - 100, pHeight - 150, 0xffffff, -1, -1, 0xcccccc, 0xcccccc);
			c.setBackground(c.linearGradientColor(0, 0, 0, 100, 0x99ccff, 0xffffff), 0x888888);
		}
			
		c.setRoundedFrame();
		c.setDropShadow();
		c.addLegend(50, 30, false, FONT_TITLE, 10).setBackground(Chart.Transparent);

		return c;
	}

	public static String getReportMultiLineChart(int pWidth, int pHeight, List<double[]> pDataList, Date[] pLabels, String pXTitle, String pYTitle, String pChartTitle, String[] pLegend) {
		XYChart tXYChart = getMultiLineChart(pWidth, pHeight, pDataList, pLabels, pXTitle, pYTitle, pChartTitle, pLegend, false);
		return System.getProperty("java.io.tmpdir") + "/" + tXYChart.makeTmpFile(System.getProperty("java.io.tmpdir"), 0, 600);
	}

	/**
	 * 
	 * @param pData
	 *            目前所查詢出來的資料
	 * @param pAdapter
	 *            提供該物件產生的方式
	 * @param pTotalInterval
	 *            所要查詢的總時間
	 * @param pTimeOffset
	 *            每一筆資料的區間 TIME_MIN_15,TIME_MIN_30,...,TIME_YEAR
	 */
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	/*public static void fillEmptyData(List pData, ReportItemAdapter pAdapter, Interval pTotalInterval, int pTimeOffset) {
		List<Interval> tSplitIntervals = getSplitIntervalList(pTotalInterval, pTimeOffset);
		for (int i = 0; i < tSplitIntervals.size(); i++) {
			if (pData.size() <= i || !DateUtil.between(tSplitIntervals.get(i).getStartTime(), pAdapter.getInterval(pData.get(i)))) {
				Object tObject = pAdapter.createObject();
				pAdapter.setInterval(tObject, tSplitIntervals.get(i));
				pData.add(i, tObject);
			}
		}
	}*/

	/**
	 * 用來補齊報表資料，切割區間
	 * 
	 * @param pAllTime
	 *            所要查詢報表的總時間
	 * @param pOffsetMin
	 *            每依筆的間隔時間
	 * @return 間隔的 List<Interval>
	 */
	/*private static List<Interval> getSplitIntervalList(Interval pAllTime, int pOffsetMin) {
		List<Interval> tOut = new ArrayList<Interval>();
		Date tStart = pAllTime.getStartTime();
		Interval tTemp = null;
		do {
			tTemp = new Interval();
			tTemp.setStartTime(tStart);
			if (pOffsetMin == DateUtil.SAMPLING_RATE_1MONTH) {
				tStart = DateUtil.getSimpleDateOffset(tStart, Calendar.MONTH, 1);
			} else if (pOffsetMin == DateUtil.SAMPLING_RATE_1YEAR) {
				tStart = DateUtil.getSimpleDateOffset(tStart, Calendar.YEAR, 1);
			} else {
				tStart = DateUtil.getSimpleDateOffset(tStart, Calendar.MINUTE, pOffsetMin);
			}
			tTemp.setEndTime(DateUtil.getSimpleDateOffset(tStart, Calendar.SECOND, 0));
			tOut.add(tTemp);
		} while (DateUtil.lessEqual(tStart, pAllTime.getEndTime()));
		return tOut;
	}*/

}