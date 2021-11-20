package cybersoft.backend.java14.crm.filter;

import java.io.IOException;

import cybersoft.backend.java14.crm.utils.UrlConst;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {
		UrlConst.ROOT
})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		boolean isAuthed = req.getSession().getAttribute("isAuthenticated") 
							!= null ? true : false;
		
		if(isAuthed) { // nếu đăng nhập rồi thì cho qua
			chain.doFilter(req, resp);
		} else if(UrlConst.AUTH_LOGIN.equals(req.getServletPath())) {
			// nếu chưa đăng nhập và truy cập trang đăng nhập thì cho qua
			chain.doFilter(req, resp);
		} else { // nếu chưa đăng nhập và truy cập trang khác thì bắt đăng nhập
			resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
		}
	}

}
