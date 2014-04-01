package web.struts.login;

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
		ms = (MyServer) appContext.getBean("MyServer");

		if (ms != null) {
			if (ms.valid(getUsername(), getPassword())) {
				setTip("登陸成功");
				return "success";
			} else {
				return "error";
			}
		} else
			System.out.println("ms is null");

		return SUCCESS;
	}

}