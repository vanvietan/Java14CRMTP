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
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		/* code được thực hiện khi nhận request */
		req.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, resp);
		/* code được thực hiện khi trả response */
		resp.setCharacterEncoding("UTF-8");
	}

}
