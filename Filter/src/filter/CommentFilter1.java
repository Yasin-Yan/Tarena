package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/comment", initParams = {@WebInitParam(name = "illegalWord", value = "damn")})
public class CommentFilter1 implements Filter{
	private String illegalWord;

//	容器删除过滤器实例之前调用，只执行一次
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

//	用于处理请求的主要方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {	
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String comment = req.getParameter("comment");
		if(comment.indexOf(illegalWord) != -1) {
//			有敏感词汇
			out.print("<h3>评论内容已关闭</h3>");
		}else {
//			没有敏感词汇则向后处理，交给其他过滤器或Servlet
			chain.doFilter(request, response);
		}
	}

	/**
	 * 容器启动之后，创建过滤器实例
	 * 然后调用init方法，只会调用一次
	 * 容器会将已经创建好的FilterConfig对象作为参数传入
	 * 可以从该参数中获取初始化的配置信息
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		illegalWord = filterConfig.getInitParameter("illegalWord");
		System.out.println("Filter1:init is running..." + illegalWord);
	}

}
