package web.struts;

import com.opensymphony.xwork2.ActionSupport;

public class TransferAction extends ActionSupport{
    
	private String value1;
	private String value2;
	
	public String index() {
    	
    	System.out.println("Test Struts Transger Action Success");
    	System.out.println(value1);
    	System.out.println(value2);
        return SUCCESS;
    }
	
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
} 