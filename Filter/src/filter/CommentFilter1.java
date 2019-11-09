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

//	����ɾ��������ʵ��֮ǰ���ã�ִֻ��һ��
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

//	���ڴ����������Ҫ����
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
//			�����дʻ�
			out.print("<h3>���������ѹر�</h3>");
		}else {
//			û�����дʻ������������������������Servlet
			chain.doFilter(request, response);
		}
	}

	/**
	 * ��������֮�󣬴���������ʵ��
	 * Ȼ�����init������ֻ�����һ��
	 * �����Ὣ�Ѿ������õ�FilterConfig������Ϊ��������
	 * ���ԴӸò����л�ȡ��ʼ����������Ϣ
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		illegalWord = filterConfig.getInitParameter("illegalWord");
		System.out.println("Filter1:init is running..." + illegalWord);
	}

}
