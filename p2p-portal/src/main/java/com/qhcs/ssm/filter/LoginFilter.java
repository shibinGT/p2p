package com.qhcs.ssm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class LoginFileter
 */

public class LoginFilter implements Filter {
private String[] pa;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//转换成HttpServlet
		HttpServletRequest hsr=(HttpServletRequest)request;
		HttpServletResponse hsp=(HttpServletResponse)response;
		//获取登陆时存在session里的用户
		 Object o=hsr.getSession().getAttribute("loginUser");
		 String path=hsr.getServletPath();		
		 String contextpath=request.getServletContext().getContextPath();
		 String oldURL=hsr.getRequestURI();
		 //如果为空，刚返回登陆界面
		 if(o==null&&!onThePath(path)){
			//把防问前URL放进session
			hsr.getSession().setAttribute("oldURL", oldURL);
			 hsp.sendRedirect(contextpath+"/tologin");
			 return;
		 }	
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//获取web.xml中分配的过滤器参数
		String p=fConfig.getInitParameter("nologinUrl");
		//以;号分割成数组
		pa=p.split(";");
	}
	
	private boolean onThePath(String path){
		
		for(String a:pa){
			if(path.startsWith(a)){
				return true;
			}			
		}
		return false;
	}

}
