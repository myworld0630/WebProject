import javax.servlet.http.*;

public class IndexAction{
	
    public String index() {
    	
    	System.out.println("Test Struts Action Success");
        return "success";
    }
} 