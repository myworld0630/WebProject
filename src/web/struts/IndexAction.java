package web.struts;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{

    public String index() {
    	
    	System.out.println("Test Struts Action Success");
        return SUCCESS;
    }
} 