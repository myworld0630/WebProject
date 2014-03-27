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
 * ���o ChartDirector �� Chart
 * 
 * @author Jichang
 */
public class ReportUtil {

//	public static final int INIT_WIDTH = (int) (1080 / 1.4); // �w�]�e��
//	public static final int INIT_HEIGHT = (int) (INIT_WIDTH / 1.618); // �w�]�e��

	private static final int COLOR_ARY[] = new int[] { 0x00B050, 0xFF0000, 0x0070C0, 0xE46C0A, 0x7030A0, 0x00B0F0, 0xFF7C80, 0xA6A6A6 };

	private static final int HEIGHT_TITLE = 24; // ���D������
	private static final int HEIGHT_ROW = 20; // �C�@����ƪ�����
	private static final int ITMES_ROW = 1; // �C�@�榳�X�����

	private static final int LEGEND_START_X = 40; // �ƦC������r���_�I��m
	private static final int LEGEND_START_Y = 0; // �ƦC������r���_�I��m

	private static final int PLOTAREA_START_X = 45; // ����]�t ���
	private static final int PLOTAREA_START_Y = 12; // �W���d��
	private static final int PLOTAREA_END_OFFSET_X = 20; // �k��d��
	private static final int PLOTAREA_END_OFFSET_Y = 30; // �U���]�t ���
	
	private static final int Y_AXIS_WIDTH = 50; // y�b���e��

	private static final String FONT_LEGEND = "msjh.ttf";
	private static final String FONT_TITLE = "�L�n������";

	public static final int SHRINK_DATA_SIZE = 100;
	public static final int SHRINK_MAX_LABEL_LENGTH = 150;
	
	public static final int AGGREGATE_BOUND = 1000; 

	/**
	 * ���� XYChart
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null);
	//}
	
	/**
	 * ���� XYChart
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param dashline
	 * 			     �H��u��ܥ����ȤΤW�U��
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, boolean dashline) {
		//return getXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, dashline);
	//}

	/**
	 * �ץX����ϥ�
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @return �Ϫ�s��URL
	 */
	//public static String getReportXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getReportXYChart(pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null);
	//}

	/**
	 * ���� XYChart
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param pChartSetting
	 *            �i�H�]�w�@�ǳ����F��
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//return getXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true);
	//}

	/**
	 * ���� XYChart
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param dashline
	 * 			     �H��u��ܥ����ȤΤW�U��
	 * @return XYChart
	 */
	//public static XYChart getXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean dashline) {
		//return getXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, true, dashline);
	//}
	/**
	 * �ץX����ϥ�
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param pChartSetting
	 *            �i�H�]�w�@�ǳ����F��
	 * @return �Ϫ�s��URL
	 */
	//public static String getReportXYChart(final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting) {
		//return getReportXYChart((int) (1080 / 1.4), (int) ((int) (1080 / 1.4) / 1.618), pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, pChartSetting, false);
	//}

	/**
	 * ���� XYChart
	 * 
	 * @param pWidth
	 *            �Ϫ��e��
	 * @param pHeight
	 *            �Ϫ�����
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @return XYChart
	 */
	//public static XYChart getXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, true);
	//}

	/**
	 * �ץX����ϥ�
	 * 
	 * @param pWidth
	 *            �Ϫ��e��
	 * @param pHeight
	 *            �Ϫ�����
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @return �Ϫ�s��URL
	 */
	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, boolean dashline) {
		//return getReportXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, dashline);
	//}
	
	//public static String getReportXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval) {
		//return getReportXYChart(pWidth, pHeight, pTitle, pTimeStamp, pUnitX, pData, pUnitY, pLegend, pInterval, null, false);
	//}
	
	/**
	 * ���� DynamicXYChart
	 * 
	 * @param pWidth
	 *            �Ϫ��e��
	 * @param pHeight
	 *            �Ϫ�����
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param pChartSetting
	 *            �i�H�]�w�@�ǳ����F��
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

		// �վ�ϨҤ�r����
		String[] tAdjDataDesc = new String[pLegend.length];
		int tLength = 75;
		for (int i = 0; i < pLegend.length; i++) {
			tAdjDataDesc[i] = StringUtil.paddingRight(pLegend[i].trim(), tLength - pLegend[i].length() * 2, " ");
		}

		// �վ㪺�ɶ��b
		Date[] tAdjTimeStamps = pTimeStamp;

		// ø�s�C�@���u
		drawLayer(pData, pInterval, tXYChart, tAdjDataDesc, tAdjTimeStamps, false);

		// �]�w��ܮ榡
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);

		// �]�w�w�]�b�]�w
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
	 * ���� XYChart
	 * 
	 * @param pWidth
	 *            �Ϫ��e��
	 * @param pHeight
	 *            �Ϫ�����
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param pChartSetting
	 *            �i�H�]�w�@�ǳ����F��
	 * @return XYChart
	 */
	/*public static XYChart getXYChart(int pWidth, int pHeight, final String pTitle, final Date[] pTimeStamp, String pUnitX, final List<double[]> pData, String pUnitY, final String[] pLegend, final Interval pInterval, ChartSetting pChartSetting, boolean show, boolean dashline) {
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, pUnitY, show);

		// �վ�ϨҤ�r����
		String[] tAdjDataDesc = getAdjDataDesc(pLegend);

		// �վ㪺�ɶ��b
		Date[] tAdjTimeStamps = pTimeStamp;

		// ø�s�C�@���u
		drawLayer(pData, pInterval, tXYChart, tAdjDataDesc, tAdjTimeStamps, dashline);

		// �]�w��ܮ榡
		autoSetMultiFormat(tXYChart.xAxis(), pInterval);

		// �]�w�w�]�b�]�w
		setDefaultAxis(pUnitX, pUnitY, tXYChart);

		// �]�����ө_�Ǫ�bug...
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
	 * ���� �|Y�b XYChart
	 */
	/*public static XYChart getMultipleAxesChart(int pWidth, int pHeight, String pTitle, Date[] pTimeStamp, String pUnitX, List<double[]> pData, String yUnit, String[] yTitle, Interval pInterval, boolean show){
		XYChart tXYChart = initXYChart(pWidth, pHeight, pTitle, pUnitX, pData, yTitle[0], pData.size(), show);
		
		// �վ㪺�ɶ��b
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
		// �ץ��ƭȬۦP���u�����O���u���D 2013-12-26 update by ycyeh
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
	 * ���� ��Y�b XYChart
	 * 
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pData0
	 *            �Ϫ�W�C�@���I�����
	 * @param pData1
	 *            �Ϫ�W�C�@���I�����            
	 * @param xTitle
	 *            �U��ɶ��b���D
	 * @param y1Title
	 *            �������D
	 * @param y2Title
	 *            �k�����D
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
		
		// �վ㪺�ɶ��b
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

		// �]�w��ܮ榡
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
	 * �]�w�w�]�b�]�w
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
	 * �]�wY�b�W�U��
	 * 
	 * @param pUnitX
	 * @param pUnitY
	 * @param tXYChart
	 */
	private static void setReportScale(Double max, Double min, XYChart tXYChart){
		tXYChart.yAxis().setLinearScale(min, max);
	}
	
	/**
	 * ø�s�C�@���u
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
				// �Ϫ�ק� : ���h
				if(i > 0 && dashline){
					tLayer.addDataSet(tArrayMath.aggregate(pData.get(i), Chart.AggregateFirst), tXYChart.dashLineColor(COLOR_ARY[i % 8], Chart.DashLine), tAdjDataDesc[i]);					
				}else{
					tLayer.addDataSet(tArrayMath.aggregate(pData.get(i), Chart.AggregateFirst), COLOR_ARY[i % 8], tAdjDataDesc[i]);
				}
			}
		} else {
			for (int i = 0; i < pData.size(); i++) {
				//tLayer.addDataSet(pData.get(i), COLOR_ARY[i % 8], tAdjDataDesc[i]).setDataSymbol((i + 1), 8);
				// �Ϫ�ק� : ���h
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
	 * �Ϫ���l��
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
	 *  �Ϫ���l��
	 * 
	 * @param pWidth
	 * @param pHeight
	 * @param pTitle
	 * @param pUnitX
	 * @param pData
	 * @param pUnitY
	 * @param yAxisCount �hY�b
	 */
	private static XYChart initDynamicXYChart(int pWidth, int pHeight, final String pTitle, String pUnitX, final List<double[]> pData, String pUnitY, int yAxisCount, boolean show) {
		int tLineCount = (int) Math.ceil(((double) pData.size() / (double) ITMES_ROW) / 2); // �@�@�X��
		// �ثe�O��²�檺�覡�P�_,���ӦҼ{��J�r������
		XYChart tXYChart = null;
		
		if(show){
			tXYChart = new XYChart(pWidth, pHeight + HEIGHT_ROW * tLineCount , Chart.brushedSilverColor(), Chart.Transparent, 1);
		}else{			
			tXYChart = new XYChart(pWidth, pHeight + HEIGHT_ROW * tLineCount , 0xffffc0, 0x000000, 1);
		}
		
		
		// �]�w�w�]�r��
		tXYChart.setDefaultFonts("simsun.ttc", "simsun.ttc", "simsun.ttc", "simsun.ttc");
		// �~�جO�ꨤ
		tXYChart.setRoundedFrame();
		// �����v
		tXYChart.setDropShadow();

		// �Ϩ�
		int tLegendStartX = LEGEND_START_X;
		int tLegendStartY = LEGEND_START_Y + HEIGHT_TITLE;
		// �Ϫ�_�l��m
		int tPlotAreaStartX = PLOTAREA_START_X + (StringUtil.isEmptyOrSpace(pUnitY) ? 0 : 20) + (yAxisCount >= 3 ? 75 : 0);
		int tPlotAreaStartY = PLOTAREA_START_Y + tLegendStartY + HEIGHT_ROW * tLineCount;
		// ��u�Ϫ��j�p
		int pInnerWidth = pWidth - tPlotAreaStartX - PLOTAREA_END_OFFSET_X - (yAxisCount -1) * Y_AXIS_WIDTH;
		int pInnerHeight = pHeight - PLOTAREA_START_Y - tLegendStartY - PLOTAREA_END_OFFSET_Y - (StringUtil.isEmptyOrSpace(pUnitX) ? 0 : 20);

		// ���D (���D��r,�r��,�j�p,�C��)
		tXYChart.addTitle(pTitle, FONT_TITLE, 18, 0x000000);
		// �ϨҪ����� (�_�l�IX,�_�l�IY,�O�_����,�r��,�r���j�p)
		tXYChart.addLegend2(tLegendStartX, tLegendStartY, 2, FONT_LEGEND + " Bold", 10).setBackground(Chart.Transparent, Chart.Transparent);
		// ��u�Ϧ�m (�_�l�IX,�_�l�IY,�e��,����,�I���C��,�ĤG�I���C��(�������),����C��,������u�C��,������u�C��)

		// �Ϫ�ק� : ���h
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
	 *  �Ϫ���l��
	 * 
	 * @param pWidth
	 * @param pHeight
	 * @param pTitle
	 * @param pUnitX
	 * @param pData
	 * @param pUnitY
	 * @param yAxisCount �hY�b
	 * @param show �O�_���������
	 * 
	 */
	private static XYChart initXYChart(int pWidth, int pHeight, final String pTitle, String pUnitX, final List<double[]> pData, String pUnitY, int yAxisCount, boolean show) {
		XYChart tXYChart = null;
		if(show){
			tXYChart = new XYChart(pWidth, pHeight, Chart.brushedSilverColor(), Chart.Transparent, 1);
		}else{			
			tXYChart = new XYChart(pWidth, pHeight, 0xffffc0, 0x000000, 1);
		}
		// �]�w�w�]�r��
		tXYChart.setDefaultFonts("simsun.ttc", "simsun.ttc", "simsun.ttc", "simsun.ttc");
		// �~�جO�ꨤ
		tXYChart.setRoundedFrame();
		// �����v
		tXYChart.setDropShadow();
		int tLineCount = (int) Math.ceil(((double) pData.size() / (double) ITMES_ROW)); // �@�@�X��
																						// �ثe�O��²�檺�覡�P�_,���ӦҼ{��J�r������
		// �Ϩ�
		int tLegendStartX = LEGEND_START_X;
		int tLegendStartY = LEGEND_START_Y + HEIGHT_TITLE;
		// �Ϫ�_�l��m
		int tPlotAreaStartX = PLOTAREA_START_X + (StringUtil.isEmptyOrSpace(pUnitY) ? 0 : 20) + (yAxisCount >= 3 ? 75 : 0);
		int tPlotAreaStartY = PLOTAREA_START_Y + tLegendStartY + HEIGHT_ROW * tLineCount;
		// ��u�Ϫ��j�p
		int pInnerWidth = pWidth - tPlotAreaStartX - PLOTAREA_END_OFFSET_X - (yAxisCount -1) * Y_AXIS_WIDTH;
		int pInnerHeight = pHeight - tPlotAreaStartY - PLOTAREA_END_OFFSET_Y - (StringUtil.isEmptyOrSpace(pUnitX) ? 0 : 20);

		// ���D (���D��r,�r��,�j�p,�C��)
		tXYChart.addTitle(pTitle, FONT_TITLE, 18, 0x000000);
		// �ϨҪ����� (�_�l�IX,�_�l�IY,�O�_����,�r��,�r���j�p)		
		tXYChart.addLegend(tLegendStartX, tLegendStartY, false, FONT_LEGEND + " Bold", 10).setBackground(Chart.Transparent);
		// ��u�Ϧ�m (�_�l�IX,�_�l�IY,�e��,����,�I���C��,�ĤG�I���C��(�������),����C��,������u�C��,������u�C��)
				
		// �Ϫ�ק� : ���h
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
	 * �ץX����ϥ�
	 * 
	 * @param pWidth
	 *            �Ϫ��e��
	 * @param pHeight
	 *            �Ϫ�����
	 * @param pTitle
	 *            ����W��
	 * @param pTimeStamp
	 *            �U��ɶ��b new Date[]{date1,date2,....}
	 * @param pUnitX
	 *            �U��ɶ��b���
	 * @param pData
	 *            �Ϫ�W�C�@���I�����
	 * @param pUnitY
	 *            �������
	 * @param pLegend
	 *            �C�@���u������,�Ϩ�
	 * @param pInterval
	 *            ���˰϶�
	 * @param pChartSetting
	 *            �i�H�]�w�@�ǳ����F��
	 * @return �Ϫ�s��URL
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
			if (tDiff <= 3) { // �����
				pXAxis.setMultiFormat(Chart.StartOfDayFilter(), "{value|hh:nn}", Chart.AllPassFilter(), "{value|hh:nn}");
				pXAxis.setLabelFormat("{value|hh:nn}");
			} else if (3 < tDiff && tDiff <= 8) { // �g����
				pXAxis.setMultiFormat(Chart.StartOfWeekFilter(), "{value|mm/dd}", Chart.AllPassFilter(), "{value|mm/dd}");
				pXAxis.setLabelFormat("{value|mm/dd}");
			} else if (8 < tDiff && tDiff <= 32) { // �����
				pXAxis.setMultiFormat(Chart.StartOfMonthFilter(), "{value|mm/dd}", Chart.AllPassFilter(), "{value|mm/dd}");
				pXAxis.setLabelFormat("{value|mm/dd}");
			} else if (32 < tDiff && tDiff < 360) { // �~����
				pXAxis.setMultiFormat(Chart.StartOfYearFilter(), "{value|yy/mm/dd}", Chart.AllPassFilter(), "{value|yy/mm/dd}");
				pXAxis.setLabelFormat("{value|yy/mm/dd}");
			} else { // ��L
				pXAxis.setMultiFormat(Chart.AllPassFilter(), "{value|yy/mm/dd}");
				pXAxis.setLabelFormat("{value|yy/mm/dd}");
			}
		} catch (Exception e) {
		}
	}*/

	/**
	 * �N�C�@�ӹϨһ�����r�վ㦨�ۦP����
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
		if (!labelXList.isEmpty()) {// �B�zlabelX
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
	 *            �ثe�Ҭd�ߥX�Ӫ����
	 * @param pAdapter
	 *            ���ѸӪ��󲣥ͪ��覡
	 * @param pTotalInterval
	 *            �ҭn�d�ߪ��`�ɶ�
	 * @param pTimeOffset
	 *            �C�@����ƪ��϶� TIME_MIN_15,TIME_MIN_30,...,TIME_YEAR
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
	 * �ΨӸɻ������ơA���ΰ϶�
	 * 
	 * @param pAllTime
	 *            �ҭn�d�߳����`�ɶ�
	 * @param pOffsetMin
	 *            �C�̵������j�ɶ�
	 * @return ���j�� List<Interval>
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