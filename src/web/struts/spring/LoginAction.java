package web.struts.spring;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
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
		
		//下面的 code 就是  dependency injection(DI 依賴注入)，依賴注入 DI 就是 Factory Pattern 的實現
		//spring 透過 ApplicationContext.getBean 方法由 Bean Factory 將物件 instance 後並回傳完成依賴注入
		ms = (MyServer) appContext.getBean("MyServer");

		if (ms != null) {
			if (ms.valid(getUsername(), getPassword())) {
				setTip("歡迎登入");
				
				//將登入的姓名放入 session 中，用來做登入攔截的判斷
				Map<String, Object> sessionMap = ActionContext.getContext().getSession();
				sessionMap.put("username",username);
				return "success";
			} else {
				return "error";
			}
		} else
			System.out.println("ms is null");

		return SUCCESS;
	}

}