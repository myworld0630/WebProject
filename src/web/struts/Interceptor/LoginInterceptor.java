package web.struts.Interceptor;

import java.util.Map;

import web.struts.spring.LoginAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得進入攔截器的 Action 的名稱
		//Object action = invocation.getAction();
		//System.out.println("action:" + action);

		// 判斷是否為登陸請求Action,如果是則不攔截
		if (LoginAction.class == invocation.getAction().getClass())
			return invocation.invoke();

		
		// 從session中獲取登錄信息，若有登錄用戶則繼續訪問；若沒有返回登錄，訪問global-results
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if (session.get("username") == null) {
			System.out.println("Session username is null");
			return "index"; // 這裡的 index 是 struts.xml 檔裡面 global-result 的 result
							// name 的名稱
		}

		return invocation.invoke();
	}
}