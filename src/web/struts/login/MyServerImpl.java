package web.struts.login;

public class MyServerImpl implements MyServer {

    public boolean valid(String username, String password) {
    	
        if(username.equals("angus")&&password.equals("hello")){
            return true;
        }
        return false;
    }

}