package web.struts.jasperreport;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

// 用來丟到 JasperReport 中的 Bean 物件
class testBean{
	
	private String testString1;
	private String testString2;
	private String testString3;
	
	testBean(String testString1,String testString2, String testString3){
		this.testString1 = testString1;
		this.testString2 = testString2;
		this.testString3 = testString3;
	}
	
	public String getTestString1() {
		return testString1;
	}
	public void setTestString1(String testString1) {
		this.testString1 = testString1;
	}
	public String getTestString2() {
		return testString2;
	}
	public void setTestString2(String testString2) {
		this.testString2 = testString2;
	}
	public String getTestString3() {
		return testString3;
	}
	public void setTestString3(String testString3) {
		this.testString3 = testString3;
	}
}


public class HelloJasper extends ActionSupport{

	private List queryList;
    private Map<String,Object> paramMap;
	
    @Override
    public String execute() throws Exception {
        
    	ArrayList myList = new ArrayList<testBean>(); 
        
    	testBean bean1 = new testBean("Angus","Angus","Angus");
    	testBean bean2 = new testBean("Angela","Angela","Angela");
    	testBean bean3 = new testBean("Alex","Alex","Alex");
    	
    	myList.add(bean1);
    	myList.add(bean2);
    	myList.add(bean3);
    	
    	queryList = myList;
    	
    	paramMap = new HashMap<String,Object>();
    	paramMap.put("title", "Japer Report 報表測試");
    	paramMap.put("testString1", "testString1");
    	paramMap.put("testString2", "testString2");
    	paramMap.put("testString3", "testString3");
    	
        return SUCCESS;
    }

    public List getQueryList() {
        return queryList;
    }

    public void setQueryList(List queryList) {
        this.queryList = queryList;
    }

	public Map<String,Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String,Object> paramMap) {
		this.paramMap = paramMap;
	}

} 