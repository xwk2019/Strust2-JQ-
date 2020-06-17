package cn.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Interceptor extends MethodFilterInterceptor {
   
	private static final long serialVersionUID = 1L;

	protected String doIntercept(ActionInvocation invocation) throws Exception {

   
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object object = session.get("user");
        
        if(object == null){       
            return "login";
        }else{
            
            return invocation.invoke();
        }
    }
}

