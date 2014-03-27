package web.struts.chartdirector;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

//import com.chttl.ienc.bean.RuleCondition.LinkOperator;

public class StringUtil {

	public static final DecimalFormat FORMAT_DOUBLE = new DecimalFormat("0.00");
	public static final String CHANGE_LINE = System.getProperty("line.separator");
	public static final String EMPTY = "".intern();
	public static final String TAB = "\t";
	public static enum STR_TYPE {EMAIL, PHONE_NO}

	/**
	 * 是空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isEmptyOrSpace(final Object pValue){
		if(pValue == null){
			return true;
		}
		return false;
	}
	
	/**
	 * 是空的時候返回 true
	 * @param pValue
	 * @return
	 */
	public static boolean isEmptyOrSpace(final String pValue){
		if(pValue == null || pValue.length()<=0){
			return true;
		}
		return false;
	}

	/**
	 * 是空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isEmptyOrSpace(final Object[] pValue) {
		if (pValue == null || pValue.length <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 是空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isEmptyOrSpace(final Collection<?> pValue) {
		if (pValue == null || pValue.size() <= 0) {
			return true;
		}
		return false;
	}
	public static boolean isEmptyOrZero(final Integer pValue) {
		return (pValue == null || pValue == 0);
	}
	
	public static boolean isEmptyOrSpace(Map<?,?> pValue) {
		if (pValue == null || pValue.size() <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 非空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isNotEmptyOrSpace(final String pValue) {
		return !isEmptyOrSpace(pValue);
	}

	/**
	 * 非空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isNotEmptyOrSpace(final Object[] pValue) {
		return !isEmptyOrSpace(pValue);
	}

	/**
	 * 非空的時候返回 true
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean isNotEmptyOrSpace(final Collection<?> pValue) {
		return !isEmptyOrSpace(pValue);
	}

	public static boolean isNotEmptyOrZero(final Integer pValue) {
		return !isEmptyOrZero(pValue);
	}
	
	public static boolean isNotEmptyOrSpace(Map<?,?> pValue) {
		return !isEmptyOrSpace(pValue);
	}
	
	/**
	 * 清除前後空白
	 * @param pValue
	 * @return
	 */
	public static String trimNull(final Object pValue) {
		if (pValue == null) {
			return "";
		}
		if (pValue instanceof String) {
			String tString = (String) pValue;
			return tString.trim();
		}
		return String.valueOf(pValue).trim();
	}

	/**
	 * 將字串最後面的 ';' ',' 移除
	 * 
	 * @param pInput
	 * @return
	 */
	public static String trimLastChar(final String pInput) {
		String tOut = "";
		if (isNotEmptyOrSpace(pInput)) {
			String tTemp = new String(pInput).trim();
			char tChar = tTemp.charAt(tTemp.length() - 1);
			if (tChar == ',' || tChar == ';' || tChar == '.' || tChar == '\n') {
				tOut = tTemp.substring(0, tTemp.length() - 1);
			}else{
				return pInput;
			}
		}
		return tOut;
	}

	/**
	 * 補零 000xxx...
	 * 
	 * @param pValue
	 * @param pLength
	 * @return
	 */
	public static String paddingZeroLeft(final String pValue, int pLength) {
		return StringUtils.leftPad(pValue, pLength, "0");
	}

	/**
	 * 補零 xxx000
	 * 
	 * @param pValue
	 * @param pLength
	 * @return
	 */
	public static String paddingZeroRight(final String pValue, int pLength) {
		return StringUtils.rightPad(pValue, pLength, "0");
	}
	
	/**
	 * 取得自串的長度,中文字當成2
	 * @param pValue
	 * @return
	 */
	public static int getChineseStrLength(final String pValue){
		int tOut = 0;
		for(int i=0;i<pValue.length();i++){
			tOut+=pValue.charAt(i)>0xff?2:1; 
		}
		return tOut;
	}
	
	/**
	 * 考慮中文字形的補滿
	 * @param pValue
	 * @param pLength
	 * @param pSymbol
	 * @return
	 */
	public static String paddingRight(final String pValue, int pLength,final String pSymbol) {
		String tOut = pValue == null?"":pValue;
		if(getChineseStrLength(pValue)< pLength){
			String tTemp = "";
			for (int i = 0; i < pLength - getChineseStrLength(pValue); i++) {
				tTemp+=pSymbol;
			}
			tOut += tTemp;
		}
		return tOut;
	}
	
	/**
	 * 唯一識別碼,亂數
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 編碼
	 * @param pText 999999
	 * @return 
	 * 0000   => 4a7d1ed414474e4033ac29ccb8653d9b
	 * 999999 => 52c69e3a57331081823331c4e69d3f2e
	 */
	//public static String encodeMd5Hex(final String pText) { 
		//return DigestUtils.md5Hex(pText);
	//}
	
	public static String getRandomPassword(int pLength){
		StringBuffer tOut = new StringBuffer();
		int[] tIntAry = new int[pLength];
		int tType;
		for(int i = 0; i < pLength; i++){
			tType = (int)((Math.random()*7)%3);
			if(tType ==1){
				tIntAry[i]=(int)((Math.random()*10) + 48);
			}else if(tType ==2){
				tIntAry[i] = (char)((Math.random()*26) + 65);
			}else{
				tIntAry[i] = (char)((Math.random()*26) + 97);
			}
		}
		for(int j = 0; j < pLength; j++){
			tOut.append((char)tIntAry[j]);
		}
		return tOut.toString();
	}

	
//	/**
//	 * 編碼
//	 * @param pText
//	 * @return 
//	 * 999999
//	 */
//	public static String encodeBASE64(String pText) { 
//		if (pText == null) return null;
//		return (new BASE64Encoder()).encode( pText.getBytes() ); 
//	}
//	
//	/**
//	 * 解碼
//	 * @param pText
//	 * @return
//	 */
//	public static String decodeBASE64(String pText) {
//		if (pText == null) return null; 
//		BASE64Decoder decoder = new BASE64Decoder(); 
//		try { 
//			byte[] b = decoder.decodeBuffer(pText); 
//			return new String(b); 
//		} catch (Exception e) { 
//			return null; 
//		} 
//	}

	/**
	 * 處理字串截斷
	 * 
	 * @param pDesc
	 * @param pMaxLength
	 * @return
	 */
	public static String getMaxLength(final String pDesc, int pMaxLength) {
		if (pDesc == null) {
			return EMPTY;
		}
		if (pDesc.length() <= pMaxLength) {
			return pDesc;
		} else {
			return pDesc.substring(0, pMaxLength);
		}

	}

	/**
	 * String to Double
	 * 
	 * @param pValue
	 * @return
	 */
	public static double getDouble(String pValue) {
		try {
			if (pValue != null) {
				return Double.parseDouble(pValue.replaceAll(",", ""));
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public static Double[] getDouble(String[] pValueAry) {
		Double[] tOut = new Double[pValueAry.length];
		for (int i = 0; i < pValueAry.length; i++) {
			tOut[i] = getDouble(pValueAry[i]);
		}
		return tOut;
	}
	
	/**
	 * String to Float
	 * 
	 * @param pValue
	 * @return
	 */
	public static float getFloat(String pValue) {
		try {
			if (pValue != null) {
				return Float.parseFloat(pValue);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	/**
	 * String to Integer
	 * 
	 * @param pValue
	 * @return
	 */
	public static int getInteger(String pValue) {
		try {
			if (pValue != null) {
				return Integer.parseInt(pValue.trim());
			}
		} catch (Exception e) {
		}
		return 0;
	}
	/**
	 * String to Integer
	 * 
	 * @param pValueAry
	 * @return
	 */
	public static Integer[] getInteger(String[] pValueAry) {
		Integer[] tOut = new Integer[pValueAry.length];
		for (int i = 0; i < pValueAry.length; i++) {
			tOut[i] = getInteger(pValueAry[i]);
		}
		return tOut;
	}

	/**
	 * String to Long
	 * 
	 * @param pValue
	 * @return
	 */
	public static long getLong(String pValue) {
		try {
			if (pValue != null) {
				return Long.parseLong(pValue);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	/**
	 * String to Boolean
	 * 
	 * @param pValue
	 * @return
	 */
	public static boolean getBoolean(String pValue) {
		if (pValue == null) {
			return false;
		}
		if ("1".equals(pValue) || "true".equalsIgnoreCase(pValue) || "on".equalsIgnoreCase(pValue)) {
			return true;
		}
		return false;
	}

	/**
	 * String to LinkOperator
	 * 
	 * @param pString
	 * @return
	 */
	/*public static LinkOperator getLinkOperator(String pString) {
		if (pString != null) {
			if ("AND".equals(pString)) {
				return LinkOperator.AND;
			} else if ("OR".equals(pString)) {
				return LinkOperator.OR;
			}
		}
		return LinkOperator.OR; // the iENBox cannot accept the "NONE"
	}*/

	/**
	 * 將 list 轉成 字串
	 * @param pList
	 * @return
	 */
	public static String listToStringBypSymbol(List<?> pList,String pSymbol ){
		StringBuffer tBuffer = new StringBuffer();
		for (Object o : pList) {
			tBuffer.append(o).append(pSymbol);
		}
		return trimLastChar(tBuffer.toString());
	}
	
	/**
	 * 將 list 轉成 字串
	 * @param pList
	 * @return
	 */
	public static String listToString(List<?> pList){
		return Arrays.toString(pList.toArray(new Object[0]));
	}

	/**
	 * 將物件轉成字串
	 * @param pObject
	 * @return
	 */
	public static String getString(Object pObject) {
		if(pObject == null){
			return "";
		}else if (pObject instanceof String) {
			return (String)pObject;
		}else if (pObject instanceof Object[]) {
			if(isEmptyOrSpace((Object[])pObject)){
				return "";
			}else{
				return arrayToString((Object[])pObject);
			}
		}else if(pObject instanceof Integer){
			return String.valueOf(pObject);
		}else if(pObject instanceof Double){
			if(Double.isNaN((Double)pObject)){
				return "NaN";
			}
			return FORMAT_DOUBLE.format(pObject);
		}else if (pObject instanceof Collection<?>) {
			if(isEmptyOrSpace(((Collection<?>)pObject))){
				return "";
			}else{
				return arrayToString(((Collection<?>)pObject).toArray(new Object[0]));
			}
		}else{
			return String.valueOf(pObject);
		}
	}
	
	/**
	 * 將物件轉成字串，並設定小數點位數
	 * @param pObject
	 * @return
	 */
	public static String getString(Object pObject, int decimal) {
		String decimalStr = "0.";
		for(int i=0; i<decimal; i++)
			decimalStr += "0";
		if(decimal <= 0)
			decimalStr = "#";
		return getString(pObject, decimalStr);
	}
	
	/**
	 * 將物件轉成字串，並設定顯示格式
	 * @param pObject
	 * @return
	 */
	public static String getString(Object pObject, String format) {
		if(pObject == null){
			return "NA";
		}else {
			double value =((Number) pObject).doubleValue();
			if(Double.isNaN(value)|| Double.isInfinite(value)){
				return "NA";	
			}else{
				DecimalFormat tFormat = new DecimalFormat(format);		
				DecimalFormatSymbols dfs = tFormat.getDecimalFormatSymbols();
			    dfs.setDecimalSeparator('.');
			    tFormat.setDecimalFormatSymbols(dfs);
				return tFormat.format(pObject);
			}
		}
	}
	
	private static String arrayToString(Object[] pObject){
		String tOut = Arrays.toString(pObject);
		if(tOut.length()<=2){
			return "";
		}else{
			return tOut;
		}
	}

	/**
	 * 傳入 1,2,3,4
	 * @param pStrId  1,2,3,4
	 * @return 回傳 list
	 */
	public static List<Integer> getIntegerList(String pStrId) {
		if(isEmptyOrSpace(pStrId)){
			return new ArrayList<Integer>(0);
		}
		return Arrays.asList(getInteger(pStrId.split(",")));
	}
	
	public static List<Double> getDoubleList(String pStrId) {
		if(isEmptyOrSpace(pStrId)){
			return new ArrayList<Double>(0);
		}
		return Arrays.asList(getDouble(pStrId.split(",")));
	}
	
	public static List<String> getStringList(String pStrId) {
		if(isEmptyOrSpace(pStrId)){
			return new ArrayList<String>(0);
		}
		return Arrays.asList(pStrId.split(","));
	}
	public static String arrayToString(Object[] pInherit, String pSymbol) {
		if(StringUtil.isNotEmptyOrSpace(pInherit)){
			StringBuffer tOut = new StringBuffer();
			for (Object o : pInherit) {
				tOut.append(o).append(pSymbol);
			}
			return trimLastChar(tOut.toString());
		}
		return EMPTY;
	}

	public static  <T> List<T> getListContent(T pObject) {
		List<T> tOut = new ArrayList<T>();
		tOut.add(pObject);
		return tOut;
	}
	public static String getLogBuild(List<String> pBuildList) {
		if(StringUtil.isNotEmptyOrSpace(pBuildList)){
			StringBuffer tOut = new StringBuffer();
			for (String s : pBuildList) {
				tOut.append("#").append(s).append("#").append(";");
			}
			return trimLastChar(tOut.toString());
		}
		return EMPTY;
	}
	public static String convertCharset(String pRawData,String pOriginalCharset,String pTargetCharset){
		try {
			return new String(pRawData.getBytes(pOriginalCharset), pTargetCharset);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pRawData;
	}
	public static String convertCharsetMS950toUTF(String pRawData){
		return convertCharset(pRawData,"MS950", "UTF-8");
	}
	public static String trimChangeLineAndTab(String pValue){
		if(StringUtil.isNotEmptyOrSpace(pValue)){
			pValue = pValue.replaceAll("\r\n", " ");
			pValue = pValue.replaceAll("\n"  , " ");
			pValue = pValue.replaceAll("\t"  , " ");
		}
		return pValue;
	}

	public static String getSecret(String pUniformNo) {
		if(StringUtil.isNotEmptyOrSpace(pUniformNo) && pUniformNo.length()>=2){
			return StringUtils.rightPad(pUniformNo.substring(0,1), pUniformNo.length()-1, "*")+pUniformNo.charAt(pUniformNo.length()-1);
		}
		return pUniformNo;
	}
	
	public static boolean isValid(String str, STR_TYPE type){
		String pattern; 
		switch(type){
		case EMAIL:
			pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			return str.matches(pattern);
		case PHONE_NO:
			pattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
			return str.matches(pattern);
		}
		return false;
	}
	
}