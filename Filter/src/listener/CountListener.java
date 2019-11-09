package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CountListener implements HttpSessionListener{
	private int count = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		HttpSession session = se.getSession();
		ServletContext sct = session.getServletContext();
		sct.setAttribute("count", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		HttpSession session = se.getSession();
		ServletContext sct = session.getServletContext();
		sct.setAttribute("count", count);
	}

}
