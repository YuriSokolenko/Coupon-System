package coupon.system.coupon.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;

import coupon.system.coupon.services.LogInServiceImpl;
import coupon.system.coupon.services.SessionIdCollector;

@CrossOrigin
@WebFilter("/secured/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String sessionID = httpRequest.getParameter("id");
		System.out.println("Session id in FILTER: " + sessionID);

		HttpSession session = SessionIdCollector.clientsSessions.get(sessionID);

		System.out.println("Session from MAP: " + session);
		if (session == null) {
			System.out.println("No active session. Denying access.");
			((HttpServletResponse) response).sendError(401);

			return;
		}

		String loggedInUser = (session.getAttribute(LogInServiceImpl.LOGGED_IN_USER)).toString();

		if (loggedInUser == null) {
			System.out.println("No logged-in user. Dening access.");
			((HttpServletResponse) response).sendError(401);
			return;
		}
		System.out.println("User '" + loggedInUser + "' is logged-in. Allowing access.");
		filterChain.doFilter(request, response);
	}
}