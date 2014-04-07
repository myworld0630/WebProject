package web.struts.spring.login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

public class LoginAction extends ActionSupport /*implements Action*/ {

	private String username;
	private String password;
	private String tip;
	private MyServer ms;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setMs(MyServer ms) {
		this.ms = ms;
	}

	public String execute() throws Exception {

		System.out.println(username + " " + password);
		System.out.println(getUsername() + " " + getPassword());
		
		WebApplicationContext tContext = ContextLoaderListener.getCurrentWebApplicationContext();
		ApplicationContext appContext = tContext;
		
		//ä¸‹é¢?™è? code å°±æ˜¯  dependency injection(DI ä¾è³´æ³¨å…¥)ï¼Œæ?è¬? DI å°±æ˜¯?©ä»¶?é? Factory Pattern ?–å?ï¼?
		//ä»¥é?ä½ç?å¼ç¢¼ä¹‹é??„è??ˆåº¦ï¼Œspring ?é? ApplicationContext.getBean ?¹æ?å¾?Bean Factory ?–å??©ä»¶å®Œæ?ä¾è³´æ³¨å…¥
		ms = (MyServer) appContext.getBean("MyServer");

		if (ms != null) {
			if (ms.valid(getUsername(), getPassword())) {
				setTip("?»é™¸?å?");
				return "success";
			} else {
				return "error";
			}
		} else
			System.out.println("ms is null");

		return SUCCESS;
	}

}