package coupon.system.coupon.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coupon.system.coupon.entites.Client;
import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Customer;
import coupon.system.coupon.repositories.CompanyRepositoryDAO;
import coupon.system.coupon.repositories.CustomerRepositoryDAO;

@CrossOrigin
@RestController
@RequestMapping("login-service")
public class LogInServiceImpl implements LogInService {

	@Autowired
	CompanyRepositoryDAO companyRepDAO;
	@Autowired
	CustomerRepositoryDAO customerRepDAO;

	@Autowired
	CustomerService customerService;

	@Autowired
	CompanyService companyService;

	private Company currentCompanyAttribute;
	private Customer currentCustomerAttribute;
	private final String FALSE_LOGIN = "{" + "login:" + "null" + "}";

	public static final String LOGGED_IN_USER = "session.attribute.logged.in.user";
	private HttpSession session;

	@Override
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestBody Client client, HttpServletRequest request) throws CouponSystemException {

		switch (client.getClientType()) {
		case ADMIN:
			if (client.getName().equals("admin") && client.getPassword().equals("1234")) {
				request.getSession().invalidate();
				session = request.getSession();
				session.setMaxInactiveInterval(10000);
				String sessionID = request.getSession(false).getId();
				String sessionIDToJSON = "{" + "\"" + "login" + "\"" + ":" + "\"" + request.getSession(false).getId()
						+ "\"" + "}";
				System.out.println(sessionIDToJSON);
				session.setAttribute(LOGGED_IN_USER, client);
				SessionIdCollector.clientsSessions.put(sessionID, session);
				System.out.println(
						"Session id from MAP in login: " + SessionIdCollector.clientsSessions.get(sessionID).getId());
				return sessionIDToJSON;
			} else {

				return FALSE_LOGIN;
			}

		case COMPANY:
			Company company = companyRepDAO.findByName(client.getName());
			if (company != null && (company.getPassword().equals(client.getPassword()))) {
				request.getSession().invalidate();
				session = request.getSession();
				session.setMaxInactiveInterval(10000);

				String sessionID = request.getSession(false).getId();
				String sessionIDToJSON = "{" + "\"" + "login" + "\"" + ":" + "\"" + request.getSession(false).getId()
						+ "\"" + "}";
				System.out.println(sessionIDToJSON);
				session.setAttribute(LOGGED_IN_USER, client);
				SessionIdCollector.clientsSessions.put(sessionID, session);
				System.out.println(
						"Session id from MAP in login: " + SessionIdCollector.clientsSessions.get(sessionID).getId());
				return sessionIDToJSON;
			} else {

				return FALSE_LOGIN;
			}

		case CUSTOMER:
			Customer customer = customerRepDAO.findByName(client.getName());
			if (customer != null && (customer.getPassword().equals(client.getPassword()))) {
				request.getSession().invalidate();
				session = request.getSession();
				session.setMaxInactiveInterval(10000);
				String sessionID = request.getSession(false).getId();
				String sessionIDToJSON = "{" + "\"" + "login" + "\"" + ":" + "\"" + request.getSession(false).getId()
						+ "\"" + "}";
				System.out.println(sessionIDToJSON);
				session.setAttribute(LOGGED_IN_USER, client);
				SessionIdCollector.clientsSessions.put(sessionID, session);
				System.out.println(
						"Session id from MAP in login: " + SessionIdCollector.clientsSessions.get(sessionID).getId());
				return sessionIDToJSON;
			} else {

				return FALSE_LOGIN;
			}
		}
		return FALSE_LOGIN;
	}

	@Override
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(@RequestBody HttpServletRequest r, String sessionID) throws CouponSystemException {
		r.getSession().invalidate();
		System.out.println("Loged out!");
	}

}