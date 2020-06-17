package cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        int loc = uri.lastIndexOf("/");
        String page = uri.substring(loc+1);
        if(page.equals("login.jsp")||page.equals("register.jsp")||page.equals("footer.jsp")||page.equals("registerRight.jsp")){
        	
        }else{
        	HttpSession session = req.getSession();
        	if(session.getAttribute("user")!=null){
        		
        	}else{
        		String contextPath =req.getContextPath();
        		resp.sendRedirect(contextPath+"/login.jsp");
        		return;
        	}
        }
        chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
