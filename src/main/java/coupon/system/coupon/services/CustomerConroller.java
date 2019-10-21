package coupon.system.coupon.services;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coupon.system.coupon.entites.Client;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;
import coupon.system.coupon.entites.Income;
import coupon.system.coupon.entites.IncomeType;

@Transactional
@CrossOrigin
@RestController
@RequestMapping("/secured/customer-service")
public class CustomerConroller {

	private HttpSession session;
	private Customer currentCustomer;

	@Autowired
	private IncomeServiceTemplateImpl incomeService;

	@Autowired
	EntityManager entityManager;

	@Autowired
	private CustomerService customerService;

	private Income income;

	@RequestMapping(value = "purchaseCoupon", method = RequestMethod.POST)
	public void purchaseCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws CouponSystemException {
		income.setAmount(coupon.getPrice());
		income.setDate(new Date());
		income.setDescription(IncomeType.CUSTOMER_PURCHASE.name());
		income.setName(currentCustomer.getCustName());
		incomeService.storeIncome(income);

		Customer currentCustomer = getCurrentCustomerFromSession(request);
		customerService.setCurrentCust(currentCustomer);
		customerService.purchaseCoupon(coupon);

		Collection<Coupon> couponsAfter = customerService.getCurrentCust().getCoupons();
		for (Coupon c : couponsAfter) {
			System.out.println(c);
			System.out.println("--------------------------------------------------------------");
		}
	}

	/**
	 * 
	 * @param request
	 * @return Current logged in Customer
	 */
	private Customer getCurrentCustomerFromSession(HttpServletRequest request) {
		HttpServletRequest httpRequest = request;
		String sessionID = httpRequest.getParameter("id");
		System.out.println(sessionID + " Session ID in getCustomerCOUPON!");
		HttpSession session = SessionIdCollector.clientsSessions.get(sessionID);
		System.out.println(" I succeed to get session from MAP! " + session.getId());
		// get currentCustomer
		Client clientAttribute = (Client) session.getAttribute(LogInServiceImpl.LOGGED_IN_USER);
		System.out.println(" Logged in Client in CustomerController method: " + clientAttribute);
		System.out.println(
				"Current customer name: " + customerService.customerRepDAO.findByName(clientAttribute.getName()));
		Customer currentCustomer = customerService.customerRepDAO.findByName(clientAttribute.getName());
		return currentCustomer;
	}

}
