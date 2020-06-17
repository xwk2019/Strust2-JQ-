package cn.Interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
 

public class InterceptorTest extends AbstractInterceptor{

	private static final long serialVersionUID = 2422100326160658352L;


	@Override

	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session=invocation.getInvocationContext().getSession();
		Object role = session.get("role");

        if(role!=null){
            
            return invocation.invoke();
        }else{
        	return "error";
        }
    }

		

	}

 


